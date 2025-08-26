package co.com.authentication.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(name = "CreateUserDto", description = "DTO for creating a new applicant")
public record CreateUserDto(

    @Schema(description = "First name of the applicant", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Name is required")
    String name,

    @Schema(description = "Last name of the applicant", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Last name is required")
    String lastName,
    @Schema(description = "Documentation number of the applicant", example = "1041923445")
    String documentationNumber,

    @Schema(description = "Birth date of the applicant", example = "1990-05-21")
    LocalDate birthDate,

    @Schema(description = "Address of the applicant", example = "Calle 123 #45-67, Bogotá")
    String address,

    @Schema(description = "Phone number of the applicant", example = "3001234567")
    String phone,

    @Schema(description = "Email of the applicant", example = "juan.perez@mail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,

    @Schema(description = "Base salary of the applicant (must be between 0 and 15,000,000)", example = "3500000", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Base salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "15000000.0", message = "Salary must be less than or equal to 15000000")
    Double baseSalary
) {

}
