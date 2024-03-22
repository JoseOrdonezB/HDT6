public class HashFactory implements IFactoryFuncionesHash {
    private final String algoritmo;

    public HashFactory(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    @Override
    public IFuncionesHash crearFuncionesHash() {
        switch (algoritmo.toLowerCase()) {
            case "md5":
                return new MD5();
            case "hash":
                return new HashOr();
             case "sha1":
                 return new SHA1HashFunction();
            default:
                throw new IllegalArgumentException("Algoritmo no soportado: " + algoritmo);
        }
    }
}
