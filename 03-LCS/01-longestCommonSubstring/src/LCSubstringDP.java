public class LCSubstringDP{
    static int lcs2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // Initialize
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // if either of the string is empty the LCS length will be 0
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
       for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (dp[i][j] == -1) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0; // This is what we changed.
                }
            }
         }
       }
        int maxLen = -1;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (dp[i][j] > maxLen) maxLen = dp[i][j];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        System.out.println(lcs2(s1, s2));

    }
}