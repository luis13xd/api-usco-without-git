package com.usco.testspring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class GeneralReport {
        @Id
        @Column(name = "id", nullable = false)
        private UUID id;
        private String carrera;
        private double puntaje;
        private UUID idEncuesta;
    }
