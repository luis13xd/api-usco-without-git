package com.usco.testspring.dto.vo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDto {
    private String userEmail;
    private String password;
}
