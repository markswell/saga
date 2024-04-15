package com.markswell.payment.application.core.usecase;

import com.markswell.payment.application.core.domain.User;
import com.markswell.payment.application.core.usecase.exception.UserNotFoundException;
import com.markswell.payment.application.ports.in.FindUserByIdInputPort;
import com.markswell.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer userId) {
        return findUserByIdOutputPort.find(userId)
                .orElseThrow(() -> new UserNotFoundException("User %s was not found".formatted(userId)));
    }

}
