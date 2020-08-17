package com.challenge.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class July23 {

    public Integer[] singleNumber(int[] nums) {
        List<Integer> output = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(((i+1) < nums.length) && (nums[i] != nums[i+1])){
                output.add(nums[i]);
            } else{
                i++;
            }
        }
        return output.stream().toArray(Integer[]::new);
        //return output.toArray(new int[output.size()]);
    }

    public static void main(String[] args) {
        July23 obj = new July23();
        int input[] = new int[]{1,2,1,3,2,5};
        Integer output[] = obj.singleNumber(input);
        for(int i : output){
            System.out.print(i + "\t");
            System.out.println();
        }
    }
}
