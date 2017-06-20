package com.kyee.service.impl;

import com.kyee.domain.Role;
import com.kyee.domain.User;
import com.kyee.repository.UserRepository;
import com.kyee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * The PostConstruct annotation is used on a method that needs to be executed
     * after dependency injection is done to perform any initialization.
     * This method MUST be invoked before the class is put into service.
     */
    @PostConstruct
    public void dataInit(){
        User helloUser = User.builder().userName("helloUser").passWord("helloUser").role(Role.USER).build();
        User adminUser = User.builder().userName("helloAdmin").passWord("helloAdmin").role(Role.ADMIN).build();

        userRepository.save(helloUser);
        userRepository.save(adminUser);
    }
}
