package quarteirao;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
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

public class QuarteiraoControllerFXML implements Initializable {

    QuarteiraoMetodos QM = new QuarteiraoMetodos();

    QuarteiraoAtributos QA = new QuarteiraoAtributos();

    QuarteiraoDAO dao = new QuarteiraoDAO();

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
    private ComboBox<QuarteiraoMetodos> localidadeCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> rgCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> macroAreaCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> microAreaCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> supervisorCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> aceCB;

    @FXML
    private TextField quarteiraoTF;

    @FXML
    private TextField residenciasTF;

    @FXML
    private TextField comerciosTF;

    @FXML
    private TextField terrenoBaldioTF;

    @FXML
    private TextField pontosEstrategicosTF;

    @FXML
    private TextField outrosTF;

    @FXML
    private TextField gatosTF;

    @FXML
    private TextField caesTF;

    @FXML
    private TextField habitantesTF;

    @FXML
    private CheckBox ratosSimCB;

    @FXML
    private CheckBox ratosNaoCB;

    @FXML
    private TextArea observacaoTA;

    @FXML
    private TableView tabelaQuarteiraoTV;

    @FXML
    private TableColumn<QuarteiraoMetodos, String> colunaTotalTC;

    @FXML
    private TableColumn<QuarteiraoMetodos, String> colunaNumeroQuarteiraoTC;

    @FXML
    private ComboBox<QuarteiraoMetodos> buscarBairroCB;

    @FXML
    private ComboBox<QuarteiraoMetodos> buscarDataRGCB;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TextField totalQuarteiraoTF;

    @FXML
    private TextField totalImoveisTF;

    @FXML
    void buscarBairroCBMouse(MouseEvent event) {
//        QuarteiraoDAO dao = new QuarteiraoDAO();
        buscarDataRGCB.setDisable(false);
        dao.listaRG(buscarDataRGCB);
        QM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        QM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        tabelaQuarteiraoTV.getItems().clear();
    }

    @FXML
    void buscarBairroCBTeclado(KeyEvent event) {
//        QuarteiraoDAO dao = new QuarteiraoDAO();
        if (event.getCode() == KeyCode.ENTER) {
            buscarDataRGCB.setDisable(false);
            dao.listaRG(buscarDataRGCB);
            QM.limparFormulario(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidadeCB,
                    rgCB,
                    macroAreaCB,
                    microAreaCB,
                    supervisorCB,
                    aceCB,
                    observacaoTA,
                    quarteiraoTF,
                    residenciasTF,
                    comerciosTF,
                    terrenoBaldioTF,
                    pontosEstrategicosTF,
                    outrosTF,
                    habitantesTF,
                    caesTF,
                    gatosTF,
                    ratosSimCB,
                    ratosNaoCB,
                    buscarBairroCB,
                    buscarDataRGCB,
                    tabelaQuarteiraoTV,
                    listarTodosBT
            );

            QM.bloquearCamposFormulario(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidadeCB,
                    rgCB,
                    macroAreaCB,
                    microAreaCB,
                    supervisorCB,
                    aceCB,
                    observacaoTA,
                    quarteiraoTF,
                    residenciasTF,
                    comerciosTF,
                    terrenoBaldioTF,
                    pontosEstrategicosTF,
                    outrosTF,
                    habitantesTF,
                    caesTF,
                    gatosTF,
                    ratosSimCB,
                    ratosNaoCB,
                    buscarBairroCB,
                    buscarDataRGCB,
                    tabelaQuarteiraoTV,
                    listarTodosBT
            );
            tabelaQuarteiraoTV.getItems().clear();
        }
    }

    @FXML
    void atualizarBTMouse(MouseEvent event) {
        atualizar();
    }

