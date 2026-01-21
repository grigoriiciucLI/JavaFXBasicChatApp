package Service;

import Domain.User.Person;
import Domain.User.User;
import Repository.Db.Filter;
import Repository.IRepository;

import java.util.Optional;

public class PersonService extends EntityService<Long, Person> {
    public PersonService(IRepository<Long, Person> repo) {
        super(repo);
    }
    public Optional<User> findByUsername(String username) {
        Filter f = new Filter();
        f.addFilter("username", username);
        return getRepo().filter(f)
                .stream()
                .map(p -> (User) p)
                .findFirst();
    }
}

