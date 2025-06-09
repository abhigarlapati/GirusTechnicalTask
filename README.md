# Girus Technical Coding Task Submission

**Candidate:** Garlapati Chandra Karthikeya Abhi  
**Email:** 2100030159cseh@gmail.com  
**Submission Date:** June 9, 2025  
**Language:** Java  
**IDE Used:** Visual Studio Code  
**Execution:** All programs can be run using standard input/output via terminal.

---

## 📁 Folder Structure

```
GirusTechnicalTask/
│
├── Problem1_Sudoku/
│   └── SudokuValidator.java
│
├── Problem2_AlienDictionary/
│   └── AlienDictionary.java
│
├── Problem3_KnightsAndPortals/
│   └── KnightsAndPortals.java
│
├── Problem4_BitwiseMatching/
│   └── BitwiseMatchingPattern.java
│
├── Problem5_MatrixIslandsWithDiagonals/
│   └── MatrixIslandsWithDiagonals.java
│
└── README.md
```

---

## ✅ Problem 1: Sudoku Validator With Custom Zones

**Description:**  
Validates a 9x9 Sudoku board with the following checks:
- Each row, column, and 3x3 box contains digits 1–9 without repetition.
- Additionally, it validates *custom zones* (9 user-provided coordinates) to also contain digits 1–9 without duplicates.

**To Compile & Run:**
```bash
cd Problem1_Sudoku
javac SudokuValidator.java
java SudokuValidator
```

**Sample Input:**
```
Enter the Sudoku board (9x9) row-wise:
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
Enter number of custom zones: 1
Enter 9 coordinates for zone 1 (row and column pairs):
0 0
0 1
0 2
1 0
1 1
1 2
2 0
2 1
2 2
```

**Sample Output:**
```
Valid Sudoku board.
```

---

## ✅ Problem 2: Alien Dictionary

**Description:**  
Given a sorted list of words in an alien dictionary, determine the order of characters in the alien language.

**To Compile & Run:**
```bash
cd Problem2_AlienDictionary
javac AlienDictionary.java
java AlienDictionary
```

**Sample Input:**
```
Enter number of words:
4
Enter the words:
wrt
wrf
er
ett
```

**Sample Output:**
```
Character order: w -> e -> r -> t -> f
```

---

## ✅ Problem 3: Knights and Portals

**Description:**  
Find the shortest path in a grid from the top-left to bottom-right cell using:
- Normal up/down/left/right movement through empty cells (`0`)
- One-time teleportation from any one empty cell to any other empty cell

**To Compile & Run:**
```bash
cd Problem3_KnightsAndPortals
javac KnightsAndPortals.java
java KnightsAndPortals
```

**Sample Input:**
```
Enter number of rows: 3
Enter number of columns: 3
Enter grid (0 for empty, 1 for wall):
0 1 0
0 1 0
0 0 0
```

**Sample Output:**
```
Shortest path with teleport: 4
```

---

## ✅ Problem 4: Bitwise Matching Pattern

**Description:**  
Given a number `n`, find the next largest number that has the **same number of `1`s in binary**.

**To Compile & Run:**
```bash
cd Problem4_BitwiseMatching
javac BitwiseMatchingPattern.java
java BitwiseMatchingPattern
```

**Sample Input:**
```
Enter an integer:
78
```

**Sample Output:**
```
Next integer with same number of 1s: 83
```

---

## ✅ Problem 5: Matrix Islands with Diagonals

**Description:**  
Count the number of islands in a binary matrix (`0` and `1`). Cells are connected **horizontally, vertically, or diagonally**.

**To Compile & Run:**
```bash
cd Problem5_MatrixIslandsWithDiagonals
javac MatrixIslandsWithDiagonals.java
java MatrixIslandsWithDiagonals
```

**Sample Input:**
```
Enter number of rows: 4
Enter number of columns: 4
Enter matrix values (0 or 1):
1 1 0 0
0 1 0 0
0 0 1 1
0 0 0 1
```

**Sample Output:**
```
Number of islands: 1

