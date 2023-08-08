package snakeGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameRanking_Model {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/snakemvc";
	String login = "snakemvc";
	String password = "SnakingSummer2023";

	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;

	public GameRanking_Model() {

		try {
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void getTopPlayers() {
        String name1 = "", name2 = "", name3 = "";
        int score1 = 0, score2 = 0, score3 = 0;
        String sentence = "SELECT * FROM snakemvc.ranking ORDER BY score_player DESC LIMIT 3";
        resultSet = null;

        try {
            resultSet = statement.executeQuery(sentence);
            int i = 1;
            while (resultSet.next() && i <= 3) {
                String nickname = resultSet.getString("nickname_player");
                int score = resultSet.getInt("score_player");
                
                if (i == 1) {
                    name1 = nickname;
                    score1 = score;
                } else if (i == 2) {
                    name2 = nickname;
                    score2 = score;
                } else if (i == 3) {
                    name3 = nickname;
                    score3 = score;
                }
                i++;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Store names and scores in the class variables
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    // Top 3 names and scores
    private String name1;
    private String name2;
    private String name3;
    private int score1;
    private int score2;
    private int score3;

    // Getter to access to them
    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }
}