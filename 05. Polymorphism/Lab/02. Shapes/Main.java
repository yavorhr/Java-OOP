import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape rectangle = new Rectangle(2D, 4D);
        Shape circle = new Circle(5D);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}






