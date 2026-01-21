package Service;

import Domain.User.User;

//e ideal sa lucreze cu User, nu cu Person
//nu trebuie sa stie detalii personale
public class AuthService {
    private final PersonService personService;
    private User currentUser;

    public AuthService(PersonService personService) {
        this.personService = personService;
    }

    public User login(String username, String rawPassword) {
        User user = personService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        currentUser = user;
        return user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }
}
