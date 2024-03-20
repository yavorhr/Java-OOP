package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.Collection;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);

    Collection<Decoration> getDecorations();

}
