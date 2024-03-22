package me.alliwannadev.backend.modules.user.service;

import lombok.RequiredArgsConstructor;
import me.alliwannadev.backend.modules.user.domain.User;
import me.alliwannadev.backend.modules.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
