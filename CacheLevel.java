import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLevel {
    private int size;
    private String evictionPolicy;
    private LinkedHashMap<String, CacheEntry> cache;

    public CacheLevel(int size, String evictionPolicy) {
        this.size = size;
        this.evictionPolicy = evictionPolicy;
        this.cache = new LinkedHashMap<>(size, 0.75f, true);
    }

    public void put(String key, String value) {
        if (cache.size() >= size) {
            evict();
        }
        cache.put(key, new CacheEntry(key, value));
    }

    public CacheEntry get(String key) {
        CacheEntry entry = cache.get(key);
        if (entry != null) {
            entry.access();
            return entry;
        }
        return null;
    }

    private void evict() {
        String keyToEvict = null;
        if (evictionPolicy.equals("LRU")) {
            keyToEvict = cache.entrySet().iterator().next().getKey();
        } else if (evictionPolicy.equals("LFU")) {
            int minFrequency = Integer.MAX_VALUE;
            for (Map.Entry<String, CacheEntry> entry : cache.entrySet()) {
                if (entry.getValue().frequency < minFrequency) {
                    minFrequency = entry.getValue().frequency;
                    keyToEvict = entry.getKey();
                }
            }
        }
        if (keyToEvict != null) {
            cache.remove(keyToEvict);
        }
    }

    public void display() {
        System.out.print("[");
        for (Map.Entry<String, CacheEntry> entry : cache.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue().value + ", ");
        }
        System.out.print("]");
    }
}
