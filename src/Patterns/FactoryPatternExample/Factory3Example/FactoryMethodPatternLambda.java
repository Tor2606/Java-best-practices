package Patterns.FactoryPatternExample.Factory3Example;

public class FactoryMethodPatternLambda {
    public static void main(String[] args) {
        handleVehicle(Car::new);
        handleVehicle(Bus::new);
    }

    static void handleVehicle(Java8VehicleDriver driver){
        System.out.println("Handling a new vehicle...");
        driver.driveVehicle();
        driver.cleanVehicle();
    }
}
