public class SubsetSum {

    public static boolean subsetSum(int[] arr, int sum, int n) {
        // Create the table
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    // have choice, so if any one of them is true the ans should be true.
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // have no choice.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;

        System.out.println(subsetSum(arr, sum, n));
    }
}
