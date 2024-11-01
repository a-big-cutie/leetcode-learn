package org.array;

import java.util.Arrays;

/**
 * Define an array and a target, find two numbers whose sum is the target value, and return the array index
 * get the sum of two numbers and return they array index
 */
public class SumOfTwoNums {


    public int[] getArrayIndex(int[] inrArrays, int target) {
        for (int i = 0; i < inrArrays.length; i++) {
            for (int j = 0; j < inrArrays.length; j++) {
                if (i == j) {
                    continue;
                }
                if (inrArrays[i] + inrArrays[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] inrArrays = new int[]{2,7,11,15};
        SumOfTwoNums sumOfTwoNums = new SumOfTwoNums();
        int[] resultArray = sumOfTwoNums.getArrayIndex(inrArrays,9);
        System.out.println(Arrays.toString(resultArray));
    }
}
