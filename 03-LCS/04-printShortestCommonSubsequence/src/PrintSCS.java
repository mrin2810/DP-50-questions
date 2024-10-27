public class PrintSCS{
    class Initialization {
        public static void init(int[][] dp) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 0;
                    else dp[i][j] = -1;
                }
            }
        }
    }
    static String printShortestCommonSuperSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        Initialization.init(dp);
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
                    subsequence = str1.charAt(i - 1) + subsequence; // include the character that did not match
                    i--;
                } else {
                    subsequence = str2.charAt(j - 1) + subsequence; // include the character that did not match
                    j--;
                }
            }
        }
        while (i > 0) {
            subsequence = str1.charAt(i - 1) + subsequence;
            i--;
        }
        while (j > 0) {
            subsequence = str2.charAt(j - 1) + subsequence;
            j--;
        }
        return subsequence;
    }

    public static void main(String[] args) {
        String s1 = "HELLO";
        String s2 = "GEEK";
        System.out.println(printShortestCommonSuperSequence(s1, s2));
    }
}