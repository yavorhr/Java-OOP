package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepositoryImpl implements Repository<Gun> {
  private Collection<Gun> models;

  public GunRepositoryImpl() {
    this.models = new ArrayList<>();
  }

  @Override
  public Collection<Gun> getModels() {
    return this.models;
  }

  @Override
  public void add(Gun model) {
    this.models.add(model);
  }

  @Override
  public boolean remove(Gun model) {
    return this.models.remove(model);
  }

  @Override
  public Gun find(String name) {
    return this.models.stream()
            .filter(m -> m.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
