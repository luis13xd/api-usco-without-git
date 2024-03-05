package com.usco.testspring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeriodDtoUpdate {
    private String period;
    private Long year;
}
