package com.usco.testspring.service;

import com.usco.testspring.domain.Survey;
import com.usco.testspring.domain.User;
import com.usco.testspring.dto.UserDto;
import com.usco.testspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    @Override
    public User save(UserDto user) {
        User surveyToSave = modelMapper.map(user, User.class);
        return userRepository.save(surveyToSave);
    }

    @Override
    public List<User> getAll() {
        return (List) userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        User survey = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found!"));
        return survey;
    }

    @Override
    public User updateUser(Integer id, UserDto dto) {
        User surveyFound = getUserById(id);
        modelMapper.map(dto, surveyFound);
        return userRepository.save(surveyFound);
    }

    @Override
    public void deleteUser(Integer id) {
        User surveyFound = getUserById(id);
        userRepository.deleteById(surveyFound.getIdUser());
    }
}
