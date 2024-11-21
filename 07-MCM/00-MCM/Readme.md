# [<](../Readme.md) 00 Matrix Chain Multiplication

## [Problem Statement](https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/)
Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum. When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed is m*n*p.

## Explain
![alt text](Capture.PNG)

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

## Code using Template
```java

```