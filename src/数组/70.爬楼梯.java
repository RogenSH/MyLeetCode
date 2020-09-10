/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (46.86%)
 * Likes:    689
 * Dislikes: 0
 * Total Accepted:    96.9K
 * Total Submissions: 205.7K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // return solution1(n);
        // return solution2(n);
        return solution3(n);
        // return solution4(n);
    }

    // 递归，超时
    public int solution1(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        return solution1(n - 1) + solution1(n - 2);
    }

    // 动态规划1
    public int solution2(int n) {
        // 注意数组长度为 n + 2
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    // 动态规划2 优化空间
    public int solution3(int n) {
        int x = 0, y = 0, z = 1;
        for (int i = 1; i <= n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }

    // 斐波那契数列 计算公式（可通过特征方程推导）
    public int solution4(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

}
// @lc code=end

