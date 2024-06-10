import java.util.ArrayList;
import java.util.List;

public class MinDifference {

    public static boolean[] subsetSum(int[] arr, int sum, int n) {
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

        return dp[n];
    }

    public int minDifference(int arr[], int n)
    {
        int range = 0;
        for (int i = 0; i < n; i++) {
            range += arr[i];
        }
        boolean[] candidate_identifier = subsetSum(arr, range, n);
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i <= range / 2; i++) {
            if (candidate_identifier[i]) {
                candidates.add(i);
            }
        }

        int minimum = Integer.MAX_VALUE;
        for (Integer candidate : candidates) {
            int new_minimum = range - 2 * candidate;
            if (new_minimum < minimum) {
                minimum = new_minimum;
            }
        }

        return minimum;
    }

    public static void main(String[] args) {

    }
}
