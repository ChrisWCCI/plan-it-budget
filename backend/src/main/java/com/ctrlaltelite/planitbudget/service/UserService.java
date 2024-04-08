package com.ctrlaltelite.planitbudget.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ctrlaltelite.planitbudget.web.dto.UserDto;
import com.ctrlaltelite.planitbudget.web.dto.LoginDto;
import com.ctrlaltelite.planitbudget.web.dto.LoginMessage;

public interface UserService extends UserDetailsService {
    String addUser(UserDto userRegistrationDto);

    LoginMessage loginUser(LoginDto loginDto);
}
