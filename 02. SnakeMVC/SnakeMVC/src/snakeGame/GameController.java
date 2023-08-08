package snakeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameController implements WindowListener, MouseListener, KeyListener, ActionListener {

	private GameMenu_View gameMenu;
	private GameHelp_View gameHelp;
	private GameRanking_View gameRankingView;
	private GameRanking_Model gameRankingModel;
	private GameNickname_View currentNicknameView;

	private GameFrame_View gameFrameView;
	private GamePlay_Model gameModel;
	public GameScore_Model gameScoreModel;

	String nickname = "";

	public GameController(GamePlay_Model gameModel, GameMenu_View gameMenu) {
		this.gameModel = gameModel;
		this.gameMenu = gameMenu;
		
		gameMenu.addMouseListener(this);
		gameMenu.addWindowListener(this);
		//gameMenu.addKeyListener(this);

		gameModel.startGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Game Menu Events

		// Method isActive needed to avoid a Bug: Opening a new Nickname_View window
		if (gameMenu.isActive() && gameMenu.btnPlay.contains(e.getPoint())) {
			// Play Snake
			gameMenu.dispose();
			openGameNicknameView();

		} else if (gameMenu.isActive() && gameMenu.btnControls.contains(e.getPoint())) {
			// Game Help (Controllers)
			openGameHelpView();

		} else if (gameMenu.isActive() && gameMenu.btnRanking.contains(e.getPoint())) {
			// Game Ranking (Top Scores)
			openGameRankingView();

			// Closing windows
		} else if (gameHelp != null && gameHelp.btnBack.contains(e.getPoint())) {
			closeGameHelpView();

		} else if (gameRankingView != null && gameRankingView.btnBack.contains(e.getPoint())) {
			closeGameRankingView();

		} else if (currentNicknameView != null && currentNicknameView.btnBack.contains(e.getPoint())) {
			closeGameNicknameView();

		} else if (currentNicknameView != null && currentNicknameView.btnPlay.contains(e.getPoint())) {
			checkNickname();
		}
	}

	private void checkNickname() {
		nickname = currentNicknameView.txtNickname.getText();

		if (nickname.length() > 15 || nickname.length() < 3) {
			currentNicknameView.showErrorDialog();
		} else {
			// Start Game
			currentNicknameView.dispose();
			gameModel = new GamePlay_Model();
			gameFrameView = new GameFrame_View(gameModel);
			gameFrameView.addMouseListener(this);
			gameFrameView.addWindowListener(this);

			// Send player nickname to model
			gameModel.setPlayerName(nickname);
		}
	}

	private void openGameNicknameView() {
		gameMenu.setVisible(false);
		currentNicknameView = new GameNickname_View();
		currentNicknameView.addMouseListener(this);
		currentNicknameView.addWindowListener(this);
	}

	private void closeGameNicknameView() {
		if (currentNicknameView != null) {
			currentNicknameView.dispose();
			// Reset the reference to the GameHelp_View
			// Needed to fix a bug: Double Screen
			currentNicknameView = null;
			gameRankingView = null;
			gameHelp = null;
		}
		gameMenu.setVisible(true);
	}

	private void openGameHelpView() {
		gameMenu.setVisible(false);
		gameHelp = new GameHelp_View();
		gameHelp.addMouseListener(this);
		gameHelp.addWindowListener(this);
	}

	private void closeGameHelpView() {	
		if (gameHelp != null) {
			gameHelp.dispose();
			// Reset the reference to the GameHelp_View
			// Needed to fix a bug: Double Screen
			currentNicknameView = null;
			gameRankingView = null;
			gameHelp = null;
		}
		gameMenu.setVisible(true);
	}

	private void openGameRankingView() {
		gameMenu.setVisible(false);
		// Create instance of the model and pass the model to the view
		gameRankingModel = new GameRanking_Model(); 
		gameRankingView = new GameRanking_View(gameRankingModel); 
		gameRankingView.addMouseListener(this);
		gameRankingView.addWindowListener(this);
	}

	private void closeGameRankingView() {
		if (gameRankingView != null) {
			gameRankingView.dispose();
			// Reset the reference to the GameRanking_View
			// Needed to fix a bug: Double Screen
			currentNicknameView = null;
			gameRankingView = null;
			gameHelp = null;
		}
		gameMenu.setVisible(true);
	}



	/*
 public void saveNickname() {

		String playerNickname = nickname;
		System.out.println("Nickname controller: " + playerNickname);
		new GameScore_Model(nickname);
	}

 public void saveScore(int applesEaten) {

		int playerScore = applesEaten;
		System.out.println("Score controller: " + playerScore);
	}
	 */

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}

