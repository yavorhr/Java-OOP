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

  //test Garage constructor
  @Test
  public void testGarageIsInitializedWithWithEmptyListOfCars() {
    Assert.assertEquals(0, emptyGarage.getCount());
  }

  //Unmodifiable list test
  @Test(expected = UnsupportedOperationException.class)
  public void testGetCarsReturnsUnmodifiableCollection() {
    this.garage.getCars().add(new Car("test_car", 0, 0));
  }

  //test : addCar()
  @Test
  public void testAddCarShouldWorksCorrect() {
    Assert.assertEquals(3, this.garage.getCars().size());
    Assert.assertEquals("Trabant", this.garage.getCars().get(2).getBrand());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddCarWithNullArgumentShouldThrowError() {
    this.garage.addCar(null);
  }


}