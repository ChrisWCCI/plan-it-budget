// package com.ctrlaltelite.planitbudget.web.dto;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.ctrlaltelite.planitbudget.service.UserService;

// @RestController
// @CrossOrigin
// @RequestMapping("api/v1/user")
// public class UserController {
// @Autowired
// private UserService userService;

// @PostMapping(path = "/save")
// public String saveEmployee(@RequestBody UserDto userDto) {
// String id = userService.addUser(userDto);
// return id;
// }

// @PostMapping(path = "/login")
// public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
// LoginMessage loginMessage = userService.loginUser(loginDto);
// return ResponseEntity.ok(loginMessage);
// }
// }