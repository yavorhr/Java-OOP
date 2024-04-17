package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
  private Collection<Drink> drinks;

  public DrinkRepositoryImpl() {
    this.drinks = new ArrayList<>();
  }

  @Override
  public Collection<Drink> getAll() {
    return Collections.unmodifiableCollection(this.drinks);
  }

  @Override
  public void add(Drink drink) {
    this.drinks.add(drink);
  }

  @Override
  public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
    return this.drinks.stream()
            .filter(d ->
                    d.getBrand().equals(drinkBrand) &&
                            d.getName().equals(drinkName))
            .findFirst()
            .orElse(null);
  }
}
