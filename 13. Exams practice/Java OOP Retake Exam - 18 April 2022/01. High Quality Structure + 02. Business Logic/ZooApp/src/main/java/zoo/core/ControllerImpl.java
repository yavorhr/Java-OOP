package zoo.core;

import factory.AnimalFactory;
import factory.AreaFactory;
import factory.FoodFactory;
import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.areas.Area;
import zoo.entities.foods.Food;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, Area> areas;
  private FoodRepository foodRepository;

  public ControllerImpl() {
    this.areas = new HashMap<>();
    this.foodRepository = new FoodRepositoryImpl();
  }

  @Override
  public String addArea(String areaType, String areaName) {
    Area area = AreaFactory.create(areaType, areaName);
    this.areas.put(areaName, area);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
  }

  @Override
  public String buyFood(String foodType) {
    Food food = FoodFactory.create(foodType);
    this.foodRepository.add(food);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
  }

  @Override
  public String foodForArea(String areaName, String foodType) {
    Food food = this.foodRepository.findByType(foodType);
    validateIfFoodExist(food, foodType);

    Area area = getArea(areaName);
    area.addFood(food);
    this.foodRepository.remove(food);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
  }

  @Override
  public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
    Animal animal = AnimalFactory.create(animalType, animalName, kind, price);
    Area area = this.getArea(areaName);

    if (animalCanLiveInTheArea(animal.getClass().getSimpleName(), area.getClass().getSimpleName())) {
      return ConstantMessages.AREA_NOT_SUITABLE;
    }
    if (areaIsFull(area.getCapacity())) {
      return ConstantMessages.NOT_ENOUGH_AREA_CAPACITY;
    }

    area.addAnimal(animal);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
  }

  @Override
  public String feedAnimal(String areaName) {
    Area area = this.getArea(areaName);
    area.feed();

    return String.format(ConstantMessages.ANIMALS_FED, area.getAnimals().size());
  }

  @Override
  public String calculateKg(String areaName) {
    Area area = this.getArea(areaName);

    double totalKgInTheArea = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

    return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, totalKgInTheArea);
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();
    this.areas.values().forEach(a -> sb.append(a.getInfo()));

    return sb.toString().trim();
  }

  // Helpers
  private boolean animalCanLiveInTheArea(String animalType, String areaType) {
    return (animalType.equals("TerrestrialAnimal") && !areaType.equals("LandArea")
            || animalType.equals("AquaticAnimal") && !areaType.equals("WaterArea"));
  }

  private void validateIfFoodExist(Food food, String type) {
    if (food == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, type));
    }
  }

  private Area getArea(String areaName) {
    return areas.get(areaName);
  }

  private boolean areaIsFull(int capacity) {
    return capacity == 0;
  }

}
