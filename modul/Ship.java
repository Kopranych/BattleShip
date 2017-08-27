package modul;

/**
 * Created by kopra on 29.06.2017.
 */
public class Ship {
    private static final int horizCoord = 0;
    private static final int vertikCoord = 1;
    private int numberDeck;
    private int positinShip;
    private int coordinX;
    private int coordinY;
    public static final String INTACT = "#";
    private String[][] shipBox;

    private int numOneTiered = 4;
    private int numTwoTiered = 3;
    private int numThreeTiered = 2;
    private int numFourTiered = 1;
    private int numTotalShip = numOneTiered + numTwoTiered + numThreeTiered + numFourTiered;
    private final int OneTiered = 1;
    private final int TwoTiered = 2;
    private final int ThreeTiered = 3;
    private final int FourTiered = 4;

    public String[][] getShipBox() {
        return shipBox;
    }

    public void setShipBox(String[][] shipBox) {
        this.shipBox = shipBox;
    }

    public String getIntact() {
        return INTACT;
    }

    public static int getHorizCoord() {
        return horizCoord;
    }

    public static int getVertikCoord() {
        return vertikCoord;
    }

    public int getNumberDeck() {
        return numberDeck;
    }

    public void setNumberDeck(int numberDeck) {
        this.numberDeck = numberDeck;
    }

    public int getPositinShip() {
        return positinShip;
    }

    public void setPositinShip(int positinShip) {
        this.positinShip = positinShip;
    }

    public int getCoordinX() {
        return coordinX;
    }

    public void setCoordinX(int coordinX) {
        this.coordinX = coordinX;
    }

    public int getCoordinY() {
        return coordinY;
    }

    public void setCoordinY(int coordinY) {
        this.coordinY = coordinY;
    }

    public void creatSuperShip(int numDeck, int position ) {
        positinShip = position;
        numberDeck = numDeck;
        if (positinShip == horizCoord) {
            shipBox = new String[1][numberDeck];
            for (int i = 0; i < numberDeck; i++) {
                shipBox[0][i] = INTACT;
            }
        } else {
            shipBox = new String[numberDeck][1];
            for (int i = 0; i < numberDeck; i++) {
                shipBox[i][0] = INTACT;
            }
        }
    }

    public void rotateShip() {
        if (positinShip == horizCoord) {
            positinShip = vertikCoord;
            shipBox = new String[numberDeck][1];
            for (int i = 0; i < numberDeck; i++) {
                shipBox[i][0] = INTACT;
            }
        } else {
            positinShip = horizCoord;
            shipBox = new String[1][numberDeck];
            for (int i = 0; i < numberDeck; i++) {
                shipBox[0][i] = INTACT;
            }
        }

    }
    public int getOneTiered() {
        return OneTiered;
    }

    public int getTwoTiered() {
        return TwoTiered;
    }

    public int getThreeTiered() {
        return ThreeTiered;
    }

    public int getFourTiered() {
        return FourTiered;
    }

    public int getNumOneTiered() {
        return numOneTiered;
    }

    public int getNumTwoTiered() {
        return numTwoTiered;
    }

    public int getNumThreeTiered() {
        return numThreeTiered;
    }

    public int getNumFourTiered() {
        return numFourTiered;
    }

    public int getNumTotalShip() {
        return numTotalShip;
    }

    public void showShip(String[][] ship) {
        for (int i = 0; i < ship.length; i++) {
            for (int j = 0; j < ship[i].length; j++) {
                System.out.print(ship[i][j]);
            }
            System.out.println();
        }
    }
}


