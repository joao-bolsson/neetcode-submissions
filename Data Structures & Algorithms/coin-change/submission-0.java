/*

coins=[1,5,10]


amount=12

        []
 [1]   [5]   [10]

[1,1] [1,5] [1,10]

[]
    [1]
        [1,1] 2
        [1,5] 7
        [1,10] 11
    [5]
        [5,1] 6
        [5,5] 10
        [5,10] x 15
    [10]
        [10,1] 11
            [10,1,1] <- 12
        [10,5] x 15
        [10,10] x 20



*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        var queue = new LinkedList<Integer>();
        queue.add(0);

        var seen = new HashSet<Integer>();

        var level = 1;
        while (!queue.isEmpty()) {
            var size = queue.size();
            while (size-- > 0) {
                var curr = queue.pop();
                
                if (seen.contains(curr)) continue;
                seen.add(curr);

                for (var c : coins) {
                    var nextAmount = curr + c;
                    if (seen.contains(nextAmount)) continue;
                    if (nextAmount == amount) return level;
                    if (nextAmount > amount) continue;
                    queue.add(nextAmount);
                }
            }
            level++;
        }

        return -1;
    }
}
