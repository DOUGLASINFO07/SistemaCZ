package funcionarios;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import jeanderson.br.util.MaskFormatter;
import menu.MenuMetodos;
import util.SituacaoFuncional;
import util.Utilitario;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @since 24/08/2019
 */
public class FuncionarioMetodo extends Application {

    Connection conn;

    Utilitario util = new Utilitario();

    MenuMetodos menuMetodos = new MenuMetodos();

    FuncionarioAtributos FA = new FuncionarioAtributos();

    public FuncionarioMetodo() {
    }

    public FuncionarioMetodo(int posicao, String orgaoEmissorRG) {
        FA.setOrgaoEmissorRG(orgaoEmissorRG);
    }

    @Override
    public String toString() {
        return FA.getOrgaoEmissorRG();
    }

    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

    public void limparFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        nomeTF.setText("");
        cpfTF.setText("");
        rgTF.setText("");
        orgaoEmissorRGCB.setValue("Selecione");
        estadoOrgaoRGEmissorCB.setValue("UF");
        dataEmissaoRGDP.getEditor().clear();
        data1HabilitacaoDP.getEditor().clear();
        habilitacaoTF.setText("");
        categoriaHabilitacaoCB.setValue("Selecione");
        dataNascimentoDP.getEditor().clear();
        municipioNascimentoTF.setText("");
        estadoNascimentoCB.setValue("UF");
        nomeMaeTF.setText("");
        nomePaiTF.setText("");
        logradouroEnderecoTF.setText("");
        numeroEnderecoTF.setText("");
        bairroEnderecoTF.setText("");
        cepEnderecoTF.setText("");
        cidadeEnderecoTF.setText("");
        estadoEnderecoCB.setValue("UF");
        emailTF.setText("");
        telefoneTF.setText("");
        telefoneContatoTF.setText("");
        whatsAppTF.setText("");
        matriculaTF.setText("");
        cargoCB.setValue("Selecione");
        vinculoEmpregaticioCB.setValue("Selecione");
        areaTrabalhoCB.setValue("Selecione");
        equipeCB.setValue("Selecione");
        situacaoFuncionalCB.setValue("Selecione");
        dataDemissaoDP.getEditor().clear();
        dataAdmissaoDP.getEditor().clear();
        formaEgressoCB.setValue("Selecione");
        formaIngressoCB.setValue("Selecione");
        observacaoTA.setText("");
        fotoFuncionarioIV.setImage(new Image("/imagens/usuario.png"));
    }

    public void liberarCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        nomeTF.setDisable(false);
        cpfTF.setDisable(false);
        rgTF.setDisable(false);
        orgaoEmissorRGCB.setDisable(false);
        estadoOrgaoRGEmissorCB.setDisable(false);
        dataEmissaoRGDP.setDisable(false);
        habilitacaoTF.setDisable(false);
        dataNascimentoDP.setDisable(false);
        municipioNascimentoTF.setDisable(false);
        estadoNascimentoCB.setDisable(false);
        nomeMaeTF.setDisable(false);
        nomePaiTF.setDisable(false);
        logradouroEnderecoTF.setDisable(false);
        numeroEnderecoTF.setDisable(false);
        bairroEnderecoTF.setDisable(false);
        cepEnderecoTF.setDisable(false);
        cidadeEnderecoTF.setDisable(false);
        estadoEnderecoCB.setDisable(false);
        emailTF.setDisable(false);
        telefoneTF.setDisable(false);
        telefoneContatoTF.setDisable(false);
        whatsAppTF.setDisable(false);
        matriculaTF.setDisable(false);
        cargoCB.setDisable(false);
        vinculoEmpregaticioCB.setDisable(false);
        areaTrabalhoCB.setDisable(false);
        equipeCB.setDisable(false);
        situacaoFuncionalCB.setDisable(false);
        dataDemissaoDP.setDisable(false);
        dataAdmissaoDP.setDisable(false);
        formaEgressoCB.setDisable(false);
        formaIngressoCB.setDisable(false);
        observacaoTA.setDisable(false);
    }

    public void bloquearCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        nomeTF.setDisable(true);
        cpfTF.setDisable(true);
        rgTF.setDisable(true);
        orgaoEmissorRGCB.setDisable(true);
        estadoOrgaoRGEmissorCB.setDisable(true);
        dataEmissaoRGDP.setDisable(true);
        data1HabilitacaoDP.setDisable(true);
        habilitacaoTF.setDisable(true);
        categoriaHabilitacaoCB.setDisable(true);
        dataNascimentoDP.setDisable(true);
        municipioNascimentoTF.setDisable(true);
        estadoNascimentoCB.setDisable(true);
        nomeMaeTF.setDisable(true);
        nomePaiTF.setDisable(true);
        logradouroEnderecoTF.setDisable(true);
        numeroEnderecoTF.setDisable(true);
        bairroEnderecoTF.setDisable(true);
        cepEnderecoTF.setDisable(true);
        cidadeEnderecoTF.setDisable(true);
        estadoEnderecoCB.setDisable(true);
        emailTF.setDisable(true);
        telefoneTF.setDisable(true);
        telefoneContatoTF.setDisable(true);
        whatsAppTF.setDisable(true);
        matriculaTF.setDisable(true);
        cargoCB.setDisable(true);
        vinculoEmpregaticioCB.setDisable(true);
        areaTrabalhoCB.setDisable(true);
        equipeCB.setDisable(true);
        situacaoFuncionalCB.setDisable(true);
        dataDemissaoDP.setDisable(true);
        dataAdmissaoDP.setDisable(true);
        formaEgressoCB.setDisable(true);
        formaIngressoCB.setDisable(true);
        observacaoTA.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn cargo,
            TableView tabelaFuncionario,
            TextField buscarFuncionario
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        cargo.setCellValueFactory(new PropertyValueFactory("equipe"));
        tabelaFuncionario.setItems(atualizaTabela(buscarFuncionario.getText()));
    }

    public ObservableList<FuncionarioAtributos> atualizaTabela(String buscarFuncionario) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return FXCollections.observableArrayList(dao.listaFuncionario(
                buscarFuncionario
        ));
    }

    public void pegarDadoTabela(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        String nome = tabelaFuncionarioTV.getSelectionModel().getSelectedItem().toString();
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.buscarDadosFuncionario(nome, FA);

        nomeTF.setText(FA.getNome());
        cpfTF.setText(FA.getCpf());
        rgTF.setText(FA.getRg());
        orgaoEmissorRGCB.setValue(FA.getOrgaoEmissorRG());
        estadoOrgaoRGEmissorCB.setValue(FA.getEstadoOrgaoEmissorRG());
        dataEmissaoRGDP.getEditor().setText(util.converterDataAmericanoBrasil(FA.getDataEmissaoRG()));

        if (FA.getData1Habilitacao() == null) {
            data1HabilitacaoDP.getEditor().setText("");
        } else {
            data1HabilitacaoDP.getEditor().setText(util.converterDataAmericanoBrasil(FA.getData1Habilitacao()));
        }

        habilitacaoTF.setText(FA.getHabilitacao());
        categoriaHabilitacaoCB.setValue(FA.getCategoriaHabilitacao());
        dataNascimentoDP.getEditor().setText(util.converterDataAmericanoBrasil(FA.getDataNascimento()));
        municipioNascimentoTF.setText(FA.getMunicipioNascimento());
        estadoNascimentoCB.setValue(FA.getEstadoNascimento());
        nomeMaeTF.setText(FA.getNomeMae());
        nomePaiTF.setText(FA.getNomePai());
        logradouroEnderecoTF.setText(FA.getLogradouroEndereco());
        numeroEnderecoTF.setText(FA.getNumeroEndereco());
        bairroEnderecoTF.setText(FA.getBairroEndereco());
        cepEnderecoTF.setText(FA.getCepEndereco());
        cidadeEnderecoTF.setText(FA.getCidadeEndereco());
        estadoEnderecoCB.setValue(FA.getEstadoEndereco());
        emailTF.setText(FA.getEmail());
        telefoneTF.setText(FA.getTelefone());
        telefoneContatoTF.setText(FA.getTelefoneContato());
        whatsAppTF.setText(FA.getWhtasApp());
        matriculaTF.setText(FA.getMatricula());
        cargoCB.setValue(FA.getCargo());
        vinculoEmpregaticioCB.setValue(FA.getVinculoEmpregaticio());
        areaTrabalhoCB.setValue(FA.getAreaTrabalho());
        equipeCB.setValue(FA.getEquipe());
        situacaoFuncionalCB.setValue(FA.getSituacaoFuncional());

        if (FA.getDataDemissao() == null) {
            dataDemissaoDP.getEditor().setText("");
        } else {
            dataDemissaoDP.getEditor().setText(util.converterDataAmericanoBrasil(FA.getDataDemissao()));
        }

        dataAdmissaoDP.getEditor().setText(util.converterDataAmericanoBrasil(FA.getDataAdmissao()));
        formaEgressoCB.setValue(FA.getFormaEgresso());
        formaIngressoCB.setValue(FA.getFormaIngresso());
        observacaoTA.setText(FA.getObservacao());
        fotoFuncionarioIV.setImage(new Image("file:../src/" + FA.getFotoFuncionario()));

    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void salvarFuncionario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT,
            FuncionarioAtributos FA
    ) {

        FA.setNome(nomeTF.getText());
        FA.setCpf(cpfTF.getText());
        FA.setRg(rgTF.getText());
        FA.setOrgaoEmissorRG(orgaoEmissorRGCB.getSelectionModel().getSelectedItem().toString());
        FA.setEstadoOrgaoEmissorRG(estadoOrgaoRGEmissorCB.getSelectionModel().getSelectedItem().toString());

        if (dataEmissaoRGDP.getEditor().getText().equals("")) {
            FA.setDataEmissaoRG(null);
        } else {
            FA.setDataEmissaoRG(util.converterDataBrasilAmericano(dataEmissaoRGDP.getEditor().getText()));
        }

        FA.setHabilitacao(habilitacaoTF.getText());
        FA.setCategoriaHabilitacao(categoriaHabilitacaoCB.getSelectionModel().getSelectedItem().toString());

        if (data1HabilitacaoDP.getEditor().getText().equals("")) {
            FA.setData1Habilitacao(null);
        } else {
            FA.setData1Habilitacao(util.converterDataBrasilAmericano(data1HabilitacaoDP.getEditor().getText()));
        }

        if (dataNascimentoDP.getEditor().getText().equals("")) {
            FA.setDataNascimento(null);
        } else {
            FA.setDataNascimento(util.converterDataBrasilAmericano(dataNascimentoDP.getEditor().getText()));
        }

        FA.setMunicipioNascimento(municipioNascimentoTF.getText());
        FA.setEstadoNascimento(estadoNascimentoCB.getSelectionModel().getSelectedItem().toString());
        FA.setNomeMae(nomeMaeTF.getText());
        FA.setNomePai(nomePaiTF.getText());
        FA.setLogradouroEndereco(logradouroEnderecoTF.getText());
        FA.setNumeroEndereco(numeroEnderecoTF.getText());
        FA.setBairroEndereco(bairroEnderecoTF.getText());
        FA.setCepEndereco(cepEnderecoTF.getText());
        FA.setCidadeEndereco(cidadeEnderecoTF.getText());
        FA.setEstadoEndereco(estadoEnderecoCB.getSelectionModel().getSelectedItem().toString());
        FA.setEmail(emailTF.getText());
        FA.setTelefone(telefoneTF.getText());
        FA.setTelefoneContato(telefoneContatoTF.getText());
        FA.setWhtasApp(whatsAppTF.getText());
        FA.setCargo(cargoCB.getSelectionModel().getSelectedItem().toString());
        FA.setVinculoEmpregaticio(vinculoEmpregaticioCB.getSelectionModel().getSelectedItem().toString());
        FA.setMatricula(matriculaTF.getText());
        FA.setEquipe(equipeCB.getSelectionModel().getSelectedItem().toString());
        FA.setAreaTrabalho(areaTrabalhoCB.getValue().toString());
        FA.setSituacaoFuncional(situacaoFuncionalCB.getSelectionModel().getSelectedItem().toString());

        if (dataAdmissaoDP.getEditor().getText().equals("")) {
            FA.setDataAdmissao(null);
        } else {
            FA.setDataAdmissao(util.converterDataBrasilAmericano(dataAdmissaoDP.getEditor().getText()));
        }

        if (dataDemissaoDP.getEditor().getText().equals("")) {
            FA.setDataDemissao(null);
        } else {
            FA.setDataDemissao(util.converterDataBrasilAmericano(dataDemissaoDP.getEditor().getText()));
        }

        FA.setFormaIngresso(formaIngressoCB.getSelectionModel().getSelectedItem().toString());
        FA.setFormaEgresso(formaEgressoCB.getSelectionModel().getSelectedItem().toString());
        FA.setObservacao(observacaoTA.getText());

        FA.setFotoFuncionario(fotoFuncionarioIV.getImage().toString());

        System.out.println(FA.getFotoFuncionario());

        if (nomeTF.getText().equals("")
                || cpfTF.getText().equals("")
                || rgTF.getText().equals("")
                || orgaoEmissorRGCB.getValue().equals("Selecione")
                || estadoOrgaoRGEmissorCB.getValue().equals("UF")
                || dataEmissaoRGDP.equals("")
                || dataEmissaoRGDP.equals("")
                || municipioNascimentoTF.getText().equals("")
                || estadoNascimentoCB.getValue().equals("UF")
                || nomeMaeTF.getText().equals("")
                || logradouroEnderecoTF.getText().equals("")
                || numeroEnderecoTF.getText().equals("")
                || bairroEnderecoTF.getText().equals("")
                || cepEnderecoTF.getText().equals("")
                || cidadeEnderecoTF.getText().equals("")
                || estadoEnderecoCB.getValue().equals("UF")
                || emailTF.getText().equals("")
                || telefoneTF.getText().equals("")
                || matriculaTF.getText().equals("")
                || cargoCB.getValue().equals("Selecione")
                || vinculoEmpregaticioCB.getValue().equals("Selecione")
                || areaTrabalhoCB.getValue().equals("Selecione")
                || equipeCB.getValue().equals("Selecione")
                || situacaoFuncionalCB.getValue().equals("Selecione")
                || dataAdmissaoDP.equals("")
                || formaIngressoCB.getValue().equals("Selecione")
                || FA.getFotoFuncionario().equals("/imagens/usuario.png")) {

            util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!"
                    + "\nConfira o formulário!"
                    + "\nTodos os campos devem ser preenchidos!");

            Platform.runLater(() -> {
                nomeTF.requestFocus();
            });
        } else {
            if (telefoneTF.getText().length() < 15) {
                Platform.runLater(() -> {
                    telefoneTF.requestFocus();
                    telefoneTF.positionCaret(telefoneTF.getText().length());
                });

                util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!!\n Confira o número do telefone!!");

            } else {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailTF.getText());
                if (!(m.find() && m.group().equals(emailTF.getText()))) {
                    Platform.runLater(() -> {
                        emailTF.requestFocus();
                    });
                    util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!!\n Confira o E-mail!!");
                } else {
                    //Confere se está tudo ok com o banco de dados
                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    FuncionarioAtributos funcionarioAtributo = new FuncionarioAtributos(
                            FA.getNome(),
                            FA.getCpf(),
                            FA.getRg(),
                            FA.getOrgaoEmissorRG(),
                            FA.getEstadoOrgaoEmissorRG(),
                            FA.getDataEmissaoRG(),
                            FA.getHabilitacao(),
                            FA.getCategoriaHabilitacao(),
                            FA.getData1Habilitacao(),
                            FA.getDataNascimento(),
                            FA.getMunicipioNascimento(),
                            FA.getEstadoNascimento(),
                            FA.getNomeMae(),
                            FA.getNomePai(),
                            FA.getLogradouroEndereco(),
                            FA.getNumeroEndereco(),
                            FA.getBairroEndereco(),
                            FA.getCepEndereco(),
                            FA.getCidadeEndereco(),
                            FA.getEstadoEndereco(),
                            FA.getEmail(),
                            FA.getTelefone(),
                            FA.getTelefoneContato(),
                            FA.getWhtasApp(),
                            FA.getCargo(),
                            FA.getVinculoEmpregaticio(),
                            FA.getMatricula(),
                            FA.getEquipe(),
                            FA.getAreaTrabalho(),
                            FA.getSituacaoFuncional(),
                            FA.getDataAdmissao(),
                            FA.getDataDemissao(),
                            FA.getFormaIngresso(),
                            FA.getFormaEgresso(),
                            FA.getObservacao(),
                            FA.getFotoFuncionario()
                    );

                    if (funcionarioDAO.salvar(funcionarioAtributo)) {
                        limparFormulario(
                                novoCadastro,
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
                        bloquearCamposFormulario(
                                novoCadastro,
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
                        //exibe mensagem de cadastrado com sucesso.
                        util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "Cadastro realizado com sucesso!!");

                        Platform.runLater(() -> {
                            Platform.runLater(novoCadastro::requestFocus);
                        });
                        salvarBT.setDisable(true);
                        buscarImagemBT.setDisable(true);
                    } else {
                        util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "Atenção!!\nO cadastro do funcionário, NÃO pode ser realizado!");
                    }
                }
            }
        }
    }

    public void atualizarFuncionario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        FA.setNome(nomeTF.getText());
        FA.setCpf(cpfTF.getText());
        FA.setRg(rgTF.getText());
        FA.setOrgaoEmissorRG(orgaoEmissorRGCB.getSelectionModel().getSelectedItem().toString());
        FA.setEstadoOrgaoEmissorRG(estadoOrgaoRGEmissorCB.getSelectionModel().getSelectedItem().toString());

        if (dataEmissaoRGDP.getEditor().getText().equals("")) {
            FA.setDataEmissaoRG(null);
        } else {
            FA.setDataEmissaoRG(util.converterDataBrasilAmericano(dataEmissaoRGDP.getEditor().getText()));
        }

        FA.setHabilitacao(habilitacaoTF.getText());
        FA.setCategoriaHabilitacao(categoriaHabilitacaoCB.getSelectionModel().getSelectedItem().toString());

        if (data1HabilitacaoDP.getEditor().getText().equals("")) {
            FA.setData1Habilitacao(null);
        } else {
            FA.setData1Habilitacao(util.converterDataBrasilAmericano(data1HabilitacaoDP.getEditor().getText()));
        }

        if (dataNascimentoDP.getEditor().getText().equals("")) {
            FA.setDataNascimento(null);
        } else {
            FA.setDataNascimento(util.converterDataBrasilAmericano(dataNascimentoDP.getEditor().getText()));
        }

        FA.setMunicipioNascimento(municipioNascimentoTF.getText());
        FA.setEstadoNascimento(estadoNascimentoCB.getSelectionModel().getSelectedItem().toString());
        FA.setNomeMae(nomeMaeTF.getText());
        FA.setNomePai(nomePaiTF.getText());
        FA.setLogradouroEndereco(logradouroEnderecoTF.getText());
        FA.setNumeroEndereco(numeroEnderecoTF.getText());
        FA.setBairroEndereco(bairroEnderecoTF.getText());
        FA.setCepEndereco(cepEnderecoTF.getText());
        FA.setCidadeEndereco(cidadeEnderecoTF.getText());
        FA.setEstadoEndereco(estadoEnderecoCB.getSelectionModel().getSelectedItem().toString());
        FA.setEmail(emailTF.getText());
        FA.setTelefone(telefoneTF.getText());
        FA.setTelefoneContato(telefoneContatoTF.getText());
        FA.setWhtasApp(whatsAppTF.getText());
        FA.setCargo(cargoCB.getSelectionModel().getSelectedItem().toString());
        FA.setVinculoEmpregaticio(vinculoEmpregaticioCB.getSelectionModel().getSelectedItem().toString());
        FA.setMatricula(matriculaTF.getText());
        FA.setEquipe(equipeCB.getSelectionModel().getSelectedItem().toString());
        FA.setAreaTrabalho(areaTrabalhoCB.getValue().toString());
        FA.setSituacaoFuncional(situacaoFuncionalCB.getSelectionModel().getSelectedItem().toString());

        if (dataAdmissaoDP.getEditor().getText().equals("")) {
            FA.setDataAdmissao(null);
        } else {
            FA.setDataAdmissao(util.converterDataBrasilAmericano(dataAdmissaoDP.getEditor().getText()));
        }

        if (dataDemissaoDP.getEditor().getText().equals("")) {
            FA.setDataDemissao(null);
        } else {
            FA.setDataDemissao(util.converterDataBrasilAmericano(dataDemissaoDP.getEditor().getText()));
        }

        FA.setFormaIngresso(formaIngressoCB.getSelectionModel().getSelectedItem().toString());
        FA.setFormaEgresso(formaEgressoCB.getSelectionModel().getSelectedItem().toString());
        FA.setObservacao(observacaoTA.getText());

        if (nomeTF.getText().equals("")
                || cpfTF.getText().equals("")
                || rgTF.getText().equals("")
                || orgaoEmissorRGCB.getValue().equals("Selecione")
                || estadoOrgaoRGEmissorCB.getValue().equals("UF")
                || dataEmissaoRGDP.equals("")
                || dataEmissaoRGDP.equals("")
                || municipioNascimentoTF.getText().equals("")
                || estadoNascimentoCB.getValue().equals("UF")
                || nomeMaeTF.getText().equals("")
                || logradouroEnderecoTF.getText().equals("")
                || numeroEnderecoTF.getText().equals("")
                || bairroEnderecoTF.getText().equals("")
                || cepEnderecoTF.getText().equals("")
                || cidadeEnderecoTF.getText().equals("")
                || estadoEnderecoCB.getValue().equals("UF")
                || emailTF.getText().equals("")
                || telefoneTF.getText().equals("")
                || matriculaTF.getText().equals("")
                || cargoCB.getValue().equals("Selecione")
                || vinculoEmpregaticioCB.getValue().equals("Selecione")
                || areaTrabalhoCB.getValue().equals("Selecione")
                || equipeCB.getValue().equals("Selecione")
                || situacaoFuncionalCB.getValue().equals("Selecione")
                || dataAdmissaoDP.equals("")
                || formaIngressoCB.getValue().equals("Selecione")
                || FA.getFotoFuncionario().equals("/imagens/usuario.png")) {

            util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!"
                    + "\nConfira o formulário!"
                    + "\nTodos os campos devem ser preenchidos!");

        } else {
            //confere se o campo telefone contem todos os números.
            if (telefoneTF.getText().length() < 15) {
                Platform.runLater(() -> {
                    telefoneTF.requestFocus();
                    telefoneTF.positionCaret(telefoneTF.getText().length());
                });

                util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!!\n Confira o número do telefone!!");

            } else {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailTF.getText());
                if (!(m.find() && m.group().equals(emailTF.getText()))) {
                    Platform.runLater(() -> {
                        emailTF.requestFocus();
                    });
                    util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!!\nConfira o email!!");
                } else {

                    //Confere se está tudo ok com o banco de dados
                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    FuncionarioAtributos funcionarioAtributo = new FuncionarioAtributos(
                            FA.getNome(),
                            FA.getCpf(),
                            FA.getRg(),
                            FA.getOrgaoEmissorRG(),
                            FA.getEstadoOrgaoEmissorRG(),
                            FA.getDataEmissaoRG(),
                            FA.getHabilitacao(),
                            FA.getCategoriaHabilitacao(),
                            FA.getData1Habilitacao(),
                            FA.getDataNascimento(),
                            FA.getMunicipioNascimento(),
                            FA.getEstadoNascimento(),
                            FA.getNomeMae(),
                            FA.getNomePai(),
                            FA.getLogradouroEndereco(),
                            FA.getNumeroEndereco(),
                            FA.getBairroEndereco(),
                            FA.getCepEndereco(),
                            FA.getCidadeEndereco(),
                            FA.getEstadoEndereco(),
                            FA.getEmail(),
                            FA.getTelefone(),
                            FA.getTelefoneContato(),
                            FA.getWhtasApp(),
                            FA.getCargo(),
                            FA.getVinculoEmpregaticio(),
                            FA.getMatricula(),
                            FA.getEquipe(),
                            FA.getAreaTrabalho(),
                            FA.getSituacaoFuncional(),
                            FA.getDataAdmissao(),
                            FA.getDataDemissao(),
                            FA.getFormaIngresso(),
                            FA.getFormaEgresso(),
                            FA.getObservacao(),
                            FA.getFotoFuncionario()
                    );
                    if (funcionarioDAO.atualizar(funcionarioAtributo)) {
                        limparFormulario(
                                novoCadastro,
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

                        bloquearCamposFormulario(
                                novoCadastro,
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

                        tabelaFuncionarioTV.getItems().clear();

                        util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "Os dados do Funcionário foram atualizados com sucesso!!"
                        );
                    } else {
                        util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÂO!!\nOs dados do Funcionário " + nomeTF.getText() + " "
                                + "\nNÃO foram atualizados!"
                        );
                    }
                }
            }
        }
    }

    public void excluirFuncionario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button buscarImagemBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ImageView fotoFuncionarioIV,
            TextField nomeTF,
            TextField cpfTF,
            TextField rgTF,
            ComboBox orgaoEmissorRGCB,
            ComboBox estadoOrgaoRGEmissorCB,
            DatePicker dataEmissaoRGDP,
            DatePicker data1HabilitacaoDP,
            TextField habilitacaoTF,
            ComboBox categoriaHabilitacaoCB,
            DatePicker dataNascimentoDP,
            TextField municipioNascimentoTF,
            ComboBox estadoNascimentoCB,
            TextField nomeMaeTF,
            TextField nomePaiTF,
            TextField logradouroEnderecoTF,
            TextField numeroEnderecoTF,
            TextField bairroEnderecoTF,
            TextField cepEnderecoTF,
            TextField cidadeEnderecoTF,
            ComboBox estadoEnderecoCB,
            TextField emailTF,
            TextField telefoneTF,
            TextField telefoneContatoTF,
            TextField whatsAppTF,
            TextField matriculaTF,
            ComboBox cargoCB,
            ComboBox vinculoEmpregaticioCB,
            ComboBox areaTrabalhoCB,
            ComboBox equipeCB,
            ComboBox situacaoFuncionalCB,
            DatePicker dataDemissaoDP,
            DatePicker dataAdmissaoDP,
            ComboBox formaEgressoCB,
            ComboBox formaIngressoCB,
            TextArea observacaoTA,
            TableView tabelaFuncionarioTV,
            TextField buscarFuncionarioTF,
            Button listarTodosBT
    ) {
        //Confere se está tudo ok com o banco de dados.
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FA.setMatricula(matriculaTF.getText());

        if (funcionarioDAO.excluir(FA.getMatricula(), FA)) {

            limparFormulario(
                    novoCadastro,
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

            bloquearCamposFormulario(
                    novoCadastro,
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
            tabelaFuncionarioTV.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "O Funcionário foi excluído com sucesso!!"
            );
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastro::requestFocus);//fim do run.
        } else {
            util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "ATENÇÃO!"
                    + "\nO Funcionário NÃO pode ser excluído!"
            );
        }
    }

    public void selecionarFotoFuncionario(
            ImageView fotoFuncionario
    ) {
        FileChooser buscarImage = new FileChooser();
        buscarImage.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg"));

        File imagem = buscarImage.showOpenDialog(new Stage());
        if (imagem != null) {
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            FA.setFotoFuncionario("fotosFuncionarios/" + imagem.getName());

            try {
                Files.copy(Paths.get(imagem.getAbsolutePath()), Paths.get("../src/fotosFuncionarios/" + imagem.getName()), options);
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioMetodo.class.getName()).log(Level.SEVERE, null, ex);
            }
            fotoFuncionario.setImage(new Image("file:///" + FA.getFotoFuncionario()));
        }
    }

    public void preencherComboBoxOrgaoEmissorRG(ComboBox<FuncionarioMetodo> orgaoEmissorRG) {

        List<FuncionarioMetodo> orgaoEmissorRGCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListOrgaoEmissorRG;

        FuncionarioMetodo orgaoEmissorRG1 = new FuncionarioMetodo(1, "SSP");
        FuncionarioMetodo orgaoEmissorRG2 = new FuncionarioMetodo(2, "CC");
        FuncionarioMetodo orgaoEmissorRG3 = new FuncionarioMetodo(3, "PF");
        FuncionarioMetodo orgaoEmissorRG4 = new FuncionarioMetodo(4, "Detran");
        FuncionarioMetodo orgaoEmissorRG5 = new FuncionarioMetodo(5, "PM");

        orgaoEmissorRGCB.add(orgaoEmissorRG1);
        orgaoEmissorRGCB.add(orgaoEmissorRG2);
        orgaoEmissorRGCB.add(orgaoEmissorRG3);
        orgaoEmissorRGCB.add(orgaoEmissorRG4);
        orgaoEmissorRGCB.add(orgaoEmissorRG5);

        observableListOrgaoEmissorRG = FXCollections.observableArrayList(orgaoEmissorRGCB);

        orgaoEmissorRG.setItems(observableListOrgaoEmissorRG);
    }

    public void preencherComboBoxEstado(ComboBox<FuncionarioMetodo> estado) {

        List<FuncionarioMetodo> estadoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListeSTADO;

        FuncionarioMetodo estado1 = new FuncionarioMetodo(1, "AC");
        FuncionarioMetodo estado2 = new FuncionarioMetodo(2, "AL");
        FuncionarioMetodo estado3 = new FuncionarioMetodo(3, "AP");
        FuncionarioMetodo estado4 = new FuncionarioMetodo(4, "AM");
        FuncionarioMetodo estado5 = new FuncionarioMetodo(5, "BA");
        FuncionarioMetodo estado6 = new FuncionarioMetodo(6, "CE");
        FuncionarioMetodo estado7 = new FuncionarioMetodo(7, "DF");
        FuncionarioMetodo estado8 = new FuncionarioMetodo(8, "ES");
        FuncionarioMetodo estado9 = new FuncionarioMetodo(9, "GO");
        FuncionarioMetodo estado10 = new FuncionarioMetodo(10, "MA");
        FuncionarioMetodo estado13 = new FuncionarioMetodo(13, "MG");
        FuncionarioMetodo estado12 = new FuncionarioMetodo(12, "MS");
        FuncionarioMetodo estado11 = new FuncionarioMetodo(11, "MT");
        FuncionarioMetodo estado14 = new FuncionarioMetodo(14, "PA");
        FuncionarioMetodo estado15 = new FuncionarioMetodo(15, "PB");
        FuncionarioMetodo estado17 = new FuncionarioMetodo(17, "PE");
        FuncionarioMetodo estado18 = new FuncionarioMetodo(18, "PI");
        FuncionarioMetodo estado16 = new FuncionarioMetodo(16, "PR");
        FuncionarioMetodo estado19 = new FuncionarioMetodo(19, "RJ");
        FuncionarioMetodo estado20 = new FuncionarioMetodo(20, "RN");
        FuncionarioMetodo estado22 = new FuncionarioMetodo(22, "RO");
        FuncionarioMetodo estado23 = new FuncionarioMetodo(23, "RR");
        FuncionarioMetodo estado21 = new FuncionarioMetodo(21, "RS");
        FuncionarioMetodo estado24 = new FuncionarioMetodo(24, "SC");
        FuncionarioMetodo estado26 = new FuncionarioMetodo(26, "SE");
        FuncionarioMetodo estado25 = new FuncionarioMetodo(25, "SP");
        FuncionarioMetodo estado27 = new FuncionarioMetodo(27, "TO");

        estadoCB.add(estado1);
        estadoCB.add(estado2);
        estadoCB.add(estado3);
        estadoCB.add(estado4);
        estadoCB.add(estado5);
        estadoCB.add(estado6);
        estadoCB.add(estado7);
        estadoCB.add(estado8);
        estadoCB.add(estado9);
        estadoCB.add(estado10);
        estadoCB.add(estado11);
        estadoCB.add(estado12);
        estadoCB.add(estado13);
        estadoCB.add(estado14);
        estadoCB.add(estado15);
        estadoCB.add(estado16);
        estadoCB.add(estado17);
        estadoCB.add(estado18);
        estadoCB.add(estado19);
        estadoCB.add(estado20);
        estadoCB.add(estado21);
        estadoCB.add(estado22);
        estadoCB.add(estado23);
        estadoCB.add(estado24);
        estadoCB.add(estado25);
        estadoCB.add(estado26);
        estadoCB.add(estado27);

        observableListeSTADO = FXCollections.observableArrayList(estadoCB);

        estado.setItems(observableListeSTADO);
    }

    public void preencherComboBoxCategotiaHabilitacao(ComboBox<FuncionarioMetodo> categoriaHabilitacao) {

        List<FuncionarioMetodo> categoriaHabilitacaoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListCategoriaHabilitacao;

        FuncionarioMetodo categoria1 = new FuncionarioMetodo(1, "A");
        FuncionarioMetodo categoria2 = new FuncionarioMetodo(2, "B");
        FuncionarioMetodo categoria3 = new FuncionarioMetodo(3, "C");
        FuncionarioMetodo categoria4 = new FuncionarioMetodo(4, "D");
        FuncionarioMetodo categoria5 = new FuncionarioMetodo(5, "E");
        FuncionarioMetodo categoria6 = new FuncionarioMetodo(6, "A-B");

        categoriaHabilitacaoCB.add(categoria1);
        categoriaHabilitacaoCB.add(categoria2);
        categoriaHabilitacaoCB.add(categoria3);
        categoriaHabilitacaoCB.add(categoria4);
        categoriaHabilitacaoCB.add(categoria5);
        categoriaHabilitacaoCB.add(categoria6);

        observableListCategoriaHabilitacao = FXCollections.observableArrayList(categoriaHabilitacaoCB);

        categoriaHabilitacao.setItems(observableListCategoriaHabilitacao);
    }

    public void preencherComboBoxcargo(ComboBox<FuncionarioMetodo> cargo) {

        List<FuncionarioMetodo> cargoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListCargo;

        FuncionarioMetodo cargo1 = new FuncionarioMetodo(1, "Agente de Endemias");
        FuncionarioMetodo cargo2 = new FuncionarioMetodo(2, "Supervisor de Área");
        FuncionarioMetodo cargo3 = new FuncionarioMetodo(3, "Supervisor Geral");
        FuncionarioMetodo cargo4 = new FuncionarioMetodo(4, "Coordenador");

        cargoCB.add(cargo1);
        cargoCB.add(cargo2);
        cargoCB.add(cargo3);
        cargoCB.add(cargo4);

        observableListCargo = FXCollections.observableArrayList(cargoCB);

        cargo.setItems(observableListCargo);
    }

    public void preencherComboBoxVinculoEmpregaticio(ComboBox<FuncionarioMetodo> vinculo) {

        List<FuncionarioMetodo> vinculoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListVinculo;

        FuncionarioMetodo vinculo1 = new FuncionarioMetodo(1, "Efetivo");
        FuncionarioMetodo vinculo2 = new FuncionarioMetodo(2, "Contratado");
        FuncionarioMetodo vinculo3 = new FuncionarioMetodo(3, "Terceirizado");
        FuncionarioMetodo vinculo4 = new FuncionarioMetodo(4, "Estagiário");

        vinculoCB.add(vinculo1);
        vinculoCB.add(vinculo2);
        vinculoCB.add(vinculo3);
        vinculoCB.add(vinculo4);

        observableListVinculo = FXCollections.observableArrayList(vinculoCB);

        vinculo.setItems(observableListVinculo);
    }

    public void preencherComboBoxEquipe(ComboBox<FuncionarioMetodo> equipe) {

        List<FuncionarioMetodo> equipeCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListEquipe;

        FuncionarioMetodo equipe1 = new FuncionarioMetodo(1, "PA");
        FuncionarioMetodo equipe2 = new FuncionarioMetodo(2, "Equipe 01-A");
        FuncionarioMetodo equipe3 = new FuncionarioMetodo(3, "Equipe 01-B");
        FuncionarioMetodo equipe4 = new FuncionarioMetodo(4, "Equipe 01-C");
        FuncionarioMetodo equipe5 = new FuncionarioMetodo(5, "Equipe 01-D");
        FuncionarioMetodo equipe6 = new FuncionarioMetodo(6, "Equipe 01-E");
        FuncionarioMetodo equipe7 = new FuncionarioMetodo(7, "Equipe 01-F");
        FuncionarioMetodo equipe8 = new FuncionarioMetodo(8, "Equipe 01-G");
        FuncionarioMetodo equipe9 = new FuncionarioMetodo(9, "Equipe 01-H");

        equipeCB.add(equipe1);
        equipeCB.add(equipe2);
        equipeCB.add(equipe3);
        equipeCB.add(equipe4);
        equipeCB.add(equipe5);
        equipeCB.add(equipe6);
        equipeCB.add(equipe7);
        equipeCB.add(equipe8);
        equipeCB.add(equipe9);

        observableListEquipe = FXCollections.observableArrayList(equipeCB);

        equipe.setItems(observableListEquipe);
    }

    public void preencherComboBoxAreaTrabalho(ComboBox<FuncionarioMetodo> area) {

        List<FuncionarioMetodo> areaCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListArea;

        FuncionarioMetodo area1 = new FuncionarioMetodo(1, "Controle de Aedes");
        FuncionarioMetodo area2 = new FuncionarioMetodo(2, "Controle de Escorpião");
        FuncionarioMetodo area3 = new FuncionarioMetodo(3, "Controle de Chagas");
        FuncionarioMetodo area4 = new FuncionarioMetodo(4, "Ponto Estratégico");
        FuncionarioMetodo area5 = new FuncionarioMetodo(5, "UBV");
        FuncionarioMetodo area6 = new FuncionarioMetodo(6, "Denuncias e Notificações");
        FuncionarioMetodo area7 = new FuncionarioMetodo(7, "Escritório");
        FuncionarioMetodo area8 = new FuncionarioMetodo(8, "PEM");
        FuncionarioMetodo area9 = new FuncionarioMetodo(9, "Canil");
        FuncionarioMetodo area10 = new FuncionarioMetodo(10, "Mobilização Social");

        areaCB.add(area1);
        areaCB.add(area2);
        areaCB.add(area3);
        areaCB.add(area4);
        areaCB.add(area5);
        areaCB.add(area6);
        areaCB.add(area7);
        areaCB.add(area8);
        areaCB.add(area9);
        areaCB.add(area10);

        observableListArea = FXCollections.observableArrayList(areaCB);

        area.setItems(observableListArea);
    }

    public void preencherComboBoxSituacaoFuncional(ComboBox<SituacaoFuncional> situacaoFuncional) {

        ObservableList<SituacaoFuncional> observableListSituacaoFuncional;

        //cria lista de dados para ser exibido no comboBox.
        List<SituacaoFuncional> listSituacaoFuncional = new ArrayList<>();
        listSituacaoFuncional.add(new SituacaoFuncional("Regular"));
        listSituacaoFuncional.add(new SituacaoFuncional("Afastado pelo INSS"));
        listSituacaoFuncional.add(new SituacaoFuncional("Licença - LIP"));
        listSituacaoFuncional.add(new SituacaoFuncional("Desviado de Função"));
        listSituacaoFuncional.add(new SituacaoFuncional("Readaptado"));
        listSituacaoFuncional.add(new SituacaoFuncional("Outras licenças"));
        listSituacaoFuncional.add(new SituacaoFuncional("Inativo"));

        // Pega os dados da lista e cria uma lista no formato para o combobox
        observableListSituacaoFuncional = FXCollections.observableArrayList(listSituacaoFuncional);

        //Insere os dados no comboBox
        situacaoFuncional.setItems(observableListSituacaoFuncional);
        Callback<ListView<SituacaoFuncional>, ListCell<SituacaoFuncional>> factory = lv -> new ListCell<SituacaoFuncional>() {
            @Override
            protected void updateItem(SituacaoFuncional item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getSituacaoFuncional());
            }
        };
        situacaoFuncional.setCellFactory(factory);
        situacaoFuncional.setButtonCell(factory.call(null));
    }

    public void preencherComboBoxFormaIngresso(ComboBox<FuncionarioMetodo> ingresso) {

        List<FuncionarioMetodo> ingressoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListIngresso;

        FuncionarioMetodo ingresso1 = new FuncionarioMetodo(1, "Concurso Público");
        FuncionarioMetodo ingresso2 = new FuncionarioMetodo(2, "Processo Seletivo");
        FuncionarioMetodo ingresso3 = new FuncionarioMetodo(3, "Empresa Terceirizada");
        FuncionarioMetodo ingresso4 = new FuncionarioMetodo(4, "Cedido de outro Setor");
        FuncionarioMetodo ingresso5 = new FuncionarioMetodo(5, "Contrato");
        FuncionarioMetodo ingresso6 = new FuncionarioMetodo(6, "Estágio");
        FuncionarioMetodo ingresso7 = new FuncionarioMetodo(7, "Cargo Comissionado");

        ingressoCB.add(ingresso1);
        ingressoCB.add(ingresso2);
        ingressoCB.add(ingresso3);
        ingressoCB.add(ingresso4);
        ingressoCB.add(ingresso5);
        ingressoCB.add(ingresso6);
        ingressoCB.add(ingresso7);

        observableListIngresso = FXCollections.observableArrayList(ingressoCB);

        ingresso.setItems(observableListIngresso);
    }

    public void preencherComboBoxFormaEgresso(ComboBox<FuncionarioMetodo> egresso) {

        List<FuncionarioMetodo> egressoCB = new ArrayList<>();

        ObservableList<FuncionarioMetodo> observableListEgresso;

        FuncionarioMetodo egresso1 = new FuncionarioMetodo(1, "Exonerou-se");
        FuncionarioMetodo egresso2 = new FuncionarioMetodo(2, "Exonerado");
        FuncionarioMetodo egresso3 = new FuncionarioMetodo(3, "Termino de Contrato");
        FuncionarioMetodo egresso4 = new FuncionarioMetodo(4, "Óbito");
        FuncionarioMetodo egresso5 = new FuncionarioMetodo(5, "Saiu da Terceirizada");
        FuncionarioMetodo egresso6 = new FuncionarioMetodo(6, "Dispensado da Terceirizada");
        FuncionarioMetodo egresso7 = new FuncionarioMetodo(7, "Saiu Estagio");
        FuncionarioMetodo egresso8 = new FuncionarioMetodo(8, "Término deestágio");

        egressoCB.add(egresso1);
        egressoCB.add(egresso2);
        egressoCB.add(egresso3);
        egressoCB.add(egresso4);
        egressoCB.add(egresso5);
        egressoCB.add(egresso6);
        egressoCB.add(egresso7);
        egressoCB.add(egresso8);

        observableListEgresso = FXCollections.observableArrayList(egressoCB);

        egresso.setItems(observableListEgresso);
    }

    public void selecionarFoto(
            ImageView fotoUsuario
    ) {
        FileChooser buscarImage = new FileChooser();
        buscarImage.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg"));

        File imagem = buscarImage.showOpenDialog(new Stage());
        if (imagem != null) {
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            FA.setFotoFuncionario("fotosFuncionarios/" + imagem.getName());

            try {
                Files.copy(Paths.get(imagem.getAbsolutePath()), Paths.get("../src/fotosFuncionarios/" + imagem.getName()), options);
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioMetodo.class.getName()).log(Level.SEVERE, null, ex);
            }
            fotoUsuario.setImage(new Image("file:../src/" + FA.getFotoFuncionario()));
        }
    }

    public void gerarRelatorio() {
        Connection conn1 = null;
        Utilitario util1 = new Utilitario(conn1);
        String relatorio = "../src/relatorios/Funcionario.jasper";
        util1.relatorio(relatorio);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}
