public class CoinChange2 {
    public static int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        // Create the table
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j == 0) dp[i][j] = 0;
                if (i == 0) dp[i][j] = Integer.MAX_VALUE - 1;
                // initialize the second row
                if (i == 1 && j != 0) {
                    if(amount % coins[i - 1] == 0) {
                        dp[i][j] = amount / coins[i - 1];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    }
                }
            }
        }
        // Calculate
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];

    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3};
        int sum = 1;

        System.out.println(coinChange2(arr, sum));
    }
}
