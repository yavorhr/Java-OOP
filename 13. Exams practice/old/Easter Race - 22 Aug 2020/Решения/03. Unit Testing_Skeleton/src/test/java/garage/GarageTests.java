package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GarageTests {
    private Garage garage;
    private Car ferrari;
    private Car bmw;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.ferrari = new Car("Ferrari", 240, 500);
        this.bmw = new Car("BMW", 220, 450);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void getCars() {
        garage.getCars().remove(0);
    }

    @Test
    public void testtest(){
        this.garage.addCar(ferrari);
        this.garage.addCar(bmw);
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();
        Assert.assertEquals(ferrari,theMostExpensiveCar);
    }

    @Test
    public void getCount() {
        int expected = 0;
        int actual = garage.getCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxSpeed() {
        List<Car> cars = new ArrayList<>();
        cars.add(ferrari);
        cars.add(bmw);
        int speed = 230;
        cars = cars.stream().filter(c -> c.getMaxSpeed() > speed).collect(Collectors.toList());
        Assert.assertEquals(1, cars.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCarNull() {
        garage.addCar(null);
    }

    @Test
    public void addCar() {
        garage.addCar(ferrari);
    }

    @Test
    public void findCarByBrand() {
        garage.addCar(ferrari);
        List<Car> ferrari = garage.findAllCarsByBrand("Ferrari");
        Assert.assertEquals(1, ferrari.size());

    }

    @Test
    public void mostExpensiveCar() {
        garage.addCar(ferrari);
        garage.addCar(bmw);
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(500, theMostExpensiveCar.getPrice(), 0.0);
    }

    @Test
    public void testSpeed(){
        garage.addCar(ferrari);
        garage.addCar(bmw);
        List<Car> speedestCars = garage.findAllCarsWithMaxSpeedAbove(230);
        Assert.assertEquals(1,speedestCars.size());
    }


}