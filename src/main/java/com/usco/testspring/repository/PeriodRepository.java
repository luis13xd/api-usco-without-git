package com.usco.testspring.repository;

import com.usco.testspring.domain.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PeriodRepository extends CrudRepository<Period, UUID> {
}
