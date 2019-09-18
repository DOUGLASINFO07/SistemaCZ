package menu;

import atividades.AtividadesMetodos;
import denuncia.DenunciasMetodos;
import funcionarios.FuncionarioMetodo;
import relatorioFuncionario.RelatorioFuncionarioMetodo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import localidades.LocalidadeMetodo;
import quarteirao.QuarteiraoMetodos;
import relatorioAtividades.RelatorioAtividadesMetodo;
import relatorioLocalidade.RelatorioLocalidadeMetodo;
import relatorioQuarteirao.RelatorioQuarteiraoMetodo;
import servicoTratamentoFocal.ServicoTratamentoFocalMetodos;

/**
 * @author douglas borges egidio
 */
public class MenuMetodos {

    private static Scene mainScene;

//    //INICIO DO CONJUNTO DE MÉTODOS PARA ABRIR TELA MENU.
//    private static Stage stage;
//
//    public Stage getStage() {
//        return stage;
//    }//Fim do método
//
//    public void setStage(Stage stage) {
//        MenuMetodos.stage = stage;
//    }//Fim do método setStage().
//
//    public static void main(String[] args) {
//        launch(args);
//    }//Fim do método main.

//    @Override
//    public void start(Stage stage) throws IOException {
//////       Parent root = null;
//////        try {
//////            root = FXMLLoader.load(getClass().getResource("/menu/Menu.fxml"));
//////            stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
//////            Scene scene = new Scene(root);
//////            stage.setTitle("Sistema Gerenciamento de Controle de Zoonoses");
//////            stage.setFullScreen(true);
//////            stage.setScene(scene);
//////            stage.show();
//////            setStage(stage);
//////        } //Fim do métod start().
//////        catch (IOException ex) {
//////            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
//////        }
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu/Menu.fxml"));
////        AnchorPane newAnchorPane = loader.load();
////
////        mainScene = new Scene(newAnchorPane);
////        stage.setTitle("Sistema Gerenciamento de Controle de Zoonoses - Tela de Login");
////        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
////        stage.setScene(mainScene);
////        stage.setFullScreen(true);
////        stage.show();
//    }
    //FIM DO CONJUNTO DE MÉTODO PARA ABRIR TELA MENU.

//    //MÉTODO QUE FECHA A TELA MENU.
//    public void fecharMenu() {
//        getStage().close();
//    }//FIM DO MÉTODO.

    //MÉTODO QUE ABRE A TELA USUÁRIO.
//    public void abrirFuncionario() throws Exception {
//
////        FuncionarioMetodo FM = new FuncionarioMetodo();
////        try {
////           FM.start(new Stage());
////            fecharMenu();
////        } catch (IOException ex) {
////            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }//FIM DO MÉTODO.

//    //MÉTODO QUE ABRE A TELA USUÁRIO.
//    public void abrirLocalidade() {
//        LocalidadeMetodo LM = new LocalidadeMetodo();
//        try {
//            LM.start(new Stage());
//            fecharMenu();
//        } catch (Exception ex) {
//            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.

//    //MÉTODO QUE ABRE A TELA USUÁRIO.
//    public void abrirQuarteirao() {
//        QuarteiraoMetodos QM = new QuarteiraoMetodos();
//        try {
////            QM.start(new Stage());
////            fecharMenu();
//        } catch (Exception ex) {
//            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.

//    //MÉTODO QUE ABRE A TELA USUÁRIO.
//    public void abrirAtividades() {
//        AtividadesMetodos AM = new AtividadesMetodos();
//        try {
////            AM.start(new Stage());
////            fecharMenu();
//        } catch (Exception ex) {
//            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.

    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirLancamentoTratamentoFocal() {
        ServicoTratamentoFocalMetodos STF = new ServicoTratamentoFocalMetodos();
        try {
            STF.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void abrirDenuncia() {
        DenunciasMetodos DM = new DenunciasMetodos();
        try {
            DM.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void abrirRelatorioFuncionario() {
        RelatorioFuncionarioMetodo RFM = new RelatorioFuncionarioMetodo();
        try {
            RFM.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void abrirRelatorioLocalidade() {
        RelatorioLocalidadeMetodo RLM = new RelatorioLocalidadeMetodo();
        try {
            RLM.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void abrirRelatorioQuarteirao() {
        RelatorioQuarteiraoMetodo RQM = new RelatorioQuarteiraoMetodo();
        try {
            RQM.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void abrirRelatorioAtividades() {
        RelatorioAtividadesMetodo RAM = new RelatorioAtividadesMetodo();
        try {
            RAM.start(new Stage());
//            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public static Scene getMainScene() {
        return mainScene;
    }

}
