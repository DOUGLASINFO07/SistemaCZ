package relatorioQuarteirao;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class RelatorioQuarteiraoControllerFXML implements Initializable {

    RelatorioQuarteiraoMetodo RQM = new RelatorioQuarteiraoMetodo();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private ComboBox pesquisarPorCB;

    @FXML
    private Pane paneCampoPesquisaCB;

    @FXML
    private ComboBox campoPesquisaCB;

    @FXML
    private Pane paneCampoPesquisa2CB;

    @FXML
    private ComboBox campoPesquisa2CB;

    @FXML
    private Pane paneCampoPesquisaTF;

    @FXML
    private TextField campoPesquisaTF;

    @FXML
    private Button pesquisarBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TableView relatorioPesquisaTV;

    @FXML
    private TableColumn localidadeCT;

    @FXML
    private TableColumn macroAreaCT;

    @FXML
    private TableColumn microAreaCT;

    @FXML
    private TableColumn supervisorCT;

    @FXML
    private TableColumn aceCT;

    @FXML
    private TableColumn rgCT;

    @FXML
    private TableColumn quarteiraoCT;

    @FXML
    private TableColumn residenciaCT;

    @FXML
    private TableColumn comercioCT;

    @FXML
    private TableColumn terrenoBaldioCT;

    @FXML
    private TableColumn PECT;

    @FXML
    private TableColumn outrosCT;

    @FXML
    private TableColumn totalCT;

    @FXML
    private TableColumn habitanteCT;

    @FXML
    void campoPesquisaCBMouse(MouseEvent event) {

    }

    @FXML
    void campoPesquisaCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            RelatorioQuarteiraoMetodo RQM1 = new RelatorioQuarteiraoMetodo();
            RQM1.iniciarTabela(
                    voltarMenuBT,
                    dataLB,
                    horasLB,
                    pesquisarPorCB,
                    paneCampoPesquisaCB,
                    campoPesquisaCB,
                    paneCampoPesquisa2CB,
                    campoPesquisa2CB,
                    paneCampoPesquisaTF,
                    campoPesquisaTF,
                    pesquisarBT,
                    imprimirBT,
                    relatorioPesquisaTV,
                    localidadeCT,
                    macroAreaCT,
                    microAreaCT,
                    supervisorCT,
                    aceCT,
                    rgCT,
                    quarteiraoCT,
                    residenciaCT,
                    comercioCT,
                    terrenoBaldioCT,
                    PECT,
                    outrosCT,
                    totalCT,
                    habitanteCT
            );
        }
    }

    @FXML
    void campoPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoPesquisaTFTeclado(KeyEvent event) {
        RelatorioQuarteiraoMetodo RQM2 = new RelatorioQuarteiraoMetodo();

        campoPesquisaTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            RelatorioQuarteiraoMetodo RQM8 = new RelatorioQuarteiraoMetodo();

            @Override
            public void handle(KeyEvent event) {
                RQM2.iniciarTabela(
                        voltarMenuBT,
                        dataLB,
                        horasLB,
                        pesquisarPorCB,
                        paneCampoPesquisaCB,
                        campoPesquisaCB,
                        paneCampoPesquisa2CB,
                        campoPesquisa2CB,
                        paneCampoPesquisaTF,
                        campoPesquisaTF,
                        pesquisarBT,
                        imprimirBT,
                        relatorioPesquisaTV,
                        localidadeCT,
                        macroAreaCT,
                        microAreaCT,
                        supervisorCT,
                        aceCT,
                        rgCT,
                        quarteiraoCT,
                        residenciaCT,
                        comercioCT,
                        terrenoBaldioCT,
                        PECT,
                        outrosCT,
                        totalCT,
                        habitanteCT
                );
            }
        });
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        RelatorioQuarteiraoMetodo RQM3 = new RelatorioQuarteiraoMetodo();
        RQM3.gerarRelatorio(
                pesquisarPorCB,
                campoPesquisaCB,
                campoPesquisa2CB,
                campoPesquisaTF,
                paneCampoPesquisaCB,
                paneCampoPesquisa2CB,
                paneCampoPesquisaTF
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        RelatorioQuarteiraoMetodo RQM4 = new RelatorioQuarteiraoMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RQM4.gerarRelatorio(
                    pesquisarPorCB,
                    campoPesquisaCB,
                    campoPesquisa2CB,
                    campoPesquisaTF,
                    paneCampoPesquisaCB,
                    paneCampoPesquisa2CB,
                    paneCampoPesquisaTF
            );
        }
    }

    @FXML
    void pesquisarBTMouse(MouseEvent event) {
        RelatorioQuarteiraoMetodo RQM5 = new RelatorioQuarteiraoMetodo();
        RQM5.iniciarTabela(
                voltarMenuBT,
                dataLB,
                horasLB,
                pesquisarPorCB,
                paneCampoPesquisaCB,
                campoPesquisaCB,
                paneCampoPesquisa2CB,
                campoPesquisa2CB,
                paneCampoPesquisaTF,
                campoPesquisaTF,
                pesquisarBT,
                imprimirBT,
                relatorioPesquisaTV,
                localidadeCT,
                macroAreaCT,
                microAreaCT,
                supervisorCT,
                aceCT,
                rgCT,
                quarteiraoCT,
                residenciaCT,
                comercioCT,
                terrenoBaldioCT,
                PECT,
                outrosCT,
                totalCT,
                habitanteCT
        );
    }

    @FXML
    void pesquisarBTTeclado(KeyEvent event) {
        RelatorioQuarteiraoMetodo RQM6 = new RelatorioQuarteiraoMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RQM6.iniciarTabela(
                    voltarMenuBT,
                    dataLB,
                    horasLB,
                    pesquisarPorCB,
                    paneCampoPesquisaCB,
                    campoPesquisaCB,
                    paneCampoPesquisa2CB,
                    campoPesquisa2CB,
                    paneCampoPesquisaTF,
                    campoPesquisaTF,
                    pesquisarBT,
                    imprimirBT,
                    relatorioPesquisaTV,
                    localidadeCT,
                    macroAreaCT,
                    microAreaCT,
                    supervisorCT,
                    aceCT,
                    rgCT,
                    quarteiraoCT,
                    residenciaCT,
                    comercioCT,
                    terrenoBaldioCT,
                    PECT,
                    outrosCT,
                    totalCT,
                    habitanteCT
            );
        }
    }

    @FXML
    void pesquisarPorCBMouse(ActionEvent event) {

        RelatorioQuarteiraoMetodo RQM7 = new RelatorioQuarteiraoMetodo();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                RQM7.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisa2CB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisa2CB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");
                campoPesquisa2CB.setValue("RG");
                campoPesquisaTF.setText("");
            }
        });
    }

    @FXML
    void pesquisarPorCBTeclado(KeyEvent event) {

        RelatorioQuarteiraoMetodo RQM8 = new RelatorioQuarteiraoMetodo();

        pesquisarPorCB.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                RQM8.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisa2CB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisa2CB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");
                campoPesquisa2CB.setValue("RG");
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
        RQM.abrirMenu();
//        RQM.fecharRelatorioLocalidade();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            RQM.abrirMenu();
//            RQM.fecharRelatorioLocalidade();
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

        RQM.preencherComboBoxPesquisarPor(pesquisarPorCB);

        pesquisarPorCB.getSelectionModel().selectFirst();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                RQM.pesquisarPor(
                        pesquisarPorCB,
                        campoPesquisaCB,
                        campoPesquisa2CB,
                        campoPesquisaTF,
                        paneCampoPesquisaCB,
                        paneCampoPesquisa2CB,
                        paneCampoPesquisaTF,
                        imprimirBT,
                        pesquisarBT
                );
                relatorioPesquisaTV.getItems().clear();
                campoPesquisaCB.setValue("SELECIONE");
                campoPesquisa2CB.setValue("RG");
                campoPesquisaTF.setText("");
            }
        });
        Platform.runLater(pesquisarPorCB::requestFocus);//fim do run.
    }
}
