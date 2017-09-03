package modul;


import view.GUIJButton;

import java.util.Random;

/**
 * Created by kopra on 16.06.2017.
 */
public class PlayerComp implements Playerable {
    private String name;
    private Field compField;
    private Ship[] shipsPlayer;
    private Field playerField;
    private GUIJButton[][] bottonsPlayer;
    private static PointOnField point;

    public Field getPlayerField() {
        return playerField;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public Field getCompField() {
        return compField;
    }

    public void setCompField(Field compField) {
        this.compField = compField;
    }

    public void setShipPlayer(Ship[] ship) {
        this.shipsPlayer = ship;
    }

    public GUIJButton[][] getBottonsPlayer() {
        return bottonsPlayer;
    }

    public void setBottonsPlayer(GUIJButton[][] bottonsPlayer) {
        this.bottonsPlayer = bottonsPlayer;
    }



    @Override
    public int shot() {
        int horyz;
        int vertic;
        int indexShip = -1;
        PointOnField point;
        boolean isShot = false;

        while (!isShot) {//чтоб комп не стрелял повторно по тем же клеткам
            point = getProgress();
            vertic = point.getY();
            horyz = point.getX();

            if (playerField.spaceGame[vertic][horyz] == shipsPlayer[0].getIntact()) {
                for (int i = 0; i < shipsPlayer.length; i++) {
                    if (shipsPlayer[i].getPositinShip() == shipsPlayer[i].getHorizCoord()) {
                        for (int j = 0; j < shipsPlayer[i].getNumberDeck(); j++) {
                            if (shipsPlayer[i].getCoordinX() + j == horyz && shipsPlayer[i].getCoordinY() == vertic) {
                                String[][] tempShipBox = shipsPlayer[i].getShipBox();
                                tempShipBox[0][j] = shotToShip;
                                shipsPlayer[i].setShipBox(tempShipBox);
                                bottonsPlayer[vertic][horyz].setText(shotToShip);
                                indexShip = i;
                            }
                        }
                    } else {
                        for (int j = 0; j < shipsPlayer[i].getNumberDeck(); j++) {
                            if (shipsPlayer[i].getCoordinY() + j == vertic && shipsPlayer[i].getCoordinX() == horyz) {
                                String[][] tempShipBox = shipsPlayer[i].getShipBox();
                                tempShipBox[j][0] = shotToShip;
                                shipsPlayer[i].setShipBox(tempShipBox);
                                bottonsPlayer[vertic][horyz].setText(shotToShip);
                                indexShip = i;
                            }
                        }
                    }
                }
                compField.spaceGame[vertic][horyz] = shotToShip;
                isShot = true;

            } else if (compField.spaceGame[vertic][horyz] == Field.EMPTY) {
                compField.spaceGame[vertic][horyz] = shot;
                bottonsPlayer[vertic][horyz].setText(shot);
                System.out.println("Промах комп");
                isShot = true;
                indexShip =  miss;
            }
        }
        return indexShip;
    }

    private PointOnField getProgress(){
        Random rd = new Random();
        return point = new PointOnField(rd.nextInt(Field.XCOOR),rd.nextInt(Field.YCOOR));

    }
}
