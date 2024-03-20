package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.Collection;

public class DecorationRepository implements Repository {
  private Collection<Decoration> decorationRepository;

  @Override
  public void add(Decoration decoration) {
    this.decorationRepository.add(decoration);
  }

  @Override
  public boolean remove(Decoration decoration) {
    return this.decorationRepository.remove(decoration)
  }

  @Override
  public Decoration findByType(String type) {
    return this.decorationRepository.stream()
            .filter(d ->
                    d.getClass().getSimpleName().equals(type))
            .findFirst()
            .orElse(null);
  }
}
