public class LCSMemoized {
    static int lcs2(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        } else {
            if (dp[m][n] == -1) {
                if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                    dp[m][n] = 1 + lcs2(s1, s2, m - 1, n - 1, dp);
                } else {
                    dp[m][n] = Math.max(lcs2(s1, s2, m, n - 1, dp), lcs2(s1, s2, m - 1, n, dp));
                }
            }
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "abecefr";
        int m = s1.length();
        int n = s2.length();
        // Init memo
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs2(s1, s2, m, n, dp));

    }
}
