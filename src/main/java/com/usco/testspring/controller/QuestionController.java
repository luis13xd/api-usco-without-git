package com.usco.testspring.controller;

import com.usco.testspring.domain.Question;
import com.usco.testspring.dto.QuestionDto;
import com.usco.testspring.service.QuestionServiceImpl;
import javax.validation.Valid;import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {


    private final QuestionServiceImpl questionService;

    private final ModelMapper mapper;

    public QuestionController(QuestionServiceImpl questionService, ModelMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody QuestionDto question) {
        questionService.save(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAll () {
        List<QuestionDto> questions = questionService.getAllQuestions().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> getQuestionById (@PathVariable("id") Integer id) {
        Question question = questionService.getQuestionById(id);
        return new ResponseEntity<>(convertToDto(question),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> updateQuestion (@PathVariable("id") Integer id, @RequestBody QuestionDto questionDto) {
        Question question = questionService.updateQuestion(id, questionDto);
        return new ResponseEntity<>(convertToDto(question),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion (@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private QuestionDto convertToDto(Question obj){
        return mapper.map(obj, QuestionDto.class);
    }

    private Question convertToEntity(Question dto){
        return mapper.map(dto, Question.class);
    }
}
