package com.usco.testspring.service;

import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.FacultyDto;
import com.usco.testspring.dto.FacultyDtoUpdate;

import java.util.List;
import java.util.UUID;

public interface FacultyService {
    public void save (FacultyDto faculty);
    public List<Faculty> getAllFaculties();
    public Faculty getFacultyById(UUID id);
    public Faculty updateFaculty(UUID id, FacultyDtoUpdate faculty);
    public void deleteFaculty(UUID id);

}
