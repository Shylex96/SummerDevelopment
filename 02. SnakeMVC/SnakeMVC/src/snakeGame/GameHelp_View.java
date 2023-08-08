package snakeGame;

import javax.swing.*;
import java.awt.*;

public class GameHelp_View extends JFrame {

    private static final long serialVersionUID = 1L;

    private Image imgControls;
    public Rectangle btnBack;

    public GameHelp_View() {
    	
        this.setTitle("Snake Game - Controllers");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgControls = toolkit.getImage("resources/imgControls.png");

        btnBack = new Rectangle(475, 531, 95, 50);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imgControls, 0, 20, this);
    }
}
