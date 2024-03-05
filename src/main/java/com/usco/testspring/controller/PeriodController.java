package com.usco.testspring.controller;
import com.usco.testspring.domain.Period;
import com.usco.testspring.dto.PeriodDto;
import com.usco.testspring.dto.PeriodDtoUpdate;
import com.usco.testspring.service.PeriodServiceImpl;
import javax.validation.Valid;import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/period")
public class PeriodController {
    private final PeriodServiceImpl periodService;

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody PeriodDto period) {
        periodService.save(period);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Period>> getAll (@RequestParam(value = "period", required = false) String period, @RequestParam(value = "year", required = false) Long year)  {
        return new ResponseEntity<>(periodService.getAllPeriods(period, year),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Period> getPeriodById (@PathVariable("id") UUID id) {
        return new ResponseEntity<>(periodService.getPeriodById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Period> updatePeriod (@PathVariable("id") UUID id, @RequestBody PeriodDtoUpdate period) {
        return new ResponseEntity<>(periodService.updatePeriod(id, period),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeriod (@PathVariable("id") UUID id) {
        periodService.deletePeriod(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
