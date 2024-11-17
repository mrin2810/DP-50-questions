# [<](../Readme.md) 08 Sequence pattern Matching (is Subsequence)

## [Problem Statement](https://leetcode.com/problems/is-subsequence/description/)

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. 
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

```text
Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
```

## Is this LCS?

Question is talking about subsequence so, we will be thinking in LCS direction.

### How it is related to LCS?
It is pretty straight forward that to check if one string is subsequence of the other, we will use similar logic.
Here we have 2 strings, we only have to make sure first string is an entire subsequence. 
We can only skip letters from one string.
- Let's think to apply LCS code directly in Example 1
- If we do that, what is the answer that we get? 
  - First string ("abc")
  - So, after finding the LCS of the 2 string check if it is equal to the shorter string
    - if yes, return True
    - else return False

## Variation
- if the string is equal to one of the input strings, return True
- else return False
We can optimize this a little by ONLY checking the length and not the entire string...
- Because, if the length of the subsequence matches with the first string
- It has to have all the letters... LCS range is from 0 to length of the smaller string. 

## Completed Code
[Java Code](./src/SPMDP.java)