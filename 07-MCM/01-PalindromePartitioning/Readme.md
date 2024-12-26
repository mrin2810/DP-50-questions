# [<](../Readme.md) 01 Palindrome Partitioning

## [Problem Statement](https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/)
Given a string s, the task is to find the minimum number of cuts needed for palindrome partitioning of the given string. A partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome.

### Examples
```text
Input: s = “geek” 
Output: 2 
Explanation: We need to make minimum 2 cuts, i.e., “g | ee | k”.

Input: s= “aaaa” 
Output: 0 
Explanation: The string is already a palindrome.

Input: s = “ababbbabbababa” 
Output: 3
Explanation: We need to make minimum 3 cuts, i.e., “aba | bb | babbab | aba”.
```

### Follow Format Rule for MCM?
- How many partitions do we need to have in the string "nitin" such that each partitioned string is a palindrome itself.
![img.png](img.png)
- We have to minimize that number and give that as an answer.

#### Identify MCM 
- Min # of partitions
- We take left pointer and right pointer and see where we can put the partitions?
![img_1.png](img_1.png)
- Can we see how this relates to MCM?
  - Yes

#### Format - Rules
- We can convert the general format to specific format for any question by following 4 steps
  - Step 1: Find value of `i` and `j`
    - instead of array we are sending a string
    - for this problem
      - `i = 0` is safe
      - `j = len(str) - 1` is safe
  - Step 2: Find Base Condition
    - ```if (i > j) return 0```
    - for this problem
      - if the size of the string is 0 or 1 return 0
      - if the string itself is a palindrome return 0
      - `if (i >= j || isPalindrome(subStr)) return 0`
  - Step 3: k loop values
    - Depends on what is valid
    - for this problem
      - we can partition between i to j - 1 (because we will use `k+1`)
      - k : from k = i to j - 1.
        - partition schemen (i to k) and (k+1 to j)
  - Step 4: How to get to answer?
    - get minimum of the temp answer we will be calculating.
    - for this problem
      - We need minimum, so we will, calculate temp answer like this
        - ```java
          int ans = Integer.MAX_VALUE;
          for(int k = 0; k < j; k++){
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1; // 1 is to calculate
            ans = min(ans, temp);
          }
          return ans;
          ```


### Code
```java
class Solution {
    public static int solve(String s, int i, int j) {
      if (i >= j) return 0;
      if (isPalindrome(s, i, j)) return 0;
      int ans = Integer.MAX_VALUE;
      for (int k = i; k < j; k++) {
          int temp = solve(s, i, k) + solve(s, k+1, j) + 1;
          ans = min(ans, temp);
      }
      return ans;
    }
}
```