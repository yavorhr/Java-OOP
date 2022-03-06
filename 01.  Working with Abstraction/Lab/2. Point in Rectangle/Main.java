import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Rectangle rectangle = new Rectangle(new Point2D(coordinates[0], coordinates[1]),
                new Point2D(coordinates[2], coordinates[3]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            coordinates = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean contains = rectangle.contains(new Point2D(coordinates[0], coordinates[1]));
            System.out.println(contains);
        }
    }

}