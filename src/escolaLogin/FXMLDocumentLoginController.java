package escolaLogin;

import com.firebase.client.Firebase;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import notificacao.FXMLDocumentController;
import org.controlsfx.control.Notifications;

/**
 * @author douglas borges egidio
 */
public class FXMLDocumentLoginController implements Initializable {

    @FXML
    private AnchorPane anchorPanePrincipal;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private AnchorPane anchorPane3;

    @FXML
    private AnchorPane anchorPane4;

    @FXML
    private AnchorPane anchorPaneCadastro;

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private JFXTextField textFieldNomeUsuario;

    @FXML
    private JFXTextField textFieldSenhaLogin;

    @FXML
    private JFXTextField textFieldNomeUsuarioLogin;

    @FXML
    private Button buttonVoltarLogin;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private JFXTextField textFieldNomeCompleto;

    @FXML
    private JFXTextField textFieldSenha;

    @FXML
    private JFXTextField textFieldConfirmaSenha;

    @FXML
    private JFXTextField textFieldEmail;

    @FXML
    private JFXTextField textFieldNumeroTelefone;

    @FXML
    private JFXTextField textFieldDisciplina;

    @FXML
    void cadastrarProfessor(ActionEvent event) {

        ProfessorModel professorModel = new ProfessorModel();

        if (professorModel.getNomeCompleto() == null) {

        }

        Firebase firebase = new Firebase("https://dimtechcurso.firebaseio.com/");

        professorModel.setNomeCompleto(textFieldNomeCompleto.getText());
        professorModel.setNomeUsuario(textFieldNomeUsuario.getText());
        professorModel.setSenha(textFieldSenha.getText());
        professorModel.setConfirmasenha(textFieldConfirmaSenha.getText());
        professorModel.setEmail(textFieldEmail.getText());
        professorModel.setNumeroTelefone(textFieldNumeroTelefone.getText());
        professorModel.setDisciplina(textFieldDisciplina.getText());

        firebase.child("professor").child(professorModel.getNomeCompleto()).setValue(professorModel);

        textFieldNomeCompleto.setText("");
        textFieldNomeUsuario.setText("");
        textFieldSenha.setText("");
        textFieldConfirmaSenha.setText("");
        textFieldEmail.setText("");
        textFieldNumeroTelefone.setText("");
        textFieldDisciplina.setText("");

        textFieldNomeUsuarioLogin.setText(professorModel.getNomeUsuario());
        textFieldSenhaLogin.setText(professorModel.getSenha());

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), anchorPaneCadastro);
        translateTransition.setByX(600);
        translateTransition.play();

    }

    @FXML
    void mostrarPaginaCadastro(ActionEvent event) {

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), anchorPaneCadastro);
        translateTransition.setByX(-600);
        translateTransition.play();

    }

    @FXML
    void mostrarPaginaLogin(ActionEvent event) {

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), anchorPaneCadastro);
        translateTransition.setByX(600);
        translateTransition.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        anchorPane1.setStyle("-fx-background-image: url(\"/imagens/1.jpg\")");
        anchorPane2.setStyle("-fx-background-image: url(\"/imagens/2.jpg\")");
        anchorPane3.setStyle("-fx-background-image: url(\"/imagens/3.jpg\")");
        anchorPane4.setStyle("-fx-background-image: url(\"/imagens/4.jpg\")");

        addAnimacao();

        anchorPaneCadastro.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.1), anchorPaneCadastro);
        translateTransition.setByX(600);
        translateTransition.play();

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("");
//        alert.setHeaderText("");
//        alert.setContentText("");
//        alert.show();

        buttonCadastrar.setOnAction(a -> new meuDownload("Titulo","Este é o texto").start());
//        new meuDownload.setOnShown(a -> {
//            System.out.println("Showing");
//            Task<String> close = new Task<String>() {
//
//                @Override
//                protected String call() throws Exception {
//                    System.out.println("closing in 5s");
//                    Thread.sleep(5 * 1000);
//                    System.out.println("Alert Closed");
//                    return null;
//                }
//            };
//
//            close.setOnSucceeded(c -> {
//                alert.close();
////                alert.hide();
//            });
//            new Thread(close).start();
//        });

    }
    
    class meuDownload extends Thread {
    
    String Title;
    String Texto;

        public meuDownload(String Title, String Texto) {
            this.Title = Title;
            this.Texto = Texto;
        }
        
        @Override
        public void run() {

            try {
                Thread.sleep(500);//tempo para exibir a notificação(500 == meio segundo)
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Image img = new Image("/notificacao/imagem.png");

            Notifications notifications = Notifications.create()
                    .title(Title)
                    .text(Texto)
                    .graphic(new ImageView(img))//node
                    .hideAfter(Duration.seconds(5))//tempo de exibicão da notificacao.
                    .position(Pos.CENTER)
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

    private void addAnimacao() {

        FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), anchorPane4);
        fadeTransition0.setFromValue(1);
        fadeTransition0.setToValue(0);
        fadeTransition0.play();

        fadeTransition0.setOnFinished((event) -> {

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), anchorPane3);
            fadeTransition1.setFromValue(1);//faz a transição retrocedendo uma tela
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished((event1) -> {

                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), anchorPane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished((event2) -> {
//
//                    FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3), anchorPane1);
//                    fadeTransition3.setFromValue(1);
//                    fadeTransition3.setToValue(0);
//                    fadeTransition3.play();
//                    
//                    fadeTransition3.setOnFinished((event3) -> {
//
//                    FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3), anchorPane1);
//                    fadeTransition4.setFromValue(0);
//                    fadeTransition4.setToValue(1);
//                    fadeTransition4.play();

//                    fadeTransition2.setOnFinished((event4) -> {
                    FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(3), anchorPane2);
                    fadeTransition5.setFromValue(0);
                    fadeTransition5.setToValue(1);//faz a transição avançando uma tela.
                    fadeTransition5.play();

                    fadeTransition5.setOnFinished((event5) -> {

                        FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(3), anchorPane3);
                        fadeTransition6.setFromValue(0);
                        fadeTransition6.setToValue(1);
                        fadeTransition6.play();

                        fadeTransition6.setOnFinished((event6) -> {

                            FadeTransition fadeTransition7 = new FadeTransition(Duration.seconds(3), anchorPane4);
                            fadeTransition7.setFromValue(0);
                            fadeTransition7.setToValue(1);
                            fadeTransition7.play();

                            fadeTransition7.setOnFinished((event7) -> {
                                addAnimacao();
                            });

                        });
//                            });
//
                    });

                });

            });

        });

//        });
    }

}





