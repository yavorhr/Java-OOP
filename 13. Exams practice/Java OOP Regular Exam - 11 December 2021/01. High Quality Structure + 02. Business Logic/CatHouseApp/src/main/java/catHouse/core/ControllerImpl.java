package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.entities.houses.House;
import catHouse.entities.toys.Toy;
import catHouse.factory.FactoryHouse;
import catHouse.factory.FactoryToy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Repository toyRepository;
  private Collection<House> houses;

  public ControllerImpl() {
    this.toyRepository = new ToyRepositoryImpl();
    this.houses = new ArrayList<>();
  }

  @Override
  public String addHouse(String type, String name) {
    House house = FactoryHouse.create(type, name);
    this.houses.add(house);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
  }

  @Override
  public String buyToy(String type) {
    Toy toy = FactoryToy.create(type);
    this.toyRepository.buyToy(toy);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
  }

  @Override
  public String toyForHouse(String houseName, String toyType) {
    return null;
  }

  @Override
  public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
    return null;
  }

  @Override
  public String feedingCat(String houseName) {
    return null;
  }

  @Override
  public String sumOfAll(String houseName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
