package com.app.service.impl;

import com.app.beans.StatusCodes;
import com.app.entity.User;
import com.app.repo.UserRepo;
import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    HttpSession httpSession;
    @Override
    public StatusCodes login(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        StatusCodes statusCodes = new StatusCodes();

        User loggedInUser = userRepo.findByUsername(username);
        if (loggedInUser==null) {
            statusCodes.setStatus(404);
            statusCodes.setMessage("User Not Found");
        }
        else{
            if (loggedInUser.getPassword().equals(password)) {
                statusCodes.setStatus(200);
                statusCodes.setMessage("Welcome "+loggedInUser.getfName());
                httpSession.setAttribute("username",loggedInUser.getUsername());
            }
            else{
                statusCodes.setMessage("Wrong Password");
                statusCodes.setStatus(401);
            }
        }
        return statusCodes;
    }
}
