import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(scanner));
        vehicleMap.put("Truck", createVehicle(scanner));
        vehicleMap.put("Bus", createVehicle(scanner));

        int n = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String type = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            try {
                switch (command) {
                    case "Drive", "DriveEmpty" -> driveVehicle(vehicleMap.get(type), value, command);
                    case "Refuel" -> refuelVehicle(vehicleMap.get(type), value);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        printOutput(vehicleMap);
    }

    private static void printOutput(Map<String, Vehicle> vehicleMap) {
        vehicleMap.values().forEach(System.out::println);
    }

    private static void refuelVehicle(Vehicle vehicle, double liters) {
        vehicle.refuel(liters);
    }

    private static void driveVehicle(Vehicle vehicle, double distance, String command) {
        if (vehicle instanceof Bus && command.equals("Drive")){
            System.out.println(((Bus) vehicle).driveWithPassengers(distance));
        } else {
            System.out.println(vehicle.drive(distance));
        }
    }

    private static Vehicle createVehicle(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        String type = tokens[0];
        double distance = Double.parseDouble(tokens[1]);
        double litersPerKm = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        if (type.equals("Car")) {
            return new Car(distance, litersPerKm, tankCapacity);
        } else if (type.equals("Bus")) {
            return new Bus(distance, litersPerKm, tankCapacity);
        }
        return new Truck(distance, litersPerKm, tankCapacity);
    }
}


