package wildFarm.Animals;

import wildFarm.Food.Food;
import wildFarm.Food.Meat;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}

