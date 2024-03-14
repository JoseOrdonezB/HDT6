import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HashFunction implements IFuncionesHash {
    @Override
    public String generarHash(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(clave.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString(); 
        } catch (NoSuchAlgorithmException e){
            return " "; 
        }
    }
}
