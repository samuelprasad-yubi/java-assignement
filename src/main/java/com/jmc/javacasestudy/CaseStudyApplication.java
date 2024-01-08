package com.jmc.javacasestudy;

import com.jmc.javacasestudy.controller.AuthController;
import com.jmc.javacasestudy.model.Route;
import com.jmc.javacasestudy.model.SignupRequest;
import com.jmc.javacasestudy.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaseStudyApplication implements CommandLineRunner {

  @Autowired RouteService routeService;
  @Autowired AuthController authController;

  public static void main(String[] args) {
    SpringApplication.run(CaseStudyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    authController.registerUser(
        new SignupRequest("admin", "admin@gmail.com", "admin", "435435435"));

    routeService.addRoute(new Route(1L, "India", "USA"));
    routeService.addRoute(new Route(2L, "USA", "CHINA"));
    routeService.addRoute(new Route(3L, "CHINA", "NEPAL"));
    routeService.addRoute(new Route(4L, "NEPAL", "RUSSIA"));
  }
}
