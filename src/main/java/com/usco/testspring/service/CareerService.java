package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.dto.CareerDtoUpdate;
import com.usco.testspring.dto.vo.PonderadoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CareerService {
    public void save (CareerDto career);
    public List<Career> getAllCareers();
    public List<Career> getCareersByFaculty(UUID id);
    public Career getCareerById(UUID id);
    public Career updateCareer(UUID title, CareerDtoUpdate career);
    public void deleteCareer(String title);
    Optional<Career> findByTitle(String title);
    double calculatorPondereado(PonderadoDto ponderadoDto,CareerDtoUpdate career);

    List<Career> calculatePonderados(PonderadoDto ponderadoDto);
}
