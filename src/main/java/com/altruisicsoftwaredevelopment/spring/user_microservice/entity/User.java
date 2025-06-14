package com.altruisicsoftwaredevelopment.spring.user_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

  @Id @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String fullName;
}
