public class HashOr implements IFuncionesHash {

    public static String getHash(String texto) {
        return texto;
    }

    @Override
    public String generarHash(String clave) {
        return getHash(clave);
    }
}
