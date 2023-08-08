package snakeGame;

public class PlaySnake {

	public static void main(String[] args) {
		
		GamePlay_Model gameModel = new GamePlay_Model();
		GameMenu_View gameMenu = new GameMenu_View();
		new GameController(gameModel, gameMenu);
	}
}
