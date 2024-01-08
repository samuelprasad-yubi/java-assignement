package com.jmc.javacasestudy.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import lombok.*;

@Entity
@Table(name = "schedule")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "end_time")
  private LocalTime endTime;

  @Column(name = "start_time")
  private LocalTime startTime;

  @ManyToOne private Bus bus;

  @ManyToOne private Route route;

  public enum ERole {
    USER,
    ADMIN
  }
}
