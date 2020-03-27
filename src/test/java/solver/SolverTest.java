package solver;

import static org.junit.Assert.*;
import org.junit.Test;
import grid.Grid;

public class SolverTest {

    @Test
    public void solvingWorks() {
        int[][] grid1 = {
            {0,0,1,0,4,0,6,0,0},
			{0,0,0,0,0,1,0,0,0},
			{0,8,7,0,0,6,2,0,0},
			{0,1,0,7,0,0,0,0,2},
			{0,5,0,8,0,2,0,3,0},
			{8,0,0,0,0,4,0,9,0},
			{0,0,2,3,0,0,1,8,0},
			{0,0,0,1,0,0,0,0,0},
			{0,0,8,0,2,0,7,0,0},
        };
        Grid grid = new Grid(grid1);
        Solver solver = new Solver(grid);
        assertTrue(solver.solveRecursively());

        
    }
}