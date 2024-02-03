public class Student {
  private String name;
  private int age;
  private double grade;

  public Student(String name, int age, double grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getGrade() {
    return this.grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return String.format("%s is %d years old. %s student.", this.name, this.age, getStudentGradeString(this.grade));
  }

  private String getStudentGradeString(double grade) {
    String result = "";
    if (grade >= 5.50) {
      result = "Excellent";
    } else if (grade >= 4.50) {
      result = "Very good";
    } else if (grade >= 3.50) {
      result = "Average";
    } else {
      result = "Poor";
    }
    return result;
  }
}
