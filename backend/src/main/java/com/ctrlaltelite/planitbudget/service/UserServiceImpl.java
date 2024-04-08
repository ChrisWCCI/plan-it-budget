package com.ctrlaltelite.planitbudget.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ctrlaltelite.planitbudget.entity.User;
import com.ctrlaltelite.planitbudget.repository.UserRepository;
import com.ctrlaltelite.planitbudget.web.dto.LoginDto;
import com.ctrlaltelite.planitbudget.web.dto.UserDto;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userRegistrationDto.getPassword()));
        userRepository.save(user);
        return user.getUserName();
    }

    UserDto userRegistrationDto;

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPassWordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPassWordRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(),
                        encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }
    }
}