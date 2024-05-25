package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetStoreTests {
  private PetStore store;
  private PetStore emptyStore;
  private Animal cat;
  private Animal dog;

  @Before
  public void setup() {
    this.emptyStore = new PetStore();

    this.store = new PetStore();
    this.cat = new Animal("cat", 8, 50);
    this.dog = new Animal("dog", 15, 100);
    this.store.addAnimal(cat);
    this.store.addAnimal(dog);
  }

  // test constructors

  @Test
  public void testPetStoreConstructorInitStore() {
    Assert.assertEquals(0, this.emptyStore.getCount());
    Assert.assertEquals(0, this.emptyStore.getAnimals().size());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testPetStoreConstructorReturnUnmodifiableList() {
    this.store.getAnimals().remove(this.cat);
  }

  @Test
  public void testAnimalConstructorInitStore() {
    Assert.assertEquals("cat", this.cat.getSpecie());
    Assert.assertEquals(8, this.cat.getMaxKilograms());
    Assert.assertEquals(50, this.cat.getPrice(), 0);
    this.dog.setAge(5);
    Assert.assertEquals(5, this.dog.getAge());
  }

  // test findAllAnimalsWithMaxKilograms();
  @Test
  public void testFindAllAnimalsWithMaxKilograms() {
    int actual = this.store.findAllAnimalsWithMaxKilograms(8).size();
    int expected = 1;
    Assert.assertEquals(expected, actual);
  }

  // test addAnimal();
  @Test
  public void testAddAnimalShouldAddAnimalToColl() {
    Assert.assertEquals(this.store.getCount(), 2);
    Assert.assertEquals(this.store.getAnimals().size(), 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddAnimalShouldThrowErrorWhenNullIsGiven() {
    this.store.addAnimal(null);
  }

  //test getTheMostExpensiveAnimal()
  @Test
  public void testGetTheMostExpensiveAnimal() {
    Animal animal = this.store.getTheMostExpensiveAnimal();
    Assert.assertEquals(animal, this.dog);
    Assert.assertEquals(animal.getSpecie(), "dog");
    Assert.assertEquals(animal.getPrice(), 100, 0);
  }

  //test getTheMostExpensiveAnimal()
  @Test
  public void testFindAllAnimalBySpecie() {
    int actual = this.store.findAllAnimalBySpecie("dog").size();
    int expected = 1;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testFindAllAnimalBySpecieShouldReturnEmptyList() {
    int actual = this.store.findAllAnimalBySpecie("bird").size();
    int expected = 0;
    Assert.assertEquals(expected, actual);
  }
}

