package login;

import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import util.CarregarPagina;

/**
 * @author Douglas Borges Egidio
 * @author DouglasINFO07
 * @since 22/08/2019.
 */
public class LoginMetodos extends Application {

    CarregarPagina cp = new CarregarPagina();

    private static Scene mainScene;

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void main(String[] args) {
        launch(args);
    }//Fim do método main.

    @Override
    public void start(Stage stage2) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/Login.fxml"));
        AnchorPane newAnchorPane = loader.load();

        mainScene = new Scene(newAnchorPane);
        stage2.setTitle("SISTEMA DE GERENCIAMENTO E CONTROLE DE ZOONOSES");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        stage2.setScene(mainScene);
//        stage2.setFullScreen(true);
        stage2.setMaximized(true);

        stage2.initStyle(StageStyle.UNDECORATED);

        stage2.show();

        stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Image img = new Image("imagens/iconeSistemaCZ100x100.png");

                javafx.scene.control.Alert alert4 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
                alert4.setTitle("SISTEMACZ");
                alert4.setContentText("O que deseja fazer?");
                alert4.setGraphic(new ImageView(img));
                alert4.setHeaderText("SISTEMA DE GERENCIAMENTO E CONTROLE DE ZOONOSES");
                alert4.setResizable(true);
                alert4.getDialogPane().setPrefSize(480, 270);

                DialogPane dialogPane = alert4.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/css/Alerts.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog-Pane");

                ButtonType buttonTypeSair = new ButtonType("Sair");
                ButtonType buttonTypeDeslogar = new ButtonType("Deslogar");
                ButtonType buttonTypeCancela = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert4.getButtonTypes()
                        .setAll(
                                buttonTypeSair,
                                buttonTypeDeslogar,
                                buttonTypeCancela
                        );

                Optional<ButtonType> resultado = alert4.showAndWait();
                if (resultado.get().getText() == "Sair") {
                    System.exit(0);
                } else if (resultado.get().getText() == "Deslogar") {
                    event.consume();
                    cp.carregarPagina("/login/Login.fxml");
                } else {
                    event.consume();
                }
            }
        });

    }//Fim do métod start().

}
