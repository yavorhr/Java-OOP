package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
  private Car bmw;
  private Car mercedes;
  private Car trabant;
  private Garage garage;
  private Garage emptyGarage;

  @Before
  public void setUp() {
    this.garage = new Garage();
    this.bmw = new Car("BMW", 320, 45000);
    this.mercedes = new Car("Mercedes-Benz", 280, 50000);
    this.trabant = new Car("Trabant", 100, 2000);

    this.garage.addCar(this.bmw);
    this.garage.addCar(this.mercedes);
    this.garage.addCar(this.trabant);

    this.emptyGarage = new Garage();
  }

  //Constructor tests
  @Test
  public void testGarageIsInitializedWithWithEmptyListOfCars() {
    Assert.assertEquals(0, emptyGarage.getCount());
  }

}