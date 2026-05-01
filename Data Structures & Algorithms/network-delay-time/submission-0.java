class Solution {

    int[][] buildMat(int[][] times, int n) {
        var mat = new int[n][n];

        for (var node : mat) Arrays.fill(node, -1); // no connections
        for (var time : times) {
            var u = time[0] - 1;
            var v = time[1] - 1;
            var w = time[2];

            mat[u][v] = w;
        }

        return mat;
    }

    record Tuple(int node, int weight) implements Comparable<Tuple>{

        public int compareTo(Tuple other) {
            return weight - other.weight;
        }
    }

    int[] djisktra(int[][] mat, int k) {
        var nodes = new int[mat.length];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[k] = 0;
        
        var visited = new boolean[mat.length];

        var queue = new PriorityQueue<Tuple>();
        queue.add(new Tuple(k, 0));

        while (!queue.isEmpty()) {
            var tuple = queue.poll();

            var curr = tuple.node;
            var currWeight = tuple.weight;
            
            if (visited[curr]) continue;
            visited[curr] = true; // all neighboors added to the queue

            // find neighboors
            for (var i = 0; i < mat.length; i++) {
                if (visited[i]) continue;

                var nextWeight = mat[curr][i];
                if (nextWeight == -1) continue; // no connection

                // curr goes to i with mat[k][i] weight
                var newDist = currWeight + nextWeight;
                if (newDist < nodes[i]) {
                    nodes[i] = newDist;
                    var newTuple = new Tuple(i, newDist);
                    queue.add(newTuple);
                }   
            }
        }
        return nodes;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        var mat = buildMat(times, n);

        var res = djisktra(mat, k-1);

        var max = Integer.MIN_VALUE;

        for (var r : res) {
            if (r == Integer.MAX_VALUE) return -1; // node not visited
            max = Math.max(max, r);
        }

        return max;
    }
}