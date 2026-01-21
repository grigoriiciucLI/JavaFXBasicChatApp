package Service;

import Domain.Entity;
import Repository.IRepository;

public abstract class EntityService<ID,E extends Entity<ID>> implements IService {
    protected final IRepository<ID, E> repo;
    public EntityService(IRepository<ID, E> repo) {
        this.repo = repo;
    }
    public IRepository<ID, E> getRepo() {
        return repo;
    }
}
