public class Student {
  private String name;
  private String email;

  public Student(String firstName, String lastName) {
    this.setName(firstName);
    this.setEmail(lastName);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (invalidName(name)) {
      throw new InvalidPersonNameException("Name must contain only letters!");
    }
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  private boolean invalidName(String name) {
    for (char currentChar : name.toCharArray()) {
      if (Character.isDigit(currentChar)) {
        return true;
      }
    }
    return false;
  }

  private boolean valueIsInvalid(int value) {
    return value < 0;
  }
}
