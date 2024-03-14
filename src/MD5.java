import java.security.MessageDigest;

public class MD5 implements IFuncionesHash {

    public static String calculateMD5(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(clave.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error al calcular el hash MD5", e);
        }
    }

    @Override
    public String generarHash(String clave) {
        return calculateMD5(clave);
    }
}
