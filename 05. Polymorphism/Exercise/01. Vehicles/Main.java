import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);

        int n = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String type = tokens[1];
            double liters = Double.parseDouble(tokens[2]);

            try {
                switch (command) {
                    case "Drive" -> driveVehicle(type.equals("Car") ? car : truck, liters);
                    case "Refuel" -> refuelVehicle(type.equals("Car") ? car : truck, liters);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        printOutput(car,truck);
    }

    private static void printOutput(Vehicle car, Vehicle truck) {
        System.out.println(car);
        System.out.println(truck);
    }

    private static void refuelVehicle(Vehicle vehicle, double distance) {
        vehicle.refuel(distance);
    }

    private static void driveVehicle(Vehicle vehicle, double distance) {
        System.out.println( vehicle.drive(distance));
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        String type = tokens[0];
        double distance = Double.parseDouble(tokens[1]);
        double litersPerKm = Double.parseDouble(tokens[2]);

        if (type.equals("Car")) {
            return new Car(distance, litersPerKm);
        }
        return new Truck(distance, litersPerKm);
    }
}


