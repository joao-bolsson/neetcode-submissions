class Solution {

    record Route(int[] stops) {}

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        var queue = new LinkedList<Route>();

        var visited = new HashSet<Route>(); // routes already visited

        // stop -> routes they are part of
        var map = new HashMap<Integer, List<Route>>();
        for (var r : routes) {
            var route = new Route(r);
            
            for (var stop : r) {
                var list = map.getOrDefault(stop, new ArrayList<Route>());
                list.add(route);

                map.put(stop, list);
            }
        }

        if (!map.containsKey(source)) return -1; // no route from source

        // adds the first stops to be checked out
        for (var routeWithSource : map.get(source)) {
            queue.add(routeWithSource);
            visited.add(routeWithSource);
        }

        int buses = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                var route = queue.pop();

                for (var stop : route.stops) {
                    if (stop == target) return buses;

                    for (var next : map.get(stop)) {
                        if (visited.contains(next)) continue;
                        visited.add(next);

                        queue.add(next); // add the route
                    }
                }
            }

            buses++;
        }

        return -1;
    }
}