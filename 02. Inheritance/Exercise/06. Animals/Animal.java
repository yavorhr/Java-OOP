public class Animal {
    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected String produceSound() {
        return "";
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.name + " " + this.age + " " + this.gender).append(System.lineSeparator())
                .append(this.produceSound());

        return sb.toString();
    }
}
