package com.jmc.javacasestudy.controller;

import com.jmc.javacasestudy.model.Bus;
import com.jmc.javacasestudy.model.GenericResponse;
import com.jmc.javacasestudy.model.Route;
import com.jmc.javacasestudy.service.BusService;
import com.jmc.javacasestudy.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-url")
public class AdminController {

  @Autowired BusService busService;

  @Autowired ScheduleService scheduleService;

  @PostMapping("/add")
  public ResponseEntity<GenericResponse> addBus(@Valid @RequestBody Bus bus) {
    busService.add(bus);
    return ResponseEntity.ok(new GenericResponse("Bus is added"));
  }

  @PostMapping("/edit")
  public ResponseEntity<GenericResponse> editBus(@Valid @RequestBody Bus bus) {
    busService.edit(bus);
    return ResponseEntity.ok(new GenericResponse("Bus is edited"));
  }

  @PostMapping("/delete/{busNumber}")
  public ResponseEntity<GenericResponse> deleteBus(@PathVariable String busNumber) {
    busService.delete(busNumber);
    return ResponseEntity.ok(new GenericResponse("Bus is deleted"));
  }

  @PostMapping("/add-schedule")
  public ResponseEntity<GenericResponse> addSchedule(
      @RequestBody Route.AddScheduleRequest addScheduleRequest) {
    scheduleService.addSchedule(addScheduleRequest);
    return ResponseEntity.ok(new GenericResponse("Successfull"));
  }
}
