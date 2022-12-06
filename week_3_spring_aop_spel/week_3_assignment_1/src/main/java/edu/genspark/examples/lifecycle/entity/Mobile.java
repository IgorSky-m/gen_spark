package edu.genspark.examples.lifecycle.entity;

import edu.genspark.examples.lifecycle.annotations.DisableTracking;
import edu.genspark.examples.lifecycle.entity.api.IDevice;
import edu.genspark.examples.lifecycle.entity.api.ITrackable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@DisableTracking
@Component
public class Mobile implements IDevice, ITrackable {

    @Value("true")
    private boolean trackingActive;

    @Value("Modile device")
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isTrackingActive() {
        return trackingActive;
    }

    @Override
    public void setTrackingActive(boolean trackingActive) {
        this.trackingActive = trackingActive;
    }


}
