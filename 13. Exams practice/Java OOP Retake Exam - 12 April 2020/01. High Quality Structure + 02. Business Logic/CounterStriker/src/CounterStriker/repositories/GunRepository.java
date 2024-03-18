package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun> {
  private List<Gun> guns;

  public GunRepository() {
    this.guns = new ArrayList<>();
  }

  @Override
  public Collection<Gun> getModels() {
    return Collections.unmodifiableCollection(this.guns);
  }

  @Override
  public void add(Gun gun) {
    Validator.throwErrorIfNullArgumentIsPassed(gun);
    this.guns.add(gun);
  }

  @Override
  public boolean remove(Gun gun) {
    return this.guns.remove(gun);
  }

  @Override
  public Gun findByName(String name) {
    return this.guns.stream()
            .filter(g -> g.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
