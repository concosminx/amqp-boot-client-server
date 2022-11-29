package com.nimsoc.spring.registration.async.service;



import com.nimsoc.spring.dto.CarDto;
import com.nimsoc.spring.registration.async.persistance.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

  Car toCar(CarDto carDto) {
    return Car.builder()
        .id(carDto.getId())
        .color(carDto.getColor())
        .name(carDto.getName())
        .build();
  }

  CarDto toCarDto(Car car) {
    return CarDto.builder()
        .id(car.getId())
        .color(car.getColor())
        .name(car.getName())
        .build();
  }
}