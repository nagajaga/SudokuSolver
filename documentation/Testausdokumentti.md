# Yksikkötestaus

Yksikkötestit on kirjoitettu luokille Grid ja Solver.
Test pakkauksessa sijaitsevat GridTest ja SolverTest testaavat ohjelman toimintaa.

## GridTest.java

GridTest.java testaa grid tietorakenteen toimintaa. Get ja set metodien toimintaa on testattu syöttämällä arvoja valmiiseen ruudukkoon ja tarkastamalla muutoksia ja palautuksia. Metodit jolla selvitetään onko tietyssä rivissä, sarakkeessa tai laatikossa tiettyä lukua, palauttavat oikeat boolean totuusarvot esimerkkisyötteillä. Tulostusta on myös testattu. Luokan rivikattavuus on 100%.

## SolverTest.java

SolverTest.java testaa solver luokan toimintaa. Ohjelmalle syötetään sudoku ja jos solverin metodi solveRecursively palauttaa boolean arvon tosi, se on onnistunut ratkaisemaan sudokun. Luokan rivikattavuus on 100%.

## Suorituskykytestaus

Suorituskykyä on testattu ratkaisemalla jokaisen eri vaikeustason sudoku 1000 kertaa käyttäen molempia algoritmejä.

<img src="https://github.com/nagajaga/sudokuSolver/blob/master/documentation/graph.png">

Kuvassa näkyy millisekunteina kauan meni keskimäärin ratkaista jokaisen eri vaikeustason sudoku eri algoritmeillä (Pienempi arvo on nopeampi).

Huomataan, että helpommalla vaikeustasolla backtracking pärjää yhtä hyvin tai jopa nopeammin kuin looginen ratkaisija. Vaikeimmalla vaikeustasolla kuitenkin looginen ratkaisija on huomattavasti nopeampi sudokun ratkomisessa.

## Rivikattavuus

Luokkien rivikattavuutta voi tarkastella tarkemmin painamalla alla olevaa codecov kuvaketta.

[![codecov](https://codecov.io/gh/nagajaga/SudokuSolver/branch/master/graph/badge.svg)](https://codecov.io/gh/nagajaga/SudokuSolver)

