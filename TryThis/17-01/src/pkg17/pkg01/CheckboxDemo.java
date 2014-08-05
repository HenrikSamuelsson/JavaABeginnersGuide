package pkg17.pkg01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates Check Boxes.
 */
public class CheckboxDemo extends Application {
    
    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;
    
    /**
     * Will report the state change of a check box.
     */
    Label response;
    
    /**
     * Create a label that will report all selected check boxes.
     */
    Label selected;
    
    String deviceListing;
    
    /**
     * Starts the JavaFX application by calling launch().
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
       
        // Give the stage a title.
        primaryStage.setTitle("Check Boxes Demo");
        
        // Use a vertical FlowPane for the root node and set some vertical and 
        // horizontal padding.
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        
        // Set the content to the left side but center it horizontally.
        rootNode.setPadding(new Insets(0, 0, 0, 10));
        rootNode.setAlignment(Pos.CENTER_LEFT);
        
        // Create a scene for the rootNode with a given size.
        Scene scene = new Scene(rootNode, 350, 200);
        
        // Set the scene on the stage.
        primaryStage.setScene(scene);
        
        // A label with intstructions to the user.
        Label heading = new Label("What Computers Do You Own?");
        
        // Create the other labels.
        response = new Label("");
        selected = new Label("");
        
        // Create the check boxes.
        cbSmartphone = new CheckBox("Smartphone");
        cbTablet = new CheckBox("Tablet");
        cbNotebook = new CheckBox("Notebook");
        cbDesktop = new CheckBox("Desktop");
        
        // Allow the smart phone check box to have a third, indeterminate state.
        cbSmartphone.setAllowIndeterminate(true);
        
        // Handling of action events for the check boxes.
        cbSmartphone.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbSmartphone.isIndeterminate())
                    response.setText("Smartphone state is indeterminate.");
                else if(cbSmartphone.isSelected())
                    response.setText("Smartphone was just selected.");
                else
                    response.setText("Smartphone was just cleared.");
                
                showAll();
            }
        });
        
        cbTablet.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbTablet.isSelected())
                    response.setText("Tablet was just selected.");
                else
                    response.setText("Tablet was just cleared.");
                
                showAll();
            }
        });
        
        cbNotebook.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbNotebook.isSelected())
                    response.setText("Notebook was just selected.");
                else
                    response.setText("Notebook was just cleared.");
                
                showAll();
            }
        });
        
        cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbDesktop.isSelected())
                    response.setText("Desktop was just selected.");
                else
                    response.setText("Desktop was just cleared.");
                
                showAll();
            }
        });
        
        // Add controls to the scene graph.
        rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet, 
                cbNotebook, cbDesktop, response, selected);
        
        primaryStage.show();
        
        showAll();
    }
    
    /**
     * Checks current selections and reports the result in the GUI.
     */
    void showAll() {
        deviceListing = "";
        if(cbSmartphone.isSelected()) deviceListing += "Smartphone ";
        if(cbTablet.isSelected()) deviceListing += "Tablet ";
        if(cbNotebook.isSelected()) deviceListing += "Notebook ";
        if(cbDesktop.isSelected()) deviceListing += "Desktop ";
        
        selected.setText("Devices selected: " + deviceListing);
    }
}
