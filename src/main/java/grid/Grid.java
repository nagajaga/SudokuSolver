package grid;

public class Grid{
    private int[][] grid;

    public Grid(int[][] grid){
        this.grid = grid;
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

    public void set(int x, int y, int value){
        this.grid[x][y] = value;
    }

    public int get(int x, int y) {
        return this.grid[x][y];
    }

    public boolean onRivissa(int rivi, int arvo){
        //iteroidaan rivin läpi ja palautetaan true jos arvo on jo rivissä
        for(int i = 0; i < 9; i++) {
            if(grid[rivi][i] == arvo) {
                return true;
            }
        }
        return false;
    }

    public boolean onSarakkeessa(int sarake, int arvo) {
        //iteroidaan sarakkeen läpi ja palautetaan true jos arvo on jo sarakkeessa
        for(int i = 0; i < 9; i++) {
            if(grid[i][sarake] == arvo) {
                return true;
            }
        }
        return false;
    }

    public boolean onLaatikossa(int rivi, int sarake, int arvo) {
        //iteroidaan laatikon läpi ja palautetaan true jos arvo on jo laatikossa
        int laatikkoRivi = rivi - rivi % 3;
        int laatikkoSarake = sarake - sarake % 3;

        for(int i = laatikkoRivi; i < laatikkoRivi + 3; i++){
            for(int j = laatikkoSarake; j < laatikkoSarake + 3; j++){
                if(this.grid[i][j] == arvo) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onSallittu(int rivi, int sarake, int arvo) {
        //tarkistetaan onko arvo rivissä, sarakkeessa tai laatikossa, jos ei ole, niin arvo on sallittu
        if(!onRivissa(rivi, arvo) && !onSarakkeessa(sarake, arvo) && !onLaatikossa(rivi, sarake, arvo)) {
            return true;
        }
        return false;
    }

}