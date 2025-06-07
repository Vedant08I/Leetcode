class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> lst = new ArrayList<>();
        int len = nums.length;
        if(len == 0)return lst;
        boolean lastClear = false;
        for(int i = 1;i< nums.length;i++){
           int count = 0; 
           while(i < nums.length && nums[i-1] +1 == nums[i]){
            count++;
            i++;
           }
           StringBuilder str = new StringBuilder();
           str.append(nums[i-1-count]);
           if(count >0){
                str.append("->");
                str.append(nums[i-1]);
                if(i-1 == nums.length-1)lastClear = true;
           }
           lst.add(str.toString());
           
        }
        
        if(!lastClear){
            StringBuilder st = new StringBuilder();
            st.append(nums[len-1]);
            lst.add(st.toString());
        }
        return lst;
        //tc: O(n)
        //sc: O(n)
    }
}