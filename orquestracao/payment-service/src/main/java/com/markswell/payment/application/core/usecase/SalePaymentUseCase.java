package com.markswell.payment.application.core.usecase;

import com.markswell.payment.application.core.domain.Sale;
import com.markswell.payment.application.core.domain.Payment;
import com.markswell.payment.application.ports.in.SalePaymentInputPort;
import com.markswell.payment.application.ports.in.FindUserByIdInputPort;
import com.markswell.payment.application.ports.out.UpdateUserOutputPort;
import com.markswell.payment.application.ports.out.SavePaymentOutputPort;
import com.markswell.payment.application.ports.out.SendToKafkaPaymentOutputPort;
import com.markswell.payment.application.core.usecase.exception.InsufficientFunds;

import static com.markswell.payment.application.core.domain.enums.SaleEvent.*;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final UpdateUserOutputPort updateUserOutputPort;
    private final FindUserByIdInputPort findUserByIdInputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendToKafkaPaymentOutputPort sendToKafkaPaymentOutputPort;

    public SalePaymentUseCase(
            UpdateUserOutputPort updateUserOutputPort,
            FindUserByIdInputPort findUserByIdInputPort,
            SavePaymentOutputPort savePaymentOutputPort,
            SendToKafkaPaymentOutputPort sendToKafkaPaymentOutputPort
    ) {
        this.updateUserOutputPort = updateUserOutputPort;
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaPaymentOutputPort = sendToKafkaPaymentOutputPort;
    }

    @Override
    public void payment(Sale sale) {
        try {
            var user = findUserByIdInputPort.find(sale.getUserId());
            if(user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new InsufficientFunds("User %s has insufficient funds".formatted(user.getName()));
            }
            user.debitBalance(sale.getValue());
            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            sendToKafkaPaymentOutputPort.send(sale, PAYMENT_EXECUTED);
        } catch (InsufficientFunds e) {
            sendToKafkaPaymentOutputPort.send(sale, PAYMENT_FAILED);
            e.printStackTrace();
        }
    }

    private Payment buildPayment(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }

}
