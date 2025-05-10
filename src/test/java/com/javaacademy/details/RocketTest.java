package com.javaacademy.details;

import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RocketTest {

    @Test
    @DisplayName("Проверка наличия 3х ступеней")
    public void stageInRocket() {
        Rocket rocket = Mockito.mock(Rocket.class);
        Mockito.when(rocket.getFirstStage()).thenReturn(new Engine(0));
        Mockito.when(rocket.getSecondStage()).thenReturn(new Engine(0));
        Mockito.when(rocket.getThirdStage()).thenReturn(new Engine(0));

        Assertions.assertNotNull(rocket.getFirstStage());
        Assertions.assertNotNull(rocket.getSecondStage());
        Assertions.assertNotNull(rocket.getThirdStage());
    }

    @Test
    @DisplayName("Избыток топлива")
    public void fuelMoreOfLimit() {
        Assertions.assertThrows(LimitFuelException.class, () -> new Engine(200_000));
        System.out.println("Проверка избыточного топлива при создании: Ок");
    }

    @Test
    @DisplayName("Избыточной дозаправка")
    public void overRefueling() {
        Assertions.assertThrows(LimitFuelException.class,
                () -> new Engine(100_000).refuel(100_000));
        System.out.println("Проверка избыточного топлива при дозаправке: Ок");
    }

    @Test
    @DisplayName("Запуск при низком уровне топлива")
    public void startEngineOnLowerLimitFuel() {
        Assertions.assertThrows(NotEnoughFuelException.class,
                () -> new Engine(10_000).start());
        System.out.println("Запуск двигателя при низком уровне топлива: Ок");
    }

    @Test
    @DisplayName("Успешный запуск при отсутствии ошибок двигателей")
    public void successRunRocket() {
        Engine mockFirstStage = Mockito.mock(Engine.class);
        Engine mockSecondStage = Mockito.mock(Engine.class);
        Engine mockThirdStage = Mockito.mock(Engine.class);

        Rocket rocket = new Rocket(mockFirstStage.getCurrentFuel(),
                                   mockSecondStage.getCurrentFuel(),
                                   mockThirdStage.getCurrentFuel());
        Assertions.assertDoesNotThrow(() -> rocket.run());
    }

    @Test
    @DisplayName("Ошибка двигателя при старте")
    public void failureEngineAtStart() {
        Engine mockFirstStage = Mockito.mock(Engine.class);
        Engine mockSecondStage = Mockito.mock(Engine.class);
        Engine spyThirdStage = Mockito.spy(new Engine(20_000));

        Assertions.assertDoesNotThrow(() -> mockFirstStage.start());
        Assertions.assertDoesNotThrow(() -> mockSecondStage.start());
        Assertions.assertThrows(NotEnoughFuelException.class, () -> spyThirdStage.start());
    }
}
