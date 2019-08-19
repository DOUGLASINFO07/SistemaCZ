package relatorioFuncionario;

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
import jeanderson.br.util.MaskFormatter;
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
public class RelatorioFuncionarioMetodo extends Application {

    Connection conn;

    Utilitario util = new Utilitario();

    MenuMetodos menuMetodos = new MenuMetodos();

    RelatorioFuncionarioAtributos RFA = new RelatorioFuncionarioAtributos();

    public RelatorioFuncionarioMetodo() {
    }

    public RelatorioFuncionarioMetodo(int posicao, String pesquisarPor) {
        RFA.setPesquisarPor(pesquisarPor);
    }

    @Override
    public String toString() {
        return RFA.getPesquisarPor();
    }

    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

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
        Parent root = FXMLLoader.load(getClass().getResource("/relatorioFuncionario/RelatorioFuncionario.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Funcionarios");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharRelatorioFuncionario() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
            menuMetodos.start(new Stage());
            fecharRelatorioFuncionario();
        } catch (Exception ex) {
            Logger.getLogger(RelatorioFuncionarioMetodo.class.getName()).log(Level.SEVERE, null, ex);
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
            TableColumn nomeCT,
            TableColumn matriculaTC,
            TableColumn situacaoFuncionalCT,
            TableColumn cargoCT,
            TableColumn areaTrabalhoCT,
            TableColumn equipeCT,
            TableColumn vinculoEmpregaticioCT
    ) {
        pesquisarPorCB.setValue("PESQUISAR POR");
        campoPesquisaCB.setValue("SELECIONE");
        campoPesquisaTF.setText("");
        imprimirBT.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nomeCT,
            TableColumn matriculaCT,
            TableColumn situacaoFuncionalCT,
            TableColumn cargoCT,
            TableColumn areaTrabalhoCT,
            TableColumn equipeCT,
            TableColumn vinculoEmpregaticioCT,
            TableView relatorioPesquisaTV,
            ComboBox campoPesquisaCB,
            TextField campoPesquisaTF,
            ComboBox pesquisarPor,
            Pane paneCampoPesquisaCB,
            Pane paneCampoPesquisaTF
    ) {
        String buscarRelatorioFuncionario = null;
        
        if(!campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE") || 
                !campoPesquisaTF.getText().equals("")){
        
        if (paneCampoPesquisaCB.isVisible()) {
            if(campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")){
                buscarRelatorioFuncionario = "";
            }else{
            buscarRelatorioFuncionario = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisaTF.isVisible()) {
            buscarRelatorioFuncionario = campoPesquisaTF.getText();
        }
        }

        nomeCT.setCellValueFactory(new PropertyValueFactory("nomeCT"));
        matriculaCT.setCellValueFactory(new PropertyValueFactory("matriculaCT"));
        situacaoFuncionalCT.setCellValueFactory(new PropertyValueFactory("situacaoFuncionalCT"));
        cargoCT.setCellValueFactory(new PropertyValueFactory("cargoCT"));
        areaTrabalhoCT.setCellValueFactory(new PropertyValueFactory("areaTrabalhoCT"));
        equipeCT.setCellValueFactory(new PropertyValueFactory("equipeCT"));
        vinculoEmpregaticioCT.setCellValueFactory(new PropertyValueFactory("vinculoEmpregaticioCT"));
        
        
        relatorioPesquisaTV.setItems(atualizaTabela(
                buscarRelatorioFuncionario,
                pesquisarPor.getSelectionModel().getSelectedItem().toString()
        ));
            
    }

    public ObservableList<RelatorioFuncionarioAtributos> atualizaTabela(
            String buscarRelatorioFuncionario,
            String pesquisarPor
    ) {
            
        RelatorioFuncionarioDAO dao = new RelatorioFuncionarioDAO();
        return FXCollections.observableArrayList(dao.listaRelatorioFuncionario(
                buscarRelatorioFuncionario,
                pesquisarPor
        ));
    }

    public void preencherComboBoxPesquisarPor(ComboBox<RelatorioFuncionarioMetodo> pesquisarPor) {

        List<RelatorioFuncionarioMetodo> pesquisarPorCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListPesquisarPor;

        RelatorioFuncionarioMetodo pesquisarPor1 = new RelatorioFuncionarioMetodo(1, "PESQUISAR POR");
        RelatorioFuncionarioMetodo pesquisarPor2 = new RelatorioFuncionarioMetodo(2, "NOME DO FUNCIONÁRIO");
        RelatorioFuncionarioMetodo pesquisarPor3 = new RelatorioFuncionarioMetodo(3, "MATRÍCULA");
        RelatorioFuncionarioMetodo pesquisarPor4 = new RelatorioFuncionarioMetodo(4, "SITUAÇÃO FUNCIONAL");
        RelatorioFuncionarioMetodo pesquisarPor5 = new RelatorioFuncionarioMetodo(5, "CARGO");
        RelatorioFuncionarioMetodo pesquisarPor6 = new RelatorioFuncionarioMetodo(6, "ÁREA DE TRABALHO");
        RelatorioFuncionarioMetodo pesquisarPor7 = new RelatorioFuncionarioMetodo(7, "EQUIPE");
        RelatorioFuncionarioMetodo pesquisarPor8 = new RelatorioFuncionarioMetodo(8, "VÍNCULO EMPREGATÍCIO");
        RelatorioFuncionarioMetodo pesquisarPor9 = new RelatorioFuncionarioMetodo(9, "TODOS");

        pesquisarPorCB.add(pesquisarPor1);
        pesquisarPorCB.add(pesquisarPor2);
        pesquisarPorCB.add(pesquisarPor3);
        pesquisarPorCB.add(pesquisarPor4);
        pesquisarPorCB.add(pesquisarPor5);
        pesquisarPorCB.add(pesquisarPor6);
        pesquisarPorCB.add(pesquisarPor7);
        pesquisarPorCB.add(pesquisarPor8);
        pesquisarPorCB.add(pesquisarPor9);

        observableListPesquisarPor = FXCollections.observableArrayList(pesquisarPorCB);

        pesquisarPor.setItems(observableListPesquisarPor);
    }

    public void preencherComboBoxcargo(ComboBox<RelatorioFuncionarioMetodo> cargo) {

        List<RelatorioFuncionarioMetodo> cargoCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListCargo;

        RelatorioFuncionarioMetodo cargo1 = new RelatorioFuncionarioMetodo(1, "Agente de Endemias");
        RelatorioFuncionarioMetodo cargo2 = new RelatorioFuncionarioMetodo(2, "Supervisor de Área");
        RelatorioFuncionarioMetodo cargo3 = new RelatorioFuncionarioMetodo(3, "Supervisor Geral");
        RelatorioFuncionarioMetodo cargo4 = new RelatorioFuncionarioMetodo(4, "Coordenador");

        cargoCB.add(cargo1);
        cargoCB.add(cargo2);
        cargoCB.add(cargo3);
        cargoCB.add(cargo4);

        observableListCargo = FXCollections.observableArrayList(cargoCB);

        cargo.setItems(observableListCargo);
    }

    public void preencherComboBoxVinculoEmpregaticio(ComboBox<RelatorioFuncionarioMetodo> vinculo) {

        List<RelatorioFuncionarioMetodo> vinculoCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListVinculo;

        RelatorioFuncionarioMetodo vinculo1 = new RelatorioFuncionarioMetodo(1, "Efetivo");
        RelatorioFuncionarioMetodo vinculo2 = new RelatorioFuncionarioMetodo(2, "Contratado");
        RelatorioFuncionarioMetodo vinculo3 = new RelatorioFuncionarioMetodo(3, "Terceirizado");
        RelatorioFuncionarioMetodo vinculo4 = new RelatorioFuncionarioMetodo(4, "Estagiário");

        vinculoCB.add(vinculo1);
        vinculoCB.add(vinculo2);
        vinculoCB.add(vinculo3);
        vinculoCB.add(vinculo4);

        observableListVinculo = FXCollections.observableArrayList(vinculoCB);

        vinculo.setItems(observableListVinculo);
    }

    public void preencherComboBoxEquipe(ComboBox<RelatorioFuncionarioMetodo> equipe) {

        List<RelatorioFuncionarioMetodo> equipeCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListEquipe;

        RelatorioFuncionarioMetodo equipe1 = new RelatorioFuncionarioMetodo(1, "PA");
        RelatorioFuncionarioMetodo equipe2 = new RelatorioFuncionarioMetodo(2, "Equipe 01-A");
        RelatorioFuncionarioMetodo equipe3 = new RelatorioFuncionarioMetodo(3, "Equipe 01-B");
        RelatorioFuncionarioMetodo equipe4 = new RelatorioFuncionarioMetodo(4, "Equipe 01-C");
        RelatorioFuncionarioMetodo equipe5 = new RelatorioFuncionarioMetodo(5, "Equipe 01-D");
        RelatorioFuncionarioMetodo equipe6 = new RelatorioFuncionarioMetodo(6, "Equipe 01-E");
        RelatorioFuncionarioMetodo equipe7 = new RelatorioFuncionarioMetodo(7, "Equipe 01-F");
        RelatorioFuncionarioMetodo equipe8 = new RelatorioFuncionarioMetodo(8, "Equipe 01-G");
        RelatorioFuncionarioMetodo equipe9 = new RelatorioFuncionarioMetodo(9, "Equipe 01-H");

        equipeCB.add(equipe1);
        equipeCB.add(equipe2);
        equipeCB.add(equipe3);
        equipeCB.add(equipe4);
        equipeCB.add(equipe5);
        equipeCB.add(equipe6);
        equipeCB.add(equipe7);
        equipeCB.add(equipe8);
        equipeCB.add(equipe9);

        observableListEquipe = FXCollections.observableArrayList(equipeCB);

        equipe.setItems(observableListEquipe);
    }

    public void preencherComboBoxAreaTrabalho(ComboBox<RelatorioFuncionarioMetodo> area) {

        List<RelatorioFuncionarioMetodo> areaCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListArea;

        RelatorioFuncionarioMetodo area1 = new RelatorioFuncionarioMetodo(1, "Controle de Aedes");
        RelatorioFuncionarioMetodo area2 = new RelatorioFuncionarioMetodo(2, "Controle de Escorpião");
        RelatorioFuncionarioMetodo area3 = new RelatorioFuncionarioMetodo(3, "Controle de Chagas");
        RelatorioFuncionarioMetodo area4 = new RelatorioFuncionarioMetodo(4, "Ponto Estratégico");
        RelatorioFuncionarioMetodo area5 = new RelatorioFuncionarioMetodo(5, "UBV");
        RelatorioFuncionarioMetodo area6 = new RelatorioFuncionarioMetodo(6, "Denuncias e Notificações");
        RelatorioFuncionarioMetodo area7 = new RelatorioFuncionarioMetodo(7, "Escritório");
        RelatorioFuncionarioMetodo area8 = new RelatorioFuncionarioMetodo(8, "PEM");
        RelatorioFuncionarioMetodo area9 = new RelatorioFuncionarioMetodo(9, "Canil");
        RelatorioFuncionarioMetodo area10 = new RelatorioFuncionarioMetodo(10, "Mobilização Social");

        areaCB.add(area1);
        areaCB.add(area2);
        areaCB.add(area3);
        areaCB.add(area4);
        areaCB.add(area5);
        areaCB.add(area6);
        areaCB.add(area7);
        areaCB.add(area8);
        areaCB.add(area9);
        areaCB.add(area10);

        observableListArea = FXCollections.observableArrayList(areaCB);

        area.setItems(observableListArea);
    }

    public void preencherComboBoxSituacaoFuncional(ComboBox<RelatorioFuncionarioMetodo> situacao) {

        List<RelatorioFuncionarioMetodo> situacaoCB = new ArrayList<>();

        ObservableList<RelatorioFuncionarioMetodo> observableListSituacao;

        RelatorioFuncionarioMetodo situacao1 = new RelatorioFuncionarioMetodo(1, "Regular");
        RelatorioFuncionarioMetodo situacao2 = new RelatorioFuncionarioMetodo(2, "Afastado pelo INSS");
        RelatorioFuncionarioMetodo situacao3 = new RelatorioFuncionarioMetodo(3, "Licença - LIP");
        RelatorioFuncionarioMetodo situacao4 = new RelatorioFuncionarioMetodo(4, "Desviado de Função");
        RelatorioFuncionarioMetodo situacao5 = new RelatorioFuncionarioMetodo(5, "Readaptado");
        RelatorioFuncionarioMetodo situacao6 = new RelatorioFuncionarioMetodo(6, "Outras licenças");
        RelatorioFuncionarioMetodo situacao7 = new RelatorioFuncionarioMetodo(7, "Inativo");

        situacaoCB.add(situacao1);
        situacaoCB.add(situacao2);
        situacaoCB.add(situacao3);
        situacaoCB.add(situacao4);
        situacaoCB.add(situacao5);
        situacaoCB.add(situacao6);
        situacaoCB.add(situacao7);

        observableListSituacao = FXCollections.observableArrayList(situacaoCB);

        situacao.setItems(observableListSituacao);
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
                preencherComboBoxSituacaoFuncional(campoPesquisaCB);
                break;
            case 4:
                preencherComboBoxcargo(campoPesquisaCB);
                break;
            case 5:
                preencherComboBoxAreaTrabalho(campoPesquisaCB);
                break;
            case 6:
                preencherComboBoxEquipe(campoPesquisaCB);
                break;
            case 7:
                preencherComboBoxVinculoEmpregaticio(campoPesquisaCB);
                break;
            case 8:
                break;
            default:
                break;
        }

        String teste = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();

        switch (teste) {
            case "NOME DO FUNCIONÁRIO":
                paneCampoPesquisaTF.setVisible(true);
                paneCampoPesquisaCB.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "MATRÍCULA":
                paneCampoPesquisaTF.setVisible(true);
                paneCampoPesquisaCB.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "SITUAÇÃO FUNCIONAL":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "CARGO":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "ÁREA DE TRABALHO":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "EQUIPE":
                paneCampoPesquisaCB.setVisible(true);
                paneCampoPesquisaTF.setVisible(false);
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                break;
            case "VÍNCULO EMPREGATÍCIO":
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
            Logger.getLogger(RelatorioFuncionarioMetodo.class.getName()).log(Level.SEVERE, null, ex);
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
            if(campoPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("SELECIONE")){
                nome = "";
            }else{
            nome = campoPesquisaCB.getSelectionModel().getSelectedItem().toString();
            }
        }
        if (paneCampoPesquisaTF.isVisible()) {
            nome = campoPesquisaTF.getText();
        }
        pesquisarPor = pesquisarPorCB.getSelectionModel().getSelectedItem().toString();

        switch (pesquisarPor) {
            case "NOME DO FUNCIONÁRIO":
                pesquisa = "nome";
                break;
            case "MATRÍCULA":
                pesquisa = "matricula";
                break;
            case "SITUAÇÃO FUNCIONAL":
                pesquisa = "situacaoFuncional";
                break;
            case "CARGO":
                pesquisa = "cargo";
                break;
            case "ÁREA DE TRABALHO":
                pesquisa = "areaTrabalho";
                break;
            case "EQUIPE":
                pesquisa = "equipe";
                break;
            case "VÍNCULO EMPREGATÍCIO":
                pesquisa = "vinculoEmpregaticio";
                break;
            case "TODOS":
                pesquisa = "nome";
                nome = "";
                break;
            default:
                break;
        }

        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorios/RelatorioFuncionario.jasper";
        relatorio(
                relatorio,
                pesquisa,
                nome,
                pesquisarPor
        );
    }
}
