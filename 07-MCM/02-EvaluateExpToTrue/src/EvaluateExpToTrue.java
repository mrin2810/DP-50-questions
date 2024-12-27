import java.util.HashMap;
import java.util.Map;

public class EvaluateExpToTrue {
    public static int solve(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        // If none of the base conditions are met...
        int ans = 0;

        for (int k = i + 1; k < j; k+=2) {
            int lT = solve(s, i, k - 1, true);
            int rT = solve(s, k + 1, j, true);
            int lF = solve(s, i, k - 1, false);
            int rF = solve(s, k + 1, j, false);

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

    public static int solveMemo(String s, int i, int j, boolean isTrue, int[][] trueMat, int[][] falseMat) {
        if (isTrue) {
            if (trueMat[i][j] != -1) return trueMat[i][j];
        } else {
            if (falseMat[i][j] != -1) return falseMat[i][j];
        }
        if (i > j) return 0;
        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        // If none of the base conditions are met...
        int ans = 0;

        for (int k = i + 1; k < j; k+=2) {
            if (trueMat[i][k-1] == -1){
                trueMat[i][k-1] = solveMemo(s, i, k - 1, true, trueMat, falseMat);
            }
            int lT = trueMat[i][k-1];
            if (trueMat[k+1][j] == -1){
                trueMat[k+1][j] = solveMemo(s, k + 1, j, true, trueMat, falseMat);
            }
            int rT = trueMat[k+1][j];
            if (falseMat[i][k-1] == -1) {
                falseMat[i][k-1] = solveMemo(s, i, k - 1, false, trueMat, falseMat);
            }
            int lF = falseMat[i][k-1];
            if (falseMat[k+1][j] == -1) {
                falseMat[k+1][j] = solveMemo(s, k + 1, j, false, trueMat, falseMat);
            }
            int rF = falseMat[k+1][j];

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
        if (isTrue) {
            trueMat[i][j] = ans;
        } else {
            falseMat[i][j] = ans;
        }
        return ans;
    }

    public static int solveMemo2(String s, int i, int j, boolean isTrue, Map<String, Integer> map) {
        String currKey = "" + i + "," + j + "," + isTrue;

        if (map.containsKey(currKey)) return map.get(currKey);

        if (i > j) return 0;
        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        // If none of the base conditions are met...
        int ans = 0;

        for (int k = i + 1; k < j; k+=2) {
            String keyLT = "" + i + "," + (k - 1) + "," + "true";
            String keyLF = "" + i + "," + (k - 1) + "," + "false";
            String keyRT = "" + (k + 1) + "," + j + "," + "true";
            String keyRF = "" + (k + 1) + "," + j + "," + "false";

            int lT = !map.containsKey(keyLT) ? solveMemo2(s, i, k - 1, true, map) : map.get(keyLT);
            int rT = !map.containsKey(keyLF) ? solveMemo2(s, k + 1, j, true, map) : map.get(keyLF);
            int lF = !map.containsKey(keyRT) ? solveMemo2(s, i, k - 1, false, map) : map.get(keyRT);
            int rF = !map.containsKey(keyRF) ? solveMemo2(s, k + 1, j, false, map) : map.get(keyRF);

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
            int n = expression.length();
            System.out.println("Expression: " + expression);
            System.out.print("\tRecursive: " + solve(expression, 0, n - 1, true));

            int[][] trueMat = new int[n][n];
            int[][] falseMat = new int[n][n];
            PalindromePartition.memset(trueMat, -1);
            PalindromePartition.memset(falseMat, -1);
            System.out.print("\tMemoized: " + solveMemo(expression, 0, n - 1, true, trueMat, falseMat));

            System.out.println("\tMemoized Correct: " + solveMemo2(expression, 0, n -1, true, new HashMap<String, Integer>()));
        }
    }
}
