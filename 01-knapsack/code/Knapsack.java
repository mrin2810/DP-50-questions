public class Knapsack {
    static int[][] dp = new int[102][1002]; //Based on n and W constraints

    private static int knapsack(int[] wt, int[] val, int W, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;
        //Choice Diagram
        int exclude = knapsack(wt, val, W, n - 1);
        if (wt[n-1] <= W) {
            // We have a choice
            int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
            return Math.max(include, exclude);
        } else {
            // We don't have a choice
            return exclude;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int W = 7;

        // Recursive
        System.out.println(knapsack(wt, val, W, n));

        // Memoized
        // initialize the dp matrix with -1
        for(int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        // Recursive Memoized Function
        System.out.println(knapsack_memo(wt, val, W, n));
    }

    private static int knapsack_memo(int[] wt, int[] val, int W, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;

        // Return memoized solution if present
        if (dp[n][W] != -1) return dp[n][W];

        //Choice Diagram
        int exclude = knapsack_memo(wt, val, W, n - 1);
        if (wt[n-1] <= W) {
            // We have a choice
            int include = val[n - 1] + knapsack_memo(wt, val, W - wt[n - 1], n - 1);
            // Save the solution
            dp[n][W] = Math.max(include, exclude);
        } else {
            // Save the solution
            dp[n][W] = exclude;
        }
        return dp[n][W];
    }
}