package magicGame.repositories;

import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
  private Collection<Magic> magics;

  public MagicRepositoryImpl() {
    this.magics = new ArrayList<>();
  }

  @Override
  public Collection<Magic> getData() {
    return Collections.unmodifiableCollection(this.magics);
  }

  @Override
  public void addMagic(Magic model) {
    this.magics.add(model);
  }

  @Override
  public boolean removeMagic(Magic model) {
    return this.magics.remove(model);
  }

  @Override
  public Magic findByName(String name) {
    return this.magics
            .stream()
            .filter(m -> m.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
