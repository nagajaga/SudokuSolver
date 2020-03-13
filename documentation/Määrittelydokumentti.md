# SudokuSolver Määrittelydokumentti


## Mitä ongelmaa ratkaiset?
Ohjelman tavoite on ratkaista kaikki mahdolliset perinteiset 9x9 sudoku pelit. Tarkoituksena on hyödyntää rekursiivistä backtracking algoritmiä pelin ratkomiseen. Backtracking on depth-first search eli syvyyshakualgoritmi. Tavoitteena on myös luoda toinen optimoitu algoritmi ja verrata näiden kahden algoritmin suoritusaikoja.

## Mitä tietorakenteita käytetään?
Ruudukko tullaan tallentamaan 2d-taulukkoon, jossa koordinaatit x=0, y=0 viittaavat vasempaan yläkulmaan ja x=8, y=8 oikeaan alakulmaan.

## Aika- ja tilavaativuus
Rekursiivinen backtracking algoritmi saa aikavaativuudeksi huonoimmassa tapauksessa O(n^m), jossa "n" on rivin pituus eli perinteisesti 9 ja "m" on tyhjien solujen määrä.

Tilavaativuus on n\*n eli 9\*9.

## Mitä syötteitä ohjelma saa?
Ohjelma saa syötteenä osittain täytettyjä ruudukkoja 2d-taulukkomuodossa. Testeissä tullaan käyttämään helppoja, keskivaikeita ja vaikeita sudokuja. Myös olisi hyvä testata "huonoimpia tapauksia" syöttämällä ruudukkoja, jotka pakottavat algoritmin käymään läpi erittäin monia eri mahdollisuuksia.

## Lähteet
[Sudoku](https://en.wikipedia.org/wiki/Sudoku)

[Tirakirja](https://www.cs.helsinki.fi/u/ahslaaks/tirakirja/)

[Backtracking](https://www.geeksforgeeks.org/backtracking-introduction/)
