package sb1.fp.d;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FunctionalStyle {

    private Map<String, String> mapping = new HashMap<>();

    private String getBaseUrl() {
        return "http://www.sparebank1.no/sr-bank";
    }

    public Optional<URI> resolve(String key) {
        return Optional.ofNullable(mapping.get(key))
                .flatMap(value ->
                        Optional.of(URI.create(getBaseUrl()).resolve(value)));
    }
}
