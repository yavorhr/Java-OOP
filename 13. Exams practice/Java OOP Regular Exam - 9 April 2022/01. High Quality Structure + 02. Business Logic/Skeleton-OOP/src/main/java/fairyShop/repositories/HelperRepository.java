package fairyShop.repositories;

import fairyShop.models.helper.Helper;

import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
  private Collection<Helper> helpers;

  @Override
  public Collection<Helper> getModels() {
    return Collections.unmodifiableCollection(this.helpers);
  }

  @Override
  public void add(Helper model) {
    this.helpers.add(model);
  }

  @Override
  public boolean remove(Helper model) {
    return this.helpers.remove(model);
  }

  @Override
  public Helper findByName(String name) {
    return this.helpers
            .stream()
            .filter(h -> h.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
