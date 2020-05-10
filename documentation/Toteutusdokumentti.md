## Tietorakenteiden toteutus

Grid luokka saa parametrikseen kaksiulotteisen taulukon. Grid luokalla on get ja set metodit, joilla voidaan palauttaa ja vaihtaa yksittäisten solujen arvoja. 

Metodit onRivissa, onSarakkeessa ja onLaatikossa palauttavat tosi jos parametrinä annetussa rivissä/sarakkeessa/laatikossa on parametrinä annettu arvo.

Metodi onSallittu palauttaa boolean arvon true, jos ja vain jos kaikki yllä mainitut metodit palauttavat arvon false.

Metodi boolean[] mahdolliset pitää kirjaa mitkä arvot ovat mahdollisia mihinkin soluun.

Metodi ratkaistu tarkistaa onko tyhjiä soluja eli 0 merkattuja. Jos ei palautetaan true.

YhdenMahdolliset sijoittaa arvot soluihin joissa on vain yksi mahdollinen arvo.

AinoatMahdolliset sijoittaa arvot soluihin jotka ovat ainoa mahdollinen paikka arvolle tässä rivissä, sarakkeessa tai laatikossa.

Tarkistarivi, sarake ja laatikko vertaavat mahdollisia arvoja annettuihin soluihin.

## Ratkaisijan toteutus

Solver luokka saa parametrikseen yllä mainitun Grid olion. SolveRecursively metodi iteroi ruudukon solujen läpi ja käyttää Grid luokan metodeja tarkistaakseen onko tietty arvo sallittu tiettyyn soluun. Jos arvo on laillinen aloitetaan rekursio ja siirrytään seuraavaan soluun. Jos ratkaisua ei löydy palataan takaisin entiseen soluun.

SolveLogically käyttää gridin metodeja ja yrittää ratkaista sudokun logiikkaa käyttäen. Määrittelemällä jokaiselle solulle kaikki mahdolliset arvot ja eliminoimalla niitä muiden solujen mahdollisten arvojen perusteella saamme sudokun ratkottua nopeasti.

## Käyttöliittymän toteutus

Käyttäjältä pyydetään vaikeustasoa. Pyydetyn vaikeustason sudoku näytetään käyttäjälle alkuperäisessä tilassa ja ratkaistuna. Myös listataan 1000 ratkaisun keskimääräiset nopeudet molemmille algoritmeille.