package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T> {
    Collection<T> models;

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
