class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var map = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        var indegree = new int[numCourses];
        for (var p : prerequisites) {
            var a = p[0];
            var b = p[1];

            indegree[a]++;

            var list = map.get(b);
            list.add(a);
            map.put(b, list);
        }

        var queue = new LinkedList<Integer>();

        for (var i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        var coursesTaken = 0;
        var path = new int[numCourses];

        while (!queue.isEmpty()) {

            // visit all from same level
            var size = queue.size();
            while (size-- > 0) {
                var course = queue.pop();

                path[coursesTaken++] = course;

                // visit neighboors
                for (var neighboor : map.get(course)) {
                    indegree[neighboor]--;
                    if (indegree[neighboor] == 0) {
                        queue.add(neighboor);
                    }
                }
            }
        }

        if (coursesTaken < numCourses) return new int[0];
        return path;
    }
}