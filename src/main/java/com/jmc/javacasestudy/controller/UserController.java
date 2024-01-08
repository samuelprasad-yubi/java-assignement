package com.jmc.javacasestudy.controller;

import com.jmc.javacasestudy.model.Bus;
import com.jmc.javacasestudy.model.Route;
import com.jmc.javacasestudy.model.RouteDetailsResponse;
import com.jmc.javacasestudy.model.Schedule;
import com.jmc.javacasestudy.service.BusService;
import com.jmc.javacasestudy.service.RouteService;
import com.jmc.javacasestudy.service.ScheduleService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired BusService busService;

  @Autowired RouteService routeService;

  @Autowired ScheduleService scheduleService;

  @GetMapping("/get-all-bus")
  public ResponseEntity<List<Bus>> getAllBus() {
    return ResponseEntity.ok(busService.getAllBus());
  }

  @GetMapping("/get-all-routes")
  public ResponseEntity<List<Route>> getAllRoutes() {
    return ResponseEntity.ok(routeService.getAllRoute());
  }

  @GetMapping("/get-all-schedule")
  public ResponseEntity<List<Schedule>> getAllSchedule() {
    return ResponseEntity.ok(scheduleService.getAllSchedule());
  }

  @GetMapping("/get-schedule-by-route-id/{routeId}")
  public ResponseEntity<List<RouteDetailsResponse>> getScheduleByRouteId(
      @PathVariable Long routeId) {
    return ResponseEntity.ok(scheduleService.getScheduleByRouteId(routeId));
  }
}
