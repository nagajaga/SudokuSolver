# Viikon 5 raportti

Viidennellä viikolla loin loogisen ratkaisualgoritmin. Tämä algoritmi ratkaisee sudokun käyttäen samoja tekniikoita kuin ihmiset. Tarkastellaan mitkä arvot ovat mahdollisia tiettyyn soluun ja edetään eliminoimalla näitä kunnes mahdollisuuksia on vain yksi. Algoritmin suorituskyky on huomattavasti nopeampi kuin rekursiivinen algoritmi, koska jokaiseen soluun ei tarvitse tarkistaa jokaista arvoa. Aikaisempi 12ms ratkeava sudoku ratkesi nyt 3ms ajassa. Suorituskykyä on enimmäkseen testattu main luokassa, ensi viikolla implementoidaan testiluokkaan suorituskyvyn testausta ja refaktoroidaan koodia siistimmäksi.

Aikaa käytetty: 15h