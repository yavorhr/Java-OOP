package wildFarm.Animals;

import wildFarm.Food.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    //Модифицираме super.toString() метода от :
    //Cat[Gray, 1.1, Home, 4]
    //в :
    //Cat[Gray, Persian, 1.1, Home, 4]
    @Override
    public String toString() {
        StringBuilder baseToString = new StringBuilder(super.toString());
        baseToString.insert(baseToString.indexOf(",") + 1, " " + this.breed + ",");
        return baseToString.toString();
    }
}
