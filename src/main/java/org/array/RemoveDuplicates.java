package org.array;


import java.util.Arrays;

public class RemoveDuplicates {


    /**
     *
     * @param nums nums
     * @return  int
     */
    public int removeDuplicates(int[] nums) {
       int n = nums.length;
       if (n == 0) return 0;
       int fast = 1, slow = 1;
       while (fast < n) { // 快指针的长度肯定是小于或者等于数组长度
           if (nums[fast] != nums[fast-1]) { // 快指针和每一个数组元素比较，从第二个元素比较第一个元素开始，如果不相等表示连续位置上元素不相同，如果相等则表示连续位置上元素相同，不做任何处理
               nums[slow] = nums[fast]; // 用当前快指针元素替换慢指针的元素
               ++slow; // 慢指针元素+1
           }
           ++fast; // 如果相等则表示连续位置上元素相同，不做任何处理，对快指针元素下标+1，继续和数组元素比较
       }
        System.out.println(Arrays.toString(nums));
       return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int arrLen = removeDuplicates.removeDuplicates(nums);
        System.out.println(arrLen);
    }
}
