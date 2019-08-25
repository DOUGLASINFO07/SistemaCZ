package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Douglas Borges Egidio
 * @author DouglasINFO07
 * @since 22/08/2019.
 */
public class LoginMetodos extends Application {

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
        stage2.setFullScreen(true);
        stage2.show();

    }//Fim do métod start().

}
