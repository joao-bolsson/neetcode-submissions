class Solution {

    int[] idx;

    public Solution(int[] w) {
        var sum = 0;
        for (var num : w) sum += num;

        idx = new int[sum];

        var globalIdx = 0;
        for (var i = 0; i < w.length; i++) {
            for (var j = 0; j < w[i]; j++) {
                idx[globalIdx++] = i;
            }
        }
        // [0,1,1,1]
    }
    
    Random rand = new Random();

    public int pickIndex() {
        return idx[rand.nextInt(idx.length)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */