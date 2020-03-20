package main;

import java.util.*;
import solver.Solver;
import grid.Grid;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solver solver = new Solver();
        Grid grid = new Grid(9);
        grid.set(3,3,7);
        System.out.print(grid);
    }
}
