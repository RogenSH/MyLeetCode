/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes1 = function (nums) {
  let nonZeroIndex = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[nonZeroIndex] = nums[i];
      nums[i] = nonZeroIndex === i ? nums[i] : 0;
      nonZeroIndex++;
    }
  }
};

let moveZeroes2 = function (nums) {
  let index = 0, zeroNums = 0;

  while (index < nums.length) {
    if (nums[index] === 0) {
      nums.splice(index, 1);
      zeroNums++;
      index--;
    }
    index++;
  }

  nums.push(...Array(zeroNums).fill(0));
}

let moveZeroes4 = function (nums) {
  let index = 0, zeroArr = [];

  while (index < nums.length) {
    if (nums[index] === 0) {
      nums.splice(index, 1);
      zeroArr.push(0);
      index--;
    }
    index++;
  }

  nums.push(...zeroArr);
}

var moveZeroes = function (nums) {
  let k = 0, zeroArr = [];

  while (k < nums.length) {
    if (nums[k] == 0) {
      nums.splice(k, 1);
      zeroArr.push(0);
      k--;
    }
    k++;
  }
  nums.push(...zeroArr);
};
// @lc code=end

