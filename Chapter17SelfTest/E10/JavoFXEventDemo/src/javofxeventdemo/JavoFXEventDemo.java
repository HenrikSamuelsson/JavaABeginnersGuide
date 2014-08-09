package javofxeventdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Demonstrates JavaFX events and buttons.
 */
public class JavoFXEventDemo extends Application {
    Label response;
    
     /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Use JavaFX Buttons and Events.");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 100);
        primaryStage.setScene(myScene);
        response = new Label("Push a Button");
        
        // Setup the buttons.
        Button btnUp = new Button("Run");
        Button btnExit = new Button("Exit");
        btnUp.setOnAction((ActionEvent ae) -> {
            response.setText("You pressed Run");
        });
        btnExit.setOnAction((ActionEvent ae) -> {
            Platform.exit();
        });
        
        rootNode.getChildren().addAll(btnUp, btnExit, response);
        primaryStage.show();
    }
}
