package modul;


import view.GUIJButton;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by kopra on 16.06.2017.
 */
public class Player implements Playerable {
    private String name;
    private Field playerField;
    private Field compField;
    private Ship[] shipsComp;
    private static PointOnField point;
    private GUIJButton[][] bottonsComp;
    //    private String shot = "X";
//    private String shotToShip = "*";
//    private String killShot = "+";
    private final int killed = 2;
    private final int wounded = 1;
    private final int miss = -1;
    private volatile static boolean isShoot;

    public GUIJButton[][] getBottonsComp() {
        return bottonsComp;
    }

    public void setBottonsComp(GUIJButton[][] bottonsComp) {
        this.bottonsComp = bottonsComp;
    }

    public PointOnField getPoint() {
        return point;
    }

    public static void setPoint(PointOnField point) {
        Player.point = point;
    }

    public void setShipsComp(Ship[] shipsComp) {
        this.shipsComp = shipsComp;
    }

    public Field getCompField() {
        return compField;
    }

    public static void setShoot(boolean shoot) {
        isShoot = shoot;
    }

    public Field getPlayerField() {

        return playerField;
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

    @Override
    public int shot() {
        int horyz;
        int vertic;
        int indexShip = -1;
        boolean isShot = false;

        while (!isShot) {
            PointOnField point = getProgress();
            vertic = point.getY();
            horyz = point.getX();
            System.out.println("положили координаты");
            if (compField.spaceGame[vertic][horyz] == shipsComp[0].getIntact()) {
                for (int i = 0; i < shipsComp.length; i++) {
                    if (shipsComp[i].getPositinShip() == shipsComp[i].getHorizCoord()) {
                        for (int j = 0; j < shipsComp[i].getNumberDeck(); j++) {
                            if (shipsComp[i].getCoordinX() + j == horyz && shipsComp[i].getCoordinY() == vertic) {
                                String[][] tempShipBox = shipsComp[i].getShipBox();
                                tempShipBox[0][j] = shotToShip;
                                shipsComp[i].setShipBox(tempShipBox);
                                bottonsComp[vertic][horyz].setText(shotToShip);
                                indexShip = i;
                            }
                        }
                    } else {
                        for (int j = 0; j < shipsComp[i].getNumberDeck(); j++) {
                            if (shipsComp[i].getCoordinY() + j == vertic && shipsComp[i].getCoordinX() == horyz) {
                                String[][] tempShipBox = shipsComp[i].getShipBox();
                                tempShipBox[j][0] = shotToShip;
                                shipsComp[i].setShipBox(tempShipBox);
                                bottonsComp[vertic][horyz].setText(shotToShip);
                                indexShip = i;
                            }
                        }
                    }
                }
                compField.spaceGame[vertic][horyz] = shotToShip;
                isShot = true;
            } else if (compField.spaceGame[vertic][horyz] == Field.EMPTY) {
                compField.spaceGame[vertic][horyz] = shot;
                bottonsComp[vertic][horyz].setText(shot);
                System.out.println("Промах");
                isShot = true;
                indexShip = miss;
            }else{
                System.out.println("Попробуй ещё");
            }
        }
        System.out.println("Закончили выстрел");
        return indexShip;
    }

    public int chekShip(int indexShip) {
        if (indexShip == miss) {
            System.out.println("Индекс -1");
            return miss;
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
            fillingKillShipSpaseAroundShip(indexShip);
            return killed;
        } else {
            System.out.println("Ранил");
            return wounded;
        }
    }

    public PointOnField getProgress() {
        isShoot = false;
        while (!isShoot) ;
        return point;
    }

    private void fillingKillShipSpaseAroundShip(int indexShip) {
        if (shipsComp[indexShip].getPositinShip() == shipsComp[indexShip].getHorizCoord()) {
            for (int k = 0; k < shipsComp[indexShip].getNumberDeck(); k++) {
                String[][] tempShipBox = shipsComp[indexShip].getShipBox();
                bottonsComp[shipsComp[indexShip].getCoordinY()][shipsComp[indexShip].getCoordinX() + k].setText(killShot);
                tempShipBox[0][k] = killShot;
                shipsComp[indexShip].setShipBox(tempShipBox);
            }
        } else {
            for (int k = 0; k < shipsComp[indexShip].getNumberDeck(); k++) {
                String[][] tempShipBox = shipsComp[indexShip].getShipBox();
                bottonsComp[shipsComp[indexShip].getCoordinY() + k][shipsComp[indexShip].getCoordinX()].setText(killShot);
                for (int i = 0; i < tempShipBox.length; i++) {
                    bottonsComp[shipsComp[indexShip].getCoordinY() + k][shipsComp[indexShip].getCoordinX()].setText(shot);
                }


                tempShipBox[k][0] = killShot;
                shipsComp[indexShip].setShipBox(tempShipBox);
            }
        }
    }
}

