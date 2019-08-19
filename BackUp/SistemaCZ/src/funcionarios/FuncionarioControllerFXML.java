package funcionarios;

import java.io.IOException;
import util.BuscaCEP;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;
import util.ValidarCPF;

public class FuncionarioControllerFXML implements Initializable {

    FuncionarioMetodo FM = new FuncionarioMetodo();

    FuncionarioAtributos FA = new FuncionarioAtributos();

    Utilitario util = new Utilitario();

    @FXML
    private Button voltarMenuBT;

    @FXML
    private Button buscarImagemBT;

    @FXML
    private Button salvarBT;

    @FXML
    private Button atualizarBT;

    @FXML
    private Button excluirBT;

    @FXML
    private ImageView fotoFuncionarioIV;

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField cpfTF;

    @FXML
    private TextField rgTF;

    @FXML
    private ComboBox orgaoEmissorRGCB;

    @FXML
    private ComboBox estadoOrgaoRGEmissorCB;

    @FXML
    private DatePicker dataEmissaoRGDP;

    @FXML
    private DatePicker data1HabilitacaoDP;

    @FXML
    private TextField habilitacaoTF;

    @FXML
    private ComboBox categoriaHabilitacaoCB;

    @FXML
    private DatePicker dataNascimentoDP;

    @FXML
    private TextField municipioNascimentoTF;

    @FXML
    private ComboBox<FuncionarioMetodo> estadoNascimentoCB;

    @FXML
    private TextField nomeMaeTF;

    @FXML
    private TextField nomePaiTF;

    @FXML
    private TextField logradouroEnderecoTF;

    @FXML
    private TextField numeroEnderecoTF;

    @FXML
    private TextField bairroEnderecoTF;

    @FXML
    private TextField cepEnderecoTF;

    @FXML
    private TextField cidadeEnderecoTF;

    @FXML
    private ComboBox estadoEnderecoCB;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField telefoneTF;

    @FXML
    private TextField telefoneContatoTF;

    @FXML
    private TextField whatsAppTF;

    @FXML
    private TextField matriculaTF;

    @FXML
    private ComboBox cargoCB;

    @FXML
    private ComboBox vinculoEmpregaticioCB;

    @FXML
    private ComboBox areaTrabalhoCB;

    @FXML
    private ComboBox equipeCB;

    @FXML
    private ComboBox situacaoFuncionalCB;

    @FXML
    private DatePicker dataDemissaoDP;

    @FXML
    private DatePicker dataAdmissaoDP;

    @FXML
    private ComboBox formaEgressoCB;

    @FXML
    private ComboBox formaIngressoCB;

    @FXML
    private TextArea observacaoTA;

    @FXML
    private TableView tabelaFuncionarioTV;

    @FXML
    private TableColumn<FuncionarioMetodo, String> colunaNomeTC;

    @FXML
    private TableColumn<FuncionarioMetodo, String> colunaEquipeTC;

