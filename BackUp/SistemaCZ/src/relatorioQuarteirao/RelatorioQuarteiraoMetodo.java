package relatorioQuarteirao;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
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
public class RelatorioQuarteiraoMetodo extends Application {

    Connection conn;

    MenuMetodos menuMetodos = new MenuMetodos();

    RelatorioQuarteiraoAtributos RQA = new RelatorioQuarteiraoAtributos();

    public RelatorioQuarteiraoMetodo() {
    }

    public RelatorioQuarteiraoMetodo(int posicao, String pesquisarPor) {
        RQA.setPesquisarPor(pesquisarPor);
    }

    @Override
    public String toString() {
        return RQA.getPesquisarPor();
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
        Parent root = FXMLLoader.load(getClass().getResource("/relatorioQuarteirao/RelatorioQuarteirao.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Quarteirões");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharRelatorioQuarteirao() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
            menuMetodos.start(new Stage());
            fecharRelatorioQuarteirao();
        } catch (Exception ex) {
            Logger.getLogger(RelatorioQuarteiraoMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button voltarMenuBT,
            Label dataLB,
            Label horasLB,
            ComboBox pesquisarPorCB,
            Pane paneCampoPesquisaCB,
            ComboBox campoPesquisaCB,
            Pane paneCampoPesquisa2CB,
            ComboBox campoPesquisa2CB,
            Pane paneCampoPesquisaTF,
            TextField campoPesquisaTF,
            Button pesquisarBT,
            Button imprimirBT,
            TableView relatorioPesquisaTV,
            TableColumn localidadeCT,
            TableColumn macroAreaCT,
            TableColumn microAreaCT,
            TableColumn supervisorCT,
            TableColumn aceCT,
            TableColumn rgCT,
            TableColumn quarteiraoCT,
            TableColumn residenciaCT,
            TableColumn comercioCT,
            TableColumn terrenoBaldioCT,
            TableColumn PECT,
            TableColumn outrosCT,
            TableColumn totalCT,
            TableColumn habitanteCT
    ) {
        pesquisarPorCB.setValue("PESQUISAR POR");
        campoPesquisaCB.setValue("SELECIONE");
        campoPesquisa2CB.setValue("RG");
        campoPesquisaTF.setText("");
        imprimirBT.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            Button voltarMenuBT,
            Label dataLB,
            Label horasLB,
            ComboBox pesquisarPorCB,
            Pane paneCampoPesquisaCB,
            ComboBox campoPesquisaCB,
            Pane paneCampoPesquisa2CB,
            ComboBox campoPesquisa2CB,
            Pane paneCampoPesquisaTF,
            TextField campoPesquisaTF,
            Button pesquisarBT,
            Button imprimirBT,
            TableView relatorioPesquisaTV,
            TableColumn localidadeCT,
            TableColumn macroAreaCT,
            TableColumn microAreaCT,
            TableColumn supervisorCT,
            TableColumn aceCT,
            TableColumn rgCT,
            TableColumn quarteiraoCT,
            TableColumn residenciaCT,
            TableColumn comercioCT,
            TableColumn terrenoBaldioCT,
            TableColumn PECT,
            TableColumn outrosCT,
            TableColumn totalCT,
            TableColumn habitanteCT
    ) {
        String buscarRelatorioQuarteirao = null;
        String buscarRelatorioQuarteirao2 = null;
        if (paneCampoPesquisaCB.isVisible()) {
            if (campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")) {
                buscarRelatorioQuarteirao = "";
            } else {
                buscarRelatorioQuarteirao = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisa2CB.isVisible()) {
            if (campoPesquisa2CB.getSelectionModel().getSelectedItem().toString().equals("RG")) {
                buscarRelatorioQuarteirao2 = "";
            } else {
                buscarRelatorioQuarteirao2 = campoPesquisa2CB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisaTF.isVisible()) {
            buscarRelatorioQuarteirao = campoPesquisaTF.getText();
        }
        localidadeCT.setCellValueFactory(new PropertyValueFactory("localidadeCT"));
        macroAreaCT.setCellValueFactory(new PropertyValueFactory("macroAreaCT"));
        microAreaCT.setCellValueFactory(new PropertyValueFactory("microAreaCT"));
        supervisorCT.setCellValueFactory(new PropertyValueFactory("supervisorCT"));
        aceCT.setCellValueFactory(new PropertyValueFactory("aceCT"));
        rgCT.setCellValueFactory(new PropertyValueFactory("rgCT"));
        quarteiraoCT.setCellValueFactory(new PropertyValueFactory("quarteiraoCT"));
        residenciaCT.setCellValueFactory(new PropertyValueFactory("residenciaCT"));
        comercioCT.setCellValueFactory(new PropertyValueFactory("comercioCT"));
        terrenoBaldioCT.setCellValueFactory(new PropertyValueFactory("terrenoBaldioCT"));
        PECT.setCellValueFactory(new PropertyValueFactory("PECT"));
        outrosCT.setCellValueFactory(new PropertyValueFactory("outrosCT"));
        totalCT.setCellValueFactory(new PropertyValueFactory("totalCT"));
        habitanteCT.setCellValueFactory(new PropertyValueFactory("habitanteCT"));
        relatorioPesquisaTV.setItems(atualizaTabela(
                buscarRelatorioQuarteirao,
                buscarRelatorioQuarteirao2,
                pesquisarPorCB.getSelectionModel().getSelectedItem().toString()
        ));
        if (relatorioPesquisaTV.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("CONTROLE DE ZOONOSES\nRELATORIO DE QUARTEIRÕES");
            alert.setContentText("NENHUM DADO FOI ENCONTRADO!");
            alert.show();
        }
    }

    public ObservableList<RelatorioQuarteiraoAtributos> atualizaTabela(
            String buscarRelatorioQuarteirao,
            String buscarRelatorioQuarteirao2,
            String pesquisarPor
    ) {
        RelatorioQuarteiraoDAO dao = new RelatorioQuarteiraoDAO();
        return FXCollections.observableArrayList(dao.listaRelatorioQuarteirao(
                buscarRelatorioQuarteirao,
                buscarRelatorioQuarteirao2,
                pesquisarPor
        ));
    }

    public void preencherComboBoxPesquisarPor(ComboBox<RelatorioQuarteiraoMetodo> pesquisarPor) {
        List<RelatorioQuarteiraoMetodo> pesquisarPorCB = new ArrayList<>();
        ObservableList<RelatorioQuarteiraoMetodo> observableListPesquisarPor;
        RelatorioQuarteiraoMetodo pesquisarPor1 = new RelatorioQuarteiraoMetodo(1, "PESQUISAR POR");
        RelatorioQuarteiraoMetodo pesquisarPor2 = new RelatorioQuarteiraoMetodo(2, "LOCALIDADE");
        RelatorioQuarteiraoMetodo pesquisarPor3 = new RelatorioQuarteiraoMetodo(3, "MACRO ÁREA");
        RelatorioQuarteiraoMetodo pesquisarPor4 = new RelatorioQuarteiraoMetodo(4, "MICRO ÁREA");
        RelatorioQuarteiraoMetodo pesquisarPor5 = new RelatorioQuarteiraoMetodo(5, "SUPERVISOR");
        RelatorioQuarteiraoMetodo pesquisarPor6 = new RelatorioQuarteiraoMetodo(6, "ACE");
        RelatorioQuarteiraoMetodo pesquisarPor7 = new RelatorioQuarteiraoMetodo(7, "RG");
        RelatorioQuarteiraoMetodo pesquisarPor8 = new RelatorioQuarteiraoMetodo(8, "TODOS");
        pesquisarPorCB.add(pesquisarPor1);
        pesquisarPorCB.add(pesquisarPor2);
        pesquisarPorCB.add(pesquisarPor3);
        pesquisarPorCB.add(pesquisarPor4);
        pesquisarPorCB.add(pesquisarPor5);
        pesquisarPorCB.add(pesquisarPor6);
        pesquisarPorCB.add(pesquisarPor7);
        pesquisarPorCB.add(pesquisarPor8);
        observableListPesquisarPor = FXCollections.observableArrayList(pesquisarPorCB);
        pesquisarPor.setItems(observableListPesquisarPor);
    }

    public void preencherComboBoxMacroArea(ComboBox<RelatorioQuarteiraoMetodo> macroArea) {
        List<RelatorioQuarteiraoMetodo> macroAreaCB = new ArrayList<>();
        ObservableList<RelatorioQuarteiraoMetodo> observableListMacroArea;
        RelatorioQuarteiraoMetodo item1 = new RelatorioQuarteiraoMetodo(1, "01 - A");
        RelatorioQuarteiraoMetodo item2 = new RelatorioQuarteiraoMetodo(2, "01 - B");
        RelatorioQuarteiraoMetodo item3 = new RelatorioQuarteiraoMetodo(3, "01 - C");
        RelatorioQuarteiraoMetodo item4 = new RelatorioQuarteiraoMetodo(4, "01 - D");
        RelatorioQuarteiraoMetodo item5 = new RelatorioQuarteiraoMetodo(5, "01 - E");
        RelatorioQuarteiraoMetodo item6 = new RelatorioQuarteiraoMetodo(6, "01 - F");
        RelatorioQuarteiraoMetodo item7 = new RelatorioQuarteiraoMetodo(7, "01 - G");
        RelatorioQuarteiraoMetodo item8 = new RelatorioQuarteiraoMetodo(8, "01 - H");
        RelatorioQuarteiraoMetodo item9 = new RelatorioQuarteiraoMetodo(9, "01 - I");
        RelatorioQuarteiraoMetodo item10 = new RelatorioQuarteiraoMetodo(10, "01 - J");
        macroAreaCB.add(item1);
        macroAreaCB.add(item2);
        macroAreaCB.add(item3);
        macroAreaCB.add(item4);
        macroAreaCB.add(item5);
        macroAreaCB.add(item6);
        macroAreaCB.add(item7);
        macroAreaCB.add(item8);
        macroAreaCB.add(item9);
        macroAreaCB.add(item10);
        observableListMacroArea = FXCollections.observableArrayList(macroAreaCB);
        macroArea.setItems(observableListMacroArea);
    }

    public void preencherComboBoxMicroArea(ComboBox<RelatorioQuarteiraoMetodo> microArea) {
        List<RelatorioQuarteiraoMetodo> microAreaCB = new ArrayList<>();
        ObservableList<RelatorioQuarteiraoMetodo> observableListMicroArea;
        RelatorioQuarteiraoMetodo item1 = new RelatorioQuarteiraoMetodo(1, "Micro 01");
        RelatorioQuarteiraoMetodo item2 = new RelatorioQuarteiraoMetodo(2, "Micro 02");
        RelatorioQuarteiraoMetodo item3 = new RelatorioQuarteiraoMetodo(3, "Micro 03");
        RelatorioQuarteiraoMetodo item4 = new RelatorioQuarteiraoMetodo(4, "Micro 04");
        RelatorioQuarteiraoMetodo item5 = new RelatorioQuarteiraoMetodo(5, "Micro 05");
        RelatorioQuarteiraoMetodo item6 = new RelatorioQuarteiraoMetodo(6, "Micro 06");
        RelatorioQuarteiraoMetodo item7 = new RelatorioQuarteiraoMetodo(7, "Micro 07");
        RelatorioQuarteiraoMetodo item8 = new RelatorioQuarteiraoMetodo(8, "Micro 08");
        RelatorioQuarteiraoMetodo item9 = new RelatorioQuarteiraoMetodo(9, "Micro 09");
        RelatorioQuarteiraoMetodo item10 = new RelatorioQuarteiraoMetodo(10, "Micro 10");
        microAreaCB.add(item1);
        microAreaCB.add(item2);
        microAreaCB.add(item3);
        microAreaCB.add(item4);
        microAreaCB.add(item5);
        microAreaCB.add(item6);
        microAreaCB.add(item7);
        microAreaCB.add(item8);
        microAreaCB.add(item9);
        microAreaCB.add(item10);
        observableListMicroArea = FXCollections.observableArrayList(microAreaCB);
        microArea.setItems(observableListMicroArea);
    }

    public void pesquisarPor(
            ComboBox pesquisarPorCB,
            ComboBox campoPesquisaCB,
            ComboBox campoPesquisa2CB,
            TextField campoPesquisaTF,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisa2CB,
            Pane paneCampoPesquisaTF,
            Button imprimirBT,
            Button pesquisarBT
    ) {
         RelatorioQuarteiraoDAO dao1 = new RelatorioQuarteiraoDAO();
         RelatorioQuarteiraoDAO dao2 = new RelatorioQuarteiraoDAO();
        
        switch (pesquisarPorCB.getSelectionModel().getSelectedIndex()) {
            case 0:
                break;
            case 1:
                dao1.listaLocalidade(campoPesquisaCB);
                dao2.listaRG(campoPesquisa2CB);
                break;
            case 2:
                preencherComboBoxMacroArea(campoPesquisaCB);
                 dao2.listaRG(campoPesquisa2CB);
                break;
            case 3:
                preencherComboBoxMicroArea(campoPesquisaCB);
                 dao2.listaRG(campoPesquisa2CB);
                break;
            case 4:
                dao1.listaSupervisor(campoPesquisaCB);
                 dao2.listaRG(campoPesquisa2CB);
                break;
            case 5:
                dao1.listaACE(campoPesquisaCB);
                 dao2.listaRG(campoPesquisa2CB);
                break;
            case 6:
                dao1.listaRG(campoPesquisaCB);
                break;
            case 7:
                 dao2.listaRG(campoPesquisa2CB);
                break;
            default:
                break;
        }
        String pesquisa = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();
        switch (pesquisa) {
            case "LOCALIDADE":
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "MACRO ÁREA":
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "MICRO ÁREA":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "SUPERVISOR":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "ACE":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "RG":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisa2CB.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "TODOS":
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisaCB.setVisible(false);
                paneCampoPesquisa2CB.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            default:
                break;
        }
    }

    public void relatorio(
            String relatorio,
            String pesquisarPor,
            String nome,
            String nome2,
            String tituloPesquisa
    ) {
        Conexao conn1 = new Conexao();
        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("pesquisarPor", pesquisarPor);
        filtro.put("nome", nome);
        filtro.put("nome2", nome2);
        filtro.put("tituloPesquisa", tituloPesquisa);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn1.abrirConexao());
        } catch (JRException ex) {
            Logger.getLogger(RelatorioQuarteiraoMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(
            ComboBox pesquisarPorCB,
            ComboBox campoPesquisaCB,
            ComboBox campoPesquisa2CB,
            TextField campoPesquisaTF,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisa2CB,
            Pane paneCampoPesquisaTF
    ) {
        String pesquisa = null;
        String pesquisarPor = null;
        String nome = null;
        String nome2 = null;
        if (paneCampoPesquisaCB.isVisible()) {
            if (campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")) {
                nome = "";
            } else {
                nome = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisa2CB.isVisible()) {
            if (campoPesquisa2CB.getSelectionModel().getSelectedItem().toString().equals("RG")) {
                nome2 = "";
            } else {
                nome2 = campoPesquisa2CB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisaTF.isVisible()) {
            nome = campoPesquisaTF.getText();
        }
        pesquisarPor = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();
        switch (pesquisarPor) {
            case "LOCALIDADE":
                pesquisa = "localidade";
                break;
            case "MACRO ÁREA":
                pesquisa = "macroArea";
                break;
            case "MICRO ÁREA":
                pesquisa = "microArea";
                break;
            case "SUPERVISOR":
                pesquisa = "supervisor";
                break;
            case "ACE":
                pesquisa = "ace";
                break;
            case "RG":
                pesquisa = "rg";
                break;
            case "TODOS":
                pesquisa = "localidade";
                nome = "";
//                nome2 = "rg";
                break;
            default:
                break;
        }
        String relatorio = "../src/relatorios/RelatorioQuarteirao.jasper";
        relatorio(
                relatorio,
                pesquisa,
                nome,
                nome2,
                pesquisarPor
        );
    }
}
