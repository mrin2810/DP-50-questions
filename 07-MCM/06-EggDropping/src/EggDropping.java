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

    public static void main(String[] args) {
        int[][] inputs = {{3, 5}};

        for (int[] input: inputs) {
            System.out.println("eggs: " + input[0] + "\tfloors: " + input[1]);
            System.out.print("\tRecursive: " + solve(input[0], input[1]));
        }
    }
}