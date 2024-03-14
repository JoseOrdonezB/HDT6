import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HashFunction implements IFuncionesHash {
    public static String calcularSHA1(String texto) {
        try {
            // Crear una instancia del algoritmo SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Calcular el hash SHA-1 de la cadena de entrada
            byte[] hashBytes = md.digest(texto.getBytes());

            // Convertir los bytes del hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                // Convertir byte a su representación hexadecimal
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Devolver el hash SHA-1 en formato hexadecimal
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción en caso de que no se encuentre el algoritmo SHA-1
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String generarHash(String clave) {
        return calcularSHA1(clave);
    }
}
