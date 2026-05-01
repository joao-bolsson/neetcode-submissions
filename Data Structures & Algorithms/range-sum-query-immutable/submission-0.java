class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length];

        var total = 0;
        var i = 0;
        for (var n : nums) {
            total += n;
            preSum[i++] = total;
        }
    }
    
    public int sumRange(int left, int right) {
        var preRight = preSum[right];
        var preLeft = left > 0 ? preSum[left-1] : 0;
        return preRight - preLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */