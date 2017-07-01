/**
 * Created by kopra on 14.06.2017.
 */
public class Main {


    public static void main(String[] args) {
        GUI display = new GUI();
        Player man = new Player();
        PlayerComp comp = new PlayerComp();
        Field fieldPlayer = new Field();
        Field fieldComp = new Field();
        Ship[] ship = new Ship[10];

        for (int i = 0; i < ship.length; i++) {
            ship[i] = new Ship();
        }

        display.setFieldComp(fieldComp);
        comp.setCompField(fieldComp);
        comp.compField.setShipField(ship);
        comp.compField.initGame();
        man.setCompField(fieldComp);
        man.setShipsComp(ship);

        comp.compField.setFleet();
        for (int i = 0; i < 10; i++) {

            display.showField(fieldComp);
            man.playerShot();



        }

    }
}
