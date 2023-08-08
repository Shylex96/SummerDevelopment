package snakeGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameRanking_View extends JFrame {

    private static final long serialVersionUID = 1L;

    private Image imgControls;
    public Rectangle btnBack;

    private String name1, name2, name3;
    private int score1, score2, score3;

    // Get model with parameters
    public GameRanking_View(GameRanking_Model gameRankingModel) {
        this.setTitle("Snake Game - Ranking");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgControls = toolkit.getImage("resources/imgRanking.png");

        btnBack = new Rectangle(475, 531, 95, 50);

        // Get names and scores from model
        gameRankingModel.getTopPlayers();
        name1 = gameRankingModel.getName1();
        name2 = gameRankingModel.getName2();
        name3 = gameRankingModel.getName3();
        score1 = gameRankingModel.getScore1();
        score2 = gameRankingModel.getScore2();
        score3 = gameRankingModel.getScore3();

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imgControls, 0, 20, this);

        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        Color colors = new Color(255, 255, 255);
        g.setColor(colors);

        // Show Top 3 players
        // Score needs white space because int
        g.drawString(score1 + " ", 132, 275);
        g.drawString(score2 + " ", 132, 385);
        g.drawString(score3 + " ", 132, 495);
        
        g.drawString(name1, 250, 275);
        g.drawString(name2, 250, 385);
        g.drawString(name3, 250, 495);
    }
}
