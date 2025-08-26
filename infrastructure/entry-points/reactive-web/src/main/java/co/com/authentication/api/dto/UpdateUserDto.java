package co.com.authentication.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;

@Schema(name = "UpdateUserDto", description = "DTO for updating applicant information")
public record UpdateUserDto(

    @Schema(description = "names of the applicant", example = "Carlos Andres")
    String name,

    @Schema(description = "Last names of the applicant", example = "García Peres")
    String lastName,

    @Schema(description = "Birth date of the applicant", example = "1988-03-15")
    LocalDate birthDate,

    @Schema(description = "Address of the applicant", example = "Carrera 45 #89-10, Medellín")
    String address,

    @Schema(description = "Phone number of the applicant", example = "3109876543")
    String phone,

    @Schema(description = "Email of the applicant (must be valid format if provided)", example = "carlos.garcia@mail.com")
    @Email(message = "Invalid email format")
    String email,

    @Schema(description = "Base salary of the applicant (must be between 0 and 15,000,000 if provided)", example = "4200000")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "15000000.0", message = "Salary must be less than or equal to 15000000")
    Double baseSalary
) {}

