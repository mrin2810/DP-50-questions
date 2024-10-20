# [<](../Readme.md) 13 Minimum Number of deletions to make it a palindrome

## [Problem Statement](https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that 
the resultant string is a palindrome.

_Note: The order of characters should be maintained._

```text
Example 1: agbcba
o/p: 1

Explanation: If we remove "g" from the string "abcba" will be the resulting string (Palindrome)
```

## Is this LCS?
- We are talking about subsequence, when we talk about deletions.
- So, this most definitely is LCS.

### How it is related to LCS ([LPS](../10-largestPalindromicSubsequence/Readme.md))?
- When we do minimum number of deletions and go to a palindromic subsequence. 
- This subsequence is nothing but "Largest Palindromic Subsequence"
- Deletions and the length of the palindrome are inversely related correct?
- So, if we are doing minimum deletions, that means the length of the palindrome is largest possible.


## Variation
- Recall, We have done a similar question in finding the largest palindromic subsequence.
- We can find the answer for that question, subtract it from the length of the string and
  get answer for number of deletions.

### Code Variation
```java

class Solution {
    static int minimumNumOfDeletions(String str) {
        int lengthOfLPS = lps(str); // lps code will be the same
        return str.length() - lengthOfLPS;
    }
}
```

## Completed Code
```java
public class MinNoOfDeletionToMakePalindrome {
  public static int minNoOfDeletionToMakePalindrome(String s) {
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
    System.out.println(minNoOfDeletionToMakePalindrome(s1));
  }
}

```
