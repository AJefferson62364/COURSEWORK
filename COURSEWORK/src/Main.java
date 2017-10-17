import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javax.xml.soap.Text;
import java.io.FileInputStream;
import java.util.Optional;


public class Main extends Application {

    public static void doSomething(ActionEvent ae) {




        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is not ready yet!!");
        alert.showAndWait();
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

    public static GraphicsContext gc;
    @Override
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Saiyan-Sans.ttf"), 36);

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add("stylesheet.css");

        Canvas canvas = new Canvas();
        canvas.setWidth(768);
        canvas.setHeight(768);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();
        Image vegeta = new Image("vegeta.png");
        Image goku = new Image("goku.png");

        VBox topPane = new VBox(20);
        root.setTop(topPane);
        Label title = new Label("Dragon Ball Quiz");
        topPane.getChildren().add(title);
        title.getStyleClass().add("megatitle");
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        VBox leftPane = new VBox(20);
        gc.drawImage(goku, 50,100);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);

        VBox rightPane = new VBox(20);
        gc.drawImage(vegeta, 550,170);
        root.setLeft(rightPane);
        rightPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);

        VBox centerPane = new VBox(10);
        Button centerButton1 = new Button("START");
        centerButton1.getStyleClass().add("funky_button");
        centerButton1.setOnAction((ActionEvent ae) -> doSomething(ae));
        centerPane.getChildren().add(centerButton1);
        Button centerButton2 = new Button("VIEW HIGHSCORES");
        centerButton2.getStyleClass().add("funky_button");
        centerButton2.setOnAction((ActionEvent ae) -> doSomething(ae));
        centerPane.getChildren().add(centerButton2);
        Button centerButton3 = new Button("QUIT");
        centerButton3.getStyleClass().add("funky_button");
        centerButton3.setOnAction((ActionEvent ae) -> exitPrompt(ae));
        centerPane.getChildren().add(centerButton3);
        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
