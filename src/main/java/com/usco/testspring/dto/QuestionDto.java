package com.usco.testspring.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto {

    private Integer idQuestion;

    private String question;

    private int answerQuestion;

    @JsonBackReference
    private SurveyDto surveyQuestion;
}
