package co.com.authentication.model.user;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

  private Long id;
  private String name;
  private String lastName;
  private String documentationNumber;
  private LocalDate birthDate;
  private String address;
  private String phone;
  private String email;
  private Double baseSalary;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", documentationNumber='" + documentationNumber + '\'' +
        ", birthDate=" + birthDate +
        ", address='" + address + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", baseSalary=" + baseSalary +
        '}';
  }
}
