public class Wolf extends Animal {
  private boolean isAlone;

  public Wolf(String name, int age, boolean alone) {
    super(name, age);
    this.isAlone = alone;
  }

  @Override
  public int getAge() {
    return super.getAge() * 7;
  }

  @Override
  public void move() {
    System.out.println("Wolf is moving...");
  }

  @Override
  public String toString() {
    return String.format("Animal is from %s with name %s and is %d years old.", this.getClass().toString(), super.getName(), super.getAge());
  }
}
