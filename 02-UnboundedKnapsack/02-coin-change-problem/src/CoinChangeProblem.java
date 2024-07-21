public class CoinChangeProblem {

    public static int subsetSum(int[] arr, int sum, int n) {
        // Create the table
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0 && i != 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // have no choice.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 3, 6};
        int sum = 10;
        int n = arr.length;

        System.out.println(subsetSum(arr, sum, n));
    }
}
