/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.82%)
 * Likes:    321
 * Dislikes: 0
 * Total Accepted:    42.8K
 * Total Submissions: 67.8K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * 与minPathSum2比，不需要用额外的dp数组，而是在原数组上存储，这样就不需要额外的存储空间。
     * grid(i,j)=grid(i,j)+min(grid(i+1,j),grid(i,j+1))
     * 时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。
     * 空间复杂度 ：O(1)。不需要额外空间。
     */
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

    /**
     * 与minPathSum2比，只存储一行，优化空间 
     * dp(j)=grid(i,j)+min(dp(j),dp(j+1))
     * 时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。 
     * 空间复杂度：O(n)。额外的一维数组，和一行大小相同。
     */
    public int minPathSum1(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    // 优化点，
                    dp[j] = grid[i][j] + dp[j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    /**
     * dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1)) 
     * 时间复杂度 ：O(mn))。遍历整个矩阵恰好一次。 
     * 空间复杂度：O(mn)。额外的一个同大小矩阵。
     */
    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     * ！！！
     */
    public int minPathSum4(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // Initial memo to store already computed back tracking
        // path value on each corresponding position =>
        // Each cell in memo mapping to cell in given grid and
        // store the minimum path sum calculated backwards from
        // bottom right corner cell to this cell
        int[][] memo = new int[m][n];
        return helper(grid, 0, 0, memo);
    }
    
    private int helper(int[][] grid, int i, int j, int[][] memo) {
        if(i < grid.length && j < grid[0].length) {
            if(i == grid.length - 1 && j == grid[0].length - 1) {
                // Store current cell value in memo if we reach
                // to bottom right and return it
                memo[i][j] = grid[i][j];
                return memo[i][j];
            }
            // Consult memo in case we have already calculated routes
            // for a particular cell, if the result not as initial as
            // 0, return it, otherwise use the usual recursion on
            // bottom and right direction
            if(memo[i][j] != 0) {
                return memo[i][j];
            }
            int bottom = helper(grid, i + 1, j, memo);
            int right = helper(grid, i, j + 1, memo);
            // Take the minimum value for a cell on a decision tree
            int min = Math.min(bottom, right);
            // Add cell value to the minimum value from left or right child
            memo[i][j] = min + grid[i][j];
            return memo[i][j];
        }
        return Integer.MAX_VALUE;
    }
}
// @lc code=end
