package main;

import java.util.*;
import solver.Solver;
import grid.Grid;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Choose difficulty: (easy, medium, hard) (x to exit)");
            String difficulty = reader.nextLine();
            System.out.println();
            if (difficulty.equals("x")) {
                break;
            }
            if (difficulty.equals("easy")) {
                System.out.println("Easy sudoku");
                System.out.println();
                int[][] easy = easyGrid();
                solvePrint(easy);
                System.out.println();
                compareSolvers(easy);
            } else if (difficulty.equals("medium")) {
                System.out.println("Medium sudoku");
                System.out.println();
                int[][] medium = mediumGrid();
                solvePrint(medium);
                System.out.println();
                compareSolvers(medium);
            } else if (difficulty.equals("hard")) {
                System.out.println("Hard sudoku");
                System.out.println();
                int[][] hard = hardGrid();
                solvePrint(hard);
                System.out.println();
                compareSolvers(hard);
            } else {
                System.out.println("Invalid option, try again.");
            }
        }

    }

    public static void compareSolvers(int[][] difficulty) {
        System.out.println("Average solve time from 1000 solves using logical solver: "
                + testN(1000, "logical", difficulty) + " milliseconds");
        System.out.println("Average solve time from 1000 solves using recursive backtracking solver: "
                + testN(1000, "recursive", difficulty) + " milliseconds");

    }

    public static Long logicalSolveTime(int[][] difficulty) {
        int[][] given = difficulty;
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = given[i][j];
            }
        }
        Grid grid = new Grid(copy);
        Solver solver = new Solver(grid);
        Long start = System.currentTimeMillis();
        solver.solveLogically();
        Long done = System.currentTimeMillis() - start;
        return done;
    }

    public static Long recursiveSolveTime(int[][] difficulty) {
        int[][] given = difficulty;
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = given[i][j];
            }
        }
        Grid grid = new Grid(copy);
        Solver solver = new Solver(grid);
        Long start = System.currentTimeMillis();
        solver.solveRecursively();
        Long done = System.currentTimeMillis() - start;
        return done;
    }

    public static Double testN(int n, String solverType, int[][] difficulty) {
        if (solverType.equals("logical")) {
            Long logicalTime = 0L;
            for (int i = 0; i < n; i++) {
                logicalTime += logicalSolveTime(difficulty);
            }
            Double averageLogical = logicalTime.doubleValue() / n;
            return averageLogical;
        } else {
            Long recursiveTime = 0L;
            for (int i = 0; i < n; i++) {
                recursiveTime += recursiveSolveTime(difficulty);
            }
            Double averageRecursive = recursiveTime.doubleValue() / n;
            return averageRecursive;
        }

    }

    public static void solvePrint(int[][] difficulty) {
        int[][] given = difficulty;
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = given[i][j];
            }
        }
        Grid grid = new Grid(copy);
        Solver solver = new Solver(grid);
        System.out.println("Sudoku to solve");
        System.out.println();
        grid.tulosta();
        System.out.println();
        solver.solveLogically();
        System.out.println("Solved sudoku");
        System.out.println();
        grid.tulosta();
    }

    public static int[][] easyGrid() {
        int[][] easy = { { 0, 3, 1, 0, 0, 0, 0, 0, 6 }, { 0, 4, 9, 2, 0, 0, 0, 3, 8 }, { 0, 2, 0, 0, 1, 0, 0, 4, 5 },
                { 7, 5, 0, 0, 0, 6, 0, 0, 0 }, { 2, 0, 8, 0, 0, 5, 6, 0, 0 }, { 0, 9, 6, 0, 3, 2, 7, 5, 0 },
                { 0, 6, 2, 0, 7, 0, 0, 0, 4 }, { 0, 0, 5, 0, 0, 9, 3, 0, 7 }, { 0, 7, 0, 5, 6, 1, 0, 2, 0 } };
        return easy;
    }

    public static int[][] mediumGrid() {
        int[][] medium = { { 4, 0, 0, 0, 0, 3, 1, 5, 0 }, { 0, 0, 0, 4, 0, 0, 0, 0, 0 }, { 5, 0, 0, 9, 2, 0, 0, 0, 7 },
                { 0, 0, 4, 6, 0, 0, 0, 0, 3 }, { 2, 5, 7, 0, 0, 1, 0, 0, 0 }, { 0, 0, 3, 0, 0, 0, 0, 0, 2 },
                { 0, 0, 2, 0, 0, 7, 0, 6, 9 }, { 7, 0, 0, 0, 0, 6, 2, 0, 1 }, { 1, 9, 0, 0, 0, 0, 0, 3, 5 } };
        return medium;
    }

    public static int[][] hardGrid() {
        int[][] hard = { { 0, 0, 1, 0, 4, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 8, 7, 0, 0, 6, 2, 0, 0 },
                { 0, 1, 0, 7, 0, 0, 0, 0, 2 }, { 0, 5, 0, 8, 0, 2, 0, 3, 0 }, { 8, 0, 0, 0, 0, 4, 0, 9, 0 },
                { 0, 0, 2, 3, 0, 0, 1, 8, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 8, 0, 2, 0, 7, 0, 0 }, };
        return hard;
    }

}
