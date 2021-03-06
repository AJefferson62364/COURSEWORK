package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuizService {

    public static void selectAll(List<Quiz> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT QuizID, DifficultyLevel FROM quizdatabase ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Quiz(results.getInt("QuizID"), results.getString("DifficultyLevel")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Quiz selectById(int id, DatabaseConnection database) {

        Quiz result = null;

        PreparedStatement statement = database.newStatement("SELECT QuizID, DifficultyLevel FROM Quiz WHERE QuizID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Quiz(results.getInt("QuizID"), results.getString("DifficultyLevel"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

}
