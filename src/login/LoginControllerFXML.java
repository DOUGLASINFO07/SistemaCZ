package login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.CarregarPagina;
import util.Notificacao;
import util.Relogio;

public class LoginControllerFXML implements Initializable {

    @FXML
    private TextField usuarioTF;

    @FXML
    private Label dataLabel;

    @FXML
    private Label horaLabel;

    @FXML
    private PasswordField senhaTF;

    @FXML
    void acessarBTMouse(MouseEvent event) throws Exception {

        LoginDAO dao = new LoginDAO();

        LoginAtributos LA = new LoginAtributos();

        CarregarPagina cp = new CarregarPagina();

        dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

        if (LA.getContagem() > 0) {

            cp.carregarPagina("/menu/Menu.fxml");

        } else {

            Notificacao notificacao = new Notificacao("ERRO AO LOGAR",
                    "   Não foi possível realizar o login!!\n"
                    + "   Confira o Usuario e senha!",
                    "imagens/iconeSistemaCZ.png");

            notificacao.start();

            usuarioTF.selectAll();
            senhaTF.setText("");

            Platform.runLater(usuarioTF::requestFocus);
        }
    }

    @FXML
    void acessarBTteclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            LoginDAO dao = new LoginDAO();

            LoginAtributos LA = new LoginAtributos();

            CarregarPagina cp = new CarregarPagina();

            dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

            if (LA.getContagem() > 0) {
                cp.carregarPagina("/menu/Menu.fxml");
            } else {
                Notificacao notificacao = new Notificacao("CONTROLE DE ZOONOSES",
                        "NÃO FOI POSSÍVEL REALIZAR O LOGIN!!\n"
                        + "CONFIRA USUARIO E SENHA!!!",
                        "imagens/iconeSistemaCZ.png");
                notificacao.start();

                usuarioTF.selectAll();
                senhaTF.setText("");

                Platform.runLater(usuarioTF::requestFocus);
            }
        }
    }

    @FXML
    void sairBTMouse(MouseEvent event) {

        Image img = new Image("imagens/iconeSistemaCZ100x100.png");

        javafx.scene.control.Alert alert4 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert4.setTitle("SISTEMACZ");
        alert4.setContentText("Deseja realmente sair do sistemaCZ?");
        alert4.setGraphic(new ImageView(img));
        alert4.setHeaderText("SISTEMA DE GERENCIAMENTO E CONTROLE DE ZOONOSES");
        alert4.setResizable(true);
        alert4.getDialogPane().setPrefSize(480, 270);

        DialogPane dialogPane = alert4.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/css/Alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog-Pane");

        ButtonType buttonTypeOk = new ButtonType("OK");
        ButtonType buttonTypeCancela = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert4.getButtonTypes()
                .setAll(
                        buttonTypeOk,
                        buttonTypeCancela
                );

        Optional<ButtonType> resultado = alert4.showAndWait();
        if (resultado.get().getText() == "OK") {
            System.exit(0);
        } else {
            //Fecha a JANELA DO ALERT.
        }

    }

    @FXML
    void sairBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Image img = new Image("imagens/iconeSistemaCZ100x100.png");

            javafx.scene.control.Alert alert4 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert4.setTitle("SISTEMACZ");
            alert4.setContentText("Deseja realmente sair do sistemaCZ?");
            alert4.setGraphic(new ImageView(img));
            alert4.setHeaderText("SISTEMA DE GERENCIAMENTO E CONTROLE DE ZOONOSES");
            alert4.setResizable(true);
            alert4.getDialogPane().setPrefSize(480, 270);

            DialogPane dialogPane = alert4.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/css/Alerts.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog-Pane");

            ButtonType buttonTypeOk = new ButtonType("OK");
            ButtonType buttonTypeCancela = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert4.getButtonTypes()
                    .setAll(
                            buttonTypeOk,
                            buttonTypeCancela
                    );

            Optional<ButtonType> resultado = alert4.showAndWait();
            if (resultado.get().getText() == "OK") {
                System.exit(0);
            } else {
                //Fecha a JANELA DO ALERT.
            }
        }
    }

    @FXML
    void senhaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            LoginDAO dao = new LoginDAO();

            LoginAtributos LA = new LoginAtributos();

            CarregarPagina cp = new CarregarPagina();

            dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

            if (LA.getContagem() > 0) {
                cp.carregarPagina("/menu/Menu.fxml");
            } else {
                Notificacao notificacao = new Notificacao("CONTROLE DE ZOONOSES",
                        "NÃO FOI POSSÍVEL REALIZAR O LOGIN!!\n"
                        + "CONFIRA USUARIO E SENHA!!!",
                        "imagens/iconeSistemaCZ.png");
                notificacao.start();

                usuarioTF.selectAll();
                senhaTF.setText("");

                Platform.runLater(usuarioTF::requestFocus);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarioTF.setText("douglas");
        senhaTF.setText("123");
        Platform.runLater(usuarioTF::requestFocus);

        Relogio relogio1 = new Relogio(horaLabel);
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date1 = new Date();
        dataLabel.setTextFill(Color.GRAY);
        dataLabel.setText("Hoje é " + sdf1.format(date1) + " - Seja Bem Vindo!");
        try {
            relogio1.relogio();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

        System.gc();

    }
}
