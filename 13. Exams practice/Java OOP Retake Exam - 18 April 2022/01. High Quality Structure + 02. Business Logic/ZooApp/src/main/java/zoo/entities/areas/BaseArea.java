package zoo.entities.areas;

import validator.Validator;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseArea implements Area {
  private String name;
  private int capacity;
  private Collection<Food> foods;
  private Collection<Animal> animals;

  protected BaseArea(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.foods = new ArrayList<>();
    this.animals = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Collection<Animal> getAnimals() {
    return this.animals;
  }

  @Override
  public Collection<Food> getFoods() {
    return this.foods;
  }

  @Override
  public int sumCalories() {
    return this.foods
            .stream()
            .mapToInt(Food::getCalories)
            .sum();
  }

  @Override
  public void addAnimal(Animal animal) {
    Validator.validateCapacity(this.capacity);
    this.animals.add(animal);
    this.capacity--;
  }

  @Override
  public void removeAnimal(Animal animal) {
    this.animals.remove(animal);
    this.capacity++;
  }

  @Override
  public void addFood(Food food) {
    this.foods.add(food);
  }

  @Override
  public void feed() {
    this.animals.forEach(Animal::eat);
  }

  @Override
  public String getInfo() {
    return null;
  }
}
