package control;

import modul.Player;
import view.GUIJButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerComp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }
        GUIJButton tempButton = (GUIJButton) e.getSource();
        Player.setShoot(true);
        Player.setPoint(tempButton.getPoint());
        System.out.println("action отработал");
    }
}
