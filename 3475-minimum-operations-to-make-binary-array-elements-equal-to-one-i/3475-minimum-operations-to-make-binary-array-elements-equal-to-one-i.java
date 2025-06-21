class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, operations = 0;
        
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                operations++;
            }
        }
        
        for (int num : nums) {
            if (num == 0) return -1;
        }
        
        return operations;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0, 1, 1, 1, 0, 0};
        System.out.println(solution.minOperations(nums1));

        int[] nums2 = {0, 1, 1, 1};
        System.out.println(solution.minOperations(nums2));
    }
}
