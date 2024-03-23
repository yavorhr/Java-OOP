package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
  private ToyStore toyStore;
  private Toy toy1;
  private Toy toy2;
  private Toy toy3;
  private Toy testToy;

  @Before
  public void setUp() throws OperationNotSupportedException {
    this.toyStore = new ToyStore();

    this.testToy = new Toy("testToy", "testId");
    this.toy1 = new Toy("Lego", "111");
    this.toy2 = new Toy("PokemonToy", "222");
    this.toy3 = new Toy("MarvelToy", "333");

    this.toyStore.addToy("A", toy1);
    this.toyStore.addToy("B", toy2);
    this.toyStore.addToy("C", toy3);
  }

  // test constructor
  @Test
  public void testToyStoreConstructorShouldWorksCorrect() {
    ToyStore demoStore = new ToyStore();
    Assert.assertTrue(demoStore.getToyShelf().containsKey("A"));
    Assert.assertTrue(demoStore.getToyShelf().containsKey("B"));
    Assert.assertTrue(demoStore.getToyShelf().containsKey("C"));

    Assert.assertNull(demoStore.getToyShelf().get("A"));
    Assert.assertNull(demoStore.getToyShelf().get("B"));
    Assert.assertNull(demoStore.getToyShelf().get("C"));
  }

  // test getToyShelf() returns Unmodifiable collection
  @Test(expected = UnsupportedOperationException.class)
  public void testGetToyShelfReturnsUnmodifiableCollection() {
    this.toyStore.getToyShelf().put("A", this.testToy);
  }

  // test addToy()
  @Test(expected = IllegalArgumentException.class)
  public void testAddToyToNoneExistingShelfShouldThrowError() throws OperationNotSupportedException {
    this.toyStore.addToy("Z", this.testToy);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddToyToAlreadyOccupiedShelfShouldThrowError() throws OperationNotSupportedException {
    this.toyStore.addToy("A", this.testToy);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testAddAlreadyExistedToyShouldThrowError() throws OperationNotSupportedException {
    this.toyStore.addToy("E", toy1);
  }

  @Test
  public void testAddToyShouldWorksCorrect() throws OperationNotSupportedException {
  Assert.assertEquals("111",this.toyStore.getToyShelf().get("A").getToyId());
  Assert.assertEquals("222",this.toyStore.getToyShelf().get("B").getToyId());
  Assert.assertEquals("MarvelToy",this.toyStore.getToyShelf().get("C").getManufacturer());
  }

  // test removeToy()
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveToyFromNoneExistingShelfShouldThrowError() throws OperationNotSupportedException {
    this.toyStore.removeToy("Z", toy1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNoneExistingToyShouldThrowError() throws OperationNotSupportedException {
    this.toyStore.removeToy("A", toy3);
  }

  @Test
  public void testRemoveToyShouldWorksCorrect() throws OperationNotSupportedException {
    this.toyStore.removeToy("A", toy1);
  }


}