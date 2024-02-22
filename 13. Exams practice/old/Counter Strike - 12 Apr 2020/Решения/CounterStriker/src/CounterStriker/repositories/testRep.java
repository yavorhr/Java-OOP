package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.Collection;

public class testRep<T extends Gun> implements Repository<T>{

    @Override
    public Collection<T> getModels() {
        return null;
    }

    @Override
    public void add(T model) {

    }

    @Override
    public boolean remove(T model) {
        return false;
    }

    @Override
    public T findByName(String name) {
        return null;
    }
}
