package sb1.fp.oppgave1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class MapOppgaveTest {

    @Test
    public void testOptionalMap() {
        MapOppgave mapOppgave = new MapOppgave();

        assertEquals(Optional.empty(), mapOppgave.stringToInt(null));
        assertEquals(Optional.empty(), mapOppgave.stringToInt("pølse"));
        assertEquals(Optional.empty(), mapOppgave.stringToInt("sju"));
        assertEquals(Optional.of(7), mapOppgave.stringToInt("7"));
    }

    @Test
    public void testGenerateMailtoLink() {
        MapOppgave mapOppgave = new MapOppgave();

        User user1 = new User("syver", "enstad", Optional.of("syver.enstad@gmail.com"));
        assertEquals(Optional.of("mailto:syver.enstad@gmail.com"), mapOppgave.generateMailtoLink(user1));

        User user2 = new User("samuel", "vigdal", Optional.empty());
        assertEquals(Optional.empty(), mapOppgave.generateMailtoLink(user2));
    }

    @Test
    public void testMakeFavoriteFoodGreatAgain() {
        MapOppgave mapOppgave = new MapOppgave();

        User user1 = new User("syver", "enstad", Optional.of("syver.enstad@gmail.com"));
        assertEquals(Arrays.asList("fiskeboller med bacon", "spaghetti med bacon", "pølser med bacon"), mapOppgave.makeFavoriteFoodGreatAgain(user1));
    }


}