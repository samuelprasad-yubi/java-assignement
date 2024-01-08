package com.jmc.javacasestudy.service;

import com.jmc.javacasestudy.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusService {
  void add(Bus bus);

  void delete(String busNumber);

  void edit(Bus bus);

  Optional<Bus> findByRegNum(String busNumber);

  List<Bus> getAllBus();
}
