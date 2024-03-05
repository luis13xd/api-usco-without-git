package com.usco.testspring.repository;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CareerRepository extends JpaRepository<Career, UUID> {
    @Query(value = "SELECT c FROM Career c WHERE c.faculty = :faculty")
    List<Career> findByFaculty(@Param("faculty") Faculty faculty);

    @Query(value = "SELECT c FROM Career c WHERE c.title = :title")
    Optional<Career> findByTitle(@Param("title") String title);

    @Query(value = "SELECT c FROM Career c WHERE c.id = :id")
    Optional<Career> findById(@Param("id") UUID id);


}
