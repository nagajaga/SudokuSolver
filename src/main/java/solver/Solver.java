package solver;

import grid.Grid;
/**
 * A class that implements solving algorithms.
 */
public class Solver {
    private Grid grid;
    
    public Solver(Grid grid) {
        this.grid = grid;
    }
    /**
     * A method that uses recursive backtracking to solve a sudoku.
     * @return Returns a boolean value true when solved.
     */
    public boolean solveRecursively(){
        for(int rivi = 0; rivi < 9; rivi++) {
            for(int sarake = 0; sarake < 9; sarake++){
                //iteroidaan solujen läpi
                if(this.grid.get(rivi, sarake) == 0) {
                    for(int arvo = 0; arvo <= 9; arvo++) {
                        if(this.grid.onSallittu(rivi, sarake, arvo)){
                            //jos solun arvo on 0 ja arvoa ei löydy rivistä, sarakkeesta tai laatikosta
                            this.grid.set(rivi, sarake, arvo);
                            //asetetaan arvo soluun ja aloitetaan rekursio
                            if(solveRecursively()){
                                return true;
                            } else {
                                //jos sudoku ei ratkennut tällä arvolla, asetetaan nollaksi ja jatketaan
                                this.grid.set(rivi, sarake, 0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A method that solves a sudoku logically, using methods in Grid class.
     */
    public void solveLogically(){
        this.grid.solve();
    }
}