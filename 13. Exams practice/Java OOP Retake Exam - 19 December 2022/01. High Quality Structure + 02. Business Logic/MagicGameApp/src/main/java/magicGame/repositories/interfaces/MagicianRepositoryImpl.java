package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;
import validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
  private Collection<Magician> magicians;

  public MagicianRepositoryImpl() {
    this.magicians = new ArrayList<>();
  }

  @Override
  public Collection<Magician> getData() {
    return Collections.unmodifiableCollection(this.magicians);
  }

  @Override
  public void addMagician(Magician magician) {
    Validator.validateIfMagicianIsNotNull(magician);
    this.magicians.add(magician);
  }

  @Override
  public boolean removeMagician(Magician model) {
    return this.magicians.remove(model);
  }

  @Override
  public Magician findByUsername(String name) {
    return this.magicians
            .stream()
            .filter(m -> m.getUsername().equals(name))
            .findFirst()
            .orElse(null);
  }
}
