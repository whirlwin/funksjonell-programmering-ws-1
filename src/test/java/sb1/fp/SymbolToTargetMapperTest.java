package sb1.fp;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sb1.fp.c.WIthOptionalAndMapStyleTest;
import sb1.fp.d.FunctionalStyle;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RunWith(BlockJUnit4ClassRunner.class)
public class SymbolToTargetMapperTest {

    private FunctionalStyle symbolToTargetMapper = null;

    private static final URI BASE_URI = URI.create("https://webapps.dev.sparebank1.no");
    private static final String BANK_1 = "fisk-bank";
    private static final String BANK_2 = "flesk-bank";

    @Before
    public void setup() {
        symbolToTargetMapper = new FunctionalStyle(BASE_URI + "/" + BANK_1 + "/", createMapping());
    }

    @Test
    public void testResolve() {
        // When
        URI resolved = symbolToTargetMapper.resolve("forsikring_kjop-reiseforsikring").get();
        // Then
        assertEquals(URI.create(BASE_URI + "/privat/forsikring/#/tilbud/reise"), resolved);
    }
    @Test
    public void testResolveWithOtherBaseUrl() {
        assertEquals(
                URI.create(BASE_URI + "/privat/forsikring/#/tilbud/reise"),
                symbolToTargetMapper.resolve("forsikring_kjop-reiseforsikring").get());
    }
    @Test
    public void testResolveUrlUnderBank() {
        symbolToTargetMapper = new FunctionalStyle(BASE_URI + "/" + BANK_2 + "/", createMapping());
        assertEquals(
                URI.create(BASE_URI + "/flesk-bank/nettbank-privat/kontoer/opprett"),
                symbolToTargetMapper.resolve("nettbank-privat_opprett-konto").get());
    }

    @Test
    public void testResolveShouldFail() {
        // When
        Optional<URI> target = symbolToTargetMapper.resolve("whatever");
        //
        assertFalse(target.isPresent());
    }

    private Map<String, String> createMapping() {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("forsikring_kjop-reiseforsikring", "../privat/forsikring/#/tilbud/reise");
        mapping.put("nettbank-privat_opprett-konto", "nettbank-privat/kontoer/opprett");
        return mapping;
    }
}
