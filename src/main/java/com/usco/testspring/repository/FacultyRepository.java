package com.usco.testspring.repository;

import com.usco.testspring.domain.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, UUID> {
}
