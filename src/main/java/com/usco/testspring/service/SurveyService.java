package com.usco.testspring.service;

import com.usco.testspring.domain.Survey;
import com.usco.testspring.dto.SurveyDto;

import java.util.List;

public interface SurveyService {

    public void save (SurveyDto survey);
    public List<Survey> getAllSurveys();
    public Survey getSurveyById(Integer id);
    public Survey updateSurvey(Integer id, SurveyDto dto);
    public void deleteSurvey(Integer id);

}
