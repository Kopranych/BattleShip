import java.util.Random;

/**
 * Created by kopra on 16.06.2017.
 */
public class Field {
    //    public String name;
//    public Player man;
//    public PlayerComp computer;
    private Ship[] shipField;
    public static final int XCOOR = 10;
    public static final int YCOOR = 10;
    private static final int FIELD_SIZE = 11;
    private String empty = "|";
    private String[][] spaceGame = new String[FIELD_SIZE][FIELD_SIZE];
    private String[] topStringField = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void setShipField(Ship[] shipField) {
        this.shipField = shipField;
    }

    public void initGame() {

        for (int i = 0; i < spaceGame.length; i++) {
            for (int j = 0; j < spaceGame.length; j++) {
                if (i == 0) {
                    spaceGame[i][j] = topStringField[j];
                } else if (j == 0) {

                    spaceGame[i][0] = Integer.toString(i);//строку переводим в символ
                } else
                    spaceGame[i][j] = empty;
            }
        }
    }




    //метод установки корабля в игровое поле
    public int setShipToField(Ship ship) {
        Random generator = new Random();
        int vertical;
        int horizont;
        final int limitAttempt = 500;
        final int limitAttempt2 = limitAttempt + 500;
        int countAttempt = 0;
        boolean isBusy;

        do {
            isBusy = false;
            vertical = generator.nextInt(spaceGame.length) + 1;//генерируем координаты
            horizont = generator.nextInt(spaceGame.length) + 1;//установки коробля

            for (int i = -1; i <= ship.getShipBox().length; i++) {
                for (int j = -1; j <= ship.getShipBox()[0].length; j++) {
                    if (vertical + i < spaceGame.length && horizont + j < spaceGame.length) {//проверка что бы не выйти за границы массива
                        if (spaceGame[vertical + i][horizont + j] == ship.getIntact()) {//проверка нет ли корабля в данной клетке и вокруг нее на расстоянии в одну клетку
                            isBusy = true;
                        }
                    }
                }
            }
            countAttempt++;
            if (countAttempt == limitAttempt) {
                ship.rotateShip();//переворачиваем корабль и пробуем установить в новом положении
            } else if (countAttempt >= limitAttempt2) return 0;
        }
        while ((vertical + ship.getShipBox().length) > (spaceGame.length) ||//проверка чтобы корабль не вышел за границы поля
                (horizont + ship.getShipBox()[0].length) > (spaceGame.length) || isBusy);


        for (int i = 0; i < ship.getShipBox().length; i++) {//
            for (int j = 0; j < ship.getShipBox()[i].length; j++) {
                spaceGame[i + vertical][j + horizont] = ship.getShipBox()[i][j];//выставляем корабль в поле
            }
        }
        ship.setCoordinY(vertical);
        ship.setCoordinX(horizont);
        return 1;//расстановка кораблей успешна
    }



//   Метод размещения кораблей в игровом поле
    public void setFleet() {
        int setShipSuccessful = 0;
        int pos = 1;

        while (setShipSuccessful == 0) {
            for (int i = 0; i < shipField.length; i++) {
                pos ^= shipField[0].getVertikCoord();
                if (i < shipField[0].getNumOneTiered()) {
                    shipField[i].creatSuperShip(shipField[0].getOneTiered(), pos);
                    setShipToField(shipField[i]);
                } else if (i < shipField[0].getNumTwoTiered() + shipField[0].getNumOneTiered()) {
                    shipField[i].creatSuperShip(shipField[0].getTwoTiered(), pos);
                    setShipToField(shipField[i]);
                } else if (i < shipField[0].getNumThreeTiered() + shipField[0].getNumTwoTiered() + shipField[0].getNumOneTiered()) {
                    shipField[i].creatSuperShip(shipField[0].getThreeTiered(), pos);
                    setShipToField(shipField[i]);
                } else if (i < shipField[0].getNumFourTiered() + shipField[0].getNumThreeTiered() + shipField[0].getNumTwoTiered() + shipField[0].getNumOneTiered()) {
                    shipField[i].creatSuperShip(shipField[0].getFourTiered(), pos);
                    setShipSuccessful = setShipToField(shipField[i]);
                }
            }
        }
    }
}
