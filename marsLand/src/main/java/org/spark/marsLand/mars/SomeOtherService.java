package org.spark.marsLand.mars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SomeOtherService {

    @EventListener()
    public void onLandedOnMarsAnyName(LandedOnMarsEvent event) {
        log.warn("### WARN EVENT SOME OTHER SERVICE RECEIVED EVENT " + event.getClass().getName() + " " + event.getTimestamp());
    }

    @EventListener()
    public void onApplicationEvent(ApplicationEvent event) {
        log.warn("$$$$ SomeOtherService APPLICATION EVENT: " + event.getClass().getName() + " " + event.getTimestamp());
    }
}
