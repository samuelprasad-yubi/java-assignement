package com.jmc.javacasestudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "reg_num", unique = true)
  private String regNum;

  @Column(name = "type")
  private Route.BusTypeEnum type;
}
