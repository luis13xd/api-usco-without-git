package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Question;
import com.usco.testspring.dto.QuestionDto;
import com.usco.testspring.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public void save(QuestionDto question) {
        Question questionToSave = modelMapper.map(question, Question.class);
        questionRepository.save(questionToSave);
    }

    @Override
    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found!"));
        return question;
    }

    @Override
    public Question updateQuestion(Integer id, QuestionDto question) {
        Question questionFound = getQuestionById(id);
        modelMapper.map(question, questionFound);
        return questionRepository.save(questionFound);
    }

    @Override
    public void deleteQuestion(Integer id) {
        Question questionFound = getQuestionById(id);
        questionRepository.deleteById(questionFound.getIdQuestion());
    }


}
