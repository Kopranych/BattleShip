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
    JButton[] menuButton = new JButton[3];
    JPanel menuPanel = new JPanel();
    String [] textButton = {"StartGame","Exit","About"};


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
    public void init_window() {
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShip");

        menuPanel.setLayout(new GridLayout(3,1));
        for (int i = 0; i < menuButton.length; i++) {
            JButton buttonTemp = new JButton();
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
