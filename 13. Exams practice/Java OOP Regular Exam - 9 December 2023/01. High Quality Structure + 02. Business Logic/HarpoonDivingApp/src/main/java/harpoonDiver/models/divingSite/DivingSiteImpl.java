package harpoonDiver.models.divingSite;

import harpoonDiver.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DivingSiteImpl implements DivingSite {
  private String name;
  private Collection<String> seaCreatures;

  public DivingSiteImpl(String name) {
    this.setName(name);
    this.seaCreatures = new ArrayList<>();
  }

  @Override
  public Collection<String> getSeaCreatures() {
    return Collections.unmodifiableCollection(this.seaCreatures);
  }

  @Override
  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    Validator.validateSiteName(name);
    this.name = name;
  }
}
