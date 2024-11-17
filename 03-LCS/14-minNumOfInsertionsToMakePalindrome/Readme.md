# [<](../Readme.md) 14 Minimum Number of insertions to make it a palindrome

## [Problem Statement](https://www.geeksforgeeks.org/problems/form-a-palindrome2544/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card)
Given a string s, the task is to find the minimum number of characters to be inserted to 
convert it to a palindrome.

Note: A palindrome is a string that reads the same backward as forward for example, 
strings "aba", "abccba" are palindromes

```text
Input: s = "abcd"
Output: 3
Explanation: Here we can append 3 characters in the beginning and the resultant string will be a palindrome "dcbabcd".

Input: s = "aba"
Output: 0
Explanation: Given string is already a pallindrome hence no insertions are required.
```

## Is this LCS?
- We are talking about adding something to a string to make it a palindrome, 
- Even though we are not talking about LCS directly, but this could be related to min # deletions to make palindrome
- Recall, [min # deletions to make palindrome](../13-minNumOfDeletionToMakePalindrome/Readme.md)

### How it is related to LCS ([min # deletions to make palindrome](../13-minNumOfDeletionToMakePalindrome/Readme.md))?
- When we do minimum number of deletions and go to a palindromic subsequence. 
- This subsequence is nothing but "Largest Palindromic Subsequence"
- Now, instead of deleting the extra characters which do not have a pair
- We can add those characters on the other side and get another palindrome
- So, we still have the same answer, for any string number of deletion and 
  number of insertions will be the same to make it a palindrome.


## Variation
- Recall, We have done a similar question in finding the min number of deletions to make a palindrome 
- Even though there is a difference in how we are going to the palindrome logic
- There is NO variation in the code. (#of deletions and #of insertions will be the same)

### Code Variation
```java
// No Variation
```

## Completed Code
```java
public class MinNoOfInsertionToMakePalindrome {
  public static int minNoOfInsertionToMakePalindrome(String s) {
    int n = s.length();
    // Build Second String (Reverse)
    String s2 = "";
    for (Character c : s.toCharArray()) {
      s2 = c + s2;
    }

    // Initialize for LCS
    int dp[][] = new int[n+1][n+1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = -1;
        }
      }
    }

    // Logic
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return n - dp[n][n];
  }

  public static void main(String[] args) {
    String s1 ="mrinmayee";
    System.out.println(minNoOfInsertionToMakePalindrome(s1));
  }
}

```
