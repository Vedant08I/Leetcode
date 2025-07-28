class Solution {
    int maxOr = 0;
    int cnt = 0;
    public int countMaxOrSubsets(int[] nums) {
        //compute the max OR possible
        for(int num: nums){
            maxOr |= num;
        }
        //// Start backtracking
        dfs(nums, 0, 0);
        return cnt;
    }
    private void dfs(int[] nums, int idx, int currOr){
        if(idx == nums.length){
            if(currOr == maxOr){
                cnt++;
            }
            return;
        }
        // Include current number
        dfs(nums, idx + 1, currOr | nums[idx]);
        // Exclude current number
        dfs(nums, idx + 1, currOr);
    }
}