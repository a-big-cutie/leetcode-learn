package org.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public int[] getHashIndex(int[] inrArrays, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inrArrays.length; i++) {
            // if(map.containsKey(target - nums[i])): 计算当前数 nums[i] 的补数（即 target - nums[i]），并检查这个补数是否已经存在于哈希表中。如果存在，说明找到了两个数，它们的和等于目标值
            int key = target - inrArrays[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(inrArrays[i], i);
        }
        throw new IllegalArgumentException("No such element");
    }

    private static final Logger logger = LoggerFactory.getLogger(SumOfTwoNums.class);


    public static void main(String[] args) {
        int[] inrArrays = new int[]{2,7,11,15};
        SumOfTwoNums sumOfTwoNums = new SumOfTwoNums();
        int[] resultArray = sumOfTwoNums.getArrayIndex(inrArrays,9);
        logger.info("result array,{}",Arrays.toString(resultArray));
        int[] resultHashArray = sumOfTwoNums.getHashIndex(inrArrays,9);
        logger.info("result hash array,{}",Arrays.toString(resultHashArray));
    }
}
