public class CacheEntry {
    public String key;
    public String value;
    public int frequency;  // For LFU
    public long lastAccessTime;  // For LRU

    public CacheEntry(String key, String value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
        this.lastAccessTime = System.nanoTime();
    }

    public void access() {
        this.frequency++;
        this.lastAccessTime = System.nanoTime();
    }
}
