# Yksikkötestaus

Yksikkötestit on kirjoitettu luokille Grid ja Solver.
Test pakkauksessa sijaitsevat GridTest ja SolverTest testaavat ohjelman toimintaa.

## GridTest.java
GridTest.java testaa grid tietorakenteen toimintaa. Get ja set metodien toimintaa on testattu syöttämällä arvoja valmiiseen ruudukkoon ja tarkastamalla muutoksia ja palautuksia. Metodit jolla selvitetään onko tietyssä rivissä, sarakkeessa tai laatikossa tiettyä lukua, palauttavat oikeat boolean totuusarvot esimerkkisyötteillä. Tulostusta on myös testattu. Luokan rivikattavuus on 100%.

## SolverTest.java
SolverTest.java testaa solver luokan toimintaa. Ohjelmalle syötetään sudoku ja jos solverin metodi solveRecursively palauttaa boolean arvon tosi, se on onnistunut ratkaisemaan sudokun. Luokan rivikattavuus on 100%.

## Suorituskykytestaus
Suorituskykyä on tällä hetkellä testattu paikallisesti muutamalla eri sudokulla. Tarkoituksena on implementoida suorituskykytestaus omaan testiluokkaansa ensi viikolla ja testata monesti samoja sudokuja ja ottaa näistä keskiarvo. Nopeuksissa on ollut paljon vaihtelua jopa samalla sudokulla joten on tärkeätä suorittaa testit monesti eikä vain kerran joka sudokulla.

## Rivikattavuus
Luokkien rivikattavuutta voi tarkastella tarkemmin painamalla alla olevaa codecov kuvaketta.

[![codecov](https://codecov.io/gh/nagajaga/SudokuSolver/branch/master/graph/badge.svg)](https://codecov.io/gh/nagajaga/SudokuSolver)

