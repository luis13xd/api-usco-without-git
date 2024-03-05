package com.usco.testspring.service;

import com.usco.testspring.domain.Period;
import com.usco.testspring.dto.PeriodDto;
import com.usco.testspring.dto.PeriodDtoUpdate;

import java.util.List;
import java.util.UUID;

public interface PeriodService {
    public void save (PeriodDto period);
    public List<Period> getAllPeriods(String period, Long year);
    public Period getPeriodById(UUID id);
    public Period updatePeriod(UUID id, PeriodDtoUpdate period);
    public void deletePeriod(UUID id);
}
