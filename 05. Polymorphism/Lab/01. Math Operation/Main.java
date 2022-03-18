import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MathOperation math = new MathOperation();
        System.out.println(math.add(2, 2));

        System.out.println(math.add(3, 3, 3));

        System.out.println(math.add(4, 4, 4, 4));
    }
}






