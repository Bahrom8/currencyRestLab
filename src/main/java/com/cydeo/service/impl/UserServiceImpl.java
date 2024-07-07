package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }


    /**
     * Retrieves a list of all users from the database.
     *
     * @return List of UserDTO representing all users.
     */
    @Override
    public List<UserDTO> findAll() {
        // Fetch all users from the UserRepository and convert each to a UserDTO.
        return userRepository.findAll().stream()
                .map(user -> mapperUtil.convert(user,new UserDTO()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a user by the specified username.
     *
     * @param username The username to search for.
     * @return The UserDTO representing the found user.
     * @throws RuntimeException if the user with the given username is not found.
     */
    @Override
    public UserDTO findByUsername(String username) {
        // Find and return the user by username, or throw an exception if not found.
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        return mapperUtil.convert(user,new UserDTO());
    }


    /**
     * Creates a new user based on the provided UserDTO.
     *
     * @param userDTO The UserDTO containing user information.
     * @return The created UserDTO.
     */
    @Override
    public UserDTO create(UserDTO userDTO) {
        // Save the new user to the database and convert the result to a UserDTO.
        User newUser = userRepository.save(mapperUtil.convert(userDTO,new User()));
        return mapperUtil.convert(newUser,new UserDTO());
    }
}
