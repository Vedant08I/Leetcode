import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int x = arr[j], y = arr[i];
                int prevValue = y - x;
                int prevIndex = indexMap.getOrDefault(prevValue, -1);
                if (prevIndex >= 0 && prevIndex < j) {
                    int count = dp.getOrDefault(prevIndex * n + j, 2) + 1;
                    dp.put(j * n + i, count);
                    maxLen = Math.max(maxLen, count);
                } else {
                    dp.put(j * n + i, 2);
                }
            }
        }
        
        return maxLen > 2 ? maxLen : 0;
    }
}
