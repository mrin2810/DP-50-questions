class PalindromePartition{
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        int mn = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(s, i, k) + solve(s, k+1, j) + 1;
            mn = Math.min(mn, temp);
        }
        return mn;
    }

    public static int solveMemo(String s, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) {
            dp[i][j] = 0;
            return dp[i][j];
        }
        int mn = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solveMemo(s, i, k, dp) + solveMemo(s, k + 1, j, dp) + 1;
            mn = Math.min(mn, temp);
        }
        dp[i][j] = mn;
        return mn;
    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(solve(s, 0, s.length() - 1));
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solveMemo(s, 0, n - 1, dp));
    }
}