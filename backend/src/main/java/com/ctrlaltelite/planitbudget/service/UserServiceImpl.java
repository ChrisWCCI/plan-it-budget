package com.ctrlaltelite.planitbudget.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ctrlaltelite.planitbudget.entity.Role;
import com.ctrlaltelite.planitbudget.entity.User;
import com.ctrlaltelite.planitbudget.repository.UserRepository;
import com.ctrlaltelite.planitbudget.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }
}
