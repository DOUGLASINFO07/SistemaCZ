package relatorioFuncionario;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import util.Relogio;

public class RelatorioFuncionarioControllerFXML implements Initializable {

    RelatorioFuncionarioMetodo RFM = new RelatorioFuncionarioMetodo();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private ComboBox pesquisarPorCB;

    @FXML
    private ComboBox campoPesquisaCB;

    @FXML
    private TextField campoPesquisaTF;

    @FXML
    private Button pesquisarBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TableView relatorioPesquisaTV;

    @FXML
    private TableColumn nomeCT;

    @FXML
    private TableColumn matriculaCT;

    @FXML
    private TableColumn situacaoFuncionalCT;

    @FXML
    private TableColumn cargoCT;

    @FXML
    private TableColumn areaTrabalhoCT;

    @FXML
    private TableColumn equipeCT;

    @FXML
    private TableColumn vinculoEmpregaticioCT;

    @FXML
    private Pane paneCampoPesquisaCB;

    @FXML
    private Pane paneCampoPesquisaTF;

    @FXML
    void campoPesquisaCBMouse(MouseEvent event) {
        RelatorioFuncionarioMetodo RFM1 = new RelatorioFuncionarioMetodo();
        RFM1.iniciarTabela(
                nomeCT,
                matriculaCT,
                situacaoFuncionalCT,
                cargoCT,
                areaTrabalhoCT,
                equipeCT,
                vinculoEmpregaticioCT,
                relatorioPesquisaTV,
                campoPesquisaCB,
                campoPesquisaTF,
                pesquisarPorCB,
                paneCampoPesquisaCB,
                paneCampoPesquisaTF
        );
    }

    @FXML
    void campoPesquisaCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            RelatorioFuncionarioMetodo RFM1 = new RelatorioFuncionarioMetodo();
            RFM1.iniciarTabela(
                    nomeCT,
                    matriculaCT,
                    situacaoFuncionalCT,
                    cargoCT,
                    areaTrabalhoCT,
                    equipeCT,
                    vinculoEmpregaticioCT,
                    relatorioPesquisaTV,
                    campoPesquisaCB,
                    campoPesquisaTF,
                    pesquisarPorCB,
                    paneCampoPesquisaCB,
                    paneCampoPesquisaTF
            );
        }
    }

    @FXML
    void campoPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoPesquisaTFTeclado(KeyEvent event) {
        RelatorioFuncionarioMetodo RFM2 = new RelatorioFuncionarioMetodo();

        campoPesquisaTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            RelatorioFuncionarioMetodo RFM8 = new RelatorioFuncionarioMetodo();

            @Override
            public void handle(KeyEvent event) {
                RFM2.iniciarTabela(
                        nomeCT,
                        matriculaCT,
                        situacaoFuncionalCT,
                        cargoCT,
                        areaTrabalhoCT,
                        equipeCT,
                        vinculoEmpregaticioCT,
                        relatorioPesquisaTV,
                        campoPesquisaCB,
                        campoPesquisaTF,
                        pesquisarPorCB,
                        paneCampoPesquisaCB,
                        paneCampoPesquisaTF
                );
            }
        });
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        RelatorioFuncionarioMetodo RFM3 = new RelatorioFuncionarioMetodo();
        RFM3.gerarRelatorio(
                pesquisarPorCB,
                campoPesquisaCB,
                campoPesquisaTF,
                paneCampoPesquisaCB,
                paneCampoPesquisaTF
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        RelatorioFuncionarioMetodo RFM4 = new RelatorioFuncionarioMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RFM4.gerarRelatorio(
                    pesquisarPorCB,
                    campoPesquisaCB,
                    campoPesquisaTF,
                    paneCampoPesquisaCB,
                    paneCampoPesquisaTF
            );
        }
    }

    @FXML
    void pesquisarBTMouse(MouseEvent event) {
        RelatorioFuncionarioMetodo RFM5 = new RelatorioFuncionarioMetodo();
        RFM5.iniciarTabela(
                nomeCT,
                matriculaCT,
                situacaoFuncionalCT,
                cargoCT,
                areaTrabalhoCT,
                equipeCT,
                vinculoEmpregaticioCT,
                relatorioPesquisaTV,
                campoPesquisaCB,
                campoPesquisaTF,
                pesquisarPorCB,
                paneCampoPesquisaCB,
                paneCampoPesquisaTF
        );
        if (relatorioPesquisaTV.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("CONTROLE DE FINANÇAS\nRELATORIO DE FUNCIONÁRIOS");
            alert.setContentText("NENHUM DADO FOI ENCONTRADO!");
            alert.show();
        }
    }

    @FXML
    void pesquisarBTTeclado(KeyEvent event) {
        RelatorioFuncionarioMetodo RFM6 = new RelatorioFuncionarioMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RFM6.iniciarTabela(
                    nomeCT,
                    matriculaCT,
                    situacaoFuncionalCT,
                    cargoCT,
                    areaTrabalhoCT,
                    equipeCT,
                    vinculoEmpregaticioCT,
                    relatorioPesquisaTV,
                    campoPesquisaCB,
                    campoPesquisaTF,
                    pesquisarPorCB,
                    paneCampoPesquisaCB,
                    paneCampoPesquisaTF
            );
            if (relatorioPesquisaTV.getItems().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("CONTROLE DE FINANÇAS\nRELATORIO DE FUNCIONÁRIOS");
                alert.setContentText("NENHUM DADO FOI ENCONTRADO!");
                alert.show();
            }
        }
    }

    @FXML
    void pesquisarPorCBMouse(ActionEvent event) {

        RelatorioFuncionarioMetodo RFM7 = new RelatorioFuncionarioMetodo();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                RFM7.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");
                campoPesquisaTF.setText("");
            }
        });
    }

    @FXML
    void pesquisarPorCBTeclado(KeyEvent event) {

        RelatorioFuncionarioMetodo RFM8 = new RelatorioFuncionarioMetodo();

        pesquisarPorCB.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                RFM8.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");
                campoPesquisaTF.setText("");
            }
        });
    }

    @FXML
    void relatorioPesquisaTVMouse(MouseEvent event) {

    }

    @FXML
    void relatorioPesquisaTVTeclado(KeyEvent event) {

    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
//        RelatorioFuncionarioMetodo RFM9 = new RelatorioFuncionarioMetodo();
        RFM.abrirMenu();
        RFM.fecharRelatorioFuncionario();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
//        RelatorioFuncionarioMetodo RFM10 = new RelatorioFuncionarioMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RFM.abrirMenu();
            RFM.fecharRelatorioFuncionario();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        RFM.preencherComboBoxPesquisarPor(pesquisarPorCB);

        pesquisarPorCB.getSelectionModel().selectFirst();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                RFM.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");

            }
        });
        Platform.runLater(pesquisarPorCB::requestFocus);//fim do run.
    }
}
