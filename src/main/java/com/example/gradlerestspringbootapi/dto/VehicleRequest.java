package com.example.gradlerestspringbootapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

  private String type;
  private String modelCode;
  private String brandName;
  private String launchDate;
}
