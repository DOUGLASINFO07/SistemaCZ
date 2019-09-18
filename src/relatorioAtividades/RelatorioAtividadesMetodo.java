package relatorioAtividades;

import relatorioAtividades.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import menu.MenuMetodos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;
import util.Utilitario;

/**
 * @author douglas borges egidio
 * @since 03/03/2019
 */
public class RelatorioAtividadesMetodo extends Application {

    Connection conn;

    Utilitario util = new Utilitario();

    MenuMetodos menuMetodos = new MenuMetodos();

    RelatorioAtividadesAtributos RAA = new RelatorioAtividadesAtributos();

    public RelatorioAtividadesMetodo() {
    }

    public RelatorioAtividadesMetodo(int posicao, String pesquisarPor) {
        RAA.setPesquisarPor(pesquisarPor);
    }

    @Override
    public String toString() {
        return RAA.getPesquisarPor();
    }

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/relatorioAtividades/RelatorioAtividades.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Atividadess");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharRelatorioAtividades() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
//            menuMetodos.start(new Stage());
            fecharRelatorioAtividades();
        } catch (Exception ex) {
            Logger.getLogger(RelatorioAtividadesMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button voltarMenuBT,
            Label dataLB,
            Label horasLB,
            ComboBox pesquisarPorCB,
            Button pesquisarBT,
            Button imprimirBT,
            TableView relatorioPesquisaTV,
            TableColumn tipoAtividadesCT,
            TableColumn dataInicalCT,
            TableColumn dataTermino,
            TableColumn cicloCT
    ) {
        pesquisarPorCB.setValue("PESQUISAR POR");
        imprimirBT.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn tipoAtividadesCT,
            TableColumn dataInicalCT,
            TableColumn dataTerminoCT,
            TableColumn cicloCT,
            TableView relatorioPesquisaTV,
            ComboBox pesquisarPorCB
    ) {
        String pesquisarPor = null;
        if (!pesquisarPorCB.getSelectionModel().getSelectedItem().toString().equals("PESQUISAR POR")) {
            pesquisarPor = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();

            tipoAtividadesCT.setCellValueFactory(new PropertyValueFactory("tipoAtividadeCT"));
            dataInicalCT.setCellValueFactory(new PropertyValueFactory("dataInicial"));
            dataTerminoCT.setCellValueFactory(new PropertyValueFactory("dataTermino"));
            cicloCT.setCellValueFactory(new PropertyValueFactory("ciclo"));

            relatorioPesquisaTV.setItems(atualizaTabela(
                    pesquisarPor
            ));
            

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - RELATÓRIO DE ATIVIDADES");
            alert.setHeaderText(null);
            alert.setContentText("ESCOLHA O QUE DESEJA PESQUISAR!!");
            alert.showAndWait();

            relatorioPesquisaTV.getItems().clear();
        }

    }

    public ObservableList<RelatorioAtividadesAtributos> atualizaTabela(
            String pesquisarPor1
    ) {

        RelatorioAtividadesDAO dao = new RelatorioAtividadesDAO();
        return FXCollections.observableArrayList(dao.listaRelatorioAtividades(
                pesquisarPor1
        ));
    }

    public void preencherComboBoxAtividades(ComboBox<RelatorioAtividadesMetodo> atividades) {

        List<RelatorioAtividadesMetodo> atividadesCB = new ArrayList<>();

        ObservableList<RelatorioAtividadesMetodo> observableListAtividades;

        RelatorioAtividadesMetodo linha1 = new RelatorioAtividadesMetodo(1, "PESQUISAR POR");
        RelatorioAtividadesMetodo linha2 = new RelatorioAtividadesMetodo(2, "Tratamento Focal");
        RelatorioAtividadesMetodo linha3 = new RelatorioAtividadesMetodo(3, "Reconhecimento Geográfico");
        RelatorioAtividadesMetodo linha4 = new RelatorioAtividadesMetodo(4, "LIRAa");
        RelatorioAtividadesMetodo linha5 = new RelatorioAtividadesMetodo(5, "UBV-Pesado");
        RelatorioAtividadesMetodo linha6 = new RelatorioAtividadesMetodo(6, "UBV-Costal");
        RelatorioAtividadesMetodo linha7 = new RelatorioAtividadesMetodo(7, "Ponto Estratégico - Pesquisa");
        RelatorioAtividadesMetodo linha8 = new RelatorioAtividadesMetodo(8, "Pontoestratégico - Tratamento");
        RelatorioAtividadesMetodo linha9 = new RelatorioAtividadesMetodo(9, "LI");
        RelatorioAtividadesMetodo linha10 = new RelatorioAtividadesMetodo(10, "TPVE");
        RelatorioAtividadesMetodo linha11 = new RelatorioAtividadesMetodo(11, "Todos");

        atividadesCB.add(linha1);
        atividadesCB.add(linha2);
        atividadesCB.add(linha3);
        atividadesCB.add(linha4);
        atividadesCB.add(linha5);
        atividadesCB.add(linha6);
        atividadesCB.add(linha7);
        atividadesCB.add(linha8);
        atividadesCB.add(linha9);
        atividadesCB.add(linha10);
        atividadesCB.add(linha11);

        observableListAtividades = FXCollections.observableArrayList(atividadesCB);

        atividades.setItems(observableListAtividades);
    }

    public void relatorio(
            String relatorio,
            String pesquisarPor
    ) {
        Conexao conn1 = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("pesquisarPor", pesquisarPor);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn1.abrirConexao());
        } catch (JRException ex) {
            Logger.getLogger(RelatorioAtividadesMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(
            ComboBox pesquisarPorCB
    ) {
        String pesquisarPor = null;

        if (!pesquisarPorCB.getSelectionModel().getSelectedItem().toString().equals("PESQUISAR POR")) {
            pesquisarPor = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - RELATÓRIO DE ATIVIDADES");
            alert.setHeaderText(null);
            alert.setContentText("ESCOLHA O QUE DESEJA PESQUISAR!!");
            alert.showAndWait();
        }

        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorios/RelatorioAtividades.jasper";
        relatorio(
                relatorio,
                pesquisarPor
        );
    }
}
