class Solution {

    void backtrack(int i, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // generate all subsets with nums[i]
        curr.add(nums[i]);
        backtrack(i+1, nums, curr, res);

        // generate all subsets without nums[i]
        curr.remove(curr.size() - 1);

        //     i
        // 1,2,2,3
        while (i+1 < nums.length && nums[i] == nums[i+1]) i++;

        backtrack(i+1, nums, curr, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        var res = new ArrayList<List<Integer>>();
        backtrack(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
}