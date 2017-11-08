package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public static void selectAll(List<User> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT UserID, Username FROM quizdatabase ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Score(results.getInt("UserID"), results.getString("Username")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static User selectById(int id, DatabaseConnection database) {

        User result = null;

        PreparedStatement statement = database.newStatement("SELECT UserID, Username FROM Questions WHERE UserID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new User(results.getInt("UserID"), results.getString("Username"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(User itemToSave, DatabaseConnection database) {

        User existingItem = null;
        if (itemToSave.getUserID() != 0) existingItem = selectById(itemToSave.getUserID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO quizdatabase (userID, Username) VALUES (?, ?))");
                statement.setInt(1, itemToSave.getUserID());
                statement.setString(2, itemToSave.getUsername());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE quizdatabase SET userID = ?, Username = ? WHERE UserID = ?");
                statement.setString(1, itemToSave.getUserID());
                statement.setString(2, itemToSave.getUsername());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

