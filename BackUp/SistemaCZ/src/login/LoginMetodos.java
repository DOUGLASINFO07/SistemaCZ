package login;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import menu.MenuMetodos;

/**
 * @author douglas borges egidio
 **/

public class LoginMetodos extends Application {

    //INICIO DO CONJUNTO DE MÉTODOS PARA ABRIR TELA MENU.
    static Stage stage;

    public Stage getStage() {
        return stage;
    }//Fim do método

    public void setStage(Stage stage) {
        LoginMetodos.stage = stage;
    }//Fim do método setStage().

    public static void main(String[] args) {
        launch(args);
    }//Fim do método main.
    
     public void fecharLogin() {
        getStage().close();
    }//FIM DO MÉTODO.

    @Override
    public void start(Stage stage2) throws Exception{
        Parent root2 = null;
        try{
        root2 = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
//        Scene scene2 = new Scene(root);
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        stage2.setTitle("Sistema Gerenciamento de Controle de Zoonoses - Tela de Login");
        stage2.setFullScreen(true);
        stage2.setScene(new Scene(root2));
        stage2.show();
        setStage(stage2);
        }catch(IOException ex){
            Logger.getLogger(LoginMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.gc();
        this.stop();
    }//Fim do métod start().
    //FIM DO CONJUNTO DE MÉTODO PARA ABRIR TELA MENU.

}
