// package com.ctrlaltelite.planitbudget.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.ctrlaltelite.planitbudget.service.UserService;
// import com.ctrlaltelite.planitbudget.web.dto.LoginDto;
// import com.ctrlaltelite.planitbudget.web.dto.LoginMessage;
// import com.ctrlaltelite.planitbudget.web.dto.UserDto;

// @RestController
// @CrossOrigin
// @RequestMapping("api/user")
// public class UserController {
//     @Autowired
//     private UserService userService;

//  @GetMapping("/ping")
//     public String pingPong() {
//         return "pong";
//     }



//     @PostMapping(path = "/save")
//     public String saveUser(@RequestBody UserDto userDto) {
//         String id = userService.addUser(userDto);
//         return id;
//     }

//     @PostMapping(path = "/login")
//     public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
//         LoginMessage loginMessage = userService.loginUser(loginDto);
//         return ResponseEntity.ok(loginMessage);
//     }
// }