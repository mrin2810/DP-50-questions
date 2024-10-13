public class SCSDP {
    static int shortestCommonSupersequence(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // Initialize
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // if either of the string is empty the LCS length will be 0
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return m + n - dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        System.out.println(shortestCommonSupersequence(s1, s2, m, n));

    }
}
