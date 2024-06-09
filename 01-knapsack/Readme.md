# 0-1 knapsack

### 6 Related Problems

0. [0/1 Knapsack](00-knapsack/Readme.md)
1. [Subset Sum](01-subsetSum/Readme.md)
2. [Equal Sum Partition](02-equalSumPartition/Readme.md)
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


