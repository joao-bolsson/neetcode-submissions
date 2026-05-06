/*


in the past 4 seconds

curr = 400


396

curr = 301-300 -> 1

300
3
2
1

timestamp = 4
approach 1:
    stack, while peek >= curr - timestamp: pop to a list
    push all from list
    return list.size

*/

class HitCounter {

    Deque<Integer> stack = new ArrayDeque<Integer>();

    public HitCounter() {
        
    }
    
    // seconds
    public void hit(int timestamp) {
        stack.push(timestamp);
    }
    
    public int getHits(int timestamp) {
        var list = new ArrayList<Integer>();
        while (!stack.isEmpty() && stack.peek() > timestamp - 300) list.add(stack.pop());
        for (var i = list.size() - 1; i >= 0; i--) stack.push(list.get(i));
        return list.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
