package view;

import javax.swing.*;
import java.awt.*;

public class GUIJLable extends JLabel {
    public GUIJLable(String name){
        setText(name);
        setFont(new Font("Courier", Font.BOLD, 20));
    }
}
