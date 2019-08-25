package util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import login.LoginMetodos;

/**
 * @author douglas bOrges egidio
 * @author DIMTech
 * @since 22/08/2019
 */
public class CarregarPagina {
    
    public void carregarPagina(String nomeCaminho) {
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
