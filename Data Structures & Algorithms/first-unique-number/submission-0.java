/*

[2,3,5]

map to count

top

add
- increment counter
- check stack peek, and while peek value counts > 1: pop()
    stack.push


initialize:
   - for each number: check if there is an entry in the hashmap
        - yes: just update the counter
        - no: update the counter and push 

top
7 -> 1

*/
class FirstUnique {

    Map<Integer, Integer> map = new HashMap<>();

    Queue<Integer> queue = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for (var n : nums) {
            add(n);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }
    
    public void add(int value) {
        var n = value;
        if (!map.containsKey(n)) {
            queue.add(n);

            map.put(n, 1);
        } else {
            map.put(n, map.get(n) + 1);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
