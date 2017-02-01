package com.intelematics.service.test.unit;

import com.intelematics.dao.user.UserDao;
import com.intelematics.domain.user.User;
import com.intelematics.service.user.UserService;
import com.intelematics.service.user.UserServiceImpl;
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
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserDao userDao;

    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserByUsername(){
        String username = "test";

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setPassword("test");
        testUser.setId(1L);

        Mockito.when(userDao.findByUsername(username)).thenReturn(testUser);

        User user = userService.findByUsername(username);

        Assert.assertEquals(user, testUser);
    }

}
