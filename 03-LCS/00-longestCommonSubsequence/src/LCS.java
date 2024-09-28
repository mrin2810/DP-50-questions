public class LCS {
    static int LCS(String x, String y, int m, int n) {

        if (n == 0 || m == 0) return 0;
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            // Plus 1 because character is common
            return 1 + LCS(x, y, m - 1, n - 1);
        } else {
            // No Plus 1 because character is not common
            return Math.max(LCS(x, y, m - 1, n), LCS(x, y, m, n - 1));
        }
    }

    public static void main(String[] args) {
        String x = "abcdef";
        String y = "abecefr";

        System.out.println(LCS(x, y, 4, 4));
    }
}
