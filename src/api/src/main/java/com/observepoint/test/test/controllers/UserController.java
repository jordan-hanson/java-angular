package com.observepoint.test.test.controllers;

import com.observepoint.test.test.models.User;
import com.observepoint.test.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //    Find All Users
    //    http://localhost:8080/users/users
    @GetMapping(value = "/users",
            produces = "application/json")
    public ResponseEntity<?> listAllUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }
    //    Find User By Id
    //    http://localhost:8080/users/user/1
    @GetMapping(value = "/user/{userId}", produces = "applications/json")
    public ResponseEntity<?> getUserById(@PathVariable long userId)
    {
        User user = userService.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //    Add New User
    //    http://localhost:8080/users/user
    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<?> addNewUser(@RequestBody User newuser)
    {
//      Set User id
        newuser.setUserid(0);
//      Call add new User to UserService
        newuser = userService.save(newuser);
//      Set location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

//        return new ResponseEntity<>(new CreatedUser(newuser.getUserid(), getUserByUserName()), responseHeaders,
//                HttpStatus.CREATED);
        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }
    //    Update User by User Id
//    http://localhost:2019/users/user/1
    @PatchMapping(value = "/user/{userId}", consumes = "application/json")
    public ResponseEntity<?> updateUserById(@RequestBody User updateUser, @PathVariable long userId)
    {
        userService.update(updateUser, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    Delete User
//    http://localhost:8080/users/user/1
    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUser(
            @PathVariable long userId
    )
    {
        userService.delete(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    Use NO_CONTENT to see a 204 and a 1 back to see it worked.
//    Update those on end points http status
}

