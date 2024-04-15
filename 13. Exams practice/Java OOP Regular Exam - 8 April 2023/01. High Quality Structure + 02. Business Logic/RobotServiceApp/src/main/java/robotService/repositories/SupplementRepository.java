package robotService.repositories;

import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {
  private Collection<Supplement> supplements;

  public SupplementRepository() {
    this.supplements = new ArrayList<>();
  }

  @Override
  public void addSupplement(Supplement supplement) {
    this.supplements.add(supplement);
  }

  @Override
  public boolean removeSupplement(Supplement supplement) {
    return false;
  }

  @Override
  public Supplement findFirst(String type) {
    return null;
  }
}
