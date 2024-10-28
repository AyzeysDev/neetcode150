import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySolution {

//CONTAINS DUPLICATE
//Duplicate Integer
//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
//
//Example 1:
//
//Input: nums = [1, 2, 3, 3]
//
//Output: true
//Example 2:
//
//Input: nums = [1, 2, 3, 4]
//
//Output: false

    //SOLUTION1 -- BRUTE FORCE
    public boolean hasDuplicate_bruteforce(int[] nums) { //Time: O(n^2) Space: O(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //SOLUTION2 -- SORTING
    public boolean hasDuplicate_sorting(int[] nums) { //Time: O(nlogn) Space: O(1)
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    //SOLUTION3 -- HASHSET
    public boolean hasDuplicate(int[] nums) { //Time: O(n) Space: O(n)
        Set<Integer> hashSetTest = new HashSet<Integer>();
        for(int num: nums) {
            if(hashSetTest.contains(num)) {
                return true;
            }
            hashSetTest.add(num);
        }
        return false;
    }
}
