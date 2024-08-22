package br.com.soat8.techchallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String id;

    private String name;

    @Email(message = "Email should be valid")
    @JsonProperty("email_address")
    private String emailAddress;

    @Pattern(regexp = "\\d{11}", message = "CPF should be 11 digits")
    private String cpf;


}
