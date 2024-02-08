import vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        driveVehicle(new SportCar(50, 350), vehicles);
        driveVehicle(new RacerMotorcycle(50, 220), vehicles);
        driveVehicle(new FamilyCar(50, 130), vehicles);
        driveVehicle(new Car(50, 180), vehicles);

        vehicles.forEach(System.out::println);
    }

    private static void driveVehicle(Vehicle vehicle, List<Vehicle> vehicles) {
        vehicle.drive(200);
        vehicles.add(vehicle);
    }
}