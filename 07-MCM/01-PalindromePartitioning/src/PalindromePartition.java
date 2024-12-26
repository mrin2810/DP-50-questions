class PalindromePartition{
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        int mn = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(s, i, k) + solve(s, k+1, j) + 1;
            mn = Math.min(mn, temp);
        }
        return mn;
    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(solve(s, 0, s.length() - 1));
    }
}