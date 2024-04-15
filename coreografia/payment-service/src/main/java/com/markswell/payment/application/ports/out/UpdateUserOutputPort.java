package com.markswell.payment.application.ports.out;

import com.markswell.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
