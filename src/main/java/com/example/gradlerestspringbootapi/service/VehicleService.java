package com.example.gradlerestspringbootapi.service;

import com.example.gradlerestspringbootapi.dao.entity.Vehicle;
import com.example.gradlerestspringbootapi.dao.repository.VehicleRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  public VehicleService(
      VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Transactional
  public Vehicle createVehicle(final String type, final String modelCode, final String brandName,
      final String launchDate) {
    final Vehicle vehicle = new Vehicle();
    vehicle.setType(type);
    vehicle.setModelCode(modelCode);
    vehicle.setBrandName(brandName);
    vehicle.setLaunchDate(LocalDate.parse(launchDate));
    return this.vehicleRepository.save(vehicle);
  }

  @Transactional(readOnly = true)
  public List<Vehicle> getAllVehicles() {
    return this.vehicleRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<Vehicle> getVehicle(final int id) {
    return this.vehicleRepository.findById(id);
  }
}
