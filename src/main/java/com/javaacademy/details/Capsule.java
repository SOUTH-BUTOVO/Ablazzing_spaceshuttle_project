package com.javaacademy.details;

import com.javaacademy.Cosmonaut;
import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;

/**
 * Капсула
 */
public class Capsule {
    private Cosmonaut cosmonaut;
    private LifeCycleSystem lifeCycleSystem;

    public Capsule(Water water, JamTube jamTube, OxygenBalloon oxygenBalloon) {
        this.lifeCycleSystem = new LifeCycleSystem(water, jamTube, oxygenBalloon);
    }

    public Cosmonaut getCosmonaut() {
        return cosmonaut;
    }

    public void setCosmonaut(Cosmonaut cosmonaut) {
        //cosmonaut.setHealthy(false);
        this.cosmonaut = cosmonaut;
    }

    public LifeCycleSystem getLifeCycleSystem() {
        return lifeCycleSystem;
    }
}
