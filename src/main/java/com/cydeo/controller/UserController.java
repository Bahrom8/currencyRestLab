package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper> getAllUsers(){

        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Users are successfully retrieved.")
                .code(HttpStatus.OK.value())
                .data(userService.findAll())
                .build());

    }

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getUserByUsername(@PathVariable("username") String username){

        return ResponseEntity.ok(ResponseWrapper.builder().success(true)
                .message("User: "+ username+" is retrieved.")
                .code(HttpStatus.OK.value())
                .data(userService.findByUsername(username)).build());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createUser(@RequestBody @Valid UserDTO userDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .success(true)
                        .code(HttpStatus.CREATED.value())
                        .message("User is successfully created.")
                        .data(userService.create(userDTO)).build());


    }

}