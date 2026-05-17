/*

recent              last recent
[4 -> 4, 2 -> 2, 3 -> 3]

[1 -> 1, 2 -> 2, 3 -> 3]

4 -> 4

[3 -> 3, 2 -> 2]

double linked keys
*/

class LRUCache {

    int capacity;

    LinkedList<Integer> keys = new LinkedList();

    // key -> value
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            keys.remove((Integer) key); // remove from curr position
            keys.addFirst(key); // adds at beginning (most recent)
        }
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            // already exists, update the value
            map.put(key, value);
        } else {
            // not exist
            if (keys.size() == capacity) {
                var removed = keys.removeLast();
                map.remove(removed);
            }

            keys.addFirst(key);
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */