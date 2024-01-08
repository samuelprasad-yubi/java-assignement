package com.jmc.javacasestudy.controller;

import com.jmc.javacasestudy.repository.UserRepository;
import com.jmc.javacasestudy.security.jwt.JwtUtils;
import com.jmc.javacasestudy.security.services.UserDetailsImpl;
import com.jmc.javacasestudy.model.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  UserRepository userRepository;
  @Autowired
  JwtUtils jwtUtils;

  @Autowired PasswordEncoder encoder;
  @Autowired AuthenticationManager authenticationManager;

  @PostMapping("/sign-in")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles =
        user.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(
        new Route.JwtResponse(jwt, user.getId(), user.getUsername(), user.getEmail(), roles));
  }

  @PostMapping("/sign-up")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
    User user =
        new User(
            signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword()));

    if (signUpRequest.getRole() == null || signUpRequest.getRole().equalsIgnoreCase("user")) {
      user.setRole("ROLE_USER");
    } else if (signUpRequest.getRole().equalsIgnoreCase("admin")) {
      user.setRole("ROLE_ADMIN");
    } else {
      throw new RuntimeException("Role Not Found!");
    }
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
