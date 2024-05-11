package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
  private HeroRepository heroRepository;
  private HeroRepository emptyRepository;
  private Hero hero1;
  private Hero hero2;

  @Before
  public void setup() {
    this.emptyRepository = new HeroRepository();
    this.heroRepository = new HeroRepository();
    this.heroRepository.create(hero1);
    this.heroRepository.create(hero2);
  }

}
