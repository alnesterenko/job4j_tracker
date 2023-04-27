package ru.job4j.cast;

public class UsingAllVehicles {
    public static void main(String[] args) {
        Vehicle bigAirplane = new Airplane();
        Vehicle smallAirplane = new Airplane();
        Vehicle passengerTrain = new Train();
        Vehicle freightTrain = new Train();
        Vehicle redBus = new Bus();
        Vehicle yellowBus = new Bus();
        Vehicle[] vehicles = {bigAirplane, smallAirplane, passengerTrain, freightTrain, redBus, yellowBus};
        for (Vehicle oneVehicle: vehicles) {
            oneVehicle.move();
            System.out.println(oneVehicle.getUsingWay());
        }
    }
}
