package sb1.fp.d;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FunctionalStyle {

    private Map<String, String> mapping = new HashMap<>();
    private String baseUri;



    public FunctionalStyle(String baseUri, Map<String, String> mapping) {
        this.baseUri = baseUri;
        this.mapping = mapping;
    }

    public Optional<URI> resolve(String key) {
        return Optional.ofNullable(mapping.get(key))
                .flatMap(value ->
                        Optional.of(URI.create(baseUri).resolve(value)));
    }
}
