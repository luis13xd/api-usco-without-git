package com.usco.testspring.service;

import com.usco.testspring.domain.Survey;
import com.usco.testspring.dto.SurveyDto;
import com.usco.testspring.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{

    private final SurveyRepository surveyRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public void save(SurveyDto survey) {
        Survey surveyToSave = modelMapper.map(survey, Survey.class);
        surveyRepository.save(surveyToSave);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return (List<Survey>) surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(Integer id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found!"));
        return survey;
    }

    @Override
    public Survey updateSurvey(Integer id, SurveyDto survey) {
        Survey surveyFound = getSurveyById(id);
        modelMapper.map(survey, surveyFound);
        return surveyRepository.save(surveyFound);
    }

    @Override
    public void deleteSurvey(Integer id) {
        Survey surveyFound = getSurveyById(id);
        surveyRepository.deleteById(surveyFound.getIdSurvey());
    }
}
