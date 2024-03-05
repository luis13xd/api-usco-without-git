package com.usco.testspring.dto.vo;

import javax.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PonderadoDto {
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
}
