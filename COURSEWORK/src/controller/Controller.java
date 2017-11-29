package controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Optional;

public class Controller {

    private ListView<User> userList;
    private ListView<Score> scoreList;
    private ListView<Quiz> quizList;

    private DatabaseConnection database;
    private ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Score> allScores = new ArrayList<>();

    public Controller(ListView<User> userList, ListView<Score> scoreList, ListView<Quiz> quizList) {

        System.out.println("Initialising Main Controller...");

        this.userList = userList;
        this.scoreList = scoreList;
        this.quizList = quizList;

        database = new DatabaseConnection("/resources/quizdatabase.db");
        updateLists(0, 0);
    }

   @SuppressWarnings("Duplicates")
   public void updateLists(int selecteduserID, int selectedscoreID){

        allScores.clear();
        ScoreService.selectAll(allScores, database);
        scoreList.setItems(FXCollections.observableArrayList(allScores));

        userList.getItems().clear();
        UserService.selectAll(userList.getItems(), database);

       if (selecteduserID != 0) {
           for (int n = 0; n < userList.getItems().size(); n++) {
               if (userList.getItems().get(n).getUserID() == selecteduserID) {
                   userList.getSelectionModel().select(n);
                   userList.getFocusModel().focus(n);
                   userList.scrollTo(n);
                   break;
               }
           }
       }

       if (selectedscoreID != 0) {
           for (int n = 0; n < scoreList.getItems().size(); n++) {
               if (scoreList.getItems().get(n).getScoreID() == selectedscoreID) {
                   scoreList.getSelectionModel().select(n);
                   scoreList.getFocusModel().focus(n);
                   scoreList.scrollTo(n);
                   break;
               }
           }
       }



   }




    public static void exitPrompt(ActionEvent ae) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to exit?");

        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        } else {
            ae.consume();
        }

    }

    public static void doSomething(ActionEvent ae) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is not ready yet!!");
        alert.showAndWait();
    }

  /*  public void createnewScore() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input your username to add your score");
        dialog.setHeaderText(null);
        dialog.setContentText("Username:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent() && !result.get().equals("")){
            User newUser = new User(0, result.get());
            UserService.save(newUser, database);

            Score selectedScore = scoreList.getSelectionModel().getSelectedItem();
            updateLists(database.lastNewId(), selectedScore != null ? selectedScore.getId() : 0);
        }
        else {
            displayError("No name provided.");
        }

    }*/
}
