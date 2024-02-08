public class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void move() {
    System.out.println("Animal is moving...");
  }
}
