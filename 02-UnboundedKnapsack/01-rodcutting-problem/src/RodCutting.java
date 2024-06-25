public class RodCutting {

    public static int rodCutting(int[] rod_len, int[] price, int N, int n) {
        int dp[][] = new int[n + 1][N + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (rod_len[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - rod_len[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][N];
    }

    public static void main(String[] args) {
        int[] rod_len = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int n = rod_len.length;
        int N = 8;

        System.out.println("knapsack with top-down: " + rodCutting(rod_len, price, N, n));
    }

}
