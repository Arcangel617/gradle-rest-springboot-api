package com.example.gradlerestspringbootapi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.gradlerestspringbootapi.dao.entity.Vehicle;
import com.example.gradlerestspringbootapi.dto.VehicleRequest;
import com.example.gradlerestspringbootapi.service.VehicleService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(
      VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @PostMapping(value = "/vehicles", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Vehicle> create(
      @RequestBody VehicleRequest vehicleRequest
  ) {
    return ResponseEntity.ok(vehicleService.createVehicle(
        vehicleRequest.getType(),
        vehicleRequest.getModelCode(),
        vehicleRequest.getBrandName(),
        vehicleRequest.getLaunchDate()
    ));
  }

  @GetMapping(value = "/vehicles", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Vehicle>> getAll() {
    return ResponseEntity.ok(vehicleService.getAllVehicles());
  }

  @GetMapping(value = "/vehicles/{id}", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<Vehicle>> get(
      @PathVariable String id
  ) {
    return ResponseEntity.ok(vehicleService.getVehicle(Integer.parseInt(id)));
  }
}
