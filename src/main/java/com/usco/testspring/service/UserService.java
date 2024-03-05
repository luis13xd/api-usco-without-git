package com.usco.testspring.service;


import com.usco.testspring.domain.User;
import com.usco.testspring.dto.UserDto;


import java.util.List;

public interface UserService {

    public User save (UserDto user);
    public List<User> getAll();
    public User getUserById(Integer id);
    public User updateUser(Integer id, UserDto dto);
    public void deleteUser(Integer id);
}
