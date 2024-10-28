import java.util.Arrays;
import java.util.HashMap;
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
        for (int num : nums) {
            if (hashSetTest.contains(num)) {
                return true;
            }
            hashSetTest.add(num);
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------------------------//

//    Is Anagram
//    Solved
//    Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//
//    An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
//
//    Example 1:
//
//    Input: s = "racecar", t = "carrace"
//
//    Output: true
//    Example 2:
//
//    Input: s = "jar", t = "jam"
//
//    Output: false

    public boolean isAnagram_sort(String s, String t) { //Time: O(nlogn) Space: O(1)/O(n)
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);
    }

    public boolean isAnagram_HashMap(String s, String t) { //Time: O(n) Space: O(n)
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.equals(tMap);
    }

    public boolean isAnagram_optimal(String s, String t) { //Time: O(n) Space: O(1)
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int val: count) {
            if(val != 0) {
                return false;
            }
        }

        return true;
    }

//--------------------------------------------------------------------------------------------------------------------//
//Two Integer Sum
//    Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//
//    You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//
//    Return the answer with the smaller index first.
//
//    Example 1:
//
//    Input:
//    nums = [3,4,5,6], target = 7
//
//    Output: [0,1]
//    Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
//
//    Example 2:
//
//    Input: nums = [4,5,6], target = 10
//
//    Output: [0,2]
//    Example 3:
//
//    Input: nums = [5,5], target = 10
//
//    Output: [0,1]

    public int[] twoSum_bruteforce(int[] nums, int target) { //Time: O(n^2) Space: O(1)
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0};
    }

    public int[] twoSum_hashMap(int[] nums, int target) {//Time: O(n) Space: O(n)
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(hMap.containsKey(complement)) {
                return new int[] {hMap.get(complement), i};
            }

            hMap.put(nums[i], i);
        }

        return new int[]{0};
    }
}
