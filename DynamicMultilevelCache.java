import java.util.ArrayList;
import java.util.List;

public class DynamicMultilevelCache {
    private List<CacheLevel> cacheLevels;

    public DynamicMultilevelCache() {
        cacheLevels = new ArrayList<>();
    }

    public void addCacheLevel(int size, String evictionPolicy) {
        cacheLevels.add(new CacheLevel(size, evictionPolicy));
    }

    public void removeCacheLevel(int level) {
        if (level >= 0 && level < cacheLevels.size()) {
            cacheLevels.remove(level);
        }
    }

    public void put(String key, String value) {
        CacheLevel l1 = cacheLevels.get(0);
        l1.put(key, value);
    }

    public String get(String key) {
        CacheEntry entry = null;
        for (int i = 0; i < cacheLevels.size(); i++) {
            CacheLevel level = cacheLevels.get(i);
            entry = level.get(key);
            if (entry != null) {
                // Promote data to higher levels
                for (int j = i - 1; j >= 0; j--) {
                    CacheLevel higherLevel = cacheLevels.get(j);
                    higherLevel.put(entry.key, entry.value);
                }
                return entry.value;
            }
        }
        return null;
    }

    public void displayCache() {
        for (int i = 0; i < cacheLevels.size(); i++) {
            System.out.print("L" + (i + 1) + " Cache: ");
            cacheLevels.get(i).display();
            System.out.println();
        }
    }
}
