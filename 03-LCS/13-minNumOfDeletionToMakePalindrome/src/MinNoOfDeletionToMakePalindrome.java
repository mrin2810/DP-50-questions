public class MinNoOfDeletionToMakePalindrome {
    public static int minNoOfDeletionToMakePalindrome(String s) {
        int n = s.length();
        // Build Second String (Reverse)
        String s2 = "";
        for (Character c : s.toCharArray()) {
            s2 = c + s2;
        }

        // Initialize for LCS
        int dp[][] = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        // Logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return n - dp[n][n];
    }

    public static void main(String[] args) {
        String s1 ="mrinmayee";
        System.out.println(minNoOfDeletionToMakePalindrome(s1));
    }
}
