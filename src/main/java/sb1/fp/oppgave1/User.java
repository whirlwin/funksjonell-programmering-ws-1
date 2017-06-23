package sb1.fp.oppgave1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

final class User {

    private final String firstName;
    private final Optional<String> email;
    private final String lastName;
    private final List<String> favoriteFoods;

    User(final String firstName, final String lastName, final Optional<String> email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteFoods = Arrays.asList("fiskeboller", "spaghetti", "pølser");
    }

    public String getFirstName() {
        return firstName;
    }

    Optional<String> getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    List<String> getFavoriteFoods() {
        return favoriteFoods;
    }
}
