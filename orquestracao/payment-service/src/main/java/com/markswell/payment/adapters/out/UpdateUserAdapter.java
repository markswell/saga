package com.markswell.payment.adapters.out;

import com.markswell.payment.adapters.out.repository.UserRepository;
import com.markswell.payment.adapters.out.repository.mapper.UserMapper;
import com.markswell.payment.application.core.domain.User;
import com.markswell.payment.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public void update(User user) {
        userRepository.save(userMapper.toUserEntity(user));
    }
}
