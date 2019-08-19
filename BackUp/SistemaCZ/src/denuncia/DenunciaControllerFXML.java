package denuncia;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;

public class DenunciaControllerFXML implements Initializable {

    DenunciasMetodos DM = new DenunciasMetodos();
    
    DenunciaAtributos DA = new DenunciaAtributos();

    DenunciaDAO dao = new DenunciaDAO();

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
    private Button imprimirBT;

    @FXML
    private TextField numeroDenunciaTF;

    @FXML
    private DatePicker dataDenunciaDP;

    @FXML
    private ComboBox recebidaPorCB;

    @FXML
    private TextField denunciadoTF;

    @FXML
    private TextField denuncianteTF;

    @FXML
    private TextField logradouraTF;

    @FXML
    private TextField numeroEnderecoTF;

    @FXML
    private ComboBox bairroCB;

    @FXML
    private ComboBox tipoImovelCB;

    @FXML
    private ComboBox tipoDenunciaCB;

    @FXML
    private TextArea detalhesDenunciaTA;

    @FXML
    private ComboBox ace1CB;

    @FXML
    private ComboBox ace2CB;

    @FXML
    private CheckBox abertaCheckBox;

    @FXML
    private CheckBox concluidoCheckBox;

    @FXML
    private DatePicker dataVisitaDP;

    @FXML
    private TextArea relatorioVisitaTA;

    @FXML
    private Button listarBT;

    @FXML
    private TextField numeroDenunciaPesquisaTF;

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

        DM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );
        dao.listaACE(ace1CB);
        dao.listaACE(ace2CB);
        dao.listaACEDenuncia(recebidaPorCB);

        DM.preencherComboBoxTipoImovel(tipoImovelCB);
        DM.preencherComboBoxTipoDenuncia(tipoDenunciaCB);

        dao.listaLocalidade(bairroCB);
        
        numeroDenunciaPesquisaTF.setText("0");

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void salvar() {
        DM.salvarDenuncia(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );

//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("IMPRESSÃO DE DENUNCIA");
//        alert.setHeaderText("ATENÇÃO!!");
//        alert.setContentText("DESEJA IMPRIMIR A DENUNCIA?");
//
//        ButtonType buttonTypeOne = new ButtonType("Sim");
//        ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
//
//        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == buttonTypeOne) {
//            DM.gerarRelatorio(
//                    numeroDenunciaTF
//            );
//            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
//        } else if (result.get() == buttonTypeTwo) {
//
//        }
    }

    public void atualizar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ATUALIZAÇÃO DE DENUNCIA");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR ATUALIZAÇÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            DM.atualizarDenuncia(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    numeroDenunciaTF,
                    dataDenunciaDP,
                    recebidaPorCB,
                    denuncianteTF,
                    denunciadoTF,
                    logradouraTF,
                    numeroEnderecoTF,
                    bairroCB,
                    tipoImovelCB,
                    tipoDenunciaCB,
                    detalhesDenunciaTA,
                    ace1CB,
                    ace2CB,
                    abertaCheckBox,
                    concluidoCheckBox,
                    dataVisitaDP,
                    relatorioVisitaTA,
                    numeroDenunciaPesquisaTF,
                    listarBT,
                    imprimirBT
            );
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        }
    }

    public void excluir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXCLUSÃO DE DENUNCIA");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("CONFIRMAR EXCLUSÃO?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            DM.excluirDenuncia(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    numeroDenunciaTF,
                    dataDenunciaDP,
                    recebidaPorCB,
                    denuncianteTF,
                    denunciadoTF,
                    logradouraTF,
                    numeroEnderecoTF,
                    bairroCB,
                    tipoImovelCB,
                    tipoDenunciaCB,
                    detalhesDenunciaTA,
                    ace1CB,
                    ace2CB,
                    abertaCheckBox,
                    concluidoCheckBox,
                    dataVisitaDP,
                    relatorioVisitaTA,
                    numeroDenunciaPesquisaTF,
                    listarBT,
                    imprimirBT
            );
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        } else if (result.get() == buttonTypeTwo) {

        }
    }

    public void novoCadastro() {
        DM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );
        DM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );
        
        numeroDenunciaTF.setEditable(false);
        
        dao.contagemNumeroDenuncia(DA);
        
        int soma = DA.getSomaNumeroDenuncia() + 1;
        
        numeroDenunciaTF.setText(""+soma);
        
        salvarBT.setDisable(false);
        imprimirBT.setDisable(true);
        excluirBT.setDisable(true);
        atualizarBT.setDisable(true);
        
        numeroDenunciaPesquisaTF.setText("0");
        
    }

    public void buscarDados() {
        DM.pegarDados(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );
        DM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                numeroDenunciaTF,
                dataDenunciaDP,
                recebidaPorCB,
                denuncianteTF,
                denunciadoTF,
                logradouraTF,
                numeroEnderecoTF,
                bairroCB,
                tipoImovelCB,
                tipoDenunciaCB,
                detalhesDenunciaTA,
                ace1CB,
                ace2CB,
                abertaCheckBox,
                concluidoCheckBox,
                dataVisitaDP,
                relatorioVisitaTA,
                numeroDenunciaPesquisaTF,
                listarBT,
                imprimirBT
        );
       
        salvarBT.setDisable(true);
        atualizarBT.setDisable(false);
        excluirBT.setDisable(false);
        imprimirBT.setDisable(false);
        numeroDenunciaTF.setEditable(false);
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
    void detalhesDenunciaTATeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(ace1CB::requestFocus);//fim do run.
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
        DM.gerarRelatorio(
                numeroDenunciaTF
        );
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            DM.gerarRelatorio(
                    numeroDenunciaTF
            );
        }
    }

    @FXML
    void listarBTMouse(MouseEvent event) {
        buscarDados();

    }

    @FXML
    void listarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            buscarDados();
        }
    }

    @FXML
    void novoCadastroBTMouse(MouseEvent event) {
        novoCadastro();
    }

    @FXML
    void novoCadastroBTteclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            novoCadastro();
        }
    }

    @FXML
    void relatorioVisitaTATeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(numeroDenunciaPesquisaTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void salvarBTMouse(MouseEvent event) {
        salvar();
    }

    @FXML
    void salvarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            salvar();
        }
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        DM.abrirMenu();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            DM.abrirMenu();
        }
    }

    @FXML
    void abertaCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            concluidoCheckBox.setSelected(false);
        }
    }

    @FXML
    void abertaCheckBoxMouse(MouseEvent event) {
        concluidoCheckBox.setSelected(false);
    }

    @FXML
    void concluidoCheckBoxTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            abertaCheckBox.setSelected(false);
        }
    }

    @FXML
    void concluidoCheckBoxMouse(MouseEvent event) {
        abertaCheckBox.setSelected(false);
    }

}
