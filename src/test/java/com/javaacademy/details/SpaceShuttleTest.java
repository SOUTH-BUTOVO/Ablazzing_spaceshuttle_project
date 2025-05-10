package com.javaacademy.details;

import com.javaacademy.Cosmonaut;
import com.javaacademy.SpaceShuttle;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpaceShuttleTest {

    @Test
    @DisplayName("Запуск корабля, космонавт здоров.")
    public void successRunSpaceShuttle() {
        Cosmonaut cosmonaut = Mockito.mock(Cosmonaut.class);
        Mockito.when(cosmonaut.isHealthy()).thenReturn(true);

        Rocket rocket = Mockito.mock(Rocket.class);

        Capsule capsule = Mockito.mock(Capsule.class);
        Mockito.when(capsule.getCosmonaut()).thenReturn(cosmonaut);

        SpaceShuttle spaceShuttle = new SpaceShuttle("Юрий", rocket, capsule);

        Assertions.assertTrue(cosmonaut.isHealthy());
        Assertions.assertDoesNotThrow(() -> spaceShuttle.run());
    }

    @Test
    @DisplayName("Ошибка запуска корабля, космонавт болен.")
    public void failureRunSpaceShuttle() {
        Cosmonaut cosmonaut = Mockito.mock(Cosmonaut.class);
        Mockito.when(cosmonaut.isHealthy()).thenReturn(false);

        Rocket rocket = Mockito.mock(Rocket.class);

        Capsule capsule = Mockito.mock(Capsule.class);
        Mockito.when(capsule.getCosmonaut()).thenReturn(cosmonaut);

        SpaceShuttle spaceShuttle = new SpaceShuttle("Юрий", rocket, capsule);

        Assertions.assertFalse(cosmonaut.isHealthy());
        Assertions.assertThrows(CosmonautIsNotReadyException.class, () -> spaceShuttle.run());
    }
}
