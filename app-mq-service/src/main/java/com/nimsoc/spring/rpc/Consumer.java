package com.nimsoc.spring.rpc;


import com.nimsoc.spring.dto.Car;
import com.nimsoc.spring.dto.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Consumer {

  public static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  @RabbitListener(queues = "#{queue.name}", concurrency = "10")
  public Registration receive(Car car) {

    LOGGER.info("car is: " + car);

    return Registration.builder()
        .id(car.getId())
        .date(new Date())
        .owner("Ms. Rabbit")
        .signature("Signature of the registration")
        .build();
  }
}

