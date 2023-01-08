package com.vinicius.client.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {
    private String name;
    private String email;
    private String cpf;
}
