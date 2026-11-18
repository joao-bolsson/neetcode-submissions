class Solution {
    
    Map<Integer, Integer> cache = new HashMap<>();

    int dfs(int curr, int n) {
        if (cache.containsKey(curr)) return cache.get(curr);
        if (curr == n) return 1;
        if (curr > n) return 0;

        var res = dfs(curr + 1, n) + dfs(curr + 2, n);
        cache.put(curr, res);
        return res;
    }
    
    public int climbStairs(int n) {
        return dfs(0, n);
    }
}
