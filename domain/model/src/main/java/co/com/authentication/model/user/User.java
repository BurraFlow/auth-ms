package co.com.authentication.model.user;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

  private Long id;
  private String name;
  private String lastName;
  private LocalDate birthDate;
  private String address;
  private String phone;
  private String email;
  private Double baseSalary;
}
