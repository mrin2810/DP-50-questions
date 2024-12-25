# [<](../Readme.md) 00 Matrix Chain Multiplication

## [Problem Statement](https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/)
Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum. When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed is m*n*p.

## Explain
![alt text](Capture.PNG)
![alt 1text](Capture1.PNG)
![alt 1text](Capture2.PNG)

## Identify
- We don't know what combination is correct!
- We have to try each combination and solve it recursively to reach to a solution...
- We need to follow steps explained in the format code...
- We have to return the cost

## Template Code
```java
int solve(int[] arr, int i, int j) {
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

## 1. Choice of `i` and `j`
- We have to choose i and j
- looking at how we calculate the dimensions
- i = 1, j = size - 1

## 2. Find base condition
- Let's check i == j:
- This gives list of size 1
- Can this be a matrix? No, so this is the invalid input becomes our base condition

## 3. find range of `k`
- We have to make sure 2 partitions that we have are going to have should be valid
- if K ranges from i to j: 2nd partition will be empty array
- if K ranges from i to j - 1: 2nd partition will be arr with 1 element

## Calculate the cost of resultant matrix
- How to get the cost of final last multiplication?
![alt 1text](Capture3.PNG)
- 40 ==> arr[i - 1]
- 30 ==> arr[k]
- 30 ==> arr[j]

## Code using Template
```java


```

## MCM Bottom Up
DP is nothing but, recursion with a cache.
### Why it is needed?
- We need DP when we have more than 2 recursive calls.
- That is because we will have overlapping subproblems
- Which can be cached/memoized.
- We can call function on n - 1
- We can reduce the work by saving it (in a table)
### How to build a table?
- First thing to figure out is dimensions or the table/matrix
- We have to look at the recursive code
  - Find where we have changes for the input?
  - choose the 2 changing variables.
  - that will become the size of the array
- We want to store values now in this:
  - initialize the matrix with -1. (Denoting not solved)
  - we will only do the work when the value in matrix is -1.
  - if not -1 => we have already solved the problem and we return that value
  - else calculate and store in the matrix and then return
### Changes
We can now look at the changes:
![img.png](img.png)
return if not -1
![img_1.png](img_1.png)
sovle the problem, store in table t[i][j] and then return.
```java
class MCM{
    public static int solveMemo(int[] arr, int i, int j, int[][] t) {
        // Base Condition j <= i (arr size 1 or less)
        if (t[i][j] == -1) {
            if (j <= i) t[i][j] = 0;
            int ans = Integer.MAX_VALUE;
            // Else, try all the possible values for `k`
            for (int k = i; k < j; k++) {
                // Temp 1 answer + Temp answer 2
                int temp = solve(arr, i, k, t) +
                        solve(arr, k + 1, j, t) + arr[i - 1] * arr[k] * arr[j];
                t[i][j] = Math.min(ans, temp);
            }
        }
        return t[i][j];
    }
}
```