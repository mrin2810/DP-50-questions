# [<](../Readme.md) Matrix Chain Multiplication

## Identification of Format
- Input is a string or array
- We will have to take a slice of the string(i to j), and then move a partition (k) from i to j.
- Solve both the partitions to get temp answers, then calculate the final answer using temp ans.
- Revisit after learning about MCM

## Base Condition: Smallest valid or Invalid Input
- Here we will think about invalid input.
- i > j (meaning arr is now empty).

## Calculate the temp answer
- `k` will range from `i` to `j`.
- and calculate the temp answer.

## Related Problems (7)
- [00 MCM](./00-MCM/Readme.md)
- [02 Evaluate Expression to True/Boolean Parenthesis](./02-EvaluateExpToTrue/Readme.md)
- [04 Palindrome Partitioning](./04-PalindromwPartitioning/Readme.md)
- [05 Scramble String](./05-ScrambleString/Readme.md)
- [06 Egg Dropping Problem](./06-EggDropping/Readme.md)