package grid;

import static org.junit.Assert.*;
import org.junit.Test;

public class GridTest{
    @Test
    public void gridWorks() {
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
        assertEquals("0 0 1 0 4 0 6 0 0 \n0 0 0 0 0 1 0 0 0 \n0 8 7 0 0 6 2 0 0 \n0 1 0 7 0 0 0 0 2 \n0 5 0 8 0 2 0 3 0 \n8 0 0 0 0 4 0 9 0 \n0 0 2 3 0 0 1 8 0 \n0 0 0 1 0 0 0 0 0 \n0 0 8 0 2 0 7 0 0 \n", grid.toString());
    }

    @Test
    public void setAndGet() {
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
        grid.set(3,4,9);
        assertEquals(9, grid.get(3,4));
    }
    
    @Test
    public void onRivissaToimii(){
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
        assertTrue(grid.onRivissa(2, 8));
        assertFalse(grid.onRivissa(3, 8));

    }

    @Test
    public void onSarakkeessaToimii(){
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
        assertTrue(grid.onSarakkeessa(1, 8));
        assertFalse(grid.onSarakkeessa(8, 8));

    }

    @Test
    public void onLaatikossaToimii(){
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
        assertTrue(grid.onLaatikossa(1, 1, 8));
        assertFalse(grid.onLaatikossa(7, 4, 8));

    }

    @Test
    public void onSallittuToimii(){
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
        assertTrue(grid.onSallittu(1, 1, 4));
        assertFalse(grid.onSallittu(1, 1, 8));
        assertFalse(grid.onSallittu(1, 1, 7));
        assertFalse(grid.onSallittu(1, 1, 1));
    }

    @Test
    public void tulostusToimii(){
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
        grid.tulosta();
        grid.solve();
        assertTrue(grid.ratkaistu());
    }

}