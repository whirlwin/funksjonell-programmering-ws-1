package sb1.fp;

import java.net.URI;
import java.util.Optional;

public class NewStyle {

    public Optional<URI> resolve(String key) {
        Optional<String> maybeValue = Optional.ofNullable(getMapping().get(key));

        return maybeValue.map((value) -> {

            // Må bruke URI.resolve fordi UrlUtils ikke forstår relative paths
            // Work in progress
            return Optional.of(URI.create(getBaseUrl()).resolve(value));
        }).orElse(Optional.empty());
    }

    private String getBaseUrl() {
        return "http://www.sparebank1.no/sr-bank";
    }
}
