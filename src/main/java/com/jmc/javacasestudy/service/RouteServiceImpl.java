package com.jmc.javacasestudy.service;

import com.jmc.javacasestudy.model.Route;
import com.jmc.javacasestudy.repository.RouteRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

  @Autowired
  RouteRepository routeRepository;

  @Override
  public void addRoute(Route route) {
    routeRepository.save(route);
  }

  @Override
  public Optional<Route> getById(Long id) {
    return routeRepository.findById(id);
  }

  @Override
  public List<Route> getAllRoute() {
    return routeRepository.findAll();
  }
}
