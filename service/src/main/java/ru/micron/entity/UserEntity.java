package ru.micron.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user", schema = "public")
@Accessors(chain = true)
public class UserEntity {

  @Id
  private UUID userId;
  private LocalDate dateOfBirth;
  private String mail;
  private Boolean mailing;
}
