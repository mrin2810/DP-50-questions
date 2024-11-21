public class MCM{
    public static int solve(int[] arr, int i, int j) {
        // Base Condition j <= i (arr size 1 or less)
        if (j <= i) return 0;

        int ans = Integer.MAX_VALUE;
        // Else, try all the possible values for `k`
        for (int k = i; k < j; k++) {
            // Temp 1 answer + Temp answer 2
            int temp = solve(arr, i, k) +
                    solve(arr, k + 1, j) + arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        // We are making a call from i = 1, because our matrix dimensions are from i-1 X i
        System.out.println(solve(arr, 1, 3));
    }
}

