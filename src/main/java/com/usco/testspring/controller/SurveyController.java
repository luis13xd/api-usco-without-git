package com.usco.testspring.controller;

import com.usco.testspring.domain.Question;
import com.usco.testspring.domain.Survey;
import com.usco.testspring.dto.QuestionDto;
import com.usco.testspring.dto.SurveyDto;
import com.usco.testspring.service.SurveyServiceImpl;
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
@RequestMapping("/api/v1/survey")
public class SurveyController {

    private final SurveyServiceImpl surveyService;

    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody SurveyDto survey) {
        surveyService.save(survey);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAll () {
        List<SurveyDto> surveys = surveyService.getAllSurveys().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(surveys,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyDto> getSurveyById (@PathVariable("id") Integer id) {
        Survey survey = surveyService.getSurveyById(id);
        return new ResponseEntity<>(convertToDto(survey),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyDto> updateSurvey (@PathVariable("id") Integer id, @RequestBody SurveyDto surveyDto) {
        Survey survey = surveyService.updateSurvey(id, surveyDto);
        return new ResponseEntity<>(convertToDto(survey),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurvey (@PathVariable("id") Integer id) {
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private SurveyDto convertToDto(Survey obj){
        return mapper.map(obj, SurveyDto.class);
    }

    private Survey convertToEntity(SurveyDto dto){
        return mapper.map(dto, Survey.class);
    }
}
