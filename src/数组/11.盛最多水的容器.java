/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (58.30%)
 * Likes:    882
 * Dislikes: 0
 * Total Accepted:    97.4K
 * Total Submissions: 164.9K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 1) return 0;
        // 暴力解法 
        // return func1(height);
        // 双指针 
        // return func2(height);
        // 优化双指针
        return func3(height);
    }

    public int func3(int[] height) {
        int i = 0,j = height.length - 1,content = 0;
        while (i < j) {
            int leftHeight = height[i];
            int rightHeight = height[j];
            content = Math.max(content, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                while(i < j && height[i] <= leftHeight) ++i;
            } else{
                while(i < j && height[j] <= rightHeight) --j;
            }
        }
        return content;
    }

    public int func2(int[] height) {
        int i = 0,j = height.length - 1,content = 0;
        while (i < j) {
            content = Math.max(content, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else{
                j--;
            }
        }
        return content;
    }

    public int func1(int[] height) {
        int content = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 0; j < height.length; j++) {
                content = Math.max(content, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return content;
    }
}
// @lc code=end
