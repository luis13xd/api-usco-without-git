package com.usco.testspring.repository;

import com.usco.testspring.domain.DataEncuesta;
import com.usco.testspring.domain.ResponseDataEncuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DataResponseRepository extends CrudRepository<ResponseDataEncuenta, UUID> {
    List<ResponseDataEncuenta> findByUserId(String userId);
}
