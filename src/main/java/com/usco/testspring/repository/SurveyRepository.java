package com.usco.testspring.repository;

import com.usco.testspring.domain.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Integer> {
}
