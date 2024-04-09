package com.ctrlaltelite.planitbudget.service;


import com.ctrlaltelite.planitbudget.web.dto.UserDto;
import com.ctrlaltelite.planitbudget.web.dto.LoginDto;
import com.ctrlaltelite.planitbudget.web.dto.LoginMessage;

public interface UserService{
    String addUser(UserDto userRegistrationDto);

    LoginMessage loginUser(LoginDto loginDto);
}
