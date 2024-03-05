package com.usco.testspring.controller;
import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.FacultyDto;
import com.usco.testspring.dto.FacultyDtoUpdate;
import com.usco.testspring.service.FacultyServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {

    private final FacultyServiceImpl facultyService;

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody FacultyDto faculty) {
        facultyService.save(faculty);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Faculty>> getAll () {
        return new ResponseEntity<>(facultyService.getAllFaculties(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById (@PathVariable("id") UUID id) {
        return new ResponseEntity<>(facultyService.getFacultyById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty (@PathVariable("id") UUID id, @RequestBody FacultyDtoUpdate faculty) {
        return new ResponseEntity<>(facultyService.updateFaculty(id, faculty),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFaculty (@PathVariable("id") UUID id) {
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
