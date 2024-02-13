public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2.00;
        } else if (this.age <= 11) {
            return 1.00;
        } else {
            return 0.75;
        }
    }

    private void validateAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalStateException("Age should be between 0 and 15.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() <= 0) {
            throw new IllegalStateException("Name cannot be empty.");
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }
}
