package com.elcom.flux.controllers;

import com.elcom.flux.requests.PasswordRequest;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;
    @PatchMapping("/changePassword")
    public MessageResponse changePassword(@RequestBody PasswordRequest passwordRequest) {
        return  userService.changePassword(passwordRequest);
    }

}
