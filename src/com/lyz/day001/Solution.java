package com.lyz.day001;


import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        int len = nums.length;
        for ( int i = 0 ; i < len -1 ; i++) { // 肯定不是最后一个
            for ( int j = i+1; j < len; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //以空间换 时间 ；查找表
    // 在遍历的同时，记录一些信息， 以省去 一层外循环。
    // 需要记录 已经遍历 过的 数值 和它对应 的下标 。
    public static int[] twoSum_2(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer,Integer> hashMap = new HashMap<>(len-1);
        hashMap.put(nums[0] , 0);
        for ( int i = 1; i < len - 1; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another)){
                return new int[]{hashMap.get(another) , i};
            }
            hashMap.put(nums[i] , i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

    public static void main(String[] args) {
        //初始化数组的三种方式.多年不写，基本的都不会了哈哈。
        int[] arr = new int[5];//动态初始化，声明并开辟数组
        int[] arr1 = {1,2,3,4,5}; // 静态初始化， 简写
        int[] arr2 = new int[] {1,2,3,4,5}; //静态初始化，

        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum_1(nums , target)));
        System.out.println(Arrays.toString(twoSum_2(nums , target)));
    }

}
