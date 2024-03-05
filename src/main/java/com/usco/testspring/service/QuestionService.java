package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Question;
import com.usco.testspring.dto.QuestionDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    public void save (QuestionDto question);
    public List<Question> getAllQuestions();
    public Question getQuestionById(Integer id);
    public Question updateQuestion(Integer id, QuestionDto dto);
    public void deleteQuestion(Integer id);
    

}
