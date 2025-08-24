package co.com.authentication.model.user;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
  private Long id;
  private String name;
  private String lastName;
  private String birthDate;
  private String address;
  private String phone;
  private String email;
  private Double baseSalary;
}
