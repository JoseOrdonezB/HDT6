import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 implements IFuncionesHash {

    
    public static String calculateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            byte[] hashBytes = md.digest(input.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String generarHash(String clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarHash'");
    }

    // public static void main(String[] args) {
    //     String originalString = "Eyou eyou";
    //     String md5Hash = calculateMD5(originalString);
    //     System.out.println("MD5 Hash: " + md5Hash);
    // }
}
