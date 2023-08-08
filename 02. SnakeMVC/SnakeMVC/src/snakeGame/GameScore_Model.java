package snakeGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameScore_Model {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/snakemvc";
	String login = "snakemvc";
	String password = "SnakingSummer2023";

	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;

	private String playerName;
	private int applesEaten;

	public GameScore_Model(String playerName, int applesEaten) {

		this.playerName = playerName;
		this.applesEaten = applesEaten;

		try {
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}


	public void saveScoreToDatabase() {

		String nickname_player = playerName;
		int score_player = applesEaten;

		String sentence = "INSERT INTO snakemvc.ranking (nickname_player, score_player) VALUES (?, ?)";
		resultSet = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sentence);
			preparedStatement.setString(1, nickname_player);
			preparedStatement.setInt(2, score_player);

			// Execute the insert statement
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data has been saved successfully into DB.");
			} else {
				System.out.println("Could not save Data to DB.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("The connection has been closed successfully.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}