package com.app.service;

import com.app.beans.StatusCodes;
import com.app.entity.User;

public interface LoginService {

    public StatusCodes login(User user);
}
