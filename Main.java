public class Main {
    public static void main(String[] args) {
        DynamicMultilevelCache cache = new DynamicMultilevelCache();

        // Add cache levels
        cache.addCacheLevel(3, "LRU");  // L1
        cache.addCacheLevel(2, "LFU");  // L2

        // Add data to cache
        cache.put("A", "1");
        cache.put("B", "2");
        cache.put("C", "3");

        // Display cache contents
        System.out.println("Initial Cache State:");
        cache.displayCache();

        // Access cache
        System.out.println("Get A: " + cache.get("A")); // Returns "1" from L1
        cache.put("D", "4"); // L1 is full, evicts least recently used

        // Display cache contents
        System.out.println("Cache State After Adding D:");
        cache.displayCache();

        // Access data to promote from L2
        System.out.println("Get C: " + cache.get("C")); // Fetches from L2 and promotes to L1

        // Final cache state
        System.out.println("Final Cache State:");
        cache.displayCache();
    }
}
