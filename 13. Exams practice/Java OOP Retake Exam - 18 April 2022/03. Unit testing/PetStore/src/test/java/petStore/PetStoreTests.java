package petStore;

import org.junit.Before;

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

}

