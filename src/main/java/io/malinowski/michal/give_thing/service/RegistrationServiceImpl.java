package io.malinowski.michal.give_thing.service;

import io.malinowski.michal.give_thing.domain.model.User;
import io.malinowski.michal.give_thing.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void register(User user) {
        user.setActive(true);
        user.getRoles().add("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.debug("do zapisu: {}", user);
        userRepository.save(user);
        log.debug("zapisano: {}", user);
    }
}
