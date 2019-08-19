package login;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.MenuMetodos;

public class LoginControllerFXML implements Initializable {

    @FXML
    private Button sairBT;

    @FXML
    private TextField usuarioTF;

    @FXML
    private PasswordField senhaTF;

    @FXML
    private Button acessarBT;

    static Stage stage;

    public Stage getStage() {
        return stage;
    }//Fim do método

    public void setStage(Stage stage) {
        LoginControllerFXML.stage = stage;
    }//Fim do método setStage().

    public void fecharMenu() throws Throwable {
        getStage().close();
        this.finalize();
    }//FIM DO MÉTODO.

    @FXML
    void acessarBTMouse(MouseEvent event) throws Exception {

        LoginDAO dao = new LoginDAO();

        LoginAtributos LA = new LoginAtributos();

        MenuMetodos menu = new MenuMetodos();

        dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

        if (LA.getContagem() > 0) {
            carregarPagina("/menu/Menu.fxml");
//            Stage stage = new Stage();
//            menu.start(stage);
//            acessarBT.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("CONTROLE DE ZOONOSES");
            alert.setHeaderText("NÃO FOI POSSÍVEL REALIZAR O LOGIN!!");
            alert.setContentText("CONFIRA USUARIO E SENHA!!!");
            alert.showAndWait();

            usuarioTF.selectAll();
            senhaTF.setText("");

            Platform.runLater(usuarioTF::requestFocus);
        }
    }

    @FXML
    void acessarBTteclado(KeyEvent event) {

        LoginDAO dao = new LoginDAO();

        LoginAtributos LA = new LoginAtributos();

        MenuMetodos menu = new MenuMetodos();

        dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

        if (LA.getContagem() > 0) {

//            Stage stage = new Stage();
//            if (event.getCode() == KeyCode.ENTER) {
//                menu.start(stage);
//                acessarBT.getScene().getWindow().hide();
//            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("CONTROLE DE ZOONOSES");
            alert.setHeaderText("NÃO FOI POSSÍVEL REALIZAR O LOGIN!!");
            alert.setContentText("CONFIRA USUARIO E SENHA!!!");
            alert.showAndWait();

            usuarioTF.selectAll();
            senhaTF.setText("");

            Platform.runLater(usuarioTF::requestFocus);
        }
    }

    @FXML
    void sairBTMouse(MouseEvent event) {
        LoginMetodos LM = new LoginMetodos();

        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("CONTROLE DE ZOONOSES");

        alert.setContentText("TEM CERTEZA QUE DESEJA FECHAR O SISTEMA?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            LM.fecharLogin();
        } else if (result.get() == buttonTypeTwo) {

        }

    }

    @FXML
    void sairBTTeclado(KeyEvent event) {
        LoginMetodos LM = new LoginMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("CONTROLE DE ZOONOSES");
            alert.setContentText("TEM CERTEZA QUE DESEJA FECHAR O SISTEMA?");

            ButtonType buttonTypeOne = new ButtonType("Sim");
            ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                LM.fecharLogin();
            } else if (result.get() == buttonTypeTwo) {

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarioTF.setText("douglas");
        senhaTF.setText("123");
        Platform.runLater(usuarioTF::requestFocus);
    }

    @FXML
    void senhaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            LoginDAO dao = new LoginDAO();

            LoginAtributos LA = new LoginAtributos();

            MenuMetodos menu = new MenuMetodos();

            dao.buscarDadosLogin(usuarioTF.getText(), senhaTF.getText(), LA);

            if (LA.getContagem() > 0) {

//                Stage stage = new Stage();
//
//                menu.start(stage);
//                acessarBT.getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CONTROLE DE ZOONOSES");
                alert.setHeaderText("NÃO FOI POSSÍVEL REALIZAR O LOGIN!!");
                alert.setContentText("CONFIRA USUARIO E SENHA!!!");
                alert.showAndWait();

                usuarioTF.selectAll();
                senhaTF.setText("");

                Platform.runLater(usuarioTF::requestFocus);
            }
        }
    }

    private void carregarPagina(String nomeCaminho) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeCaminho));
            AnchorPane newAnchorPane = loader.load();
            
            Scene mainsScene = LoginMetodos.getMainScene();
            
            AnchorPane anchorPaneLogin = (AnchorPane) mainsScene.getRoot();
            anchorPaneLogin.getChildren().clear();
            anchorPaneLogin.getChildren().addAll(newAnchorPane.getChildren());
            
            
        } catch (IOException e) {
            System.out.println("Erro ao carregar pagina.");
        }
    }

}
