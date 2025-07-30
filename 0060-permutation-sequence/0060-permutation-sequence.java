class Solution {
    public void rev(int[] nums, int start, int end) {
        while(start<=end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void findnext(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                idx = i;
                break;
            }
        }
        if(idx==-1) {
            rev(nums,0,idx);
        }else{
            for(int i=n-1;i>=0;i--) {
                if(nums[i]>nums[idx]) {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    break;
                }
            }
            rev(nums,idx+1,n-1);
        }
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=1;i<=n;i++) {
            nums[i-1] = i;
        }
        for(int i=2;i<=k;i++) {
            findnext(nums);
        }
        StringBuilder sb = new StringBuilder();
        for(int num:nums) {
            sb.append(Integer.toString(num));
        }
        return sb.toString();
    }
}