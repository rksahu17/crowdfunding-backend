package com.crowdfund.app.controller;

import com.crowdfund.app.exception.PasswordIncorrectException;
import com.crowdfund.app.exception.UserAlreadyExistException;
import com.crowdfund.app.exception.UserNotFoundException;
import com.crowdfund.app.model.User;
import com.crowdfund.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exist");
        }
    }

    @PostMapping("/login")
    public ResponseEntity getUser(@RequestBody User user) {
        try {
            User userFound = userService.getUserByEmailAndAuthenticate(user.getEmail(),user.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(userFound);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (PasswordIncorrectException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password Incorrect");}
    }
}