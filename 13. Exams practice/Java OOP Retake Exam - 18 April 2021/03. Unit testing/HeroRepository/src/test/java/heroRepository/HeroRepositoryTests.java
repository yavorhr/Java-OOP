package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
  private HeroRepository heroRepository;
  private HeroRepository emptyRepository;
  private Hero hero1;
  private Hero hero2;

  @Before
  public void setup() {
    this.emptyRepository = new HeroRepository();

    this.heroRepository = new HeroRepository();
    this.hero1 = new Hero("Dean", 33);
    this.hero2 = new Hero("Mike", 59);
    this.heroRepository.create(hero1);
    this.heroRepository.create(hero2);
  }


  //test constructors
  @Test
  public void testHeroRepositoryCtorShouldWorksCorrect() {
    Assert.assertEquals(0, this.emptyRepository.getCount());
  }

  @Test
  public void testHeroCtorShouldWorksCorrect() {
    String expectedName = this.hero1.getName();
    int expectedLevel = this.hero1.getLevel();
    Assert.assertEquals(expectedName, "Dean");
    Assert.assertEquals(expectedLevel, 33);
  }

  //test create()
  @Test
  public void testCreateHeroShouldWorksCorrect() {
    Assert.assertEquals(2, this.heroRepository.getCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateHeroShouldThrowErrorWhenHeroAlreadyExists() {
    this.heroRepository.create(new Hero("Dean", 55));
  }

  @Test(expected = NullPointerException.class)
  public void testCreateHeroShouldThrowErrorWhenNullValueIsPassed() {
    this.heroRepository.create(null);
  }

  //test remove()
  @Test
  public void testRemoveHeroShouldReturnsTrueWhenHeroIsRemoved() {
    Assert.assertTrue(this.heroRepository.remove("Dean"));
  }

  @Test
  public void testRemoveHeroShouldReturnsFalseWhenHeroIsNotExisting() {
    Assert.assertFalse(this.heroRepository.remove("Vankata"));
  }

  //getHeroWithHighestLevel()
  @Test
  public void testGetHeroWithHighestLevel() {
    Hero expectedHero = this.heroRepository.getHeroWithHighestLevel();
    Assert.assertEquals(expectedHero.getName(), "Mike");
    Assert.assertEquals(expectedHero.getLevel(), 59);
  }

  // getHero()
  @Test
  public void testGetHeroShouldReturnHero() {
    Hero expectedHero = this.heroRepository.getHero("Mike");
    Assert.assertEquals(expectedHero.getName(), "Mike");
    Assert.assertEquals(expectedHero.getLevel(), 59);
  }

  // getHeroes()
  @Test(expected = UnsupportedOperationException.class)
  public void testGetHeroesReturnUnmodifiableCollection() {
    this.heroRepository.getHeroes().add(new Hero("DarkShadow", 333));
  }

  @Test
  public void testGetHeroesReturnCollection() {
    int expected = this.heroRepository.getHeroes().size();
    Assert.assertEquals(expected,2);
  }


}
