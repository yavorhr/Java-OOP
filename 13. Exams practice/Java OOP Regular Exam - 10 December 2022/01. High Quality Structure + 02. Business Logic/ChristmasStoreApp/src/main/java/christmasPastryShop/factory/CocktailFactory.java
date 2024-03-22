package christmasPastryShop.factory;


import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public class CocktailFactory {
  public static Cocktail create(String type, String name, int size, String brand) {
    Cocktail cocktail = null;

    switch (type) {
      case "Hibernation":
        cocktail = new Hibernation(name, size, brand);
        break;
      case "MulledWine":
        cocktail = new MulledWine(name, size, brand);
        break;
    }

    return cocktail;
  }
}
