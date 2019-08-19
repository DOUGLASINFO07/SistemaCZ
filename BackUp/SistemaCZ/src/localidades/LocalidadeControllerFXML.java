package localidades;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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

public class LocalidadeControllerFXML implements Initializable {

    LocalidadeMetodo LM = new LocalidadeMetodo();

    LocalidadeAtributos LA = new LocalidadeAtributos();

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
    private TextField codigoTF;

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField siglaTF;

    @FXML
    private ComboBox<LocalidadeMetodo> categoriaCB;

    @FXML
    private CheckBox zonaUrbanaRB;

    @FXML
    private CheckBox zonaRuralRB;

    @FXML
    private CheckBox tipoSedeRB;

    @FXML
    private CheckBox tipoOutrosRB;

    @FXML
    private TextArea observacaoTA;

    @FXML
    private TableView tabelaLocalidadeTV;

    @FXML
    private TableColumn<LocalidadeMetodo, String> colunaLocalidadeTC;

    @FXML
    private TableColumn<LocalidadeMetodo, String> colunaNumeroRGTC;

    @FXML
    private TextField buscarLocalidadeTF;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button imprimirBT;

    @FXML
    void observacaoTATeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if (salvarBT.isDisable()) {
                Platform.runLater(atualizarBT::requestFocus);
            } else {
                Platform.runLater(salvarBT::requestFocus);
            }
        }
    }

    @FXML
    void atualizarBTMouse(MouseEvent event) {
        atualizar();
        buscarLocalidadeTF.setText("");
    }

    @FXML
    void atualizarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            atualizar();
            buscarLocalidadeTF.setText("");
        }
    }

    @FXML
    void buscarLocalidadeTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.TAB) {
            listarTabelaLocalidade();
            tabelaLocalidadeTV.getSelectionModel().selectFirst();
            Platform.runLater(tabelaLocalidadeTV::requestFocus);//fim do run.
        }
        buscarLocalidadeTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                listarTabelaLocalidade();
                tabelaLocalidadeTV.getSelectionModel().selectFirst();
                pegarDados();
                if (buscarLocalidadeTF.getText().isEmpty()) {
                    listarTodosBT.setDisable(false);
                } else {
                    listarTodosBT.setDisable(true);
                }
            }
        });
    }

    @FXML
    void excluirBTMouse(MouseEvent event) {
        excluir();
        buscarLocalidadeTF.setText("");
    }

    @FXML
    void excluirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            excluir();
            buscarLocalidadeTF.setText("");
        }
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        LM.gerarRelatorio();
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            LM.gerarRelatorio();
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        listarTabelaLocalidade();
        tabelaLocalidadeTV.getSelectionModel().selectFirst();
        Platform.runLater(tabelaLocalidadeTV::requestFocus);//fim do run.
        pegarDados();
        imprimirBT.setDisable(false);
        buscarLocalidadeTF.setText("");
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            listarTabelaLocalidade();
            tabelaLocalidadeTV.getSelectionModel().selectFirst();
            Platform.runLater(tabelaLocalidadeTV::requestFocus);//fim do run.
            pegarDados();
            imprimirBT.setDisable(false);
            buscarLocalidadeTF.setText("");
        }
    }

    @FXML
    void novoCadastroBTMouse(MouseEvent event) {
        novoCadastro();
        imprimirBT.setDisable(true);
        buscarLocalidadeTF.setText("");
    }

    @FXML
    void novoCadastroBTteclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            novoCadastro();
            imprimirBT.setDisable(true);
            buscarLocalidadeTF.setText("");
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
    void tabelaLocalidadeTVMouse(MouseEvent event) {
        pegarDados();
    }

    @FXML
    void tabelaLocalidadeTVTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pegarDados();
        }
        tabelaLocalidadeTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pegarDados();
            }
        });
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        LM.abrirMenu();
        System.gc();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            LM.abrirMenu();
             System.gc();
        }
    }

    @FXML
    void tipoOutrosRBMouse(MouseEvent event) {
        tipoSedeRB.setSelected(false);
    }

    @FXML
    void tipoOutrosRBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            tipoSedeRB.setSelected(false);
        } else {
        }
    }

    @FXML
    void tipoSedeRBMouse(MouseEvent event) {
        tipoOutrosRB.setSelected(false);
    }

    @FXML
    void tipoSedeRBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            tipoOutrosRB.setSelected(false);
        } else {
        }
    }

    @FXML
    void zonaRuralRBMouse(MouseEvent event) {
        zonaUrbanaRB.setSelected(false);
    }

    @FXML
    void zonaRuralRBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            zonaUrbanaRB.setSelected(false);
        } else {
        }
    }

    @FXML
    void zonaUrbanaRBMouse(MouseEvent event) {
        zonaRuralRB.setSelected(false);
    }

    @FXML
    void zonaUrbanaRBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            zonaRuralRB.setSelected(false);
        } else {
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

        LM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );

        LM.preencherComboBoxCategoria(categoriaCB);

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.

    }

    public void novoCadastro() {
        LM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        LM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        excluirBT.setDisable(true);
        tabelaLocalidadeTV.getItems().clear();
        Platform.runLater(codigoTF::requestFocus);//fim do run.
        buscarLocalidadeTF.setText("");
        codigoTF.setEditable(true);
    }

    public void salvar() {
        LM.salvarLocalidade(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void listarTabelaLocalidade() {

        LM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );

        LM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        LM.iniciarTabela(
                colunaLocalidadeTC,
                colunaNumeroRGTC,
                tabelaLocalidadeTV,
                buscarLocalidadeTF
        );
        salvarBT.setDisable(true);
    }

    public void pegarDados() {
        LM.pegarDadoTabela(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );

        LM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        salvarBT.setDisable(true);
        atualizarBT.setDisable(false);
        excluirBT.setDisable(false);
        codigoTF.setEditable(false);
    }

    public void atualizar() {
        LM.atualizarLocalidade(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void excluir() {
        LM.excluirLocalidade(
                novoCadastroBT,
                voltarMenuBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                codigoTF,
                nomeTF,
                siglaTF,
                categoriaCB,
                zonaUrbanaRB,
                zonaRuralRB,
                tipoSedeRB,
                tipoOutrosRB,
                observacaoTA,
                tabelaLocalidadeTV,
                buscarLocalidadeTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

}
