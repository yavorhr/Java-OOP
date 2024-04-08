package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer> {
  private List<Explorer> explorers;

  public ExplorerRepository() {
    this.explorers = new ArrayList<>();
  }

  @Override
  public Collection<Explorer> getCollection() {
    return Collections.unmodifiableList(this.explorers);
  }

  @Override
  public void add(Explorer explorer) {
    this.explorers.add(explorer);
  }

  @Override
  public boolean remove(Explorer explorer) {
    return this.explorers.remove(explorer);
  }

  @Override
  public Explorer byName(String name) {
    return this.explorers
            .stream()
            .filter(e -> e.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
