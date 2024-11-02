public class LRSDP {
    static int longestRepeatedSubSeq(String str)
    {
       String a = new String(str);
       String b = new String(str);

       int m = a.length();
       int n = b.length();

       int[][] dp = new int[m + 1][n + 1];

       // Initialize
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        // LCS Code
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String args[])
    {
        String str = "AABEBCDD";
        System.out.println(longestRepeatedSubSeq(str)); // Output: 3 (ABD)
    }
}
