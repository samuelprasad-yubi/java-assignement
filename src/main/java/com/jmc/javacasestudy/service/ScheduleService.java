package com.jmc.javacasestudy.service;

import com.jmc.javacasestudy.model.Route;
import com.jmc.javacasestudy.model.RouteDetailsResponse;
import com.jmc.javacasestudy.model.Schedule;

import java.util.List;

public interface ScheduleService {

  void addSchedule(Route.AddScheduleRequest addScheduleRequest);

  List<Schedule> getAllSchedule();

  List<RouteDetailsResponse> getScheduleByRouteId(Long routeId);
}
