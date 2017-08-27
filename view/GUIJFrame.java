package view;

import javax.swing.*;
import java.awt.*;

public class GUIJFrame extends JFrame {
    public GUIJFrame(String title, int width, int height){
        setSize(width,height);
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
//        setIconImage(new ImageIcon("gameicon.png").getImage());
    }
}
