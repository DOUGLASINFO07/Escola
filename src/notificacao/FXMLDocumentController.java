/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificacao;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author dougl
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        new meuDownload().start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    class meuDownload extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(1000);//tempo para exibir a notificação
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Image img = new Image("/notificacao/imagem.png");

            Notifications notifications = Notifications.create()
                    .title("Download Completo.")
                    .text("Salvo na pasta de downloads.")
                    .graphic(new ImageView(img))//node
                    .hideAfter(Duration.seconds(5))//tempo de exibicão da notificacao.
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Houve um clic na notificação!");
                        }
                    });
            notifications.darkStyle();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    notifications.show();//O método deverá ser show, quiser usar uma imagem propria.
//        notifications.showConfirm();
//        notifications.showError();
                }
            });

        }

    }

}

