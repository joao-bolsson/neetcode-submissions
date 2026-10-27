/*


[-1,0,1,2,-1,-4]

i   j             k
-4, 2, -1, 0, 1, 2



i+j+k = 0

-i = k + j

-nums[i] = nums[k] + nums[j]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var res = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for (var i = 0; i <= nums.length - 3; i++) {
            var j = i+1; // left
            var k = nums.length - 1; // right

            while (j < k) {
                var sum = nums[j] + nums[k];
                var target = -nums[i];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k])); 
                    j++;
                    k--;
                } else if (sum < target) j++;
                else k--;
            }
        }

        return new ArrayList<>(res);
    }
}
