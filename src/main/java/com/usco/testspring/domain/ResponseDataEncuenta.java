package com.usco.testspring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "responses")
public class ResponseDataEncuenta {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private String carrera;
    private double porcentaje;;
    private UUID idEncuesta;
    private String userId;
}
