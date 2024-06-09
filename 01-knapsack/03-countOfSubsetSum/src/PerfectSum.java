public class PerfectSum {
    public static int perfectSum(int arr[],int n, int sum)
    {
        // Initialize DP
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }

        // Start filing the matrix
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            System.out.println(dp);
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int n = arr.length;
        int sum = 31;

        System.out.println(perfectSum(arr, n , sum));
    }
}
