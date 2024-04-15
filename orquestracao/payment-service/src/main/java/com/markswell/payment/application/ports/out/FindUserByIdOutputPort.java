package com.markswell.payment.application.ports.out;

import com.markswell.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);

}
