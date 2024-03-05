package com.usco.testspring.service;
import com.usco.testspring.domain.Period;
import com.usco.testspring.dto.PeriodDto;
import com.usco.testspring.dto.PeriodDtoUpdate;
import com.usco.testspring.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeriodServiceImpl implements PeriodService{
    private final PeriodRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public void save(PeriodDto period) {
        Period periodToSave = modelMapper.map(period, Period.class);
        repository.save(periodToSave);
    }

    @Override
    public List<Period> getAllPeriods(String period, Long year) {
        System.out.println(year);
        List<Period> periods = (List<Period>) repository.findAll();
        List<Period> filteredPeriods = periods.stream().filter(periodSearch -> period == null || periodSearch.getPeriod().equalsIgnoreCase(period)).filter(yearSearch -> year == null || yearSearch.getYear().equals(year)).collect(Collectors.toList());
        return filteredPeriods;
    }

    @Override
    public Period getPeriodById(UUID id) {
        Period period = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Period not found!"));
        return period;
    }

    @Override
    public Period updatePeriod(UUID id, PeriodDtoUpdate period) {
        Period periodFound = getPeriodById(id);
        modelMapper.map(period, periodFound);
        Period periodToUpdate = repository.save(periodFound);
        return periodToUpdate;
    }

    @Override
    public void deletePeriod(UUID id) {
        Period periodFound = getPeriodById(id);
        repository.deleteById(periodFound.getId());
    }
}
