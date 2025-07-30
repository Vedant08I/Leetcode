class Solution {
    public int trap(int[] height) {
        int water=0;

        int low=0;int high=0;
        while(high<height.length){
            if(height[high]>=height[low]){
                int min=Math.min(height[low],height[high]);
                while(low<high){
                    water+=min-height[low];
                    low++;
                }
            }
            high++;
        }
        low=height.length-1;high=height.length-1;
        while(high>=0){
            if(height[high]>height[low]){
                int min=Math.min(height[low],height[high]);
                while(low>high){
                    water+=min-height[low];
                    low--;
                }
            }
            high--;
        }

        return water;
    }
}