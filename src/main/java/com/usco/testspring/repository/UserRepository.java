package com.usco.testspring.repository;

import com.usco.testspring.domain.Survey;
import com.usco.testspring.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUserEmailAndPassword(String userEmail, String password);
    List<User> findByUserEmail(String userEmail);
    List<User> findByUserDocument(String userEmail);
}

