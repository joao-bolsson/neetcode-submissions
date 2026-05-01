class MedianFinder {

    public MedianFinder() {
        
    }

    Queue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
    Queue<Integer> right = new PriorityQueue<Integer>(); // min heap

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        // the size of both never diffs more than 1
        if (Math.abs(right.size() - left.size()) > 1) {
            // balance heaps: pop from the bigger
            var big = right.size() > left.size() ? right : left;
            var small = big == right ? left : right;

            small.add(big.poll());
        }
    }

    public double findMedian() {
        if ((left.size() + right.size()) % 2 != 0) {
            var big = right.size() > left.size() ? right : left;

            return big.peek();
        }
        return (left.peek() + right.peek()) / 2d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */