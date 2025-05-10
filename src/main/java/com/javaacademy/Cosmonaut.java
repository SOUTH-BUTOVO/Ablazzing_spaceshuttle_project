package com.javaacademy;

import lombok.ToString;

/**
 * Космонавт
 */
@ToString
public class Cosmonaut {
    //Имя космонавта
    private final String name;
    //Здоров или нет
    private boolean isHealthy = true;

    public Cosmonaut(String name) {
        this.name = name;
    }


    /**
     * Фраза во время начала полета
     */
    public void phrase() {
        System.out.printf("Космонавт %s: Поехали!\n", name);
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public String getName() {
        return name;
    }

    public boolean isHealthy() {
        return isHealthy;
    }
}
