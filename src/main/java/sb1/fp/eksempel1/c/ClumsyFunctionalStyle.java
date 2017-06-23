package sb1.fp.eksempel1.c;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClumsyFunctionalStyle {

    private Map<String, String> mapping = new HashMap<>();

    private String getBaseUrl() {
        return "http://www.sparebank1.no/sr-bank";
    }

    public Optional<URI> resolve(String key) {
        Optional<String> maybeValue = Optional.ofNullable(mapping.get(key));

        return maybeValue.map((value) -> {

            // Må bruke URI.resolve fordi UrlUtils ikke forstår relative paths
            // Work in progress
            return Optional.of(URI.create(getBaseUrl()).resolve(value));
        }).orElse(Optional.empty());
    }
}
