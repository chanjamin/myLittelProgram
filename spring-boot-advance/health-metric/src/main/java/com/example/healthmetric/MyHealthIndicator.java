package com.example.healthmetric;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class MyHealthIndicator implements HealthIndicator {
    public Health health() {
        int i = new Random().nextInt(10);
        if (i>=7)
            return Health.up().build();
        else if (i>=3)
            return Health.down(new IllegalStateException()).build();
        else
            return Health.outOfService().build();
    }
}
