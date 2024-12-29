public class ScrambleString {
    public static boolean solve(String a, String b) {
        if (a.compareTo(b) == 0) return true;
        if (a.length() == 0 || b.length() == 0) return false;
        if (a.length() <= 1) return false;
        int n = a.length();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            boolean swapped = solve(a.substring(0, i), b.substring(n - i)) == true
                    && solve(b.substring(i), a.substring(0, n - i)) == true;
            boolean notSwapped = solve(a.substring(0, i), b.substring(0, i)) == true
                    && solve(a.substring(i), b.substring(i)) == true;

            if (swapped || notSwapped){
                System.out.println(a + " " + b + " " + (swapped || notSwapped));
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"great", "rgate"},
                {"rgate", ""}
        };
        for (String[] input: inputs) {
            System.out.println("a: " + input[0] + " b: " + input[1]);
            System.out.println("\t" + solve(input[0], input[1]));
        }
    }
}
