public class LCSDP {
    static int lcs3(String s1, String s2, int m, int n) {
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

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "mrinmayee";
        String s2 = "dmhanashree";
        int m = s1.length();
        int n = s2.length();
        System.out.println(lcs3(s1, s2, m, n));

    }
}
