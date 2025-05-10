package com.javaacademy.details;

import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

/**
 * Двигатель космического корабля
 */
@ToString
public class Engine {
    //Минимальное количество топливо для старта
    private static final double MINIMUM_FUEL_FOR_START = 60_000;
    //Максимальное количество топлива внутри двигателя
    private static final double MAX_FUEL = 100_000;
    //Текущее количество топлива в двигателе
    @Getter
    private double currentFuel;

    @SneakyThrows
    public Engine(double currentFuel) {
        if (currentFuel > MAX_FUEL) {
            throw new LimitFuelException("Топлива больше лимита");
        }
        this.currentFuel = currentFuel;
    }

    /**
     * Запуск двигателя
     */
    @SneakyThrows
    public void start() {
        if (this.currentFuel < MINIMUM_FUEL_FOR_START) {
            throw new NotEnoughFuelException("Топлива не достаточно для старта!");
        }
        currentFuel = 0;
    }

    /**
     * Дозаправка
     */
    @SneakyThrows
    public void refuel(double currentFuel) {
        if ((this.currentFuel += currentFuel) > MAX_FUEL) {
            throw new LimitFuelException("Топлива больше лимита");
        }
        this.currentFuel += currentFuel;
    }
}
