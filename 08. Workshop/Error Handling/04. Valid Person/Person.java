public class Person {
  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setAge(age);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if (stringIsInvalid(firstName)) {
      throw new IllegalArgumentException("First name can't be empty!");
    }
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if (stringIsInvalid(lastName)) {
      throw new IllegalArgumentException("Last name can't be empty!");
    }
    this.lastName = lastName;
  }

  public void setAge(int age) {
    if (!valueIsInvalid(age)) {
      throw new IllegalArgumentException("Age must be greater than 0!");
    }
    this.age = age;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  private boolean stringIsInvalid(String name) {
    return name == null || name.trim().length() <= 0;
  }

  private boolean valueIsInvalid(int value) {
    return value < 0;
  }
}
