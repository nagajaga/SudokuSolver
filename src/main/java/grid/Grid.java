package grid;

/**
 * A class with methods that determine the state of the sudoku.
 */
public class Grid {
    private int[][] grid;

    public Grid(int[][] grid) {
        this.grid = grid;
    }

    /**
     * Prints the sudoku.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                output += (grid[i][j] + " ");
                if (j == 8) {
                    output += ("\n");
                }
            }
        }
        return output;
    }
    /**
     * Prints the sudoku.
     */
    public void tulosta(){
        String output = " ______________________\n";
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9 ; j++) {
                if (i == 3 && j == 0|| i == 6 && j == 0) {
                    output+= "|----------------------|\n";
                }
                if(j == 0) {
                    output += "|";
                }
                
                output +=  (grid[i][j] + " ");
                if (j % 3 == 2) {
                    output += "| ";
                }
                if (j == 8) {
                    output += ("\n");
                    
                }
            }
        }
        output += "|______________________|\n";
        System.out.print(output);
    }

    public void set(int x, int y, int value) {
        this.grid[x][y] = value;
    }

    public int get(int x, int y) {
        return this.grid[x][y];
    }

    /**
     * Checks if value is in row.
     * @param rivi Row.
     * @param arvo Value.
     * @return Returns true if value is in row.
     */
    public boolean onRivissa(int rivi, int arvo) {
        // iteroidaan rivin läpi ja palautetaan true jos arvo on jo rivissä
        for (int i = 0; i < 9; i++) {
            if (grid[rivi][i] == arvo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if value is in column.
     * @param sarake Column.
     * @param arvo Value.
     * @return Returns true if value is in column.
     */
    public boolean onSarakkeessa(int sarake, int arvo) {
        // iteroidaan sarakkeen läpi ja palautetaan true jos arvo on jo sarakkeessa
        for (int i = 0; i < 9; i++) {
            if (grid[i][sarake] == arvo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if value is in box.
     * @param rivi Row.
     * @param sarake Column.
     * @param arvo Value.
     * @return Returns true if value is in box.
     */
    public boolean onLaatikossa(int rivi, int sarake, int arvo) {
        // iteroidaan laatikon läpi ja palautetaan true jos arvo on jo laatikossa
        int laatikkoRivi = rivi - rivi % 3;
        int laatikkoSarake = sarake - sarake % 3;

        for (int i = laatikkoRivi; i < laatikkoRivi + 3; i++) {
            for (int j = laatikkoSarake; j < laatikkoSarake + 3; j++) {
                if (this.grid[i][j] == arvo) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a value is in the row, column or box.
     * @param rivi Row.
     * @param sarake Column.
     * @param arvo Value.
     * @return Returns true if value is not in row, column or box.
     */
    public boolean onSallittu(int rivi, int sarake, int arvo) {
        if (!onRivissa(rivi, arvo) && !onSarakkeessa(sarake, arvo) && !onLaatikossa(rivi, sarake, arvo)) {
            return true;
        }
        return false;
    }

    

    // palautetaan rivi pyöristettynä
    public int getRivi(int rivi) {
        if (rivi < 3) {
            return 0;
        } else if (rivi < 6) {
            return 3;
        } else {
            return 6;
        }
    }

    // palautetaan sarake pyöristettynä
    public int getSarake(int sarake) {
        if (sarake < 3) {
            return 0;
        } else if (sarake < 6) {
            return 3;
        } else {
            return 6;
        }
    }
    /**
     * Keeps track of possible candidates for a cell.
     * @param rivi Row.
     * @param sarake Column.
     * @return Returns a box.
     */
    public boolean[] mahdolliset(int rivi, int sarake) {
        boolean[] laatikko = new boolean[10];
        if (this.grid[rivi][sarake] != 0) {
            for (int i = 0; i < laatikko.length; i++) {
                laatikko[i] = false;
            }
            return laatikko;
        }
        for (int i = 0; i < laatikko.length; i++) {
            laatikko[i] = true;
        }
        for (int i = getRivi(rivi); i < getRivi(rivi) + 3; i++) {
            for (int j = getSarake(sarake); j < getSarake(sarake) + 3; j++) {
                if (this.grid[i][j] != 0) {
                    int koe = this.grid[i][j];
                    laatikko[koe] = false;
                }
            }
        }
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i][sarake] != 0) {
                int koe = this.grid[i][sarake];
                laatikko[koe] = false;
            }
        }
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[rivi][i] != 0) {
                int koe = this.grid[rivi][i];
                laatikko[koe] = false;
            }
        }
        laatikko[0] = false;
        return laatikko;
    }


    /**
     * A method that checks if solved.
     * @return Returns true if solved.
     */
    public boolean ratkaistu() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.grid[i][j] == 0) {
                    return false;
                } 
            }
        }
        return true;

    }
    /**
     * Tries to solve the sudoku by using the methods yhdenMahdolliset and ainoatMahdolliset.
     */
    public void solve() {
        while (!ratkaistu() && (yhdenMahdolliset() || ainoatMahdolliset())) {
        }
    }
    /**
     * Finds cells where there is only 1 possible option.
     * @return Returns true or false.
     */
    public boolean yhdenMahdolliset() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean[] tarkista = mahdolliset(i, j);
                int laskin = 0;
                for (int x = 0; x < tarkista.length; x++) {
                    if (tarkista[x] == true) {
                        laskin++;
                    }
                }
                if (laskin == 1) {
                    for (int y = 0; y < tarkista.length; y++) {
                        if (tarkista[y] == true) {
                            this.grid[i][j] = y;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * Checks for the only possible values to a row, column or box.
     * @return Returns true or false.
     */
    public boolean ainoatMahdolliset() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                boolean[] vertaa = mahdolliset(i, j);
                if (tarkistaLaatikko(vertaa, i, j)) {
                    return true;
                } else if (tarkistaSarake(vertaa, i, j)) {
                    return true;
                } else if (tarkistaRivi(vertaa, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Calculates the only possible values for a cell.
     * @param kopio A copy of the table.
     * @param i X coordinate.
     * @param j Y coordinate
     * @return Returns true or false.
     */
    public boolean laskeAinoatMahdolliset(boolean[] kopio, int i, int j) {
        int laskin = 0;
        int koe = 0;
        for (int x = 0; x < kopio.length; x++) {
            if (kopio[x] == true) {
                laskin++;
                koe = x;
            }
        }
        if (laskin == 1) {
            this.grid[i][j] = koe;
            return true;
        }
        return false;
    }

    /**
     * A method that checks a row and compares values.
     * @param vertaa Boolean array for comparing.
     * @param i X coordinate.
     * @param j Y coordinate.
     * @return Returns true or false.
     */
    public boolean tarkistaRivi(boolean[] vertaa, int i, int j) {
        boolean[] kopio = new boolean[10];
        boolean[] verrattava;
        for (int x = 0; x < kopio.length; x++) {
            kopio[x] = vertaa[x];
        }
        for (int x = 0; x < this.grid.length; x++) {
            verrattava = mahdolliset(i, x);
            if (x != j) {
                for (int z = 0; z < verrattava.length; z++) {
                    if (kopio[z] == true) {
                        if (verrattava[z] == true && vertaa[z] == true) {
                            kopio[z] = false;
                        }
                        if (verrattava[z] == false && vertaa[z] == false) {
                            kopio[z] = false;
                        }
                        if (verrattava[z] == false && vertaa[z] == true) {
                            kopio[z] = true;
                        }
                        if (verrattava[z] == true && vertaa[z] == false) {
                            kopio[z] = false;
                        }
                    }
                }
            }
        }
        return laskeAinoatMahdolliset(kopio, i, j);
    }

    /**
     * A method that checks a column and compares values.
     * @param vertaa Boolean array for comparing.
     * @param i X coordinate.
     * @param j Y coordinate.
     * @return Returns true or false.
     */
    public boolean tarkistaSarake(boolean[] vertaa, int i, int j) {
        boolean[] kopio = new boolean[10];
        boolean[] verrattava;
        for (int x = 0; x < kopio.length; x++) {
            kopio[x] = vertaa[x];
        }
        for (int x = 0; x < this.grid.length; x++) {
            verrattava = mahdolliset(x, j);
            if (x != i) {
                for (int z = 0; z < verrattava.length; z++) {
                    if (kopio[z] == true) {
                        if (verrattava[z] == true && vertaa[z] == true) {
                            kopio[z] = false;
                        }
                        if (verrattava[z] == false && vertaa[z] == false) {
                            kopio[z] = false;
                        }
                        if (verrattava[z] == false && vertaa[z] == true) {
                            kopio[z] = true;
                        }
                        if (verrattava[z] == true && vertaa[z] == false) {
                            kopio[z] = false;
                        }
                    }
                }
            }
        }
        return laskeAinoatMahdolliset(kopio, i, j);
    }

    /**
     * A method that checks a box and compares values.
     * @param vertaa Boolean array for comparing.
     * @param i X coordinate.
     * @param j Y coordinate.
     * @return Returns true or false.
     */
    public boolean tarkistaLaatikko(boolean[] vertaa, int i, int j) {
        if (this.grid[i][j] != 0) {
            return false;
        }
        int laskin = 0;
        boolean[] koe;
        boolean[] kopio = vertaa;
        for (int x = getRivi(i); x < getRivi(i) + 3; x++) {
            for (int y = getSarake(j); y < getSarake(j) + 3; y++) {
                koe = mahdolliset(i, j);
                for (int z = 0; z < koe.length; z++) {
                    if (koe[z] == false && vertaa[z] == true) {
                        laskin++;
                    }
                    if (koe[z] == false && vertaa[z] == false) {
                        if (koe[z] == true && vertaa[z] == true) {
                            kopio[z] = false;
                        }
                    }
                }
                if (laskin == 1) {
                    for (int u = 0; u < kopio.length; u++) {
                        if (kopio[u] == true) {
                            this.grid[i][j] = u;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}