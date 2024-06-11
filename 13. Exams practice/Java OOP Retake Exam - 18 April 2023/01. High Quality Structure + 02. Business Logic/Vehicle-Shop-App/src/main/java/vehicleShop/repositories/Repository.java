package vehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {

    void add(T model);

    boolean remove(T model);

    T findByName(String name);

    Collection<T> getModels();
}
