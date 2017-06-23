package sb1.fp.eksempel1.d;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GoodFunctionalStyle {

    private Map<String, String> mapping = new HashMap<>();
    private String baseUri;



    public GoodFunctionalStyle(String baseUri, Map<String, String> mapping) {
        this.baseUri = baseUri;
        this.mapping = mapping;
    }

    public Optional<URI> resolve(String key) {
        return Optional.ofNullable(mapping.get(key))
                .map(value -> URI.create(baseUri).resolve(value));
    }
}
