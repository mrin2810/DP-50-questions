public class CountSubsetsWithDiff {

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
        }

        return dp[n][sum];
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int s1 = (sum - d) / 2;

        return perfectSum(arr, n, s1);
    }

    public static void main(String[] args) {
        int n = 4;
        int d = 0;
        int arr[] = {1, 1, 1, 1};
        System.out.println(countPartitions(n, d, arr));
    }
}
