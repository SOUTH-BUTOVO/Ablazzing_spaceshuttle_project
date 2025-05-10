package com.javaacademy.details;

import com.javaacademy.Cosmonaut;
import com.javaacademy.SpaceShuttle;
import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CapsuleAndLifeCycleIT {

    @Test
    @DisplayName("Система жизнеобеспечения капсулы")
    public void lifeInCapsule() {
        Capsule capsule = new Capsule(new Water(), new JamTube(), new OxygenBalloon());

        System.out.println(capsule.getLifeCycleSystem() != null ?
                "Жизнеобеспечения работает" : "Жизнеобеспечение не работает");
        Assertions.assertNotNull(capsule.getLifeCycleSystem());

        System.out.println(capsule.getLifeCycleSystem().getWater() != null ?
                "Вода в наличии" : "Вода отсутствует");
        Assertions.assertNotNull(capsule.getLifeCycleSystem().getWater());

        System.out.println(capsule.getLifeCycleSystem().getJamTube() != null ?
                "Еда в наличии" : "Еда отсутствует");
        Assertions.assertNotNull(capsule.getLifeCycleSystem().getJamTube());

        System.out.println(capsule.getLifeCycleSystem().getOxygenBalloon() != null ?
                "Кислород в наличии." : "Кислород отсутствует.");
        Assertions.assertNotNull(capsule.getLifeCycleSystem().getOxygenBalloon());
    }

    @Test
    @DisplayName("Размещение космонавта в космический корабль.")
    public void putCosmonautInSpaceShuttle() {
        Rocket rocket = new Rocket(100_000, 100_000, 100_000);
        Capsule capsule = new Capsule(new Water(), new JamTube(), new OxygenBalloon());
        SpaceShuttle spaceShuttle = new SpaceShuttle("Восток-1", rocket, capsule);
        spaceShuttle.setCosmonaut(new Cosmonaut("Юрий"));

        System.out.println(spaceShuttle.getCosmonaut().isHealthy() ?
                "Здоровье космонавта: Здоров." : "Здоровье космонавта: Болен.");
        Assertions.assertTrue(spaceShuttle.getCosmonaut().isHealthy());
    }

    @Test
    @DisplayName("Количество топлива в двигателях после запуска")
    public void volFuelAfterRun() {
        Rocket rocket = new Rocket(100_000, 100_000, 100_000);
        rocket.run();

        System.out.println("Количество топлива в первом двигателе: "
                + rocket.getFirstStage().getCurrentFuel());
        Assertions.assertEquals(0, rocket.getFirstStage().getCurrentFuel());
        System.out.println("Количество топлива в втором двигателе: "
                + rocket.getSecondStage().getCurrentFuel());
        Assertions.assertEquals(0, rocket.getSecondStage().getCurrentFuel());
        System.out.println("Количество топлива в третьем двигателе: "
                + rocket.getThirdStage().getCurrentFuel());
        Assertions.assertEquals(0, rocket.getThirdStage().getCurrentFuel());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/rocket_data.csv", delimiter = ';', numLinesToSkip = 1)
    @DisplayName("Параметризованный тест")
    public void paramTestCreateRocket(int number_experiment, double fuel_stage_one,
                                      double fuel_stage_two, double fuel_stage_three, boolean result) {
        Rocket rocket = new Rocket(fuel_stage_one, fuel_stage_two, fuel_stage_three);
        Assertions.assertDoesNotThrow(() -> rocket.run());
    }
}
