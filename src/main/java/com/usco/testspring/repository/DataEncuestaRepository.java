package com.usco.testspring.repository;

import com.usco.testspring.domain.DataEncuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DataEncuestaRepository extends CrudRepository<DataEncuesta,Integer> {
    List<DataEncuesta> findByIdEncuesta(UUID id);
}