    @FXML
    private TextField buscarFuncionarioTF;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button novoCadastroBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Button imprimirBT;

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        FM.gerarRelatorio();
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            FM.gerarRelatorio();
        }
    }

    @FXML
    void atualizarBTMouse(MouseEvent event) {
        atualizar();
        buscarFuncionarioTF.setText("");
    }

    @FXML
    void atualizarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            atualizar();
            buscarFuncionarioTF.setText("");
        }
    }

    @FXML
    void buscarFuncionarioTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.TAB) {
            listarTabelaFuncionario();
            tabelaFuncionarioTV.getSelectionModel().selectFirst();
            Platform.runLater(tabelaFuncionarioTV::requestFocus);//fim do run.
        }
        buscarFuncionarioTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                listarTabelaFuncionario();
                tabelaFuncionarioTV.getSelectionModel().selectFirst();
                pegarDados();
                if (habilitacaoTF.getText().equals("")) {
                    categoriaHabilitacaoCB.setDisable(true);
                    data1HabilitacaoDP.setDisable(true);
                } else {
                    categoriaHabilitacaoCB.setDisable(false);
                    data1HabilitacaoDP.setDisable(false);
                }
                if (buscarFuncionarioTF.getText().isEmpty()) {
                    listarTodosBT.setDisable(false);
                } else {
                    listarTodosBT.setDisable(true);
                }
            }
        });

    }

    @FXML
    void buscarImagemMouse(MouseEvent event) {
        FM.selecionarFoto(fotoFuncionarioIV);
    }

    @FXML
    void buscarImagemTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            FM.selecionarFoto(fotoFuncionarioIV);
        }
    }

    @FXML
    void excluirBTMouse(MouseEvent event) {
        excluir();
        buscarFuncionarioTF.setText("");
    }

    @FXML
    void excluirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            excluir();
            buscarFuncionarioTF.setText("");
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        listarTabelaFuncionario();
        tabelaFuncionarioTV.getSelectionModel().selectFirst();
        Platform.runLater(tabelaFuncionarioTV::requestFocus);//fim do run.
        pegarDados();
        if (habilitacaoTF.getText().equals("")) {
            categoriaHabilitacaoCB.setDisable(true);
            data1HabilitacaoDP.setDisable(true);
        } else {
            categoriaHabilitacaoCB.setDisable(false);
            data1HabilitacaoDP.setDisable(false);
        }
        imprimirBT.setDisable(false);
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            listarTabelaFuncionario();
            tabelaFuncionarioTV.getSelectionModel().selectFirst();
            Platform.runLater(tabelaFuncionarioTV::requestFocus);//fim do run.
            pegarDados();
            if (habilitacaoTF.getText().equals("")) {
                categoriaHabilitacaoCB.setDisable(true);
                data1HabilitacaoDP.setDisable(true);
            } else {
                categoriaHabilitacaoCB.setDisable(false);
                data1HabilitacaoDP.setDisable(false);
            }
            imprimirBT.setDisable(false);
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
    void tabelaFuncionarioTVMouse(MouseEvent event) {
        pegarDados();
        if (habilitacaoTF.getText().equals("")) {
            categoriaHabilitacaoCB.setDisable(true);
            data1HabilitacaoDP.setDisable(true);
        } else {
            categoriaHabilitacaoCB.setDisable(false);
            data1HabilitacaoDP.setDisable(false);
        }
    }

    @FXML
    void tabelaFuncionarioTVTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pegarDados();
        }
        tabelaFuncionarioTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pegarDados();
                if (habilitacaoTF.getText().equals("")) {
                    categoriaHabilitacaoCB.setDisable(true);
                    data1HabilitacaoDP.setDisable(true);
                } else {
                    categoriaHabilitacaoCB.setDisable(false);
                    data1HabilitacaoDP.setDisable(false);
                }
            }
        });
    }

    @FXML
    void voltarMenuBTMouse(MouseEvent event) {
        FM.abrirMenu();
        FM.fecharFuncionario();
    }

    @FXML
    void voltarMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            FM.abrirMenu();
            FM.fecharFuncionario();
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
    void cepEnderecoTFMouse(MouseEvent event) {
        
        
    }

    @FXML
    void cepEnderecoTFTeclado(KeyEvent event) throws IOException {
        BuscaCEP buscaCEP = new BuscaCEP();
        if (event.getCode() == KeyCode.TAB || event.getCode() == KeyCode.ENTER) {
           String CEP = cepEnderecoTF.getText();
            bairroEnderecoTF.setText(buscaCEP.getBairro(CEP.replace(".", "").replace("-", "")));
            logradouroEnderecoTF.setText(buscaCEP.getEndereco(CEP.replace(".", "").replace("-", "")));
            cidadeEnderecoTF.setText(buscaCEP.getCidade(CEP.replace(".", "").replace("-", "")));
            estadoEnderecoCB.setValue(buscaCEP.getUF(CEP.replace(".", "").replace("-", "")));
        }
    }
    
    @FXML
    void cpfTFMouse(MouseEvent event) {
        
        
    }

    @FXML
    void cpfTFTeclado(KeyEvent event) throws IOException {
        ValidarCPF validarCPF = new ValidarCPF();
        if (event.getCode() == KeyCode.TAB || event.getCode() == KeyCode.ENTER) {
            String CPF = cpfTF.getText();
          if(validarCPF.isCPF(CPF.replace(".", "").replace("-", "")) == true){
              
          }else{
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("CONTROLE DE ZOONOSES\nCADASTRO DE FUNCIONÁRIO");
                    alert.setContentText("ATENÇÃO!!\n CPF INVÁLIDO!!\n"
                            + "O NÚMERO DO CPF NÃO EXISTE!!");
                    alert.show();//Fim do if.
                    cpfTF.setText("");
                    Platform.runLater(cpfTF::requestFocus);//fim do run.
          }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

        FM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );

        util.cpfCnpjField(cpfTF);
        util.rgField(rgTF);
        util.formatarTelefone(telefoneTF);
        util.maxField(telefoneTF, 15);
        util.formatarTelefone(telefoneContatoTF);
        util.maxField(telefoneContatoTF, 15);
        util.formatarTelefone(whatsAppTF);
        util.maxField(whatsAppTF, 15);
        util.CEPField(cepEnderecoTF);

        FM.preencherComboBoxOrgaoEmissorRG(orgaoEmissorRGCB);
        FM.preencherComboBoxEstado(estadoOrgaoRGEmissorCB);
        FM.preencherComboBoxEstado(estadoNascimentoCB);
        FM.preencherComboBoxEstado(estadoEnderecoCB);
        FM.preencherComboBoxCategotiaHabilitacao(categoriaHabilitacaoCB);
        FM.preencherComboBoxcargo(cargoCB);
        FM.preencherComboBoxVinculoEmpregaticio(vinculoEmpregaticioCB);
        FM.preencherComboBoxEquipe(equipeCB);
        FM.preencherComboBoxAreaTrabalho(areaTrabalhoCB);
        FM.preencherComboBoxSituacaoFuncional(situacaoFuncionalCB);
        FM.preencherComboBoxFormaEgresso(formaEgressoCB);
        FM.preencherComboBoxFormaIngresso(formaIngressoCB);

        FA.setFotoFuncionario("/imagens/usuario.png");

        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.

    }

    public void novoCadastro() {
        FM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        FM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        buscarImagemBT.setDisable(false);
        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        excluirBT.setDisable(true);
        tabelaFuncionarioTV.getItems().clear();
        Platform.runLater(nomeTF::requestFocus);//fim do run.
        buscarFuncionarioTF.setText("");
        categoriaHabilitacaoCB.setDisable(true);
        data1HabilitacaoDP.setDisable(true);
        categoriaHabilitacaoCB.setValue("SELECIONE");
        data1HabilitacaoDP.getEditor().clear();
    }

    public void salvar() {

        FM.salvarFuncionario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void listarTabelaFuncionario() {

        FM.limparFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );

        FM.bloquearCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        FM.iniciarTabela(
                colunaNomeTC,
                colunaEquipeTC,
                tabelaFuncionarioTV,
                buscarFuncionarioTF
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        String nome = colunaNomeTC.getCellData(0);
        FuncionarioAtributos fa = new FuncionarioAtributos();
        funcionarioDAO.buscarFoto(nome, fa);
        fotoFuncionarioIV.setImage(new Image("file:../src/" + fa.getFotoFuncionario()));

    }

    public void pegarDados() {
        FM.pegarDadoTabela(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );

        FM.liberarCamposFormulario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        salvarBT.setDisable(true);
        atualizarBT.setDisable(false);
        excluirBT.setDisable(false);
        buscarImagemBT.setDisable(false);
        matriculaTF.setEditable(false);
    }

    public void atualizar() {
        FM.atualizarFuncionario(
                novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    public void excluir() {
        FM.excluirFuncionario(novoCadastroBT,
                voltarMenuBT,
                buscarImagemBT,
                salvarBT,
                atualizarBT,
                excluirBT,
                fotoFuncionarioIV,
                nomeTF,
                cpfTF,
                rgTF,
                orgaoEmissorRGCB,
                estadoOrgaoRGEmissorCB,
                dataEmissaoRGDP,
                data1HabilitacaoDP,
                habilitacaoTF,
                categoriaHabilitacaoCB,
                dataNascimentoDP,
                municipioNascimentoTF,
                estadoNascimentoCB,
                nomeMaeTF,
                nomePaiTF,
                logradouroEnderecoTF,
                numeroEnderecoTF,
                bairroEnderecoTF,
                cepEnderecoTF,
                cidadeEnderecoTF,
                estadoEnderecoCB,
                emailTF,
                telefoneTF,
                telefoneContatoTF,
                whatsAppTF,
                matriculaTF,
                cargoCB,
                vinculoEmpregaticioCB,
                areaTrabalhoCB,
                equipeCB,
                situacaoFuncionalCB,
                dataDemissaoDP,
                dataAdmissaoDP,
                formaEgressoCB,
                formaIngressoCB,
                observacaoTA,
                tabelaFuncionarioTV,
                buscarFuncionarioTF,
                listarTodosBT
        );
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void habilitacaoTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if (categoriaHabilitacaoCB.isDisable()) {
                Platform.runLater(dataNascimentoDP::requestFocus);//fim do run.
            } else {
                Platform.runLater(categoriaHabilitacaoCB::requestFocus);//fim do run.
            }
        }

        habilitacaoTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (habilitacaoTF.getText().equals("")) {
                    categoriaHabilitacaoCB.setDisable(true);
                    data1HabilitacaoDP.setDisable(true);
                } else {
                    categoriaHabilitacaoCB.setDisable(false);
                    data1HabilitacaoDP.setDisable(false);
                }
            }
        });
    }
}
