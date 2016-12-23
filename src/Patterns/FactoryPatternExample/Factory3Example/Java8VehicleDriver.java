package Patterns.FactoryPatternExample.Factory3Example;

interface Java8VehicleDriver {
    public Vehicle getVehicle();
    public default void driveVehicle(){
        getVehicle().drive();
    }
    public default void cleanVehicle(){
        getVehicle().clean();
    }
}
