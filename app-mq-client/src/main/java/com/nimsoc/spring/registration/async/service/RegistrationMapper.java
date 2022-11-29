package com.nimsoc.spring.registration.async.service;


import com.nimsoc.spring.dto.RegistrationDto;
import com.nimsoc.spring.registration.async.persistance.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

  Registration toRegistration(RegistrationDto registrationDto){
    return Registration.builder()
        .id(registrationDto.getId())
        .date(registrationDto.getDate())
        .owner(registrationDto.getOwner())
        .signature(registrationDto.getSignature())
        .build();
  }
}
