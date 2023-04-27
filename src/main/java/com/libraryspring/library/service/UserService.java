package com.libraryspring.library.service;

import com.libraryspring.library.domain.User;
import com.libraryspring.library.exception.ResourceNotFoundException;
import com.libraryspring.library.exception.message.ErrorMessage;
import com.libraryspring.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email).orElseThrow(
                ()->new ResourceNotFoundException(String.format(ErrorMessage.USER_NOT_FOUND_EXCEPTION, email)));
        return user;
    }
}
