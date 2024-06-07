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