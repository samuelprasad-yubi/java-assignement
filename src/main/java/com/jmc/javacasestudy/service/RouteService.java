package com.jmc.javacasestudy.service;

import com.jmc.javacasestudy.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
  void addRoute(Route route);

  Optional<Route> getById(Long id);

  List<Route> getAllRoute();
}
