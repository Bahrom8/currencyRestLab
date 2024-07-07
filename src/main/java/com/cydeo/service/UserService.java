package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO create (UserDTO userDTO);

    UserDTO findByUsername(String username);

}
