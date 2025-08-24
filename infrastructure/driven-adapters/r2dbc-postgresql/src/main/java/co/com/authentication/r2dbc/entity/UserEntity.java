package co.com.authentication.r2dbc.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

  @Id
  private Long id;
  private String name;
  @Column("last_name")
  private String lastName;
  @Column("birth_date")
  private LocalDate birthDate;
  private String address;
  private String phone;
  private String email;
  @Column("base_salary")
  private Double baseSalary;
}
