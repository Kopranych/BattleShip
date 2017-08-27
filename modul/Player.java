package modul;


import java.util.Random;
import java.util.Scanner;

/**
 * Created by kopra on 16.06.2017.
 */
public class Player {
    private String name;
    private Field playerField;
    private Field compField;
    private Ship[] shipsComp;
    private String shot = "X";
    private String shotToShip = "*";
    private final int killed = 2;
    private final int wounded = 1;
    private final int miss = 0;

    public void setShipsComp(Ship[] shipsComp) {
        this.shipsComp = shipsComp;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public void setCompField(Field compField) {
        this.compField = compField;
    }

    public String getShot() {
        return shot;
    }

    public int playerShot() {
        int horyz;
        int vertic;
        int indexShip = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите координаты выстрела вертикальные");
        vertic = Integer.valueOf(sc.nextLine());
        System.out.println("Введите координаты выстрела горизонтальные");
        horyz = Integer.valueOf(sc.nextLine());

        if (compField.spaceGame[vertic][horyz] == shipsComp[0].getIntact()) {
            for (int i = 0; i < shipsComp.length; i++) {
                if (shipsComp[i].getPositinShip() == shipsComp[i].getHorizCoord()) {
                    for (int j = 0; j < shipsComp[i].getNumberDeck(); j++) {
                        if (shipsComp[i].getCoordinX() + j == horyz && shipsComp[i].getCoordinY() == vertic) {
                            String[][] tempShipBox = shipsComp[i].getShipBox();
                            tempShipBox[0][j] = shotToShip;
                            shipsComp[i].setShipBox(tempShipBox);
                            indexShip = i;
                        }
                    }
                } else {
                    for (int j = 0; j < shipsComp[i].getNumberDeck(); j++) {
                        if (shipsComp[i].getCoordinY() + j == vertic && shipsComp[i].getCoordinX() == horyz) {
                            String[][] tempShipBox = shipsComp[i].getShipBox();
                            tempShipBox[j][0] = shotToShip;
                            shipsComp[i].setShipBox(tempShipBox);
                            indexShip = i;

                        }
                    }
                }
            }
            compField.spaceGame[vertic][horyz] = shotToShip;
            return chekShip(indexShip);
        } else {
            compField.spaceGame[vertic][horyz] = shot;
            System.out.println("Промах");
            return miss;
        }
    }

    private int chekShip(int indexShip) {
        if (indexShip == -1) {
            System.out.println("Индекс -1");
            return -1;
        }

        int countDead = 0;

        for (int k = 0; k < shipsComp[indexShip].getNumberDeck(); k++) {
            if (shipsComp[indexShip].getPositinShip() == shipsComp[indexShip].getHorizCoord()) {
                String[][] tempShipBox = shipsComp[indexShip].getShipBox();
                if (tempShipBox[0][k] == shotToShip) {
                    countDead++;
                }
            } else {
                String[][] tempShipBox = shipsComp[indexShip].getShipBox();
                if (tempShipBox[k][0] == shotToShip) {
                    countDead++;
                }
            }
        }
        if (countDead == shipsComp[indexShip].getNumberDeck()) {
            System.out.println("Корабль " + indexShip + " убит");
            return killed;
        } else {
            System.out.println("Ранил");
            return wounded;
        }
    }
}

