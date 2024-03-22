import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    private String filePath;

    public JsonReader(String filePath) {
        this.filePath = filePath;
    }

    public JSONArray readJsonArrayFromFile() {
        try {
            // Leer el contenido del archivo JSON como una cadena
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convertir la cadena JSON en una matriz JSON
            return new JSONArray(content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
