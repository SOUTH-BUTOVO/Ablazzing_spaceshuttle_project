package com.javaacademy.details;

/**
 * Ракета носитель
 */
public class Rocket {
    //Двигатель первой стадии
    private Engine firstStage;
    //Двигатель второй стадии
    private Engine secondStage;
    //Двигатель третьей стадии
    private Engine thirdStage;

    public Rocket(double fuelStageOne, double fuelStageTwo, double fuelStageThree) {
        this.firstStage = new Engine(fuelStageOne);
        this.secondStage = new Engine(fuelStageTwo);
        this.thirdStage = new Engine(fuelStageThree);
    }

    /**
     * Запуск ракеты носителя
     */
    public void run() {
        try {
            firstStage.start();
            secondStage.start();
            thirdStage.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Engine getFirstStage() {
        return firstStage;
    }

    public Engine getSecondStage() {
        return secondStage;
    }

    public Engine getThirdStage() {
        return thirdStage;
    }
}
