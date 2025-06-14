public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort both the kids' greed factors and the cookie sizes in ascending order. 
        // Sorting helps us to efficiently find the smallest cookie that can satisfy each child.
        Arrays.sort(g); 
        Arrays.sort(s); 
        
        // Step 2: Initialize two pointers, 'child' and 'cookie', to keep track of the current child and cookie we're considering.
        int child = 0; 
        int cookie = 0; 
        
        // Step 3: Iterate through both arrays until we run out of kids or cookies.
        while (child < g.length && cookie < s.length) {
            // If the current cookie is big enough to satisfy the current child's greed, we move on to the next child.
            if (s[cookie] >= g[child]) { 
                child++; 
            }
            // Regardless of whether the cookie was big enough, we always move on to the next cookie.
            cookie++; 
        }
        
        // Step 4: Return the number of children who were successfully given cookies.
        return child;
    }
}