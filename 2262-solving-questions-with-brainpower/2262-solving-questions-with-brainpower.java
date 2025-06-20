class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[i] stores max points from index i to end

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];
            int nextIndex = i + skip + 1;

            // Option 1: Solve current question
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);
            
            // Option 2: Skip current question
            long skipQuestion = dp[i + 1];

            // Take the best of both choices
            dp[i] = Math.max(solve, skipQuestion);
        }

        return dp[0]; // Maximum points from index 0
    }
}
