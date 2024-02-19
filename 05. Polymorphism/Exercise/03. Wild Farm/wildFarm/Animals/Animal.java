package Animal;

import Food.*;

public abstract class Animal {
    String animalType;
    String animalName;
    double animalWeight;
    int foodEaten;

    public Animal(String animalType, String animalName, double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        foodEaten = 0;
        this.makeSound();
    }

    abstract void makeSound();

    public void eat(Food food) {
        foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.1f, Asia, %d]",
                this.animalType,
                this.animalName,
                this.animalWeight,
                this.foodEaten);
    }
}
