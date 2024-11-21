# [<](../Readme.md) 00 Matrix Chain Multiplication

## Problem Statement

## Identification of Format
- Input is a string or array
- We will have to take a slice of the string(i to j), and then move a partition (k) from i to j.
- Solve both the partitions to get temp answers, then calculate the final answer using temp ans.
- Revisit after learning about MCM

## Base Condition: Smallest valid or Invalid Input
- Here we will think about invalid input.
- i > j (meaning arr is now empty).

## Calculate the temp answer
- `k` will range from `i` to `j`.
- and calculate the temp answer.

## Template Code
```java
int solve(int arr[], int i, int j) {
    // Base Condition
    if (j < i) {
        return 0;
    }
    int ans = 0;
    for (int k = i; k < j; k++) {
        int temp = solve(arr, i, k) + sovle(arr, k+1, j); // The function will depend on question
        ans = max(ans, temp); // depends on the question
    }
    
    return ans;
}
```