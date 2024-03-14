import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Set;

public class MapFactory<K, V> {
    public Map<K, V> createMap(int choice) {
        switch (choice) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMapAdapter<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción invalida");
        }
    }

    private class TreeMapAdapter extends AbstractMap<K, V> {
        private final TreeMap<K, V> treeMap;

        public TreeMapAdapter() {
            this.treeMap = new TreeMap<>();
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            return treeMap.entrySet();
        }

        @Override
        public V put(K key, V value) {
            return treeMap.put(key, value);
        }
    }
}
