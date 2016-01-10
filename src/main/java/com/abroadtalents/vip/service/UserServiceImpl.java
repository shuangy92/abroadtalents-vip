package com.abroadtalents.vip.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.abroadtalents.vip.domain.User;
import com.abroadtalents.vip.repository.UserRepository;
import com.abroadtalents.vip.service.exception.UserAlreadyExistsException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;

    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(@NotNull @Valid final User user) {
        User existing = repository.findByName(user.getName());
        if (existing != null) {
        	LOGGER.debug("There already exists a user with name={}", user.getName());
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with name=%s\n", user.getName()));
        } else {
            LOGGER.debug("Created {}", user);
        }
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
