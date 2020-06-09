package dev.naman.interviewbitclone.controllers;

import dev.naman.interviewbitclone.dto.ResponseDto;
import dev.naman.interviewbitclone.models.User;
import dev.naman.interviewbitclone.services.UserService;
import dev.naman.interviewbitclone.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Constants.USERS_END_POINT)
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // get request to /user?category="Books"&price="<100"
    @GetMapping("/{id}")
    public ResponseDto<User> getUser(@PathVariable(name = "id") UUID id) {
        User serviceResponse = userService.getUser(id);

        if(serviceResponse == null) {
            return new ResponseDto(HttpStatus.NOT_FOUND, serviceResponse);
        }
        return new ResponseDto(HttpStatus.FOUND, userService.getUser(id));
    }
}
