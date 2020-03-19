package solver;

import static org.junit.Assert.*;
import org.junit.Test;

public class SolverTest {

    @Test
    public void solvingWorks() {
        Solver solver = new Solver();
        assertEquals(4, solver.solve(2));
        
    }
}