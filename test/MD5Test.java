import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MD5Test {

    @Test
    public void testMD5Hash() {
        String input = "Hello, World!";
        String expectedHash = "65a8e27d8879283831b664bd8b7f0ad4";

        MD5 md5 = new MD5();
        String actualHash = md5.generarHash(input);

        assertEquals(expectedHash, actualHash);
    }
}
