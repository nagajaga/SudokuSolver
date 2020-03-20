package grid;

import static org.junit.Assert.*;
import org.junit.Test;

public class GridTest{
    @Test
    public void gridWorks() {
        Grid grid = new Grid(9);
        assertEquals("0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n", grid.toString());
    }

    @Test
    public void setAndGet() {
        Grid grid = new Grid(9);
        grid.set(3,3,7);
        assertEquals(7, grid.get(3,3));
    }

}