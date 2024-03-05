package com.usco.testspring.dto;

import javax.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDtoUpdate {

    private String title;

    private String description;
}
