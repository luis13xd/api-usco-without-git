package com.usco.testspring.controller;

import com.usco.testspring.domain.Question;
import com.usco.testspring.domain.User;
import com.usco.testspring.dto.QuestionDto;
import com.usco.testspring.dto.UserDto;
import com.usco.testspring.dto.vo.AuthenticationDto;
import com.usco.testspring.repository.UserRepository;
import com.usco.testspring.service.QuestionServiceImpl;
import com.usco.testspring.service.UserServiceImpl;
import javax.validation.Valid;import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl questionService;

    private final UserRepository repository;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDto user) {
        if(repository.findByUserEmail(user.getUserEmail()).size() > 0){
            return new ResponseEntity<>("ya existe",HttpStatus.BAD_REQUEST);
        }
        if(repository.findByUserDocument(user.getUserDocument()).size() > 0){
            return new ResponseEntity<>("ya existe",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(questionService.save(user),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> questions = questionService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<List<User>> autenticate(@RequestBody AuthenticationDto dto) {
        return new ResponseEntity<>(repository.findByUserEmailAndPassword(dto.getUserEmail() ,dto.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getQuestionById(@PathVariable("id") Integer id) {
        User question = questionService.getUserById(id);
        return new ResponseEntity<>(convertToDto(question), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateQuestion(@PathVariable("id") Integer id, @RequestBody UserDto questionDto) {
        User question = questionService.updateUser(id, questionDto);
        return new ResponseEntity<>(convertToDto(question), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private UserDto convertToDto(User obj) {
        return mapper.map(obj, UserDto.class);
    }

    private User convertToEntity(User dto) {
        return mapper.map(dto, User.class);
    }
}