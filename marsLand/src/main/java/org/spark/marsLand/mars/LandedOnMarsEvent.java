package org.spark.marsLand.mars;

import org.springframework.context.ApplicationEvent;

public class LandedOnMarsEvent extends ApplicationEvent {

    public LandedOnMarsEvent(Object source) {
        super(source);
    }
}
