import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HashOrTest {

    @Test
    public void testGenerarHash() {
        String input = "Hello, World!";
        String expectedHash = "Hello, World!";

        HashOr hashOr = new HashOr();
        String actualHash = hashOr.generarHash(input);

        assertEquals(expectedHash, actualHash);
    }
}
