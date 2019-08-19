package atividades;

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

public class AtividadesControllerFXML implements Initializable {

    AtividadesAtributos AA = new AtividadesAtributos();

    AtividadesMetodos AM = new AtividadesMetodos();

    AtividadesDAO dao = new AtividadesDAO();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Button salvarBT;

    @FXML
    private Button excluirBT;

    @FXML
    private Button novoCadastroBT;

    @FXML
    private ComboBox<AtividadesMetodos> atividadeCB;

    @FXML
    private DatePicker dataInicioDP;

    @FXML
    private DatePicker dataTerminoDP;

    @FXML
    private ComboBox<AtividadesMetodos> cicloCB;

    @FXML
    private TextArea observacaoTA;

    @FXML
    private TextField nomeAtividadeTF;

    @FXML
    private ComboBox<AtividadesMetodos> buscarAtividadeCB;

    @FXML
    private TableView tabelaAtividadeTV;

    @FXML
    private TableColumn<AtividadesMetodos, String> colunaAtividadeTC;

    @FXML
    private TableColumn<AtividadesMetodos, String> colunaCicloTC;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button imprimirBT;

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
        AM.gerarRelatorio(
                tabelaAtividadeTV
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            AM.gerarRelatorio(
                    tabelaAtividadeTV
            );
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        listarTabelaAtividades();
        tabelaAtividadeTV.getSelectionModel().selectFirst();
        pegarDados();
        Platform.runLater(tabelaAtividadeTV::requestFocus);//fim do run.
        atividadeCB.setDisable(true);
        cicloCB.setDisable(true);
        imprimirBT.setDisable(false);
         buscarAtividadeCB.getSelectionModel().selectLast();
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            listarTabelaAtividades();
            tabelaAtividadeTV.getSelectionModel().selectFirst();
            pegarDados();
            Platform.runLater(tabelaAtividadeTV::requestFocus);//fim do run.
            atividadeCB.setDisable(true);
            cicloCB.setDisable(true);
            imprimirBT.setDisable(false);
                    buscarAtividadeCB.getSelectionModel().selectLast();
        }
    }

    @FXML
    void novoCadastroBTMouse(MouseEvent event) {
        novoCadastro();
        imprimirBT.setDisable(true);
    }

    @FXML
    void novoCadastroBTteclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            novoCadastro();
            imprimirBT.setDisable(true);
        }
    }

    @FXML
    void observacaoTATeclado(KeyEvent event) {

    }

    @FXML
    void salvarBTMouse(MouseEvent event) {
        AM.verificaAtividades(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT,
                AA
        );
        if (AA.getAtividadesContadas() > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
            alert.setHeaderText(null);
            alert.setContentText("A ATIVIDADE JÁ FOI LANÇADA!!");
            alert.showAndWait();
            Platform.runLater(atividadeCB::requestFocus);//fim do run.
        } else {
            salvar();
            Platform.runLater(atividadeCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void salvarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            AM.verificaAtividades(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    excluirBT,
                    atividadeCB,
                    dataInicioDP,
                    dataTerminoDP,
                    cicloCB,
                    observacaoTA,
                    nomeAtividadeTF,
                    buscarAtividadeCB,
                    colunaAtividadeTC,
                    colunaCicloTC,
                    tabelaAtividadeTV,
                    listarTodosBT,
                    imprimirBT,
                    AA
            );
            if (AA.getAtividadesContadas() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                alert.setHeaderText(null);
                alert.setContentText("A ATIVIDADE JÁ FOI LANÇADA!!");
                alert.showAndWait();
                Platform.runLater(atividadeCB::requestFocus);//fim do run.
            } else {
                salvar();
                Platform.runLater(atividadeCB::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void tabelaAtividadeTVMouse(MouseEvent event) {
        pegarDados();
        atividadeCB.setDisable(true);
        cicloCB.setDisable(true);
    }

    @FXML
    void tabelaAtividadeTVTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pegarDados();
        }
        tabelaAtividadeTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pegarDados();
                atividadeCB.setDisable(true);
                cicloCB.setDisable(true);
            }
        });
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        AM.abrirMenu();
//        AM.fecharAtividades();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            AM.abrirMenu();
//            AM.fecharAtividades();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        AtividadesDAO dao = new AtividadesDAO();
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
        AM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );

        AM.preencherComboBoxAtividades(atividadeCB);
        AM.preencherComboBoxCiclo(cicloCB);
        AM.preencherComboBoxAtividades(buscarAtividadeCB);
//        AM.preencherComboBoxAtividades(buscarCicloCB);

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.

    }

    public void excluir() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXCLUSÃO DE ATIVIDADES");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR EXCLUSÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            AM.excluirAtividades(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    excluirBT,
                    atividadeCB,
                    dataInicioDP,
                    dataTerminoDP,
                    cicloCB,
                    observacaoTA,
                    nomeAtividadeTF,
                    buscarAtividadeCB,
                    colunaAtividadeTC,
                    colunaCicloTC,
                    tabelaAtividadeTV,
                    listarTodosBT,
                    imprimirBT
            );

            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.

        } else if (result.get() == buttonTypeTwo) {

        } else {

        }
    }

    public void pegarDados() {
        AM.pegarDadoTabela(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );

        AM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );
        salvarBT.setDisable(true);
        excluirBT.setDisable(false);
        atividadeCB.setDisable(true);
        cicloCB.setDisable(true);
    }

    public void listarTabelaAtividades() {

        AM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );

        AM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );
        AM.iniciarTabela(
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                buscarAtividadeCB
        );
        salvarBT.setDisable(true);
    }

    public void salvar() {

        AM.salvarAtividades(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );

        salvarBT.setDisable(false);

    }

    public void novoCadastro() {

        AM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );
        AM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );
        salvarBT.setDisable(false);
        excluirBT.setDisable(true);

        AM.limparCamposPesquisa(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                excluirBT,
                atividadeCB,
                dataInicioDP,
                dataTerminoDP,
                cicloCB,
                observacaoTA,
                nomeAtividadeTF,
                buscarAtividadeCB,
                colunaAtividadeTC,
                colunaCicloTC,
                tabelaAtividadeTV,
                listarTodosBT,
                imprimirBT
        );

        Platform.runLater(atividadeCB::requestFocus);//fim do run.

    }

}
