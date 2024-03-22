import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Solicitar al usuario que ingrese el tipo de hash
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de hash (md5, hash, sha1):");
        String tipoHash = scanner.nextLine();

        // Crear un objeto HashFactory con el tipo de hash especificado por el usuario
        HashFactory hashFactory = new HashFactory(tipoHash);

        // Solicitar al usuario que ingrese el tipo de mapa
        System.out.println("Ingrese el tipo de mapa (1: HashMap, 2: TreeMap, 3: LinkedHashMap):");
        int tipoMapa = scanner.nextInt();

        // Crear un objeto MapFactory y utilizarlo para crear el mapa especificado por el usuario
        MapFactory<String, Estudiantes> mapFactory = new MapFactory<>();
        Map<String, Estudiantes> estudiantesMap = mapFactory.createMap(tipoMapa);

        // Crear un lector de JSON con la ruta del archivo
        JsonReader jsonReader = new JsonReader("estudiantes.json");
        // Leer el archivo JSON y obtener el JSONArray
        JSONArray jsonArray = jsonReader.readJsonArrayFromFile();

        if (jsonArray != null) {
            // Iterar sobre cada objeto JSON en el JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                // Obtener el objeto JSON que representa a un estudiante
                JSONObject jsonEstudiante = jsonArray.getJSONObject(i);
                // Crear un objeto Estudiantes a partir del objeto JSON
                Estudiantes estudiante = new Estudiantes(
                        jsonEstudiante.getString("name"),
                        jsonEstudiante.getString("phone"),
                        jsonEstudiante.getString("email"),
                        jsonEstudiante.getString("postalZip"),
                        jsonEstudiante.getString("country")
                );

                // Calcular el hash de la nacionalidad del estudiante utilizando el HashFactory
                String hash = generarHash(hashFactory, estudiante.getCountry()); // Utilizamos la nacionalidad como dato a hash

                // Almacenar el estudiante en el mapa utilizando el hash como clave
                estudiantesMap.put(hash, estudiante);
            }

            // Solicitar al usuario que ingrese la nacionalidad que desea buscar
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("Ingrese la nacionalidad que desea buscar:");
            String nacionalidadBusqueda = scanner.nextLine();

            // Calcular el hash de la nacionalidad ingresada por el usuario
            String hashNacionalidadBusqueda = generarHash(hashFactory, nacionalidadBusqueda);

            // Buscar el estudiante en el mapa utilizando el hash de la nacionalidad
            Estudiantes estudianteEncontrado = estudiantesMap.get(hashNacionalidadBusqueda);

            // Imprimir el estudiante encontrado (si existe)
            if (estudianteEncontrado != null) {
                System.out.println("Estudiante encontrado:");
                System.out.println(estudianteEncontrado);
            } else {
                System.out.println("No se encontró ningún estudiante con la nacionalidad especificada.");
            }
        }
    }

    // Método para generar el hash
    public static String generarHash(HashFactory hashFactory, String input) {
        // Crea las funciones de hash
        IFuncionesHash funcionesHash = hashFactory.crearFuncionesHash();
        // Calcula el hash utilizando las funciones de hash proporcionadas
        return funcionesHash.generarHash(input);
    }
}
