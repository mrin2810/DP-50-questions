# 0-1 knapsack

### 6 Related Problems

1. Subset Sum
2. Equal Sum Partition
3. Count of Subset Sum
4. Minimum Subset Sum Difference
5. Target Sum
6. Number of subsets with given difference

### What is Knapsack Problem?
We are given some number of items, each associated with a certain weight and a value. We are also given a bag(knapsack) with certain capacity(W).

In this setup, constrain is the capacity(W). We can only have items that are less than or equal to W. But at the same time we have to choose items which maximize the total value.

There are 3 types of knapsack problems:
1. Fractional Knapsack (Greedy) 
    - We are allowed to add a "fraction" of an item with fraction of the value will be counted as well.
    - This is a Greedy Problem NOT DP.
2. 0-1 Knapsack
    - We are only allowed to either add an entire item or we can not add the item at all.
    - No concept of fraction of an Item.
3. Unbounded Knapsack
    - Similar to 0-1 Knapsack, but we can assume, we have unlimited supply of all the items.
    - We can add multiple occurances of the same item.

### Problem Statement
Given a set of n items numbered(i) from 1 up to n, each with a weight w[i] and a value v[i], along with a maximum weight capacity W, maximize the sum of the values of the items in the knapsack so that the sum of the weights is less than or equal to the knapsack's capacity.

### Identify

Optimal? -> Maximize values
Choice? -> Either selecting an item or NOT selecting an item

### Approach

Start with Recursive solution, then memoize it and then you can choose to apply top down approach.

### Recursice Code:
Input: Weight Array(w), Value Array(v), Capacity/Weight of Knapsack(W).

Output: Maximum Profit(Value)

We can say this is recursive solution, because we have a choice. And we can create a choice diagram.
Before writing recursive code, it is important to draw choice diagram.
![choice diagram](choiceDiagram.png)
For each item(i):
- if w[i] =< W:
    - we have choice of including the item or not.
- else:
    - we have no choice, we cannot include the item.

#### Function Signature: 

```java
public int knapsack(int wt[], int val[], int W, int n);
```
In this function, we can have some skeleton code.
1. Base Case:  
    - Think of the smallest valid input.
    - n can be 0 and W can be 0.
    - So, this becomes our base case.
    - If we have no items -> profit = 0
    - Similarly, if we have no W -> profit = 0
2. Choice Diagram: 
    - Code the choice diagram (Easiest)
    - Simply convert the choice diagram that we drew in code.
    - Recursive call must always be on a smaller input.
    - In our case, we have to change n -> n-1

```java
public static int knapsack(int[] wt, int[] val, int W, int n) {
   // Base Case
   if (n == 0 || W == 0) return 0;
   //Choice Diagram
   int exclude = knapsack(wt, val, W, n - 1);
   if (wt[n-1] <= W) {
      // We have a choice
      int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
      return Math.max(include, exclude);
   } else {
      // We don't have a choice
      return exclude;
   }
}
```
### Memoize the recursive code

Memoization: To avoid making overlapping recursive calls. Or we can say, we are keeping track of solved sub-problems.

To convert recursive code to memoized code, we only have add 2 lines.
We can then move to top-down approach or not because memoized code is of similar power.

To memoize the code above, we have to have data structure that can store the memoized values.

Let's say we are deciding to create a matrix. 
#### How do we choose the dimensions of the matrix?
Look at the inputs, the input which changes its size, grows smaller, it will define your matrix.
So, in the above case, we know `W` and `n` are getting smaller in recursive calls.
Therefore, we will need 2D matrix, and the dimensions will be `[n + 1][W + 1]`.
We want to set the entire matrix to `-1`.

Then, before making a recursive call, we will check the matrix, to see if the value is already calculated?
if yes, we return the value, else, we calculate the value and store in the matrix.

### How to memoize?
Changes we need to make:
1. Make a static matrix. and match the size to n, W constraints.
2. initialize it to -1.

```java
static int[][] t = new int[102][1002];
public static void main(String args[]) {
    for (int i = 0; i < 102; i++) {
        for (int j = 0; j < 1002; j++) {
            t[i][j] = -1;
        }
    }
}

public static int knapsack(int[] wt, int[] val, int W, int n) {
   // Base Case
   if (n == 0 || W == 0) return 0;
   // Memoize
   if (t[n][W] != -1) return t[n][W];
   //Choice Diagram
   int exclude = knapsack(wt, val, W, n - 1);
   if (wt[n-1] <= W) {
      // We have a choice
      int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
      int answer = Math.max(include, exclude);
      // Save the result before returning
      t[n][W] = answer;
      return answer;
   } else {
      // Save the result before returning
      t[n][W] = exclude;
      return exclude;
   }
}
```

There is not much of a change in memoization. But we can move to Top Down now.

### Top-down Approach
This is usually called "Real" Dynamic Programming. We will use old concepts to write top-down approach.
Until now, we wrote recursive code, and converted it to memoized code. 
Now we are all set to move this code to Top-down Approach.

#### What does that mean? 
We want to avoid making recursive call entirely. 
(This is used when the number of recursive calls can cause stack overflow problem. This is a rare case.)
![topDown.png](topDown.png)

#### Process
We can come to top-down, from recursive code as well. 
1. RC 
2. RC + Table
3. Table

We need to make a table with dimensions `[n + 1][W  + 1]` the thinking should be similar to what we did for memoization.
We will fill this table in 2 steps.
1. Initialize
2. Recursive Calls --> Iterative Form

Dimension should be `n + 1 X W + 1` Because we want one row and column for base case or initialization.

In our Example:
```java
int[] wt = new int[]{1, 3, 4, 5};
int[] val = new int[]{1, 4, 5, 7};
int n = 4;
int W = 7;
```
In our table the value at `dp[i][j]` will denote what the o/p of function call with n = i and W = j.

![what this table stores](explain.png)

The recursive function's base condition converts to top-down's initialization.
So, our n == 0 and W == 0 => return 0; changes to the first row to be 0s. and first column to be 1s.

Recursive Function has to be the perfect! for everything else to work.
![img.png](img.png)

Now We will go to 