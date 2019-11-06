/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.01%)
 * Likes:    415
 * Dislikes: 0
 * Total Accepted:    76.7K
 * Total Submissions: 133.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 交换顺序
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int i = 0, j = 0;
        while (i <= nums.length - 1) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            i++;
        }
    }

    // 补零
    public void moveZeroes(int[] nums) {
        // i:插入位置下标 ; j:查找位置下标
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        // 将后面的位置补0
        for (int p = i; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
// @lc code=end
