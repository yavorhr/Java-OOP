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
  public void setup(){
    this.emptyStore = new PetStore();

    this.store = new PetStore();
    this.cat = new Animal("cat", 8, 50);
    this.dog = new Animal("dog", 15, 100);
    this.store.addAnimal(cat);
    this.store.addAnimal(dog);
  }

  // test constructors

  @Test
  public void testPetStoreConstructorInitStore(){
    Assert.assertEquals(0, this.emptyStore.getCount());
    Assert.assertEquals(0, this.emptyStore.getAnimals().size());
  }
}

