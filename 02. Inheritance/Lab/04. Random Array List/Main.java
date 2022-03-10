import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList<Integer> list = new RandomArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list.getRandomElement());
    }
}
