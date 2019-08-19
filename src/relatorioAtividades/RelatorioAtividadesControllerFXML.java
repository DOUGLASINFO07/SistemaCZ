package relatorioAtividades;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;

public class RelatorioAtividadesControllerFXML implements Initializable {

    RelatorioAtividadesMetodo RAM = new RelatorioAtividadesMetodo();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private ComboBox pesquisarPorCB;

    @FXML
    private Button pesquisarBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TableView relatorioPesquisaTV;

    @FXML
    private TableColumn tipoAtividadeCT;

    @FXML
    private TableColumn dataInicioCT;

    @FXML
    private TableColumn dataTerminoCT;

    @FXML
    private TableColumn cicloCT;

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        RelatorioAtividadesMetodo RAM1 = new RelatorioAtividadesMetodo();
        RAM1.gerarRelatorio(
                pesquisarPorCB
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        RelatorioAtividadesMetodo RAM2 = new RelatorioAtividadesMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RAM2.gerarRelatorio(
                    pesquisarPorCB
            );
        }
    }

    @FXML
    void pesquisarBTMouse(MouseEvent event) {
        RelatorioAtividadesMetodo RAM3 = new RelatorioAtividadesMetodo();
        RAM3.iniciarTabela(
                tipoAtividadeCT,
                dataInicioCT,
                dataTerminoCT,
                cicloCT,
                relatorioPesquisaTV,
                pesquisarPorCB
        );
    }

    @FXML
    void pesquisarBTTeclado(KeyEvent event) {

        RelatorioAtividadesMetodo RFM4 = new RelatorioAtividadesMetodo();

        if (event.getCode() == KeyCode.ENTER) {
            RFM4.iniciarTabela(
                    tipoAtividadeCT,
                    dataInicioCT,
                    dataTerminoCT,
                    cicloCT,
                    relatorioPesquisaTV,
                    pesquisarPorCB
            );
        }
    }

    @FXML
    void pesquisarPorCBMouse(MouseEvent event) {
        imprimirBT.setDisable(false);
        pesquisarBT.setDisable(false);

        relatorioPesquisaTV.getItems().clear();
    }

    @FXML
    void pesquisarPorCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            imprimirBT.setDisable(false);
            pesquisarBT.setDisable(false);

            relatorioPesquisaTV.getItems().clear();
        }
    }

    @FXML
    void relatorioPesquisaTVMouse(MouseEvent event) {

    }

    @FXML
    void relatorioPesquisaTVTeclado(KeyEvent event) {

    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        RAM.abrirMenu();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            RAM.abrirMenu();
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

        RAM.preencherComboBoxAtividades(pesquisarPorCB);

        pesquisarPorCB.getSelectionModel().selectFirst();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                imprimirBT.setDisable(false);
                pesquisarBT.setDisable(false);
                relatorioPesquisaTV.getItems().clear();
            }
        });

        Platform.runLater(pesquisarPorCB::requestFocus);//fim do run.
    }
}
