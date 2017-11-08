package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionsService {

    public static void selectAll(List<Questions> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT QuestionID, Question, Answer, QuizID FROM quizdatabase ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Questions(results.getInt("QuestionID"), results.getString("Question"), results.getString("Answer"), results.getInt("QuizID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Questions selectById(int id, DatabaseConnection database) {

        Questions result = null;

        PreparedStatement statement = database.newStatement("SELECT QuestionID, Question, Answer, QuizID FROM Questions WHERE QuestionID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Questions(results.getInt("QuestionID"), results.getString("Question"), results.getString("Answer"), results.getInt("QuizID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }




}