    @FXML
    void atualizarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            atualizar();

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
        QM.gerarRelatorio(
                buscarBairroCB,
                buscarDataRGCB
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            QM.gerarRelatorio(
                    buscarBairroCB,
                    buscarDataRGCB
            );
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        listarTabelaQuarteirao();
        tabelaQuarteiraoTV.getSelectionModel().selectFirst();
        pegarDados();
        Platform.runLater(tabelaQuarteiraoTV::requestFocus);//fim do run.
        QM.somaTabela(
                buscarBairroCB,
                buscarDataRGCB,
                totalQuarteiraoTF,
                totalImoveisTF
        );
        localidadeCB.setDisable(true);
        rgCB.setDisable(true);
        quarteiraoTF.setEditable(false);
        imprimirBT.setDisable(false);
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            listarTabelaQuarteirao();
            tabelaQuarteiraoTV.getSelectionModel().selectFirst();
            pegarDados();
            Platform.runLater(tabelaQuarteiraoTV::requestFocus);//fim do run.
            QM.somaTabela(
                    buscarBairroCB,
                    buscarDataRGCB,
                    totalQuarteiraoTF,
                    totalImoveisTF
            );
            localidadeCB.setDisable(true);
            rgCB.setDisable(true);
            quarteiraoTF.setEditable(false);
            imprimirBT.setDisable(false);
        }
    }

    @FXML
    void novoCadastroBTMouse(MouseEvent event) {
        novoCadastro();
        quarteiraoTF.setEditable(true);
        imprimirBT.setDisable(true);

    }

    @FXML
    void novoCadastroBTteclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            novoCadastro();
            quarteiraoTF.setEditable(true);
            imprimirBT.setDisable(true);
        }
    }

    @FXML
    void salvarBTMouse(MouseEvent event) {
        QM.verificaQuarteirao(
                localidadeCB,
                rgCB,
                quarteiraoTF,
                QA
        );
        if (QA.getTotalQuarteirao() > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
            alert.setHeaderText(null);
            alert.setContentText("O QUARTEIRÃO " + quarteiraoTF.getText() + " JÁ FOI LANÇADO!!");
            alert.showAndWait();
            Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
        } else {
            salvar();
            Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void salvarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            QM.verificaQuarteirao(
                    localidadeCB,
                    rgCB,
                    quarteiraoTF,
                    QA
            );
            if (QA.getTotalQuarteirao() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                alert.setHeaderText(null);
                alert.setContentText("O QUARTEIRÃO " + quarteiraoTF.getText() + " JÁ FOI LANÇADO!!");
                alert.showAndWait();
                Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
            } else {
                salvar();
                Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void tabelaQuarteiraoTVMouse(MouseEvent event) {
        pegarDados();
        localidadeCB.setDisable(true);
        rgCB.setDisable(true);
        quarteiraoTF.setEditable(false);
    }

    @FXML
    void tabelaQuarteiraoTVTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pegarDados();
        }
        tabelaQuarteiraoTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pegarDados();
                localidadeCB.setDisable(true);
                rgCB.setDisable(true);
                quarteiraoTF.setEditable(false);
            }
        });
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        QM.abrirMenu();
//        QM.fecharQuarteirao();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            QM.abrirMenu();
//            QM.fecharQuarteirao();
        }
    }

    @FXML
    void ratosNaoCBMouse(MouseEvent event) {
        ratosSimCB.setSelected(false);
    }

    @FXML
    void ratosNaoCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            ratosSimCB.setSelected(false);
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
    void ratosSimCBMouse(MouseEvent event) {
        ratosNaoCB.setSelected(false);
    }

    @FXML
    void ratosSimCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            ratosNaoCB.setSelected(false);
        }
    }

    @FXML
    void observacaoTATeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(quarteiraoTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void macroAreaCBTeclado(KeyEvent event) {
        macroAreaCB.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                QM.iniciarTabelaFormulario(
                        colunaTotalTC,
                        colunaNumeroQuarteiraoTC,
                        tabelaQuarteiraoTV,
                        localidadeCB,
                        rgCB
                );
                QM.somaTabelaFormulario(
                        localidadeCB,
                        rgCB,
                        totalQuarteiraoTF,
                        totalImoveisTF
                );
            }
        });
    }

    @FXML
    void macroAreaCBMouse(MouseEvent event) {
        QM.iniciarTabelaFormulario(
                colunaTotalTC,
                colunaNumeroQuarteiraoTC,
                tabelaQuarteiraoTV,
                localidadeCB,
                rgCB
        );
        QM.somaTabelaFormulario(
                localidadeCB,
                rgCB,
                totalQuarteiraoTF,
                totalImoveisTF
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        QuarteiraoDAO dao = new QuarteiraoDAO();
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
        QM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        dao.listaLocalidade(localidadeCB);
        dao.listaSupervisor(supervisorCB);
        dao.listaACE(aceCB);
        dao.listaLocalidadePesquisa(buscarBairroCB);

        QM.preencherComboBoxMacroArea(macroAreaCB);
        QM.preencherComboBoxMicroArea(microAreaCB);

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void atualizar() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("ATUALIZAÇÃO DE QUARTEIRÃO");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR ATUALIZAÇÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {

            QM.atualizarQuarteirao(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidadeCB,
                    rgCB,
                    macroAreaCB,
                    microAreaCB,
                    supervisorCB,
                    aceCB,
                    observacaoTA,
                    quarteiraoTF,
                    residenciasTF,
                    comerciosTF,
                    terrenoBaldioTF,
                    pontosEstrategicosTF,
                    outrosTF,
                    habitantesTF,
                    caesTF,
                    gatosTF,
                    ratosSimCB,
                    ratosNaoCB,
                    buscarBairroCB,
                    buscarDataRGCB,
                    tabelaQuarteiraoTV,
                    totalQuarteiraoTF,
                    totalImoveisTF,
                    listarTodosBT
            );
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        } else {

        }

    }

    public void excluir() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXCLUSÃO DE QUARTEIRÃO");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR EXCLUSÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {

            QM.excluirQuarteirao(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidadeCB,
                    rgCB,
                    macroAreaCB,
                    microAreaCB,
                    supervisorCB,
                    aceCB,
                    observacaoTA,
                    quarteiraoTF,
                    residenciasTF,
                    comerciosTF,
                    terrenoBaldioTF,
                    pontosEstrategicosTF,
                    outrosTF,
                    habitantesTF,
                    caesTF,
                    gatosTF,
                    ratosSimCB,
                    ratosNaoCB,
                    buscarBairroCB,
                    buscarDataRGCB,
                    tabelaQuarteiraoTV,
                    totalQuarteiraoTF,
                    totalImoveisTF,
                    listarTodosBT
            );

            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        } else {

        }

    }

    public void pegarDados() {
        QM.pegarDadoTabela(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );

        QM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        salvarBT.setDisable(true);
        atualizarBT.setDisable(false);
        excluirBT.setDisable(false);
        quarteiraoTF.setEditable(false);
        localidadeCB.setDisable(true);
        rgCB.setDisable(false);
    }

    public void listarTabelaQuarteirao() {

        QM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );

        QM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        QM.iniciarTabela(
                colunaTotalTC,
                colunaNumeroQuarteiraoTC,
                tabelaQuarteiraoTV,
                buscarBairroCB,
                buscarDataRGCB
        );
        salvarBT.setDisable(true);
    }

    public void salvar() {

        QM.salvarQuarteirao(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );

        salvarBT.setDisable(false);

//        if (!rg.getEditor().getText().isEmpty()) {
            QM.iniciarTabelaFormulario(
                    colunaTotalTC,
                    colunaNumeroQuarteiraoTC,
                    tabelaQuarteiraoTV,
                    localidadeCB,
                    rgCB
            );
            QM.somaTabelaFormulario(
                    localidadeCB,
                    rgCB,
                    totalQuarteiraoTF,
                    totalImoveisTF
            );
//        }

    }

    public void novoCadastro() {

        QM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        QM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                localidadeCB,
                rgCB,
                macroAreaCB,
                microAreaCB,
                supervisorCB,
                aceCB,
                observacaoTA,
                quarteiraoTF,
                residenciasTF,
                comerciosTF,
                terrenoBaldioTF,
                pontosEstrategicosTF,
                outrosTF,
                habitantesTF,
                caesTF,
                gatosTF,
                ratosSimCB,
                ratosNaoCB,
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                listarTodosBT
        );
        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        excluirBT.setDisable(true);

        QM.limparCamposPesquisa(
                buscarBairroCB,
                buscarDataRGCB,
                tabelaQuarteiraoTV,
                totalQuarteiraoTF,
                totalImoveisTF,
                imprimirBT
        );

        Platform.runLater(localidadeCB::requestFocus);//fim do run.

    }

}
