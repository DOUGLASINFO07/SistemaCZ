package relatorioLocalidade;

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
public class RelatorioLocalidadeMetodo extends Application {

    Connection conn;

    Utilitario util = new Utilitario();

    MenuMetodos menuMetodos = new MenuMetodos();

    RelatorioLocalidadeAtributos RLA = new RelatorioLocalidadeAtributos();

    public RelatorioLocalidadeMetodo() {
    }

    public RelatorioLocalidadeMetodo(int posicao, String pesquisarPor) {
        RLA.setPesquisarPor(pesquisarPor);
    }

    @Override
    public String toString() {
        return RLA.getPesquisarPor();
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
        Parent root = FXMLLoader.load(getClass().getResource("/relatorioLocalidade/RelatorioLocalidade.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Localidades");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharRelatorioLocalidade() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
            menuMetodos.start(new Stage());
            fecharRelatorioLocalidade();
        } catch (Exception ex) {
            Logger.getLogger(RelatorioLocalidadeMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button voltarMenuBT,
            Label dataLB,
            Label horasLB,
            ComboBox pesquisarPorCB,
            ComboBox campoPesquisaCB,
            TextField campoPesquisaTF,
            Button pesquisarBT,
            Button imprimirBT,
            TableView relatorioPesquisaTV,
            TableColumn codigoCT,
            TableColumn nomeCT,
            TableColumn siglaCT,
            TableColumn categoriaCT,
            TableColumn zonaCT,
            TableColumn tipoCT
    ) {
        pesquisarPorCB.setValue("PESQUISAR POR");
        campoPesquisaCB.setValue("SELECIONE");
        campoPesquisaTF.setText("");
        imprimirBT.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn codigoCT,
            TableColumn nomeCT,
            TableColumn siglaCT,
            TableColumn categoriaCT,
            TableColumn zonaCT,
            TableColumn tipoCT,
            TableColumn observacaoCT,
            TableView relatorioPesquisaTV,
            ComboBox campoPesquisaCB,
            TextField campoPesquisaTF,
            ComboBox pesquisarPor,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisaTF
    ) {
        String buscarRelatorioLocalidade = null;

        if (!campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")
                || !campoPesquisaTF.getText().equals("")) {

            if (paneCampoPesquisaCB.isVisible()) {
                if (campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")) {
                    buscarRelatorioLocalidade = "";
                } else {
                    buscarRelatorioLocalidade = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
                }
            }
            if (paneCampoPesquisaTF.isVisible()) {
                buscarRelatorioLocalidade = campoPesquisaTF.getText();
            }
        }

            codigoCT.setCellValueFactory(new PropertyValueFactory("codigoCT"));
            nomeCT.setCellValueFactory(new PropertyValueFactory("nomeCT"));
            siglaCT.setCellValueFactory(new PropertyValueFactory("siglaCT"));
            categoriaCT.setCellValueFactory(new PropertyValueFactory("categoriaCT"));
            zonaCT.setCellValueFactory(new PropertyValueFactory("zonaCT"));
            tipoCT.setCellValueFactory(new PropertyValueFactory("tipoCT"));
            observacaoCT.setCellValueFactory(new PropertyValueFactory("observacaoCT"));

            relatorioPesquisaTV.setItems(atualizaTabela(
                    buscarRelatorioLocalidade,
                    pesquisarPor.getSelectionModel().getSelectedItem().toString()
            ));
    }

    public ObservableList<RelatorioLocalidadeAtributos> atualizaTabela(
            String buscarRelatorioLocalidade,
            String pesquisarPor
    ) {
        RelatorioLocalidadeDAO dao = new RelatorioLocalidadeDAO();
        return FXCollections.observableArrayList(dao.listaRelatorioLocalidade(
                buscarRelatorioLocalidade,
                pesquisarPor
        ));
    }

    public void preencherComboBoxPesquisarPor(ComboBox<RelatorioLocalidadeMetodo> pesquisarPor) {

        List<RelatorioLocalidadeMetodo> pesquisarPorCB = new ArrayList<>();

        ObservableList<RelatorioLocalidadeMetodo> observableListPesquisarPor;

        RelatorioLocalidadeMetodo pesquisarPor1 = new RelatorioLocalidadeMetodo(1, "PESQUISAR POR");
        RelatorioLocalidadeMetodo pesquisarPor2 = new RelatorioLocalidadeMetodo(2, "CÓDIGO DE RG");
        RelatorioLocalidadeMetodo pesquisarPor3 = new RelatorioLocalidadeMetodo(3, "LOCALIDADE");
        RelatorioLocalidadeMetodo pesquisarPor4 = new RelatorioLocalidadeMetodo(4, "SIGLA");
        RelatorioLocalidadeMetodo pesquisarPor5 = new RelatorioLocalidadeMetodo(5, "CATEGORIA");
        RelatorioLocalidadeMetodo pesquisarPor6 = new RelatorioLocalidadeMetodo(6, "ZONA");
        RelatorioLocalidadeMetodo pesquisarPor7 = new RelatorioLocalidadeMetodo(7, "TIPO");
        RelatorioLocalidadeMetodo pesquisarPor8 = new RelatorioLocalidadeMetodo(8, "TODOS");

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

    public void preencherComboBoxCategoria(ComboBox<RelatorioLocalidadeMetodo> categoria) {

        List<RelatorioLocalidadeMetodo> categoriaCB = new ArrayList<>();

        ObservableList<RelatorioLocalidadeMetodo> observableListCategoria;

        RelatorioLocalidadeMetodo item1 = new RelatorioLocalidadeMetodo(1, "BAIRRO");
        RelatorioLocalidadeMetodo item2 = new RelatorioLocalidadeMetodo(2, "CONDOMINIO");
        RelatorioLocalidadeMetodo item3 = new RelatorioLocalidadeMetodo(3, "POVOADO");
        RelatorioLocalidadeMetodo item4 = new RelatorioLocalidadeMetodo(4, "VILA");
        RelatorioLocalidadeMetodo item5 = new RelatorioLocalidadeMetodo(5, "OUTROS");

        categoriaCB.add(item1);
        categoriaCB.add(item2);
        categoriaCB.add(item3);
        categoriaCB.add(item4);
        categoriaCB.add(item5);

        observableListCategoria = FXCollections.observableArrayList(categoriaCB);

        categoria.setItems(observableListCategoria);
    }

    public void preencherComboBoxZona(ComboBox<RelatorioLocalidadeMetodo> zona) {

        List<RelatorioLocalidadeMetodo> zonaCB = new ArrayList<>();

        ObservableList<RelatorioLocalidadeMetodo> observableListZona;

        RelatorioLocalidadeMetodo item1 = new RelatorioLocalidadeMetodo(1, "URBANA");
        RelatorioLocalidadeMetodo item2 = new RelatorioLocalidadeMetodo(2, "RURAL");

        zonaCB.add(item1);
        zonaCB.add(item2);

        observableListZona = FXCollections.observableArrayList(zonaCB);

        zona.setItems(observableListZona);
    }

    public void preencherComboBoxTipo(ComboBox<RelatorioLocalidadeMetodo> tipo) {

        List<RelatorioLocalidadeMetodo> tipoCB = new ArrayList<>();

        ObservableList<RelatorioLocalidadeMetodo> observableListTipo;

        RelatorioLocalidadeMetodo item1 = new RelatorioLocalidadeMetodo(1, "SEDE");
        RelatorioLocalidadeMetodo item2 = new RelatorioLocalidadeMetodo(2, "OUTROS");

        tipoCB.add(item1);
        tipoCB.add(item2);

        observableListTipo = FXCollections.observableArrayList(tipoCB);

        tipo.setItems(observableListTipo);
    }

    public void pesquisarPor(
            ComboBox pesquisarPorCB,
            ComboBox campoPesquisaCB,
            TextField campoPesquisaTF,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisaTF,
            Button imprimirBT,
            Button pesquisarBT
    ) {

        switch (pesquisarPorCB.getSelectionModel().getSelectedIndex()) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                preencherComboBoxCategoria(campoPesquisaCB);
                break;
            case 5:
                preencherComboBoxZona(campoPesquisaCB);
                break;
            case 6:
                preencherComboBoxTipo(campoPesquisaCB);
                break;
            case 7:
                break;
            default:
                break;
        }

        String pesquisa = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();

        switch (pesquisa) {
            case "CÓDIGO DE RG":
                paneCampoPesquisaTF.setVisible(true);
                paneCampoPesquisaCB.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "LOCALIDADE":
                paneCampoPesquisaTF.setVisible(true);
                paneCampoPesquisaCB.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "SIGLA":
                paneCampoPesquisaCB.setVisible(false);
                paneCampoPesquisaTF.setVisible(true);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "CATEGORIA":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "ZONA":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "TIPO":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "PESQUISAR POR":
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisaCB.setVisible(false);
                imprimirBT.setDisable(true);
                pesquisarBT.setDisable(true);
                break;
            case "TODOS":
                paneCampoPesquisaTF.setVisible(false);
                paneCampoPesquisaCB.setVisible(false);
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
            String tituloPesquisa
    ) {
        Conexao conn1 = new Conexao();

        System.out.println("\n" + nome + "\n" + pesquisarPor + "\n" + tituloPesquisa);

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("pesquisarPor", pesquisarPor);
        filtro.put("nome", nome);
        filtro.put("tituloPesquisa", tituloPesquisa);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn1.abrirConexao());
        } catch (JRException ex) {
            Logger.getLogger(RelatorioLocalidadeMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(
            ComboBox pesquisarPorCB,
            ComboBox campoPesquisaCB,
            TextField campoPesquisaTF,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisaTF
    ) {
        String pesquisa = null;
        String pesquisarPor = null;
        String nome = null;

        if (paneCampoPesquisaCB.isVisible()) {
            if (campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")) {
                nome = "";
            } else {
                nome = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisaTF.isVisible()) {
            nome = campoPesquisaTF.getText();
        }
        pesquisarPor = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();

        switch (pesquisarPor) {
            case "CÓDIGO DE RG":
                pesquisa = "codigo";
                break;
            case "LOCALIDADE":
                pesquisa = "nome";
                break;
            case "SIGLA":
                pesquisa = "sigla";
                break;
            case "CATEGORIA":
                pesquisa = "categoria";
                break;
            case "ZONA":
                pesquisa = "zona";
                break;
            case "TIPO":
                pesquisa = "tipo";
                break;
            case "TODOS":
                pesquisa = "codigo";
                nome = "";
                break;
            default:
                break;
        }

        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorios/RelatorioLocalidade.jasper";
        relatorio(
                relatorio,
                pesquisa,
                nome,
                pesquisarPor
        );
    }
}
