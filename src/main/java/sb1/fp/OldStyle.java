package sb1.fp;

import java.net.URI;
import java.util.Optional;

public class OldStyle {

    public Optional<URI> resolve(String key) {
        Optional<String> maybeValue = Optional.ofNullable(getMapping().get(key));

        if (maybeValue.isPresent()) {

            // Må bruke URI.resolve fordi UrlUtils ikke forstår relative paths
            // Work in progress
            return Optional.of(URI.create(urlUtils.getUrl(link)).resolve(maybeValue.get()));
        }
        return Optional.empty();
    }
}
