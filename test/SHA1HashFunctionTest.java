import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SHA1HashFunctionTest {

    @Test
    public void testGenerarHash() {
        String input = "Hello, World!";
        String expectedHash = "0a0a9f2a6772942557ab5355d76af442f8f65e01";

        SHA1HashFunction sha1HashFunction = new SHA1HashFunction();
        String actualHash = sha1HashFunction.generarHash(input);

        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testGenerarHashCadenaVacia() {
        String input = "";
        String expectedHash = "da39a3ee5e6b4b0d3255bfef95601890afd80709"; // Hash SHA-1 de cadena vacía

        SHA1HashFunction sha1HashFunction = new SHA1HashFunction();
        String actualHash = sha1HashFunction.generarHash(input);

        assertEquals(expectedHash, actualHash);
    }
}
