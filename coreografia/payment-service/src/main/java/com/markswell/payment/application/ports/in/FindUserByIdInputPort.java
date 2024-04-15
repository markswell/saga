package com.markswell.payment.application.ports.in;

import com.markswell.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(Integer userId);

}
