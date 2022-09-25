package com.example.springwebstore.Service;

import com.example.springwebstore.DTO.UserDTO;
import com.example.springwebstore.Data.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);

    void save(User user);

    List<UserDTO> getAll();

    User findByName(String name);

    void updateProfile(UserDTO userDTO);
}
