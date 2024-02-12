import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            printOutput(box);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printOutput(Box box) {
        System.out.printf("Surface Area - %.2f%n" + "Lateral Surface Area - %.2f%n" + "Volume - %.2f%n",
                box.calculateSurfaceArea(),
                box.calculateLateralSurfaceArea(),
                box.calculateVolume());
    }

}
