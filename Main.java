import modul.*;
import view.GUI;

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

        display.init_window();
        for (int i = 0; i < ship.length; i++) {
            ship[i] = new Ship();
        }

        display.setFieldComp(fieldComp);
        comp.setCompField(fieldComp);
        comp.setCompField(fieldComp);
        fieldComp.setShipField(ship);
        fieldComp.initGame();
        man.setCompField(fieldComp);
        man.setShipsComp(ship);
        fieldComp.setFleet();

        for (int i = 0; i < 10; i++) {
            display.showField(fieldComp);
            man.playerShot();
        }

    }
}
