package org.spark.marsLand.mars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LandedOnMarsListener implements ApplicationListener<LandedOnMarsEvent> {

    @Override
    public void onApplicationEvent(LandedOnMarsEvent event) {
      log.info("*** LandedOnMarsListener: Received event: " + event.getClass().getName());
    }
}
