class Solution {
    public int[] findErrorNums(int[] nums) {
        // using bitwise XOR

        int n = nums.length;

        int[] counter = new int[n + 1];
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            ans[1] ^= (i + 1) ^ nums[i]; // keep appending xor in index-1

            if (++counter[nums[i]] == 2) {
                ans[0] = nums[i]; // store the duplicate element
            }
        }

        // by now ans[1] contains xor of all elements
        // non-duplicate got cancelled out
        // final XOR must be containing: [duplicate ^ missing]
        ans[1] ^= ans[0]; // remove duplicate from final XOR

        return ans;

    }
}