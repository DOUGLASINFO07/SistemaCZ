package relatorioLocalidade;

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
import util.CarregarPagina;
import util.Notificacao;
import util.Relogio;
import util.Utilitario;

public class RelatorioLocalidadeControllerFXML implements Initializable {

    RelatorioLocalidadeMetodo RLM = new RelatorioLocalidadeMetodo();
    
    CarregarPagina cp = new CarregarPagina();
    
    Utilitario util = new Utilitario();
    
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
    private TableColumn codigoCT;

    @FXML
    private TableColumn localidadeCT;

    @FXML
    private TableColumn siglaCT;

    @FXML
    private TableColumn categoriaCT;

    @FXML
    private TableColumn zonaCT;

    @FXML
    private TableColumn tipoCT;

    @FXML
    private TableColumn observacaoCT;

    @FXML
    void campoPesquisaCBMouse(MouseEvent event) {

    }

    @FXML
    void campoPesquisaCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            RelatorioLocalidadeMetodo RFM1 = new RelatorioLocalidadeMetodo();
            RFM1.iniciarTabela(
                    codigoCT,
                    localidadeCT,
                    siglaCT,
                    categoriaCT,
                    zonaCT,
                    tipoCT,
                    observacaoCT,
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
        RelatorioLocalidadeMetodo RFM2 = new RelatorioLocalidadeMetodo();

        campoPesquisaTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            RelatorioLocalidadeMetodo RFM8 = new RelatorioLocalidadeMetodo();

            @Override
            public void handle(KeyEvent event) {
                RFM2.iniciarTabela(
                        codigoCT,
                        localidadeCT,
                        siglaCT,
                        categoriaCT,
                        zonaCT,
                        tipoCT,
                        observacaoCT,
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
        RelatorioLocalidadeMetodo RFM3 = new RelatorioLocalidadeMetodo();
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
        RelatorioLocalidadeMetodo RFM4 = new RelatorioLocalidadeMetodo();
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
        RelatorioLocalidadeMetodo RFM5 = new RelatorioLocalidadeMetodo();
        RFM5.iniciarTabela(
                codigoCT,
                localidadeCT,
                siglaCT,
                categoriaCT,
                zonaCT,
                tipoCT,
                observacaoCT,
                relatorioPesquisaTV,
                campoPesquisaCB,
                campoPesquisaTF,
                pesquisarPorCB,
                paneCampoPesquisaCB,
                paneCampoPesquisaTF
        );
        if (relatorioPesquisaTV.getItems().isEmpty()) {
            
//            util.alertSimples("RELATORIO DE LOCALIDADES", "Nenuhm dado foi encontrado");
            
            Notificacao notificacao = new Notificacao("RELATORIO DE LOCALIDADES",
                    "NENHUMA LOCALIDADE ENCONTRADA!!", "/imagens/iconeSistemaCZ100x100.png");
            notificacao.start();
            
            
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText("CONTROLE DE FINANÇAS\nRELATORIO DE LOCALIDADES");
//            alert.setContentText("NENHUM DADO FOI ENCONTRADO!");
//            alert.show();
        }
    }

    @FXML
    void pesquisarBTTeclado(KeyEvent event) {
        RelatorioLocalidadeMetodo RFM6 = new RelatorioLocalidadeMetodo();
        if (event.getCode() == KeyCode.ENTER) {
            RFM6.iniciarTabela(
                    codigoCT,
                    localidadeCT,
                    siglaCT,
                    categoriaCT,
                    zonaCT,
                    tipoCT,
                    observacaoCT,
                    relatorioPesquisaTV,
                    campoPesquisaCB,
                    campoPesquisaTF,
                    pesquisarPorCB,
                    paneCampoPesquisaCB,
                    paneCampoPesquisaTF
            );
            if (relatorioPesquisaTV.getItems().isEmpty()) {
                Notificacao notificacao = new Notificacao("RELATORIO DE LOCALIDADES",
                    "NENHUMA LOCALIDADE ENCONTRADA!!", "/imagens/iconeSistemaCZ100x100.png");
            notificacao.start();
            }
        }
    }

    @FXML
    void pesquisarPorCBMouse(ActionEvent event) {

        RelatorioLocalidadeMetodo RFM7 = new RelatorioLocalidadeMetodo();

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

        RelatorioLocalidadeMetodo RFM8 = new RelatorioLocalidadeMetodo();

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
        cp.carregarPagina("/menu/Menu.fxml");
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
             cp.carregarPagina("/menu/Menu.fxml");
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

        RLM.preencherComboBoxPesquisarPor(pesquisarPorCB);

        pesquisarPorCB.getSelectionModel().selectFirst();

        pesquisarPorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                RLM.pesquisarPor(
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
        Platform.runLater(pesquisarPorCB::requestFocus);//fim do run.
    }
}
