import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.12%)
 * Likes:    1493
 * Dislikes: 0
 * Total Accepted:    113.7K
 * Total Submissions: 467K
 * Testcase Eleftample:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution1(nums);
    }

    /***
     * 边界条件：
     * - nums 的有效性
     * - 重复元素处理(重点！)
     * 优化点：
     * - 排序后的冗余场景剔除，如最小值为正
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) return result;
        Arrays.sort(nums);
        // if (nums[0] > 0) return result;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break; // 补充边界条件：当最小值为正数跳出循环，需要在循环内！！！
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    /// 必须同时向中间移动
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> solution5(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3)
            return ans; // 边界条件：返回[]而非 null
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break; // 补充边界条件，当最小值为正数跳出循环！！！
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去重！！！
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // 去重!!!
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // 去重!!!
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
    
}
// @lc code=end
