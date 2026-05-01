class Solution {

    record Tuple(int node, double prob) implements Comparable<Tuple> {
        
        public int compareTo(Tuple other) {
            if (prob == other.prob) return 0;
            if (prob > other.prob) return 1;
            return -1;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        var probs = new double[n]; // probs[i] is gonna be the max probability of reaching that node
        Arrays.fill(probs, -1); // initial state

        // node -> list of [other node, prob to reach that node]
        var map = new HashMap<Integer, List<Tuple>>();

        for (var i = 0; i < edges.length; i++){
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<Tuple>()).add(new Tuple(edges[i][1], succProb[i]));
            map.computeIfAbsent(edges[i][1], k -> new ArrayList<Tuple>()).add(new Tuple(edges[i][0], succProb[i]));
        }

        var queue = new PriorityQueue<Tuple>(Collections.reverseOrder()); // max heap
        queue.add(new Tuple(start_node, 1));

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            var node = curr.node;

            if (node == end_node) return curr.prob; // find, return immediatelly
            if (probs[node] > -1) continue; // already visited that node

            probs[node] = curr.prob;

            for (var next : map.getOrDefault(node, List.of())) {
                if (probs[next.node] > -1) continue;
                queue.add(new Tuple(next.node, curr.prob * next.prob));
            }
        }

        return 0;
    }
}