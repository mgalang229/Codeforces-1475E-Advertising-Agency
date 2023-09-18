# Codeforces-1475E-Advertising-Agency
Link: https://codeforces.com/problemset/problem/1475/E
## Analysis
```
combinatorics

----------------------

1
7 5
5 1 6 4 1 1 5

sorted:
1 1 1 4 5 5 6

k distinct bloggers = [6, 5, 4, 1]

freq[6] = 1
freq[5] = 2
freq[4] = 1
freq[1] = 3

6 5 5 4 1

freq[6] choose 1
freq[5] choose 2
freq[4] choose 1
freq[1] choose 1
multiply all the values above

highest = k largest numbers

= freq[highest[0]] * freq[highest[1]] * ... * freq[highest[k-1]]

ans: 3

----------------------

1
4 2
1 1 1 1

k bloggers = [1]

freq[1] = 4

if freq[a[i]] >= k, then (freq[a[i]] choose k)

ans: 6
```
