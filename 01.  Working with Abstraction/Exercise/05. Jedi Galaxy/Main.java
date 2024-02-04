import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int stars = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        String input = scanner.nextLine();
        while (!"Let the Force be with you".equals(input)) {
            int[] heroCoordinates = readArray(scanner);
            int[] evilCoordinates = readArray(scanner);

            if (validCoordinates(heroCoordinates, matrix) && validCoordinates(evilCoordinates, matrix)) {
                collectStars(matrix, heroCoordinates, evilCoordinates);
            } else {
                System.out.println("Invalid coordinates");
            }

            input = scanner.nextLine();
        }

    }

    private static boolean validCoordinates(int[] coordinates, int[][] matrix) {
        int row = coordinates[0];
        int col = coordinates[1];

        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void collectStars(int[][] matrix, int[] heroCoordinates, int[] evilCoordinates) {
        int startRow = heroCoordinates[0];
        int startCol = heroCoordinates[1];

        for (int row = startRow; row >= 0; row--) {
            for (int col = startCol; col >= 0 ; col--) {
                System.out.print(matrix[row][col]);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimension = readArray(scanner.nextLine());
        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
