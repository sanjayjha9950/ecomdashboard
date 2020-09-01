package com.app.service;

import com.app.entity.User;
import org.springframework.stereotype.Component;


public interface RegisterService {

    public boolean addUser(User user);

}
