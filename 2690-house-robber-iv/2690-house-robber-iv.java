class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9, result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canRob(int[] nums, int k, int capability) {
        int count = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i++;
            }
            if (count >= k) return true;
            i++;
        }
        return false;
    }
}
