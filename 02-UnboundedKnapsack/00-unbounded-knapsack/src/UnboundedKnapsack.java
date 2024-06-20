public class UnboundedKnapsack {
    static int[][] dp = new int[102][1002]; //Based on n and W constraints

    private static int unboundedKnapsack(int[] wt, int[] val, int W, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;
        //Choice Diagram
        int exclude = unboundedKnapsack(wt, val, W, n - 1);
        if (wt[n-1] <= W) {
            // We have a choice
            int include = val[n - 1] + unboundedKnapsack(wt, val, W - wt[n - 1], n);
            return Math.max(include, exclude);
        } else {
            // We don't have a choice
            return exclude;
        }
    }

    private static int unboundedKnapsack_memo(int[] wt, int[] val, int W, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;

        // Return memoized solution if present
        if (dp[n][W] != -1) return dp[n][W];

        //Choice Diagram
        int exclude = unboundedKnapsack_memo(wt, val, W, n - 1);
        if (wt[n-1] <= W) {
            // We have a choice
            int include = val[n - 1] + unboundedKnapsack_memo(wt, val, W - wt[n - 1], n);
            // Save the solution
            dp[n][W] = Math.max(include, exclude);
        } else {
            // Save the solution
            dp[n][W] = exclude;
        }
        return dp[n][W];
    }

    private static int unboundedKnapsack_top_down(int[] wt, int[] val, int W, int n) {
        // Setup
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{1, 50};
        int[] val = new int[]{1, 30};
        int n = wt.length;
        int W = 100;

        // Recursive
        System.out.println("knapsack with recursion: " + unboundedKnapsack(wt, val, W, n));

        // Memoized
        // initialize the dp matrix with -1
        for(int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        // Recursive Memoized Function
        System.out.println("knapsack with memoization: " + unboundedKnapsack_memo(wt, val, W, n));

        System.out.println("knapsack with top-down: " + unboundedKnapsack_top_down(wt, val, W, n));
    }
}