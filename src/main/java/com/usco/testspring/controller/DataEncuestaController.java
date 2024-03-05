package com.usco.testspring.controller;


import com.usco.testspring.domain.DataEncuesta;
import com.usco.testspring.domain.GeneralReport;
import com.usco.testspring.domain.ResponseDataEncuenta;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.repository.DataEncuestaRepository;
import com.usco.testspring.repository.DataResponseRepository;
import com.usco.testspring.service.CareerServiceImpl;
import com.usco.testspring.service.RecommenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/data")
public class DataEncuestaController {

    private final DataEncuestaRepository careerService;
    private final DataResponseRepository responseRepository;

    private final RecommenderService service;

    @GetMapping("report")
    public ResponseEntity<List<GeneralReport>> consultarResultados () {
        return new ResponseEntity<>(service.promedioGeneral(),HttpStatus.OK);
    }


    @PostMapping("/masive/{userId}")
    public ResponseEntity<List<ResponseDataEncuenta>> save (@PathVariable("userId") String userId, @RequestBody List<DataEncuesta> career) {
        List<DataEncuesta> newData = new ArrayList<>();
        List<ResponseDataEncuenta> response = new ArrayList<>();
        List<ResponseDataEncuenta> validate = responseRepository.findByUserId(userId);
        if (validate.size() > 0){
            for (ResponseDataEncuenta r: validate){
                responseRepository.deleteById(r.getId());
            }
        }
        UUID uuid = UUID.randomUUID();
        for ( DataEncuesta d : career){
            d.setIdEncuesta(uuid);
            d.setUserId(userId);
            newData.add(d);
        }
        newData = (List<DataEncuesta>) careerService.saveAll(newData);
        responseRepository.saveAll(service.recomendar(newData,userId));
        return new ResponseEntity<>(responseRepository.findByUserId(userId),HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<?> save ( @RequestBody DataEncuesta career) {
        careerService.save(career);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("byuser/{userId}")
    public ResponseEntity<?> consultarResultados ( @PathVariable("userId") String userId) {
        return new ResponseEntity<>(responseRepository.findByUserId(userId),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") UUID id) {
        responseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
