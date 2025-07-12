class Solution { 
    public int[] earliestAndLatest(int n, int f, int s) { 
        // It takes:
        // - n:  Total number of players in the tournament.
        // - f:  The starting position of Player 1 (firstPlayer).
        // - s:  The starting position of Player 2 (secondPlayer).
        // It returns an array [earliestRound, latestRound].

        int p1 = Math.min(f, s), p2 = Math.max(f, s); // \U0001f46f‍♀️ Let's rename and normalize so player 1 always starts at the lower position.
        // p1 is the smallest position and p2 the biggest. This helps with logic.

        if (p1 + p2 == n + 1) return new int[]{1, 1}; // \U0001f4a5 Quick win! If the players start on opposite sides, they meet in round 1.

/*
Examples:

    n = 8, p1 = 1, p2 = 8
        p1 + p2 = 1 + 8 = 9
        n + 1 = 8 + 1 = 9
        p1 + p2 == n + 1 (9 == 9) – TRUE
        Player 1 and Player 2 will meet in the first round.
        The code will return {1, 1} (the earliest and latest meeting round is the first one).

    n = 11, p1 = 2, p2 = 10
        p1 + p2 = 2 + 10 = 12
        n + 1 = 11 + 1 = 12
        p1 + p2 == n + 1 (12 == 12) – TRUE
        Player 2 and Player 10 will meet in the first round.
        The code will return {1, 1}.

why n + 1 ?

If we add up the positions of the players in each pair, we get:

    1 + n = n + 1
    2 + (n-1) = n + 1
    3 + (n-2) = n + 1
        ...and so on

We see that the sum of the players' positions in each pair is always equal to n + 1
*/

        int m = (n + 1) / 2, minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE; // \U0001f522 Setting up some variables:
        //  - m: Midpoint of the players, crucial for calculating positions in the next round.
        //  - minR: Stores the earliest round (initialized to the highest possible value).
        //  - maxR: Stores the latest round (initialized to the lowest possible value).

        if (p1 - 1 > n - p2) { // \U0001f504 Symmetry check. It's sometimes easier to flip the players' positions.
            int t = n + 1 - p1;
            p1 = n + 1 - p2;
            p2 = t;
        }
/*
Imagine that you have two candies, and one of them is 
almost at the very beginning of the row of candies, and the 
other is almost at the very end. To make it easier to 
understand which candies to take, you can “flip” the 
row so that both candies are closer to the beginning. 
This code does about the same thing, “flipping” the players' positions 
to simplify the analysis.
*/

        if (p2 * 2 <= n + 1) { // \U0001f914 Case 1: Players are "close" to each other
            int a = p1 - 1, b = p2 - p1 - 1; // \U0001f4d0 "a" and "b" represent the distance between the two players.
            for (int i = 0; i <= a; i++) { // \U0001f504 Looping through possible scenarios.
                for (int j = 0; j <= b; j++) {
                    int[] next = earliestAndLatest(m, i + 1, i + j + 2); // \U0001f9e9 Recursive call! This is where the magic of breaking the big problem into smaller ones happen.
                    // It calculates the earliest and latest rounds in the next round
                    minR = Math.min(minR, next[0] + 1); // ✅ Update minRound based on the recursive result
                    maxR = Math.max(maxR, next[1] + 1); // ✅ Update maxRound based on the recursive result
                }
            }
        } else { // \U0001f914 Case 2: Players are "far" from each other
            int p4 = n + 1 - p2, a = p1 - 1, b = p4 - p1 - 1, c = p2 - p4 - 1; // \U0001f4d0 This part is a bit more complicated to simulate this scenario.
            for (int i = 0; i <= a; i++) { // \U0001f504 Looping through possible scenarios.
                for (int j = 0; j <= b; j++) {
                    int offset = i + j + 1 + (c + 1) / 2 + 1; // Calculating the offset.
                    int[] next = earliestAndLatest(m, i + 1, offset); // \U0001f9e9 Recursive call!
                    minR = Math.min(minR, next[0] + 1); // ✅ Update minRound based on the recursive result
                    maxR = Math.max(maxR, next[1] + 1); // ✅ Update maxRound based on the recursive result
                }
            }
        }
        return new int[]{minR, maxR}; // \U0001f3c1 We're done! Return the earliest and latest rounds.
    }
}