package view;

import modul.PointOnField;

import javax.swing.*;
import java.awt.*;

public class GUIJButton extends JButton {
//    private int x;
//    private int y;
    private PointOnField point = new PointOnField();
////
    public PointOnField getPoint() {
        return point;
    }
//
//    @Override
//    public int getX() {
//        return x;
//    }
//
//    @Override
//    public int getY() {
//        return y;
//    }
//
//    public void setX(int x) {
//
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public GUIJButton() {
        setFont(new Font("Courier", Font.ITALIC, 20));

    }

    public GUIJButton(String buttonText){
        setText(buttonText);
    }

    public GUIJButton(String buttonText, int whidth, int height) {
        this(buttonText);
        setSize(whidth, height);
    }
}
