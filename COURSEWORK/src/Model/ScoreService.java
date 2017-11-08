package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScoreService {

    public static void selectAll(List<Score> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT ScoreID, Score, UserID, QuizID FROM quizdatabase ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Score(results.getInt("ScoreID"), results.getInt("Score"), results.getInt("UserID"), results.getInt("QuizID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Score selectById(int id, DatabaseConnection database) {

        Score result = null;

        PreparedStatement statement = database.newStatement("SELECT ScoreID, Score, UserID, QuizID FROM Questions WHERE ScoreID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Score(results.getInt("ScoreID"), results.getInt("Score"), results.getInt("UserID"), results.getInt("QuizID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void save(Score itemToSave, DatabaseConnection database) {

        Score existingItem = null;
        if (itemToSave.getScoreID() != 0) existingItem = selectById(itemToSave.getScoreID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO quizdatabase (ScoreID, Score, UserID, QuizID c) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getScoreID());
                statement.setInt(2, itemToSave.getScore());
                statement.setInt(3, itemToSave.getUserID());
                statement.setInt(4, itemToSave.getQuizID());
                database.executeUpdate(statement);
            } else {
                PreparedStatement statement = database.newStatement("UPDATE quizdatabase SET ScoreID = ?, Score = ?, UserID = ?, QuizID = ? WHERE ScoreID = ?");
                statement.setInt(1, itemToSave.getScoreID());
                statement.setInt(2, itemToSave.getScore());
                statement.setInt(3, itemToSave.getUserID());
                statement.setInt(4, itemToSave.getQuizID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}

