package com.nimsoc.spring.registration.async;

import com.nimsoc.spring.dto.RegistrationDto;
import com.nimsoc.spring.registration.async.service.RegistrationService;
import com.nimsoc.spring.registration.rpc.StatefulBlockingClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Component
@Transactional
public class ReplyConsumer {

  public static final Logger LOGGER = LoggerFactory.getLogger(ReplyConsumer.class);

  private final RegistrationService registrationService;

  public ReplyConsumer(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @RabbitListener(queues = "#{response.name}", concurrency = "10")
  public void receive(RegistrationDto registrationDto, Message message){

    LOGGER.info("message: " + message);

    String correlationId = message.getMessageProperties().getCorrelationId();
    registrationService.saveRegistration(UUID.fromString(correlationId), registrationDto);
  }
}
