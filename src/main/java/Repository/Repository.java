package Repository;

import Domain.Entity;
import java.util.List;

public interface Repository<ID, E extends Entity<ID>> {
    void add(E e);
    E remove(ID id);
    E findById(ID id);
    List<E> getAll();
    E update(E e);
}
