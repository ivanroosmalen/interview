package com.intelematics.service.test.unit;

import com.intelematics.domain.user.User;
import com.intelematics.exceptions.IntelematicsException;
import com.intelematics.exceptions.IntelematicsIllegalArgumentException;
import com.intelematics.exceptions.IntelematicsValidationException;
import com.intelematics.service.login.LoginService;
import com.intelematics.service.login.LoginServiceImpl;
import com.intelematics.service.user.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Ian on 2/1/2017.
 */
public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService = new LoginServiceImpl();

    @Mock
    private UserService userService;

    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin(){
        String username = "test";
        String password = "password";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword(password);
        testUser.setId(1L);

        Mockito.when(userService.findByUsername(username)).thenReturn(testUser);

        User user = loginService.login(username, password);

        Assert.assertEquals(testUser, user);
    }

    @Test(expectedExceptions = IntelematicsValidationException.class)
    public void testLoginWithNullInput(){
        String username = null;
        String password = "password";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword(password);
        testUser.setId(1L);

        Mockito.when(userService.findByUsername(username)).thenReturn(testUser);

        loginService.login(username, password);
    }

    @Test(expectedExceptions = IntelematicsValidationException.class)
    public void testLoginWithNullUser(){
        String username = "test";
        String password = "password";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword(password);
        testUser.setId(1L);

        Mockito.when(userService.findByUsername(username)).thenReturn(null);

        loginService.login(username, password);
    }

    @Test(expectedExceptions = IntelematicsValidationException.class)
    public void testLoginInvalidCredentials(){
        String username = "test";
        String password = "password";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword("differentpassword");
        testUser.setId(1L);

        Mockito.when(userService.findByUsername(username)).thenReturn(testUser);

        loginService.login(username, password);
    }

    @Test(expectedExceptions = IntelematicsException.class)
    public void testLoginWitheException(){
        String username = "test";
        String password = "password";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword("differentpassword");
        testUser.setId(1L);

        Mockito.doThrow(new IntelematicsIllegalArgumentException("error")).when(userService).findByUsername(username);

        loginService.login(username, password);
    }
}
