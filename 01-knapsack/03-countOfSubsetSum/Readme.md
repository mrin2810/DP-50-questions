# [<](../Readme.md) 03 - Count of Subset Sum

## Problem Statement
Given an array arr of non-negative integers and an integer sum, the task is to count all 
subsets of the given array with a sum equal to a given sum.

Example 1
```
Input: 
N = 6
arr = [5, 2, 3, 10, 6, 8]
sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
```

Example 2
```
Input: 
N = 5
arr = [2, 5, 1, 4, 3]
sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
```

## Similarity to subset sum
Subset sum was just checking if there exists one subset that totals to the given sum. 
But here, we want to count the number of subsets. Which means, we need to count all the number of subsets.

Here we need to change the data type from boolean to int, which will store number of subsets. if the value is 0.
It means that there is no subset which is present.

This also means, no matter what, we have to iterate through the entire tree. (  we cant do an early return ).

## Code Variation
### Initialization
- for n == 0 we set false (0)
- for sum == 0 we set true (1) 

`t[n + 1][sum + 1]` will be the matrix for our code.

- For initializing, false should be set to 0 and true should be set to 1.
- Because we are only considering 1 array []
- Because we are returning the count of subsets.

### Code
Previously
```java
if (arr[i - 1] <= j) {
        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]
} else {
        dp[i][j] = dp[i - 1][j]
}
```

We want to change this || to some other operation (add) -> Because we will add the number of subsets that are possible.

```java
class Solution {
    public static int perfectSum(int arr[],int n, int sum)
    {
        // Initialize DP
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) dp[i][j] = 0;
                if (i == 0) dp[i][j] = 1;
            }
        }
        
        // Start filing the matrix
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
}
```

## Return type
Here we need to change the data type from boolean to int, which will store number of subsets. if the value is 0.
It means that there is no subset which is present.
