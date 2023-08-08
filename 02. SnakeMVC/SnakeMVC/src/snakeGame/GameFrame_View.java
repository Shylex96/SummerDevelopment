package snakeGame;

import javax.swing.JFrame;

public class GameFrame_View extends JFrame {

	private static final long serialVersionUID = 1L;


	private GamePlay_Model gameModel;

	GameFrame_View(GamePlay_Model gameModel) {

		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//this.pack();
		//this.setSize(GamePlay_Model.SCREEN_WIDTH, GamePlay_Model.SCREEN_HEIGHT);
		this.setSize(615, 640);
		this.setLocationRelativeTo(null);
		this.gameModel = gameModel;
		this.add(this.gameModel);

		this.setVisible(true);
	}
}

