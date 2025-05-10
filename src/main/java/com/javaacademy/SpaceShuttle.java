package com.javaacademy;

import com.javaacademy.details.Rocket;
import com.javaacademy.details.Capsule;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import lombok.SneakyThrows;

/**
 * Космический корабль
 */
public class SpaceShuttle {
    //Имя корабля
    private final String name;
    //Ракета носитель
    private final Rocket rocket;
    //Космический аппарат
    private final Capsule capsule;

    public SpaceShuttle(String name, Rocket rocket, Capsule capsule) {
        this.name = name;
        this.rocket = rocket;
        this.capsule = capsule;
    }

    /**
     * Посадка космонавта на борт
     */
    public void setCosmonaut(Cosmonaut cosmonaut) {
        capsule.setCosmonaut(cosmonaut);
    }

    /**
     * Запуск шаттла
     */
    @SneakyThrows
    public void run() {
        if (!capsule.getCosmonaut().isHealthy()) {
            throw new CosmonautIsNotReadyException("Космонавт болен, запуск отменён.");
        }
        capsule.getCosmonaut().phrase();
    }

    public String getName() {
        return name;
    }

    public Cosmonaut getCosmonaut() {
        return capsule.getCosmonaut();
    }
}
