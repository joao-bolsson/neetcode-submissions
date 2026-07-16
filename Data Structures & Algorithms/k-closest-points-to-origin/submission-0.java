class Solution {

    record Point(int x, int y) implements Comparable<Point> {

        public int compareTo(Point other) {
            var dist1 = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            var dist2 = Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y, 2));
            return dist1 > dist2 ? 1 : -1;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<Point>();

        for (var p : points) pq.add(new Point(p[0], p[1]));

        var res = new int[k][2];

        for (var i = 0; i < k; i++) {
            var p = pq.poll();
            res[i] = new int[]{p.x, p.y};
        }

        return res;
    }
}