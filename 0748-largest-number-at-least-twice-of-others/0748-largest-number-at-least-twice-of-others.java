class Solution {
    public int dominantIndex(int[] nums) {
        int len=nums.length;
        int max=Integer.MIN_VALUE;
        int ind=0;
        for(int i=0;i<len;i++){
            if(max<nums[i]){
                max=nums[i];
                ind=i;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]*2>max && i!=ind){
               return -1;
            }
        }
        return ind;
    }
}