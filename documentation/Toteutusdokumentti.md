## Tietorakenteiden toteutus
Grid luokka saa parametrikseen kaksiulotteisen taulukon. Grid luokalla on get ja set metodit, joilla voidaan palauttaa ja vaihtaa yksittäisten solujen arvoja. 

Metodit onRivissa, onSarakkeessa ja onLaatikossa palauttavat tosi jos parametrinä annetussa rivissä/sarakkeessa/laatikossa on parametrinä annettu arvo.

Metodi onSallittu palauttaa boolean arvon true, jos ja vain jos kaikki yllä mainitut metodit palauttavat arvon false.

## Ratkaisijan toteutus
Solver luokka saa parametrikseen yllä mainitun Grid olion. SolveRecursively metodi iteroi ruudukon solujen läpi ja käyttää Grid luokan metodeja tarkistaakseen onko tietty arvo sallittu tiettyyn soluun. Jos arvo on laillinen aloitetaan rekursio ja siirrytään seuraavaan soluun. Jos ratkaisua ei löydy palataan takaisin entiseen soluun.

