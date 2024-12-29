import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public static boolean solve(String a, String b) {
        if (a.compareTo(b) == 0) return true;
        if (a.length() == 0 || b.length() == 0) return false;
        if (a.length() == 1) return false;
        int n = a.length();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            boolean swapped = solve(a.substring(0, i), b.substring(n - i)) == true
                    && solve(b.substring(i), a.substring(0, n - i)) == true;
            boolean notSwapped = solve(a.substring(0, i), b.substring(0, i)) == true
                    && solve(a.substring(i), b.substring(i)) == true;

            if (swapped || notSwapped){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean solveMemo(String a, String b, Map<String, Boolean> memo) {
        if (a.compareTo(b) == 0) return true;
        if (a.length() == 0 || b.length() == 0) return false;
        if (a.length() == 1) return false;
        String key = a + " " + b;
        if (memo.containsKey(key)) return memo.get(key);
        int n = a.length();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            boolean swapped = solveMemo(a.substring(0, i), b.substring(n - i), memo) == true
                    && solveMemo(b.substring(i), a.substring(0, n - i), memo) == true;
            boolean notSwapped = solveMemo(a.substring(0, i), b.substring(0, i), memo) == true
                    && solveMemo(a.substring(i), b.substring(i), memo) == true;

            if (swapped || notSwapped){
                flag = true;
                break;
            }
        }
        memo.put(key, flag);
        return flag;
    }


    public static void main(String[] args) {
        String[][] inputs = {
                {"great", "rgate"},
                {"rgate", "eatgr"}
        };
        for (String[] input: inputs) {
            System.out.println("a: " + input[0] + " b: " + input[1]);
            System.out.print("\tRecursive: " + solve(input[0], input[1]));
            System.out.println("\tMemo: " + solveMemo(input[0], input[1], new HashMap()));
        }
    }
}
