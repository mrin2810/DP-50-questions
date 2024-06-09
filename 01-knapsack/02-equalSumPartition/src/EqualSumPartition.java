public class EqualSumPartition {
    public static boolean equalPartition(int arr[], int n ){
        int sum = 0;
        for (int i  = 0; i < n; i++) {
            sum += arr[i];
        }

        // check if sum is even
        if (sum % 2 != 0) return false;

        // if it is even then we can find a subset with sum / 2 as total.
        boolean[][] dp = new boolean[n + 1][(sum / 2) + 1];

        // Initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < (sum / 2) + 1; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < (sum / 2) + 1; j++) {
                if (arr[i - 1] <= j) {
                    // have choice, so if any one of them is true the ans should be true.
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // have no choice.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum / 2];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int n = arr.length;

        System.out.println(equalPartition(arr, n));
    }
}
