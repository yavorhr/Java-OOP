public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String name, String lastName, int age, double salary) {
        this.setFirstName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void validateNameLength(String name, String exceptionPrefixMessage) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(exceptionPrefixMessage + " cannot be less than 3 symbols");
        }
    }

    private void setSalary(double salary) {
        if (salary < 460 ) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        validateNameLength(firstName, "First name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateNameLength(lastName, "Last name");
        this.lastName = lastName;
    }


    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age=age;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }
        this.salary = this.salary * (1 + bonus / 100);
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }


    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}
