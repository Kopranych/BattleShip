import modul.*;
import view.GUI;
import view.GUIJButton;
import view.GUIJFrame;

/**
 * Created by kopra on 14.06.2017.
 */
public class Main {
    public static final int AMOUNT_SHIP = 10;


    public static void main(String[] args) {
        GUI display = new GUI();
        Player man = new Player();
        PlayerComp comp = new PlayerComp();
        Field fieldPlayer = new Field();
        Field fieldComp = new Field();
        Ship[] shipComp = new Ship[AMOUNT_SHIP];
        Ship[] shipPlayer = new Ship[AMOUNT_SHIP];
        GUIJFrame windowGame = new GUIJFrame("BattleShip", 1000, 500);
        GUIJButton[][] buttonsPlayer = new GUIJButton[10][10];
        GUIJButton[][] buttonsComp = new GUIJButton[10][10];

        display.setWindowGame(windowGame);
        display.setGameButtonsComp(buttonsComp);
        display.setGameButtonsPlayer(buttonsPlayer);
        display.initWindowGame();

        man.setPlayerField(fieldPlayer);
        comp.setCompField(fieldComp);

        man.getPlayerField().setButtons(buttonsPlayer);
        comp.getCompField().setButtons(buttonsComp);



        for (int i = 0; i < shipComp.length; i++) {
            shipComp[i] = new Ship();
            shipPlayer[i] = new Ship();
        }

        comp.getCompField().setShipField(shipComp);
        man.getPlayerField().setShipField(shipPlayer);

        comp.getCompField().initGame();
        man.getPlayerField().initGame();

        man.setShipsComp(shipComp);
        man.setCompField(fieldComp);
        man.setBottonsComp(buttonsComp);
        comp.setShipPlayer(shipPlayer);
        comp.setPlayerField(fieldPlayer);
        comp.setBottonsPlayer(buttonsPlayer);

        man.getPlayerField().setFleet(true);
        comp.getCompField().setFleet(false);


        display.showField(fieldComp);
        display.showField(fieldPlayer);



        for (int i = 0; i < 100; i++) {
//            display.showField(fieldComp);
            man.chekShip(man.shot());
            comp.shot();
        }

        display.showField(fieldComp);
    }
}
