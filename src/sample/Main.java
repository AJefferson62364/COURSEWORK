package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        Button startQuiz = new Button("Start");
        startQuiz.setPrefSize(100, 35);
        root.getChildren().add(startQuiz);

        Button viewScores = new Button("View Scores");
        viewScores.setPrefSize(100, 35);
        root.getChildren().add(viewScores);


        Button exitButton = new Button("Quit");
        exitButton.setPrefSize(100, 35);
        exitButton.setOnAction((ActionEvent ae) -> exitPrompt(ae));
        root.getChildren().add(exitButton);


        Scene scene = new Scene(root, 768, 768);

        stage.setTitle("QUIZ");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

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




    public static void main(String[] args) {
        launch(args);
    }
}
