import java.util.HashMap;

public class EggDropping {
    public static int solve(int eggs, int floors) {
        // Setup all the base-cases
        if (eggs == 1) return floors;
        if (floors == 1 || floors == 0) return floors;

        int ans = Integer.MAX_VALUE;

        // Loop over k values
        for (int k = 1; k <= floors; k++) {
            // calculate breaks
            int breaks = solve(eggs - 1, k - 1);
            int doesntBreak = solve(eggs, floors - k);

            int temp = 1 + Math.max(breaks, doesntBreak);
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public static int solveMemo(int eggs, int floors, HashMap<String, Integer> memo) {
        // Setup all the base-cases
        if (eggs == 1) return floors;
        if (floors == 1 || floors == 0) return floors;

        String key = eggs + "-" + floors;
        if (memo.containsKey(key)) return memo.get(key);

        int ans = Integer.MAX_VALUE;

        // Loop over k values
        for (int k = 1; k <= floors; k++) {
            String key1 = (eggs - 1) + "-" + (k - 1);
            String key2 = eggs + "-" + (floors - k);

            if(!memo.containsKey(key1)) {
                memo.put(key1, solveMemo(eggs - 1, k - 1, memo));
            }
            int breaks = memo.get(key1);
            if (!memo.containsKey(key2)) {
                memo.put(key2, solveMemo(eggs, floors - k, memo));
            }
            int doesntBreak = memo.get(key2);

            int temp = 1 + Math.max(breaks, doesntBreak);
            ans = Math.min(ans, temp);
        }
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = {{3, 5}, {1, 2}, {2, 6}, {3, 14}};

        for (int[] input: inputs) {
            System.out.println("eggs: " + input[0] + "\tfloors: " + input[1]);
            System.out.print("\tRecursive: " + solve(input[0], input[1]));
            System.out.println("\tMemoized: " + solveMemo(input[0], input[1], new HashMap<>()));
        }
    }
}