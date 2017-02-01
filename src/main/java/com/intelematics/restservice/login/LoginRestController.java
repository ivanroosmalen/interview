package com.intelematics.restservice.login;

import com.intelematics.domain.user.User;
import com.intelematics.restservice.BaseRestController;
import com.intelematics.restservice.Response;
import com.intelematics.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Ian on 3/1/2016.
 */
@RestController
@RequestMapping("/api/v1/login")
public class LoginRestController extends BaseRestController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response login(@RequestBody User userRequest) {
        User user = loginService.login(userRequest);

        Response response = new Response();
        Map<String, Object> body = response.getBody();
        body.put("user", user);
        return response;
    }
}
