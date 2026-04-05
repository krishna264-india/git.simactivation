import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    // Implement an LRU Cache in Java.
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Deque<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Move the accessed key to the front of the order deque
        order.remove(key);
        order.addFirst(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {// Update the value if key exists
            cache.put(key, value);// Update the value
            // Move the updated key to the front of the order deque
            order.remove(key);
            order.addFirst(key);
            return;
        }
        // If the cache is at capacity, remove the least recently used item
        if (cache.size() >= capacity) {
            // Remove the least recently used item
            int lru = order.removeLast();
            cache.remove(lru);
        }
        cache.put(key, value);
        order.addFirst(key);
    }
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return cache.size() > capacity;
    }
    public void display(){
        for(Integer key: order){
            System.out.println(key+" :"+cache.get(key));
        }
        System.out.println("----" + capacity+"----");
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.display();
        lruCache.get(1);
        lruCache.display();
        lruCache.put(4, 40);
        lruCache.display();
    }
}
