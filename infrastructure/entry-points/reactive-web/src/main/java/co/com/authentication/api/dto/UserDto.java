package co.com.authentication.api.dto;

import java.time.LocalDate;

public record UserDto(
    Long id,
    String name,
    String lastName,
    String documentationNumber,
    LocalDate birthDate,
    String address,
    String phone,
    String email,
    Double baseSalary
) {

}

