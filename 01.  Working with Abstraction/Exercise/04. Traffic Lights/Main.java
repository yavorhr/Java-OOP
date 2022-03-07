import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] startColors = scanner.nextLine().split("\\s+");
        int countUpdates = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLightList = new ArrayList<>();
        for (String light : startColors) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(light));
            trafficLightList.add(trafficLight);
        }

        for (int i = 0; i < countUpdates; i++) {
            for (TrafficLight light : trafficLightList) {
                light.update();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
