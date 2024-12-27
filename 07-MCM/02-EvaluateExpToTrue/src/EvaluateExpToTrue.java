public class EvaluateExpToTrue {
    public static int sovle(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        // If none of the base conditions are met...
        int ans = 0;

        for (int k = i + 1; k < j; k+=2) {
            int lT = sovle(s, i, k - 1, true);
            int rT = sovle(s, k + 1, j, true);
            int lF = sovle(s, i, k - 1, false);
            int rF = sovle(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    // true && true
                    ans += lT * rT;
                } else {
                    // false && false
                    ans += lF * rF;
                    // true && false
                    ans += lT * rF;
                    // false && true
                    ans += lF * rT;
                }
            } else if (s.charAt(k) == '|') {
                if (!isTrue) {
                    // false || false
                    ans += lF * rF;
                } else {
                    // true || true
                    ans += lT * rT;
                    // true || false
                    ans += lT * rF;
                    // false || true
                    ans += lF * rT;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    // true ^ false
                    ans += lT * rF;
                    // false ^ true
                    ans += lF * rT;
                } else {
                    // false ^ false
                    ans += lF * rF;
                    // true ^ true
                    ans += lT * rT;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] expressions = {"T^F|F", "T|T&F^T"};

        for (String expression : expressions) {
            System.out.println("Expression: " + expression);
            System.out.println("\tRecursive: " + sovle(expression, 0, expression.length() - 1, true));
        }
    }
}
