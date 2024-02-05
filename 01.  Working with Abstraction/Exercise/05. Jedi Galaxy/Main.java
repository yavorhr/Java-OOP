import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int stars = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Let the Force be with you".equals(input)) {
            int[] heroCoordinates = readArray(input);
            int[] evilCoordinates = readArray(scanner.nextLine());

            if (validCoordinates(heroCoordinates, matrix) && validCoordinates(evilCoordinates, matrix)) {
                collectStars(matrix, heroCoordinates, evilCoordinates);
            } else {
                System.out.println("Invalid coordinates");
            }
            input = scanner.nextLine();
        }

        System.out.println(stars);
    }

    private static boolean validCoordinates(int[] coordinates, int[][] matrix) {
        int row = coordinates[0];
        int col = coordinates[1];

        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void collectStars(int[][] matrix, int[] heroCoordinates, int[] evilCoordinates) {
        int startRow = heroCoordinates[0];
        int evilCol = evilCoordinates[1];

        for (int index = 0; index <= startRow; index++) {
            int heroValue = matrix[startRow - index][index];
            int evilValue = matrix[startRow - index][evilCol - index];

            if (!areDiagonalsAreIntercepted(heroValue, evilValue)) {
                stars += matrix[startRow - index][index];
            }
        }
    }

    private static boolean areDiagonalsAreIntercepted(int hero, int evil) {
        return hero == evil;
    }

    private static int[][] readMatrix(String input) {
        int[] dimension = readArray(input);
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

    private static int[] readArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
