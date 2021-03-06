package resources;

import Model.DatabaseConnection;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ActualQuiz {

    static Pane parent;

    public ActualQuiz(Pane theParent) {
        Stage stage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(stage);
    }

    public static DatabaseConnection database;


    public void start(Stage stage) {

        database = new DatabaseConnection("/Docs/College/Computing/COURSEWORK/COURSEWORK/src/resources/quizdatabase.db");

        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Saiyan-Sans.ttf"), 36);

        Pane root = new Pane();
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add("/resources/stylesheet.css");
        stage.setTitle("The Quiz");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
        stage.show();
        new quizzle();

    }







    public void closeStage(Stage stage){

        parent.setDisable(false);
        stage.close();
    }
}
