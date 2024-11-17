public class SPMDP {
    static class Initialization {
        public static void init(int[][] dp) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 0;
                    else dp[i][j] = -1;
                }
            }
        }
    }
    static boolean printLongestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        SPMDP.Initialization.init(dp);
        for (int i = 1; i < m + 1;i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // Finding the subsequence
        int i = m;
        int j = n;
        String subsequence = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                subsequence = str1.charAt(i - 1) + subsequence;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return subsequence.length() == str1.length();
    }

    public static void main(String[] args) {
        String s1 = "XYZ";
        String s2 = "ABCXYZ";
        System.out.println(printLongestCommonSubstring(s1, s2));

    }
}
