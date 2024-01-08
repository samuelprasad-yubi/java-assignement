package com.jmc.javacasestudy.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "route")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "start_location")
  private String startLocation;

  @Column(name = "end_location")
  private String endLocation;

  public enum BusTypeEnum {
    ORDINARY,
    DELUXE
  }

  @Data
  public static class AddScheduleRequest {
    private LocalTime endTime;
    private Long routeId;
    private LocalTime startTime;
    private String busRegNum;
  }

  public static class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(
        String accessToken, Long id, String username, String email, List<String> roles) {
      this.token = accessToken;
      this.id = id;
      this.username = username;
      this.email = email;
      this.roles = roles;
    }

    public String getAccessToken() {
      return token;
    }

    public void setAccessToken(String accessToken) {
      this.token = accessToken;
    }

    public String getTokenType() {
      return type;
    }

    public void setTokenType(String tokenType) {
      this.type = tokenType;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public List<String> getRoles() {
      return roles;
    }
  }
}
