package com.intelematics.dao.user;

import com.intelematics.domain.user.User;

/**
 * Created by Ian on 2/28/2016.
 */
public interface UserDao {

    /**
     * Find user by username
     * @param username
     * @return
     */
    public User findByUsername(String username);

}
