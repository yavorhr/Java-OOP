package harpoonDiver.models.seaCatch;

import java.util.Collection;
import java.util.Collections;

public class BaseSeaCatch implements SeaCatch {
  private Collection<String> seaCreatures;

  public BaseSeaCatch() {
  }

  @Override
  public Collection<String> getSeaCreatures() {
    return Collections.unmodifiableCollection(this.seaCreatures);
  }
}
