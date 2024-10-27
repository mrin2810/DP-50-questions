public class LPSDP{
    static int lps(String s) {
        int m = s.length();
        // Create a new string which is reverse of s1 
        String s2 = "";
        for (int i = m - 1; i >= 0; i--) {
            s2 = s2 + s.charAt(i);
        }
        // Code for Finding LCS
        int[][] dp = new int[m + 1][m + 1];
        // Initialize
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 0 || j == 0) {
                    // if either of the string is empty the LCS length will be 0
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][m];

    }

    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(lps(s));
    }
}