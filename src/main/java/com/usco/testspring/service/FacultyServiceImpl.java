package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.FacultyDto;
import com.usco.testspring.dto.FacultyDtoUpdate;
import com.usco.testspring.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final ModelMapper modelMapper;
    @Override
    public void save(FacultyDto faculty) {
        Faculty facultyToSave = modelMapper.map(faculty, Faculty.class);
        facultyRepository.save(facultyToSave);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return (List<Faculty>) facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(UUID id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Faculty not found!"));
        return faculty;
    }

    @Override
    public Faculty updateFaculty(UUID id, FacultyDtoUpdate faculty) {
        Faculty facultyFound = getFacultyById(id);
        modelMapper.map(faculty, facultyFound);
        Faculty FacultyUpdate = facultyRepository.save(facultyFound);
        return FacultyUpdate;
    }

    @Override
    public void deleteFaculty(UUID id) {
        Faculty facultyFound = getFacultyById(id);
        facultyRepository.deleteById(facultyFound.getId());
    }
}
