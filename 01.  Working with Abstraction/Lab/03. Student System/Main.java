import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    StudentSystem studentSystem = new StudentSystem();

    while (!"Exit".equals(input)) {
      String[] tokens = input.split(" ");
      String command = tokens[0];
      String name = tokens[1];

      switch (command) {

        case "Create" -> {
          int age = Integer.parseInt(tokens[2]);
          double grade = Double.parseDouble(tokens[3]);
          studentSystem.create(new Student(name, age, grade));
        }
        case "Show" -> System.out.println(studentSystem.show(name));
      }
      input = scanner.nextLine();
    }
  }
}
