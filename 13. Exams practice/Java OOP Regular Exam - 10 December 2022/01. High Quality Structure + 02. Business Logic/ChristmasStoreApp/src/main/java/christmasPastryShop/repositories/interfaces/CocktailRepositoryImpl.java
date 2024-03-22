package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
  private Collection<Cocktail> cocktails;

  public CocktailRepositoryImpl() {
  }

  @Override
  public Cocktail getByName(String name) {
    return this.cocktails.stream()
            .filter(c -> c.getName().equals(name))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Cocktail> getAll() {
    return this.cocktails;
  }

  @Override
  public void add(Cocktail cocktail) {
  this.cocktails.add(cocktail);
  }
}
