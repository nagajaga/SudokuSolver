package grid;

public class Grid{
    private int[][] grid;

    public Grid(int size){
        this.grid = new int[size][size];
    }
    public String toString(){
        String output = "";
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                output+= (grid[i][j] + " ");
                if(j == 8) {
                    output+=("\n");
                }
            }
        }
        return output;
    }

}