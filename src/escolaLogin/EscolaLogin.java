/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escolaLogin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author dougl
 */

public class EscolaLogin extends Application {
    
    Stage loginStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.loginStage = stage;
        abrirTelaLogin();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }

    private void abrirTelaLogin() {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/escolaLogin/FXMLDocumentLogin.fxml"));
            AnchorPane anchorpane = fXMLLoader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add(getClass().getResource("/style/styleSheet.css").toExternalForm());
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException ex) {
            Logger.getLogger(EscolaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}





