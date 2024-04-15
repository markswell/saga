package com.markswell.payment.adapters.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.markswell.payment.application.core.domain.User;
import com.markswell.payment.adapters.out.repository.UserRepository;
import com.markswell.payment.adapters.out.repository.mapper.UserMapper;
import com.markswell.payment.application.ports.out.FindUserByIdOutputPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Optional<User> find(Integer userId) {
        return userRepository.findById(userId).map(userMapper::toUser);
    }
}
