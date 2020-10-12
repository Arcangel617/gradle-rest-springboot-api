package com.example.gradlerestspringbootapi.dao.repository;

import com.example.gradlerestspringbootapi.dao.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
