package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;
import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
  private Collection<Booth> boothCollection;

  public BoothRepositoryImpl() {
    this.boothCollection = new ArrayList<>();
  }

  @Override
  public Booth getByNumber(int number) {
    return this.boothCollection.stream()
            .filter(b -> b.getBoothNumber() == number)
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Booth> getAll() {
    return this.boothCollection;
  }

  @Override
  public void add(Booth booth) {
    this.boothCollection.add(booth);
  }
}
