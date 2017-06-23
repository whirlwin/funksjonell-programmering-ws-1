package sb1.fp.oppgave1;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class MapOppgave {

    Optional<Integer> stringToInt(String in) {
        try {
            return Optional.of(Integer.valueOf(in));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    Optional<String> generateMailtoLink(User user) {
        return user.getEmail().map(e -> "mailto:" + e);
    }

    List<String> makeFavoriteFoodGreatAgain(User user1) {
        return user1.getFavoriteFoods().stream()
                .map(f -> f + " med bacon")
                .collect(Collectors.toList());
    }
}
