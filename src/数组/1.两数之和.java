/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.76%)
 * Likes:    6552
 * Dislikes: 0
 * Total Accepted:    607.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;

        // return solution1(nums, target);

        // return solution2(nums, target);

        // return solution3(nums, target);

        return solution4(nums, target);

        // return solution5(nums, target);
    }

    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int value = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (value == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = target - nums[i];
            Integer index = map.get(count);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return new int[2];
    }

    public int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (null != index && index != i) {
                return new int[]{i, index};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public int[] solution4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    public int[] solution5(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left, i};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
    
}
// @lc code=end

