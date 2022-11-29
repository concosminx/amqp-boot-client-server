package com.nimsoc.spring.registration.async.service;

import com.nimsoc.spring.dto.CarDto;
import com.nimsoc.spring.dto.RegistrationDto;
import com.nimsoc.spring.registration.async.persistance.Car;
import com.nimsoc.spring.registration.async.persistance.CarRepository;
import com.nimsoc.spring.registration.async.persistance.Registration;
import com.nimsoc.spring.registration.async.persistance.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService {

  private final CarMapper carMapper;
  private final RegistrationMapper registrationMapper;
  private final CarRepository carRepository;
  private final RegistrationRepository registrationRepository;

  public RegistrationService(CarMapper carMapper, RegistrationMapper registrationMapper, CarRepository carRepository, RegistrationRepository registrationRepository) {
    this.carMapper = carMapper;
    this.registrationMapper = registrationMapper;
    this.carRepository = carRepository;
    this.registrationRepository = registrationRepository;
  }

  public void saveCar(CarDto carDto, UUID correlationId) {
    Car car = carMapper.toCar(carDto);
    car.setCorrelationId(correlationId);
    carRepository.save(car);
  }

  public void saveRegistration(UUID correlationId, RegistrationDto registrationDto){
    Registration registration = registrationMapper.toRegistration(registrationDto);
    Car car = carRepository.findByCorrelationId(correlationId);
    registration.setCar(car);
    registrationRepository.save(registration);
  }
}
