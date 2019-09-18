package servicoTratamentoFocal;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

public class ServicoTratamentoFocalControllerFXML implements Initializable {

    ServicoTratamentoFocalMetodos STFM = new ServicoTratamentoFocalMetodos();

    ServicoTratamentoFocalAtributos STFA = new ServicoTratamentoFocalAtributos();

    ServicoTratamentoFocalDAO dao = new ServicoTratamentoFocalDAO();

    Utilitario util = new Utilitario();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Button salvarBT;

    @FXML
    private Button atualizarBT;

    @FXML
    private Button excluirBT;

    @FXML
    private Button novoCadastroBT;

    @FXML
    private TextField rgTF;

    @FXML
    private TextField localidadeTF;

    @FXML
    private TextField categoriaTF;

    @FXML
    private TextField tipoTF;

    @FXML
    private TextField zonaTF;

    @FXML
    private ComboBox semanaCB;

    @FXML
    private TextField cicloTF;

    @FXML
    private DatePicker dataDP;

    @FXML
    private ComboBox aceCB;

    @FXML
    private ComboBox supervisoCB;

    @FXML
    private CheckBox individualmenteCheckBox;

    @FXML
    private CheckBox emConjuntoCheckBox;

    @FXML
    private TextArea observacaoTA;

    @FXML
    private TextField quarteiraoTF;

    @FXML
    private TextField ladosTF;

    @FXML
    private TextField residenciaTF;

    @FXML
    private TextField comercioTF;

    @FXML
    private TextField terrenoBaldioTF;

    @FXML
    private TextField outrosTF;

    @FXML
    private TextField totalTF;

    @FXML
    private TextField visitaResgateTF;

    @FXML
    private TextField eliminadosTF;

    @FXML
    private TextField tratadosTF;

    @FXML
    private ComboBox larvicidaCB;

    @FXML
    private TextField quantLarvicidaTF;

    @FXML
    private TextField quantTratadosTF;

    @FXML
    private CheckBox emTratamentoCheckBox;

    @FXML
    private CheckBox concluidoCheckBox;

    @FXML
    private ComboBox buscarLocalidadeCB;

    @FXML
    private ComboBox buscarCicloCB;

    @FXML
    private TableView tabelaServicoLancadoTV;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaQuarteirao;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaData;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaSemana;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaCiclo;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaACE;

    @FXML
    private TableColumn<ServicoTratamentoFocalMetodos, String> colunaSituacao;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button imprimirBT;

    @FXML
    void atualizarBTMouse(MouseEvent event) {
        atualizar();
        totalTF.setDisable(false);
        totalTF.setEditable(false);
        totalTF.setText("");
    }

