package com.intelematics.service.login;

import com.intelematics.domain.user.User;
import com.intelematics.exceptions.IntelematicsException;
import com.intelematics.exceptions.IntelematicsValidationException;
import com.intelematics.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Ian on 2/1/2017.
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    static final Logger log = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserService userService;

    public User login(User user) {
        if(user == null) {
            throw new IntelematicsValidationException("Cannot log in. Please try again or contact engineering");
        }

        return login(user.getUsername(), user.getPassword());
    }

    public User login(String username, String password) {
        if(username == null || "".equals(username.trim()) || password == null || "".equals(password.trim())) {
            throw new IntelematicsValidationException("Username and/or password may not be empty");
        }

        log.info("Attempting to log in user "+username);

        User user;
        try {
            user = userService.findByUsername(username);
        } catch(Exception e) {
            throw new IntelematicsException("We are unable to log you in. Please try again later or contact engineering", e);
        }

        if(user == null) {
            throw new IntelematicsValidationException("There is no user with this username. Please make sure you entered the correct credentials.");
        }

        if(!password.equals(user.getPassword())) {
            throw new IntelematicsValidationException("Incorrect credentials.");
        }

        return user;
    }
}
