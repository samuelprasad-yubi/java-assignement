package com.jmc.javacasestudy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRequest {
  private String username;

  private String email;

  private String role;

  private String password;
}
