package sb1.fp.eksempel1.b;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProceduralOptionalStyle {

    private Map<String, String> mapping = new HashMap<>();

    private String getBaseUrl() {
        return "http://www.sparebank1.no/sr-bank";
    }

    public Optional<URI> resolve(String key) {
        Optional<String> maybeValue = Optional.ofNullable(mapping.get(key));

        if (maybeValue.isPresent()) {

            // Må bruke URI.resolve fordi UrlUtils ikke forstår relative paths
            // Work in progress
            return Optional.of(URI.create(getBaseUrl()).resolve(maybeValue.get()));
        }
        return Optional.empty();
    }
}
