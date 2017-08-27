import modul.*;
import view.GUI;
import view.GUIJButton;
import view.GUIJFrame;

import javax.swing.*;

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
        GUIJFrame windowGame = new GUIJFrame("BattleShip", 1000, 500);
        GUIJButton[][] buttonsGamePlayer = new GUIJButton[10][10];
        GUIJButton[][] buttonsGameComp = new GUIJButton[10][10];
        JButton[][] testButton = new JButton[10][10];

        for (int i = 0; i < testButton.length; i++) {
            for (int j = 0; j < testButton.length; j++) {
                testButton[i][j] = new JButton();
            }
        }

        display.setWindowGame(windowGame);
        display.setGameButtonsComp(buttonsGameComp);
        display.setGameButtonsPlayer(testButton);
        fieldPlayer.setButtons(testButton);
        display.initWindowGame();

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
