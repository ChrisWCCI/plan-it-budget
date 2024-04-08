package com.ctrlaltelite.planitbudget.service;

import com.ctrlaltelite.planitbudget.entity.User;
import com.ctrlaltelite.planitbudget.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);

}
