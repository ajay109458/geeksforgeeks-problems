 ## Dynamic Programming
  
Fibonacci series is defined as follow
```
 F(n) = F(n-1) + F(n-2) where n >= 2, F(0) = 0, F(1) = 1
```
 
Series - 0 1 1 2 3 5 8 .....

With above mentioned recursive solution, same subproblem is being 
solved multiple times we call it as overlapping subproblem


Complexity of algorithm - O(2^n)
In order to improve complexity we can store the result of the overlapping sub-problems.

There are two ways to store the result in memory
1. Memoization (Top-down)
2. Tabulation (Bottom-up)
 
#### Memoization 
- Any look up is first performed on the store and if not present in the store then retrieved.
 
#### Tabulation
- First complete table is filled then all look ups are being performed. 
 
#### What is Dynamic programming 
- DP is a algorithmic paradigm that solves a complex problem by breaking it into sub problems 
	and store the result of overlapping sub problems to avoid same computation again.
 
#### DP vs Divide & Conquer
- Similarities - In both algorithm paradigm we break a complex problem into sub problems.

- Differences - DP is applicable if there is overlapping sub problems.
	
#### Memoization Algorithm
- Check if table[i] is null
- If table[i] is not null, return table[i]
- if table[i] is null
	- If i satisfy base condition
		- populate base value in the table. 
	- If i doesn't satisfy the base condition 
		- recursively call the sub problem, compute the result and populte table[i]
		
#### Tabulation - Bottom up
- Initialize base condition in the table. 
- Loop over the remaining values and populate the value based on the previous value.
- return table[n]