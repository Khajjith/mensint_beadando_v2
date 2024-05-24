Játék leírása és projekt dokumentáció
1. Projekt leírása

Ez a projekt egy egyszerű 2D-s játék, ahol négy robotnak be kell kerítenie egy mozgó ellenfelet egy NxN méretű négyzethálós pályán. 
Az ellenfelet egy emberi játékos irányítja, és a robotok mindig tudják, hol van az ellenfél. 
A játék során véletlenszerűen generált pályákon kell játszani, ahol p% valószínűséggel vannak akadályok. 
A cél az, hogy a robotok 50%-os arányban legyőzzék az ellenfelet.

2. Futtatási követelmények

    Java Development Kit (JDK) 8 vagy újabb verzió
    Szövegszerkesztő vagy integrált fejlesztőkörnyezet (IDE) a kód szerkesztéséhez és futtatásához

3. A program futtatása

    Töltsd le vagy másold le a projekt fájljait a számítógépedre.
    Nyisd meg a projekt mappáját egy szövegszerkesztőben vagy IDE-ben.
    Győződj meg arról, hogy a következő három fájl jelen van a projekt mappájában:
        Cell.java
        Board.java
        Game.java
    Fordítsd le és futtasd a Game.java fájlt.

4. Játékmenet

    A program elindítása után a következő adatokat kell megadnod:
        A pálya mérete (N): egy egész szám, amely meghatározza a négyzethálós pálya méretét (pl. 10).
        Az akadályok aránya (p): egy 0 és 100 közötti egész szám, amely meghatározza az akadályok százalékos arányát a pályán (pl. 20).
        A játékos karaktere: egy karakter, amely megjeleníti az ellenfelet a pályán (pl. O).
    A játék kezdetekor a pálya generálásra kerül a megadott méretekkel és akadályokkal. A játékos a pálya közepén, a robotok pedig a négy sarokban helyezkednek el.
    A játékos a következő billentyűk használatával mozoghat a pályán:
        W: fel
        A: balra
        S: le
        D: jobbra
    A robotok minden körben mozognak, hogy bekerítsék a játékost.
    A játék akkor ér véget, ha:
        A robotok sikeresen bekerítették a játékost (a játékos nem tud mozogni egyik irányba sem).
        A játékos sikeresen elérte a pálya szélét és megszökött.
    A játék végén a program kiírja, hogy ki nyert (a robotok vagy az ellenfél).

5. Kódstruktúra

A projekt három fő osztályból áll:

Cell.java
        Egy cellát reprezentál a pályán, amely tárolja a cella koordinátáit (x, y).

Board.java
        A pálya logikáját és állapotát kezeli, beleértve a pálya generálását, az akadályok elhelyezését, a robotok és az ellenfél mozgását.
        Metódusok:
            generateObstacles(int p): Véletlenszerűen generál akadályokat a pályán.
            placeOpponentAndRobots(): Elhelyezi az ellenfelet és a robotokat a pályán.
            printBoard(): Kiírja a pálya aktuális állapotát.
            moveOpponent(char direction): Kezeli az ellenfél mozgását.
            moveRobots(): Kezeli a robotok mozgását.
            isGameOver(): Ellenőrzi, hogy vége van-e a játéknak.
            didRobotsWin(): Ellenőrzi, hogy a robotok nyertek-e.
            didOpponentWin(): Ellenőrzi, hogy az ellenfél nyert-e.

Game.java
        A játék fő ciklusát kezeli, amely a felhasználói bemeneteket és a pálya frissítését kezeli.
        A program elején bekéri a pálya méretét, az akadályok arányát és a játékos karakterét.

6. Példa futtatás

less

Adja meg a pálya méretét (N): 10
Adja meg az akadályok arányát (0-100): 20
Adja meg a játékos karakterét: O
Adja meg a lépést (WASD): 

Ezekkel az adatokkal a program generál egy 10x10-es pályát, amelyen az akadályok aránya 20%. 
A játékos karaktere O, amely a pálya közepén kezd, és a robotok a négy sarokban helyezkednek el. 
A játékos a WASD billentyűk segítségével mozoghat a pályán, és a cél, hogy megszökjön, mielőtt a robotok bekerítik.
