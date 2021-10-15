package org.spark.marsLand.controller;

import lombok.extern.slf4j.Slf4j;
import org.spark.marsLand.mars.LandedOnMarsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/mars")
public class LandedOnMarsController {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public LandedOnMarsController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/land")
    public String landOnMars () {
      log.info("Landed on mars - rest controller");
      LandedOnMarsEvent event = new LandedOnMarsEvent(this);
      applicationEventPublisher.publishEvent(event);
      return "We landed " + LocalDateTime.now();
    }
}
