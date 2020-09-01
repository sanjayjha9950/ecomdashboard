package com.app.service.impl;

import com.app.entity.User;
import com.app.repo.UserRepo;
import com.app.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean addUser(User user) {
        userRepo.save(user);
        return false;
    }

}