    @FXML
    void atualizarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            atualizar();
            totalTF.setDisable(false);
            totalTF.setEditable(false);
        }
    }

    @FXML
    void concluidoCheckBoxMouse(MouseEvent event) {
        emTratamentoCheckBox.setSelected(false);
    }

    @FXML
    void concluidoCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            emTratamentoCheckBox.setSelected(false);
        }
        if (event.getCode() == KeyCode.TAB) {
            if (salvarBT.isDisable()) {
                Platform.runLater(atualizarBT::requestFocus);//fim do run.
            } else {
                Platform.runLater(salvarBT::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void emConjuntoCheckBoxMouse(MouseEvent event) {
        individualmenteCheckBox.setSelected(false);
    }

    @FXML
    void emConjuntoCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            individualmenteCheckBox.setSelected(false);
        }
    }

    @FXML
    void emTratamentoCheckBoxMouse(MouseEvent event) {
        concluidoCheckBox.setSelected(false);
    }

    @FXML
    void emTratamentoCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            concluidoCheckBox.setSelected(false);
        }
    }

    @FXML
    void excluirBTMouse(MouseEvent event) {
        excluir();
    }

    @FXML
    void excluirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            excluir();
        }
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        STFM.gerarRelatorio(
                buscarLocalidadeCB,
                buscarCicloCB
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            STFM.gerarRelatorio(
                    buscarLocalidadeCB,
                    buscarCicloCB
            );
        }
    }

    @FXML
    void individualmenteCheckBoxMouse(MouseEvent event) {
        emConjuntoCheckBox.setSelected(false);
    }

    @FXML
    void individualmenteCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            emConjuntoCheckBox.setSelected(false);
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        listarTabelaServico();
        totalTF.setDisable(true);
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            listarTabelaServico();
            totalTF.setDisable(true);
        }
    }

    @FXML
    void novoCadastroBTMouse(MouseEvent event) {
        novoCadastro();
        totalTF.setDisable(false);
    }

    @FXML
    void novoCadastroBTteclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            novoCadastro();
            totalTF.setDisable(false);
        }
    }

    @FXML
    void observacaoTATeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void salvarBTMouse(MouseEvent event) {

        salvar();
        Platform.runLater(quarteiraoTF::requestFocus);//fim do run.

        totalTF.setDisable(false);
        totalTF.setEditable(false);
        totalTF.setText("");

    }

    @FXML
    void salvarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            salvar();
            Platform.runLater(quarteiraoTF::requestFocus);//fim do run.

            totalTF.setDisable(false);
            totalTF.setEditable(false);
            totalTF.setText("");
        }
    }

    @FXML
    void tabelaServicoLancadoTVMouse(MouseEvent event) {
        pegarDados();
        rgTF.setEditable(false);
        quarteiraoTF.setEditable(false);
        int soma = Integer.parseInt(residenciaTF.getText())
                + Integer.parseInt(comercioTF.getText())
                + Integer.parseInt(terrenoBaldioTF.getText())
                + Integer.parseInt(outrosTF.getText());
        totalTF.setText("" + soma);
        totalTF.setDisable(false);
    }

    @FXML
    void tabelaServicoLancadoTVTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pegarDados();
            rgTF.setEditable(false);
            quarteiraoTF.setEditable(false);
            int soma = Integer.parseInt(residenciaTF.getText())
                    + Integer.parseInt(comercioTF.getText())
                    + Integer.parseInt(terrenoBaldioTF.getText())
                    + Integer.parseInt(outrosTF.getText());
            totalTF.setText("" + soma);
            totalTF.setDisable(false);
        }
        tabelaServicoLancadoTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pegarDados();
                rgTF.setEditable(false);
                quarteiraoTF.setEditable(false);
                int soma = Integer.parseInt(residenciaTF.getText())
                        + Integer.parseInt(comercioTF.getText())
                        + Integer.parseInt(terrenoBaldioTF.getText())
                        + Integer.parseInt(outrosTF.getText());
                totalTF.setText("" + soma);
                totalTF.setDisable(false);
            }
        });
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
//        STFM.abrirMenu();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
//            STFM.abrirMenu();
        }
    }

    @FXML
    void rgTFMouse(MouseEvent event) {

    }

    @FXML
    void rgTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        } else {
            rgTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (rgTF.getLength() == 3) {
                        ServicoTratamentoFocalAtributos STFA = new ServicoTratamentoFocalAtributos();
                        dao.buscarLocalidade(rgTF, STFA);
                        localidadeTF.setText(STFA.getLocalidade());
                        categoriaTF.setText(STFA.getCategoria());
                        tipoTF.setText(STFA.getTipo());
                        zonaTF.setText(STFA.getZona());
                        Platform.runLater(dataDP::requestFocus);//fim do run.
                    }
                }
            });
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(dataDP::requestFocus);//fim do run.
        }
    }

    @FXML
    void cicloTFMouse(MouseEvent event) {
        STFA.setCiclo("");
        if (dataDP.getEditor().getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO DE SERVIÇO");
            alert.setHeaderText(null);
            alert.setContentText("DIGITE A DATA DO SERVIÇO À SER LANÇADO!!");
            alert.showAndWait();
            Platform.runLater(dataDP::requestFocus);//fim do run.
            cicloTF.setText("");
        } else {
            cicloTF.setText("");
            dao.buscarCiclo(dataDP, STFA);
            if (STFA.getCiclo().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO DE SERVIÇO");
                alert.setHeaderText(null);
                alert.setContentText("A DATA LANÇADA NÃO CORRESPONDE A UMA ATIVIDADE CADASTRADA!!\n"
                        + "CONFIRA A DATA E A ATIVIDADE!!");
                alert.showAndWait();
                Platform.runLater(dataDP::requestFocus);//fim do run.
                cicloTF.setText("");
            } else {
                cicloTF.setText(STFA.getCiclo());
            }
        }
    }

    @FXML
    void cicloTFTeclado(KeyEvent event) {
        if (dataDP.getEditor().getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO DE SERVIÇO");
            alert.setHeaderText(null);
            alert.setContentText("DIGITE A DATA DO SERVIÇO À SER LANÇADO!!");
            alert.showAndWait();
            Platform.runLater(dataDP::requestFocus);//fim do run.
            cicloTF.setText("");
        } else {
            cicloTF.setText("");
            dao.buscarCiclo(dataDP, STFA);
            if (STFA.getCiclo().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO DE SERVIÇO");
                alert.setHeaderText(null);
                alert.setContentText("A DATA LANÇADA NÃO CORRESPONDE A UMA ATIVIDADE CADASTRADA!!\n"
                        + "CONFIRA A DATA E A ATIVIDADE!!");
                alert.showAndWait();
                Platform.runLater(dataDP::requestFocus);//fim do run.
                cicloTF.setText("");
            } else {
                cicloTF.setText(STFA.getCiclo());
            }
        }
    }

    @FXML
    void totalTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            int soma = Integer.parseInt(residenciaTF.getText())
                    + Integer.parseInt(comercioTF.getText())
                    + Integer.parseInt(terrenoBaldioTF.getText())
                    + Integer.parseInt(outrosTF.getText());
            totalTF.setText("" + soma);
        }
    }

    @FXML
    void totalTFMouse(MouseEvent event) {
        int soma = Integer.parseInt(residenciaTF.getText())
                + Integer.parseInt(comercioTF.getText())
                + Integer.parseInt(terrenoBaldioTF.getText())
                + Integer.parseInt(outrosTF.getText());
        totalTF.setText("" + soma);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));
        Relogio relogio = new Relogio(horasLB);
        try {
            relogio.relogio();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

        STFM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );
        dao.listaACE(aceCB);
        dao.listaSupervisor(supervisoCB);

        STFM.preencherComboBoxSemana(semanaCB);
        STFM.preencherComboBoxInseticida(larvicidaCB);

        dao.listaLocalidade(buscarLocalidadeCB);
        dao.listaCiclo(buscarCicloCB);

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void atualizar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ATUALIZAÇÃO DE QUARTEIRÃO");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR ATUALIZAÇÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {

            STFM.atualizarServicoTratamentoFocal(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    rgTF,
                    localidadeTF,
                    categoriaTF,
                    tipoTF,
                    zonaTF,
                    dataDP,
                    semanaCB,
                    cicloTF,
                    aceCB,
                    supervisoCB,
                    observacaoTA,
                    quarteiraoTF,
                    ladosTF,
                    residenciaTF,
                    comercioTF,
                    terrenoBaldioTF,
                    outrosTF,
                    visitaResgateTF,
                    eliminadosTF,
                    tratadosTF,
                    larvicidaCB,
                    quantLarvicidaTF,
                    quantTratadosTF,
                    individualmenteCheckBox,
                    emConjuntoCheckBox,
                    emTratamentoCheckBox,
                    concluidoCheckBox,
                    tabelaServicoLancadoTV,
                    buscarLocalidadeCB,
                    listarTodosBT,
                    imprimirBT
            );
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        } else {

        }
        totalTF.setDisable(true);
    }

    public void excluir() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXCLUSÃO DE QUARTEIRÃO");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR EXCLUSÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {

            STFM.excluirServicoTratamentoFocal(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    rgTF,
                    localidadeTF,
                    categoriaTF,
                    tipoTF,
                    zonaTF,
                    dataDP,
                    semanaCB,
                    cicloTF,
                    aceCB,
                    supervisoCB,
                    observacaoTA,
                    quarteiraoTF,
                    ladosTF,
                    residenciaTF,
                    comercioTF,
                    terrenoBaldioTF,
                    outrosTF,
                    visitaResgateTF,
                    eliminadosTF,
                    tratadosTF,
                    larvicidaCB,
                    quantLarvicidaTF,
                    quantTratadosTF,
                    individualmenteCheckBox,
                    emConjuntoCheckBox,
                    emTratamentoCheckBox,
                    concluidoCheckBox,
                    tabelaServicoLancadoTV,
                    buscarLocalidadeCB,
                    listarTodosBT,
                    imprimirBT
            );

            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        } else {

        }
    }

    public void pegarDados() {

        STFM.pegarDadoTabela(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );

        STFM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );
        salvarBT.setDisable(true);
        atualizarBT.setDisable(false);
        excluirBT.setDisable(false);
        quarteiraoTF.setEditable(false);
        buscarLocalidadeCB.setDisable(false);
        buscarCicloCB.setDisable(false);
    }

    public void listarTabelaServico() {

        STFM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );

        STFM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );
        STFM.iniciarTabela(
                colunaQuarteirao,
                colunaData,
                colunaSemana,
                colunaCiclo,
                colunaACE,
                colunaSituacao,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                buscarCicloCB
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);
    }

    public void salvar() {

        STFM.salvarServicoTratamentoFocal(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );

        Platform.runLater(quarteiraoTF::requestFocus);//fim do run.

        totalTF.setDisable(true);

        salvarBT.setDisable(false);

    }

    public void novoCadastro() {

        STFM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );
        STFM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                rgTF,
                localidadeTF,
                categoriaTF,
                tipoTF,
                zonaTF,
                dataDP,
                semanaCB,
                cicloTF,
                aceCB,
                supervisoCB,
                observacaoTA,
                quarteiraoTF,
                ladosTF,
                residenciaTF,
                comercioTF,
                terrenoBaldioTF,
                outrosTF,
                visitaResgateTF,
                eliminadosTF,
                tratadosTF,
                larvicidaCB,
                quantLarvicidaTF,
                quantTratadosTF,
                individualmenteCheckBox,
                emConjuntoCheckBox,
                emTratamentoCheckBox,
                concluidoCheckBox,
                tabelaServicoLancadoTV,
                buscarLocalidadeCB,
                listarTodosBT,
                imprimirBT
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        excluirBT.setDisable(true);

        STFM.limparCamposPesquisa(
                buscarLocalidadeCB,
                buscarCicloCB,
                tabelaServicoLancadoTV,
                listarTodosBT,
                imprimirBT
        );

        Platform.runLater(rgTF::requestFocus);//fim do run.

    }

}
