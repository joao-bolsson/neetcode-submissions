/*
          d
          |
a -> b -> c

e -> f

g -> h
     |
     i

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var indegree = new int[numCourses];

        var map = new HashMap<Integer, List<Integer>>();

        System.out.println("in" + Arrays.asList(indegree));

        for (var pre : prerequisites) {
            var list = map.getOrDefault(pre[0], new ArrayList<Integer>());
            list.add(pre[1]);

            map.put(pre[0], list);
            indegree[pre[1]]++;
        }

        var queue = new LinkedList<Integer>();
        for (var i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        var visited = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            var size = queue.size();

            while (size-- > 0) {
                var curr = queue.pop();
                visited.add(curr);

                var neighbors = map.getOrDefault(curr, List.of());
                for (var next : neighbors) {
                    if (visited.contains(next)) continue;
                    if (--indegree[next] == 0) queue.add(next);
                }           
            }
        }

        return visited.size() == numCourses;
    }
}
