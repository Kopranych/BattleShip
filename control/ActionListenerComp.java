package control;

import view.GUIJButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerComp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(! (e.getSource() instanceof JButton)){
            return;
        }
        GUIJButton tempButton = (GUIJButton) e.getSource();

        System.out.println("нажата кнопна с координатами х: " + tempButton.getPoint().getX() + " у: " + tempButton.getPoint().getY());

    }
}
