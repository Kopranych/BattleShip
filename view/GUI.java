package view;


import modul.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kopra on 29.06.2017.
 */
public class GUI extends JFrame implements GUIvable {
    private Field fieldComp;
    private Field fieldPlayer;
    private GUIJFrame windowGame;
    private GUIJButton[] menuButton = new GUIJButton[3];
    private GUIJButton[][] gameButtons;
    private GUIJPanel panelGameComp = new GUIJPanel();
    private GUIJPanel panelGamePlayer = new GUIJPanel();
    private GUIJPanel panelLable = new GUIJPanel();
    private GUIJPanel panelBar = new GUIJPanel();
    private GUIJPanel panelNorth = new GUIJPanel();
    private GUIJPanel panelCentr = new GUIJPanel();
    private GUIJLable lablePlayer = new GUIJLable("Player");
    private GUIJLable lableComp = new GUIJLable("Comp");

    public void setWindowGame(GUIJFrame windowGame) {
        this.windowGame = windowGame;
    }

    public void setGameButtons(GUIJButton[][] gameButtons) {
        this.gameButtons = gameButtons;
    }

    private GUIJPanel menuPanel = new GUIJPanel();
    private String [] textButton = {"StartGame","Exit","About"};


    public void setFieldPlayer(Field fieldPlayer) {
        this.fieldPlayer = fieldPlayer;
    }

    public void setFieldComp(Field fieldComp) {
        this.fieldComp = fieldComp;
    }

    public void showField(Field field) {
        for (int i = 0; i < field.spaceGame.length; i++) {
            for (int j = 0; j < field.spaceGame.length; j++) {
                if (i == 10) {
                    System.out.print(field.spaceGame[i][j] + "  ");
                } else
                    System.out.print(" " + field.spaceGame[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Override
    public void initWindowGame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//задает отображение внутренних компонентов окна
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        windowGame.add(panelNorth, BorderLayout.NORTH);
        windowGame.add(panelCentr, BorderLayout.CENTER);

        panelNorth.setLayout(new GridLayout(2, 1));
        panelCentr.setLayout(new GridLayout(1, 2 ));

        panelNorth.add(panelBar);
        panelNorth.add(panelLable);
        panelCentr.add(panelGameComp);
        panelCentr.add(panelGamePlayer);

        panelLable.setLayout(new GridLayout(1, 2 ));
        panelLable.add(lableComp);
        panelLable.add(lablePlayer);

        panelGameComp.setLayout(new GridLayout(10,10,2,2));

        for (int i = 0; i < gameButtons.length; i++) {
            for (int j = 0; j < gameButtons.length; j++) {
                gameButtons[i][j] = new GUIJButton();
                panelGameComp.add(gameButtons[i][j]);
            }

        }
        windowGame.setVisible(true);// вызывается после всех операций с окном

    }

    @Override
    public void initWindowMenu() {
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShip");

        menuPanel.setLayout(new GridLayout(3,1));
        for (int i = 0; i < menuButton.length; i++) {
            GUIJButton buttonTemp = new GUIJButton();
            buttonTemp.setText(textButton[i]);
            menuButton[i] = buttonTemp;
            menuPanel.add(buttonTemp);
            buttonTemp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = e.getActionCommand();
                    System.out.println("Вы нажали кнопку " + buttonText);
                }
            });
        }
        add(menuPanel);
        setVisible(true);
    }

    @Override
    public void showField() {

    }
}
