package com.usco.testspring.dto;


import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CareerDto {
    @NotBlank(message = "Title is required")
    private String title;

    @Min(0)
    @Max(100)
    private double lecturaCritica;
    @Min(0)
    @Max(100)
    private double cienciasNaturales;
    @Min(0)
    @Max(100)
    private double cienciasSociales;
    @Min(0)
    @Max(100)
    private double matematicas;
    @Min(0)
    @Max(100)
    private double ingles;

    private double puntajePonderado = 0.0;
    @Min(0)
    @Max(100)
    private double puntaCorte1;

    @Min(0)
    @Max(100)
    private double puntaCorte2;

    @NotNull(message = "Faculty is required")
    private UUID faculty;
}
