package com.intelematics.service.user;

import com.intelematics.domain.user.User;

/**
 * Created by Ian on 2/28/2016.
 */
public interface UserService {

    public User findByUsername(String username);

}
