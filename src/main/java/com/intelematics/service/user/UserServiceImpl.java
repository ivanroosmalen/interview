package com.intelematics.service.user;

import com.intelematics.dao.user.UserDao;
import com.intelematics.domain.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Ian on 2/28/2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public User findByUsername(String username) {
        log.info("Finding user "+username);

        return userDao.findByUsername(username);
    }

}
