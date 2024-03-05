package com.usco.testspring.domain;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Question {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuestion;

    @Column(nullable = false, length = 100)
    private String pregunta;

    @Column(nullable = false, length = 100)
    private int respuesta;

    @Column(nullable = false, length = 100)
    private String carrera;

    @ManyToOne
    @JoinColumn(name="id_survey", nullable=false)
    private Survey survey;
}
