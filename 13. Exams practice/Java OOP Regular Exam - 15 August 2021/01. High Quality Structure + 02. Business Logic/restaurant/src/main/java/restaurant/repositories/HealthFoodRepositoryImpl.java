package restaurant.repositories;

import restaurant.entities.healthyFoods.Food;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<Food> {
  private Collection<Food> foods;

  public HealthFoodRepositoryImpl() {
    this.foods = new ArrayList<>();
  }

  @Override
  public Food foodByName(String name) {
    return this.foods
            .stream()
            .filter(f -> f.getName().equals(name))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Food> getAllEntities() {
    return this.foods;
  }

  @Override
  public void add(Food food) {
    this.foods.add(food);
  }
}
