/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.mario.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import state.mario.boundary.FormSuperMarioStateController;

/**
 *
 * @author Fernando
 */
public class SuperMarioState extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/state/mario/boundary/FormSuperMarioState.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/state/mario/boundary/resources/Mushroom.png"))); // Seta Ícone
        stage.setTitle("Super Mario State !!!");

        FormSuperMarioStateController cController = fxmlLoader.<FormSuperMarioStateController>getController();
        cController.initData(stage);

        stage.setOnCloseRequest((WindowEvent t) -> {
            t.consume();
            stage.close();
            Platform.exit();
            System.exit(0);
        });

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
