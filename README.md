# Sudoku-Solver
This is a sudoku solver project I have been working on. I will try to keep modifying it and updating it so it is the most efficient and can solve the puzzles faster.

Here is how the solver functions: 

1. The main method is able to initialize the Sudoku puzzle and then proceeds to call the solve method to solve the puzzle.
2. The solve method first finds an empty cell in the puzzle. If all cells were to be filled, then that means the puzzle is solved and the solve method returns true.
3. If the cells are not all filled, the solve method will go step by step trying to fill an empty cell with a range of numbers from 1 to 9. If the number does not conflict with the surrounding numbers, then the method will recursively call itself to fill in and keep solving the now updated puzzle.
4. There will be a point in which this recursive call will return true which also means the method will return true which means the puzzle has been solved.
5. If the call was to return false, then that means the method is now going to backtrack and set the current cell it is working on to be 0 and try for another number. 
6. If all numbers of 1 to 9 have been tried and none lead to a solution, then the method will return false and therefore indicate the puzzle is unsolvable.
7. The printSolution then prints out the solved puzzle to the console.
