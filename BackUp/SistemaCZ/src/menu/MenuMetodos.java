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

public class MenuMetodos extends Application{

    //INICIO DO CONJUNTO DE MÉTODOS PARA ABRIR TELA MENU.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }//Fim do método

    public void setStage(Stage stage) {
        MenuMetodos.stage = stage;
    }//Fim do método setStage().

    public static void main(String[] args) {
        launch(args);
    }//Fim do método main.

    @Override
    public void start(Stage stage){
       Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/menu/Menu.fxml"));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
            Scene scene = new Scene(root);
            stage.setTitle("Sistema Gerenciamento de Controle de Zoonoses");
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
            setStage(stage);
        } //Fim do métod start().
        catch (IOException ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //FIM DO CONJUNTO DE MÉTODO PARA ABRIR TELA MENU.

    //MÉTODO QUE FECHA A TELA MENU.
    public void fecharMenu() {
        getStage().close();
    }//FIM DO MÉTODO.

    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirFuncionario() throws Exception {
        FuncionarioMetodo FM = new FuncionarioMetodo();
        try {
           FM.start(new Stage());
            fecharMenu();
        } catch (IOException ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirLocalidade() {
        LocalidadeMetodo LM = new LocalidadeMetodo();
        try {
            LM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirQuarteirao() {
        QuarteiraoMetodos QM = new QuarteiraoMetodos();
        try {
            QM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirAtividades() {
        AtividadesMetodos AM = new AtividadesMetodos();
        try {
            AM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    //MÉTODO QUE ABRE A TELA USUÁRIO.
    public void abrirLancamentoTratamentoFocal() {
        ServicoTratamentoFocalMetodos STF = new ServicoTratamentoFocalMetodos();
        try {
            STF.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void abrirDenuncia() {
        DenunciasMetodos DM = new DenunciasMetodos();
        try {
            DM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void abrirRelatorioFuncionario() {
        RelatorioFuncionarioMetodo RFM = new RelatorioFuncionarioMetodo();
        try {
            RFM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void abrirRelatorioLocalidade() {
        RelatorioLocalidadeMetodo RLM = new RelatorioLocalidadeMetodo();
        try {
            RLM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void abrirRelatorioQuarteirao() {
        RelatorioQuarteiraoMetodo RQM = new RelatorioQuarteiraoMetodo();
        try {
            RQM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void abrirRelatorioAtividades() {
        RelatorioAtividadesMetodo RAM = new RelatorioAtividadesMetodo();
        try {
            RAM.start(new Stage());
            fecharMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
//    MÉTODO QUE ABRE A TELA Empresa.
//    public void abrirEmpresa() {
//        Empresa empresa = new Empresa();
//        try {
//            empresa.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//
//    ////MÉTODO QUE ABRE A TELA Empresa.
//    public void abrirSalario() {
//        Salario salario = new Salario();
//        try {
//            salario.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
// 
//     ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirBoleto() {
//        Boleto boleto = new Boleto();
//        try {
//            boleto.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//    
//    ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirPagarBoleto() {
//        PagarBoleto pagarBoleto = new PagarBoleto();
//        try {
//            pagarBoleto.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//    
//    ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirUsuarioRelatorio() {
//        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();
//        try {
//            usuarioRelatorio.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(UsuarioRelatorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//    
//    ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirEmpresaRelatorio() {
//        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();
//        try {
//            empresaRelatorio.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(EmpresaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//    
//    ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirSalarioRelatorio() {
//        SalarioRelatorio salarioRelatorio = new SalarioRelatorio();
//        try {
//            salarioRelatorio.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(SalarioRelatorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
//    ////MÉTODO QUE ABRE A TELA Boleto.
//    public void abrirBoletoRelatorio() {
//        BoletoRelatorio boletoRelatorio = new BoletoRelatorio();
//        try {
//            boletoRelatorio.start(new Stage());
//        } catch (Exception ex) {
//            Logger.getLogger(SalarioRelatorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.

//    //INICIO DOS METODOS ABRIRPANES, DEIXA AS PANES VISIVEIS OU INVISIVEIS
//    //DE ACORDO COM AS AÇÕES DOS BOTÕES.
//    public void abrirPaneCadastrar(
//            Pane cadastrar,
//            Pane boleto,
//            Pane relatorio,
//            Pane sair,
//            Pane utilitario
//    ) {
//        cadastrar.setVisible(true);
//        boleto.setVisible(false);
//        relatorio.setVisible(false);
//        sair.setVisible(false);
//        utilitario.setVisible(false);
//    }
//
//    public void abrirPaneSair(
//            Pane cadastrar,
//            Pane boleto,
//            Pane relatorio,
//            Pane sair,
//            Pane utilitario
//    ) {
//        cadastrar.setVisible(false);
//        boleto.setVisible(false);
//        relatorio.setVisible(false);
//        sair.setVisible(true);
//        utilitario.setVisible(false);
//    }
//
//    public void abrirPaneBoleto(
//            Pane cadastrar,
//            Pane boleto,
//            Pane relatorio,
//            Pane sair,
//            Pane utilitario
//    ) {
//        cadastrar.setVisible(false);
//        boleto.setVisible(true);
//        relatorio.setVisible(false);
//        sair.setVisible(false);
//        utilitario.setVisible(false);
//    }
//
//    public void abrirPaneRelatorio(
//            Pane cadastrar,
//            Pane boleto,
//            Pane relatorio,
//            Pane sair,
//            Pane utilitario
//    ) {
//        cadastrar.setVisible(false);
//        boleto.setVisible(false);
//        relatorio.setVisible(true);
//        sair.setVisible(false);
//        utilitario.setVisible(false);
//    }
//
//    public void abrirPaneUtilitario(
//            Pane cadastrar,
//            Pane boleto,
//            Pane relatorio,
//            Pane sair,
//            Pane utilitario
//    ) {
//        cadastrar.setVisible(false);
//        boleto.setVisible(false);
//        relatorio.setVisible(false);
//        sair.setVisible(false);
//        utilitario.setVisible(true);
//    }//FIM DOS MÉTODO ABRIRPANES.

}
