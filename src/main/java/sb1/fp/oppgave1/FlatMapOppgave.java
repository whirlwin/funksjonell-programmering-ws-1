package sb1.fp.oppgave1;

import java.util.Optional;

public class FlatMapOppgave {

    public Optional<String> generateMailtoLink(User user) {
        return user.getEmail().flatMap((email) -> addEmailPrefix(email));
    }

    private Optional<String> addEmailPrefix(String email) {
        return Optional.of("mailto:").map((prefix) -> prefix + email);
    }
}
