package com.intelematics.service.login;

import com.intelematics.domain.user.User;

/**
 * Created by Ian on 2/1/2017.
 */
public interface LoginService {

    User login(User user);

    User login(String username, String password);
}
