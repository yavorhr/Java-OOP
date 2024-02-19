package Animal;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }


    @Override
    public String toString() {
        return String.format("%s[%s, %s, %.1f, Asia, %d]",
                this.animalType,
                this.animalName,
                this.breed,
                this.animalWeight,
                this.foodEaten);
    }
}