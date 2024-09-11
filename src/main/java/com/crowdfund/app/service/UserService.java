package com.crowdfund.app.service;

import com.crowdfund.app.exception.PasswordIncorrectException;
import com.crowdfund.app.exception.UserAlreadyExistException;
import com.crowdfund.app.exception.UserNotFoundException;
import com.crowdfund.app.model.User;
import com.crowdfund.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) throws UserAlreadyExistException {
        User byEmail = userRepository.findByEmail(user.getEmail());
        if (null==byEmail) {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        } else
            throw new UserAlreadyExistException();
    }

    public User getUserByEmailAndAuthenticate(String email,String pass) throws UserNotFoundException, PasswordIncorrectException {
        User userFound = userRepository.findByEmail(email);
        if (userFound==null)
            throw new UserNotFoundException();
        if (passwordEncoder.matches(pass,userFound.getPassword()))
            return userFound;
        else
            throw new PasswordIncorrectException();
    }
}