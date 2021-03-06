package sb1.fp.eksempel1.a;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ProceduralStyle {

    private Map<String, String> mapping = new HashMap<>();

    private String getBaseUrl() {
        return "http://www.sparebank1.no/sr-bank";
    }

    public URI resolve(String key) {
        String value = mapping.get(key);
        if (value != null) {
            return URI.create(getBaseUrl()).resolve(value);
        }
        return null;
    }
}
