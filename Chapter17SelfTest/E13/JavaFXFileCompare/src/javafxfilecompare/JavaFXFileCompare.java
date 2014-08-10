/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfilecompare;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Compares the content of two files.
 * <p>
 * This software is relies on the JavaFX framework that is used for the
 * graphical user interface and event handling.
 *
 * @author Henrik Samuelsson
 */
public class JavaFXFileCompare extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Setup of components.
        Label lblF1 = new Label("First file:");
        Label lblF2 = new Label("Second file:");
        TextField tfF1 = new TextField("");
        TextField tfF2 = new TextField("");
        Button btn = new Button("Compare");
        Label lbRes = new Label("Result: -");

        tfF1.setPromptText("Enter name of file.");
        tfF1.setOnAction((ActionEvent ae) -> {
            btn.fire();
        });

        tfF2.setPromptText("Enter name of file.");
        tfF2.setOnAction((ActionEvent ae) -> {
            btn.fire();
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                int i = 0, j = 0;

                if (tfF1.getText().equals("")) {
                    lbRes.setText("First file name is missing.");
                    return;
                }
                if (tfF2.getText().equals("")) {
                    lbRes.setText("Second file name is missing.");
                    return;
                }

                try (FileInputStream f1 = new FileInputStream(tfF1.getText());
                        FileInputStream f2 = new FileInputStream(tfF2.getText())) {
                    // Check the content of each file.
                    do {
                        i = f1.read();
                        j = f2.read();
                        if (i != j) {
                            break;
                        }
                    } while (i != -1 && j != -1);
                    if (i != j) {
                        lbRes.setText("File content is not equal.");
                    } else {
                        lbRes.setText("File content is equal.");
                    }
                } catch (IOException exc) {
                    lbRes.setText("File Error");
                }
            }
        });


        // Setup of a pane where the components will be placed.
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblF1, tfF1, lblF2, tfF2, btn, lbRes);

        // Setup of a scene.
        Scene scene = new Scene(root, 250, 200);

        // Setup of the stage.
        primaryStage.setTitle("JavaFX based file comparison");
        primaryStage.setScene(scene);
        btn.requestFocus();
        primaryStage.show();
    }

    /**
     * Entry point to application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
