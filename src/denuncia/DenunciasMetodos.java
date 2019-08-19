package denuncia;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import menu.MenuMetodos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;
import util.Utilitario;

public class DenunciasMetodos extends Application {

    Connection conn;

    MenuMetodos menuMetodos = new MenuMetodos();

    DenunciaAtributos DA = new DenunciaAtributos();

    Utilitario util = new Utilitario();

    public DenunciasMetodos() {
    }

    public DenunciasMetodos(int posicao, String tipoImovel) {
        DA.setTipoImovel(tipoImovel);
    }

    @Override
    public String toString() {
        return DA.getTipoImovel();
    }

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/denuncia/Denuncia.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("DENUNCIA - CONTROLE DE ZOONOSES");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharDenuncia() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
            menuMetodos.start(new Stage());
            fecharDenuncia();
        } catch (Exception ex) {
            Logger.getLogger(DenunciasMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        numeroDenuncia.setText("");
        dataDenuncia.getEditor().clear();
        recebidaPor.setValue("Selecione");
        denunciante.setText("");
        denunciado.setText("");
        logradouro.setText("");
        numeroEndereco.setText("");
        bairro.setValue("Selecione");
        tipoImovel.setValue("Selecione");
        tipoDenuncia.setValue("Selecione");
        detalhesDenuncia.setText("");
        ace1.setValue("Selecione");
        ace2.setValue("Selecione");
        aberta.setSelected(true);
        concluido.setSelected(false);
        dataVisita.getEditor().clear();
        relatorioVisita.setText("");
    }

    public void liberarCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        numeroDenuncia.setDisable(false);
        dataDenuncia.setDisable(false);
        recebidaPor.setDisable(false);
        denunciante.setDisable(false);
        denunciado.setDisable(false);
        logradouro.setDisable(false);
        numeroEndereco.setDisable(false);
        bairro.setDisable(false);
        tipoImovel.setDisable(false);
        tipoDenuncia.setDisable(false);
        detalhesDenuncia.setDisable(false);
        ace1.setDisable(false);
        ace2.setDisable(false);
        aberta.setDisable(false);
        concluido.setDisable(false);
        dataVisita.setDisable(false);
        relatorioVisita.setDisable(false);
    }

    public void bloquearCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        numeroDenuncia.setDisable(true);
        dataDenuncia.setDisable(true);
        recebidaPor.setDisable(true);
        denunciante.setDisable(true);
        denunciado.setDisable(true);
        logradouro.setDisable(true);
        numeroEndereco.setDisable(true);
        bairro.setDisable(true);
        tipoImovel.setDisable(true);
        tipoDenuncia.setDisable(true);
        detalhesDenuncia.setDisable(true);
        ace1.setDisable(true);
        ace2.setDisable(true);
        aberta.setDisable(true);
        concluido.setDisable(true);
        dataVisita.setDisable(true);
        relatorioVisita.setDisable(true);
    }

    public void verificaDenunciaLancadaDia(
            TextField logradouro,
            TextField numeroEndereco,
            DatePicker dataDenuncia,
            DenunciaAtributos DA
    ) {
        DenunciaDAO dao = new DenunciaDAO();
        dao.verificarDenunciaLancadaDia(
                logradouro.getText(),
                numeroEndereco.getText(),
                dataDenuncia.getEditor().getText(),
                DA
        );
    }

    public void pegarDados(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        DenunciaDAO dao = new DenunciaDAO();

        DenunciaAtributos DA = new DenunciaAtributos();

        dao.buscarDadosDenuncia(Integer.parseInt(numeroDenunciaPesquisa.getText()), DA);

        numeroDenuncia.setText("" + DA.getNumeroDenuncia());

        if (DA.getDataDenuncia() == null) {
            dataDenuncia.getEditor().clear();
        } else {
            dataDenuncia.getEditor().setText(util.converterDataAmericanoBrasil(DA.getDataDenuncia()));
        }
//      dataDenuncia.getEditor().setText(util.converterDataAmericanoBrasil(DA.getDataDenuncia()));
        recebidaPor.setValue(DA.getRecebidaPor());
        denunciante.setText(DA.getDenunciante());
        denunciado.setText(DA.getDenunciado());
        logradouro.setText(DA.getLogradouro());
        numeroEndereco.setText(DA.getNumeroEndereco());
        bairro.setValue(DA.getBairro());
        tipoImovel.setValue(DA.getTipoImovel());
        tipoDenuncia.setValue(DA.getTipoDenuncia());
        detalhesDenuncia.setText(DA.getDetalhesDenuncia());
        ace1.setValue(DA.getAce1());
        ace2.setValue(DA.getAce2());

        if ("Aberta".equals(DA.getSituacaoVisita()) || "".equals(DA.getSituacaoVisita())) {
            aberta.setSelected(true);
            concluido.setSelected(false);
        } else {
            aberta.setSelected(false);
            concluido.setSelected(true);
        }
//        System.out.println(DA.getDataVisita());
        if (DA.getDataVisita() == null) {
            dataVisita.getEditor().clear();
        } else {
            dataVisita.getEditor().setText(util.converterDataAmericanoBrasil(DA.getDataVisita()));
        }

        relatorioVisita.setText(DA.getDetalhesVisita());

        System.out.println("" + Integer.parseInt(numeroDenuncia.getText()));

        if (Integer.parseInt(numeroDenuncia.getText()) == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE DENUNCIA");
            alert.setContentText("ATENÇÃO!!\nNÚMERO DE DENÚNCIA NÃO ENCONTRADO!!");
            alert.show();
        }
    }

    public void salvarDenuncia(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {

        DA.setNumeroDenuncia(Integer.parseInt(numeroDenuncia.getText()));

        if (dataDenuncia.getEditor().getText().equals("")) {
            DA.setDataDenuncia(null);
        } else {
            DA.setDataDenuncia(util.converterDataBrasilAmericano(dataDenuncia.getEditor().getText()));
        }
        DA.setRecebidaPor(recebidaPor.getSelectionModel().getSelectedItem().toString());
        DA.setDenunciante(denunciante.getText());
        DA.setDenunciado(denunciado.getText());
        DA.setLogradouro(logradouro.getText());
        DA.setNumeroEndereco(numeroEndereco.getText());
        DA.setBairro(bairro.getSelectionModel().getSelectedItem().toString());
        DA.setTipoImovel(tipoImovel.getSelectionModel().getSelectedItem().toString());
        DA.setTipoDenuncia(tipoDenuncia.getSelectionModel().getSelectedItem().toString());
        DA.setDetalhesDenuncia(detalhesDenuncia.getText());

        if (ace1.getSelectionModel().getSelectedItem().toString().equals("Selecione")) {
            DA.setAce1("");
        } else {
            DA.setAce1(ace1.getSelectionModel().getSelectedItem().toString());
        }

        if (ace2.getSelectionModel().getSelectedItem().toString().equals("Selecione")) {
            DA.setAce2("");
        } else {
            DA.setAce2(ace2.getSelectionModel().getSelectedItem().toString());
        }

        if (aberta.isSelected()) {
            DA.setSituacaoVisita("");
        } else {
            DA.setSituacaoVisita("");
        }

        if (dataVisita.getEditor().getText().equals("")) {
            DA.setDataVisita(null);
        } else {
            DA.setDataVisita(util.converterDataBrasilAmericano(dataVisita.getEditor().getText()));
        }

        DA.setDetalhesVisita(relatorioVisita.getText());

        if (DA.getDataDenuncia().equals("")
                || DA.getRecebidaPor().equals("Selecione")
                || DA.getDenunciante().equals("")
                || DA.getDenunciado().equals("")
                || DA.getLogradouro().equals("")
                || DA.getNumeroEndereco().equals("")
                || DA.getBairro().equals("Selecione")
                || DA.getTipoImovel().equals("Selecione")
                || DA.getTipoDenuncia().equals("Selecione")
                || DA.getDetalhesDenuncia().equals("")) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - GERADOR DE DENÚNCIAS");
            alert.setHeaderText(null);
            alert.setContentText("CONFIRA O FORMULÁRIO!!!\nOS CAMPOS ABAIXO DEVEM SER PREENCHIDOS:\n"
                    + "Data da Denuncia,\n"
                    + "Recebida Por,\n"
                    + "Denunciante,\n"
                    + "Denunciado,\n"
                    + "Logradouro,\n"
                    + "Numero do Endereço,\n"
                    + "Bairro,\n"
                    + "Tipo Imovel,\n"
                    + "Tipo Denuncia,\n"
                    + "Detalhes da Denuncia!!");
            alert.showAndWait();

            Platform.runLater(() -> {
                dataDenuncia.requestFocus();
            });
        } else {
            //Confere se está tudo ok com o banco de dados
            DenunciaDAO denunciaDAO = new DenunciaDAO();
            DenunciaAtributos denunciaAtributos = new DenunciaAtributos(
                    DA.getNumeroDenuncia(),
                    DA.getDataDenuncia(),
                    DA.getRecebidaPor(),
                    DA.getDenunciante(),
                    DA.getDenunciado(),
                    DA.getLogradouro(),
                    DA.getNumeroEndereco(),
                    DA.getBairro(),
                    DA.getTipoImovel(),
                    DA.getTipoDenuncia(),
                    DA.getDetalhesDenuncia(),
                    DA.getAce1(),
                    DA.getAce2(),
                    DA.getSituacaoVisita(),
                    DA.getDataVisita(),
                    DA.getDetalhesVisita(),
                    DA.getSomaParaConferirDenunciaLancadaDia(),
                    DA.getSomaNumeroDenuncia()
            );
            verificaDenunciaLancadaDia(
                    logradouro,
                    numeroEndereco,
                    dataDenuncia,
                    DA
            );

            if (DA.getSomaParaConferirDenunciaLancadaDia() > 0) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - DENUNCIAS");
                alert.setHeaderText("ATENÇÃO!!");
                alert.setContentText("JÁ FOI GERADO UMA DENUNCIA COM ESTE ENDEREÇO E ESTA DATA!!\n"
                        + "CONFIRMAR DENUNCIA?");

                ButtonType buttonTypeOne = new ButtonType("Sim");
                ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeOne) {

                    if (denunciaDAO.salvar(denunciaAtributos)) {
                        //exibe mensagem de cadastrado com sucesso.
                        Alert alert1 = new Alert(AlertType.INFORMATION);
                        alert1.setTitle("CONTROLE DE ZOONOSES - DENUNCIAS");
                        alert1.setHeaderText(null);
                        alert1.setContentText("DENUNCIA CADASTRADA COM SUCESSO!!");
                        alert1.showAndWait();

                        //METODO OPÇÃO DE IMPRIMIR APÓS SALVAR.
                        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert3.setTitle("IMPRESSÃO DE DENUNCIA");
                        alert3.setHeaderText("ATENÇÃO!!");
                        alert3.setContentText("DESEJA IMPRIMIR A DENUNCIA?");

                        ButtonType buttonTypeOne1 = new ButtonType("Sim");
                        ButtonType buttonTypeTwo1 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

                        alert3.getButtonTypes().setAll(buttonTypeOne1, buttonTypeTwo1);
                        Optional<ButtonType> result1 = alert3.showAndWait();
                        if (result1.get() == buttonTypeOne1) {
                            gerarRelatorio(
                                    numeroDenuncia
                            );
                        } else if (result1.get() == buttonTypeTwo1) {

                        }//FIM DO MÉTODO

                        limparFormulario(
                                novoCadastro,
                                voltarMenuBT,
                                salvarBT,
                                atualizarBT,
                                excluirBT,
                                numeroDenuncia,
                                dataDenuncia,
                                recebidaPor,
                                denunciante,
                                denunciado,
                                logradouro,
                                numeroEndereco,
                                bairro,
                                tipoImovel,
                                tipoDenuncia,
                                detalhesDenuncia,
                                ace1,
                                ace2,
                                aberta,
                                concluido,
                                dataVisita,
                                relatorioVisita,
                                numeroDenunciaPesquisa,
                                buscarBT,
                                imprimir
                        );

                        bloquearCamposFormulario(
                                novoCadastro,
                                voltarMenuBT,
                                salvarBT,
                                atualizarBT,
                                excluirBT,
                                numeroDenuncia,
                                dataDenuncia,
                                recebidaPor,
                                denunciante,
                                denunciado,
                                logradouro,
                                numeroEndereco,
                                bairro,
                                tipoImovel,
                                tipoDenuncia,
                                detalhesDenuncia,
                                ace1,
                                ace2,
                                aberta,
                                concluido,
                                dataVisita,
                                relatorioVisita,
                                numeroDenunciaPesquisa,
                                buscarBT,
                                imprimir
                        );
                    } else {
                        Alert alert2 = new Alert(AlertType.INFORMATION);
                        alert2.setTitle("CONTROLE DE ZOONOSES - DENUNCIA");
                        alert2.setHeaderText(null);
                        alert2.setContentText("DENUNCIA NÃO PODE SER CADASTRADA!!\n"
                                + "CONFIRA O FORMULARIO!!");
                        alert2.showAndWait();
                    }
                } else if (result.get() == buttonTypeTwo) {
                }
            } else {
                if (denunciaDAO.salvar(denunciaAtributos)) {
                    //exibe mensagem de cadastrado com sucesso.
                    Alert alert1 = new Alert(AlertType.INFORMATION);
                    alert1.setTitle("CONTROLE DE ZOONOSES - DENUNCIAS");
                    alert1.setHeaderText(null);
                    alert1.setContentText("DENUNCIA CADASTRADA COM SUCESSO!!");
                    alert1.showAndWait();
                    
                      //METODO OPÇÃO DE IMPRIMIR APÓS SALVAR.
                        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert3.setTitle("IMPRESSÃO DE DENUNCIA");
                        alert3.setHeaderText("ATENÇÃO!!");
                        alert3.setContentText("DESEJA IMPRIMIR A DENUNCIA?");

                        ButtonType buttonTypeOne1 = new ButtonType("Sim");
                        ButtonType buttonTypeTwo1 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

                        alert3.getButtonTypes().setAll(buttonTypeOne1, buttonTypeTwo1);
                        Optional<ButtonType> result1 = alert3.showAndWait();
                        if (result1.get() == buttonTypeOne1) {
                            gerarRelatorio(
                                    numeroDenuncia
                            );
                        } else if (result1.get() == buttonTypeTwo1) {

                        }//FIM DO MÉTODO
                    
                    limparFormulario(
                            novoCadastro,
                            voltarMenuBT,
                            salvarBT,
                            atualizarBT,
                            excluirBT,
                            numeroDenuncia,
                            dataDenuncia,
                            recebidaPor,
                            denunciante,
                            denunciado,
                            logradouro,
                            numeroEndereco,
                            bairro,
                            tipoImovel,
                            tipoDenuncia,
                            detalhesDenuncia,
                            ace1,
                            ace2,
                            aberta,
                            concluido,
                            dataVisita,
                            relatorioVisita,
                            numeroDenunciaPesquisa,
                            buscarBT,
                            imprimir
                    );
                    bloquearCamposFormulario(
                            novoCadastro,
                            voltarMenuBT,
                            salvarBT,
                            atualizarBT,
                            excluirBT,
                            numeroDenuncia,
                            dataDenuncia,
                            recebidaPor,
                            denunciante,
                            denunciado,
                            logradouro,
                            numeroEndereco,
                            bairro,
                            tipoImovel,
                            tipoDenuncia,
                            detalhesDenuncia,
                            ace1,
                            ace2,
                            aberta,
                            concluido,
                            dataVisita,
                            relatorioVisita,
                            numeroDenunciaPesquisa,
                            buscarBT,
                            imprimir
                    );
                } else {
                    Alert alert2 = new Alert(AlertType.INFORMATION);
                    alert2.setTitle("CONTROLE DE ZOONOSES - DENUNCIA");
                    alert2.setHeaderText(null);
                    alert2.setContentText("DENUNCIA NÃO PODE SER CADASTRADA!!\n"
                            + "CONFIRA O FORMULARIO!!");
                    alert2.showAndWait();
                }
            }
        }
    }

    public void atualizarDenuncia(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        DA.setNumeroDenuncia(Integer.parseInt(numeroDenuncia.getText()));

        if (dataDenuncia.getEditor().getText().equals("")) {
            DA.setDataDenuncia(null);
        } else {
            DA.setDataDenuncia(util.converterDataBrasilAmericano(dataDenuncia.getEditor().getText()));
        }
        
        DA.setRecebidaPor(recebidaPor.getSelectionModel().getSelectedItem().toString());
        DA.setDenunciante(denunciante.getText());
        DA.setDenunciado(denunciado.getText());
        DA.setLogradouro(logradouro.getText());
        DA.setNumeroEndereco(numeroEndereco.getText());
        DA.setBairro(bairro.getSelectionModel().getSelectedItem().toString());
        DA.setTipoImovel(tipoImovel.getSelectionModel().getSelectedItem().toString());
        DA.setTipoDenuncia(tipoDenuncia.getSelectionModel().getSelectedItem().toString());
        DA.setDetalhesDenuncia(detalhesDenuncia.getText());
        DA.setAce1(ace1.getSelectionModel().getSelectedItem().toString());
        DA.setAce2(ace2.getSelectionModel().getSelectedItem().toString());
        
        if (aberta.isSelected()) {
            DA.setSituacaoVisita("Aberta");
        } else {
            DA.setSituacaoVisita("Concluída");
        }

        if (dataVisita.getEditor().getText().equals("")) {
            DA.setDataVisita(null);
        } else {
            DA.setDataVisita(util.converterDataBrasilAmericano(dataVisita.getEditor().getText()));
        }
        
        DA.setDetalhesVisita(relatorioVisita.getText());

        if (DA.getDataDenuncia().equals("")
                || DA.getRecebidaPor().equals("Selecione")
                || DA.getDenunciante().equals("")
                || DA.getDenunciado().equals("")
                || DA.getLogradouro().equals("")
                || DA.getNumeroEndereco().equals("")
                || DA.getBairro().equals("Selecione")
                || DA.getTipoImovel().equals("Selecione")
                || DA.getTipoDenuncia().equals("Selecione")
                || DA.getDetalhesDenuncia().equals("")) {

            Alert alert2 = new Alert(AlertType.INFORMATION);
            alert2.setTitle("CONTROLE DE ZOONOSES - DENUNCIA");
            alert2.setHeaderText(null);
            alert2.setContentText("DENUNCIA NÃO FOI ATUALIZADA!!\n"
                    + "CONFIRA OS CAMPOS DO FORMULÁRIO!!");
            alert2.showAndWait();
            //Confere se está tudo ok com o banco de dados

        } else {
            DenunciaDAO denunciaDAO = new DenunciaDAO();
            DenunciaAtributos denunciaAtributo = new DenunciaAtributos(
                    DA.getNumeroDenuncia(),
                    DA.getDataDenuncia(),
                    DA.getRecebidaPor(),
                    DA.getDenunciante(),
                    DA.getDenunciado(),
                    DA.getLogradouro(),
                    DA.getNumeroEndereco(),
                    DA.getBairro(),
                    DA.getTipoImovel(),
                    DA.getTipoDenuncia(),
                    DA.getDetalhesDenuncia(),
                    DA.getAce1(),
                    DA.getAce2(),
                    DA.getSituacaoVisita(),
                    DA.getDataVisita(),
                    DA.getDetalhesVisita(),
                    DA.getSomaParaConferirDenunciaLancadaDia(),
                    DA.getSomaNumeroDenuncia()
            );
            if (denunciaDAO.atualizar(denunciaAtributo)) {
                limparFormulario(
                        novoCadastro,
                        voltarMenuBT,
                        salvarBT,
                        atualizarBT,
                        excluirBT,
                        numeroDenuncia,
                        dataDenuncia,
                        recebidaPor,
                        denunciante,
                        denunciado,
                        logradouro,
                        numeroEndereco,
                        bairro,
                        tipoImovel,
                        tipoDenuncia,
                        detalhesDenuncia,
                        ace1,
                        ace2,
                        aberta,
                        concluido,
                        dataVisita,
                        relatorioVisita,
                        numeroDenunciaPesquisa,
                        buscarBT,
                        imprimir
                );
                bloquearCamposFormulario(
                        novoCadastro,
                        voltarMenuBT,
                        salvarBT,
                        atualizarBT,
                        excluirBT,
                        numeroDenuncia,
                        dataDenuncia,
                        recebidaPor,
                        denunciante,
                        denunciado,
                        logradouro,
                        numeroEndereco,
                        bairro,
                        tipoImovel,
                        tipoDenuncia,
                        detalhesDenuncia,
                        ace1,
                        ace2,
                        aberta,
                        concluido,
                        dataVisita,
                        relatorioVisita,
                        numeroDenunciaPesquisa,
                        buscarBT,
                        imprimir
                );

                numeroDenunciaPesquisa.setText("0");

                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("CONTROLE DE ZOONOSES - DENUNCIA");
                alert1.setHeaderText(null);
                alert1.setContentText("A DENUNCIA FOI ATUALIZADA COM SUCESSO!!");
                alert1.showAndWait();
            } else {
                Alert alert2 = new Alert(AlertType.INFORMATION);
                alert2.setTitle("CONTROLE DE ZOONOSES - DENUNCIA");
                alert2.setHeaderText(null);
                alert2.setContentText("DENUNCIA NÃO FOI ATUALIZADA!!");
                alert2.showAndWait();
            }
        }
    }

    public void excluirDenuncia(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField numeroDenuncia,
            DatePicker dataDenuncia,
            ComboBox recebidaPor,
            TextField denunciante,
            TextField denunciado,
            TextField logradouro,
            TextField numeroEndereco,
            ComboBox bairro,
            ComboBox tipoImovel,
            ComboBox tipoDenuncia,
            TextArea detalhesDenuncia,
            ComboBox ace1,
            ComboBox ace2,
            CheckBox aberta,
            CheckBox concluido,
            DatePicker dataVisita,
            TextArea relatorioVisita,
            TextField numeroDenunciaPesquisa,
            Button buscarBT,
            Button imprimir
    ) {
        //Confere se está tudo ok com o banco de dados.
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        DA.setNumeroDenuncia(Integer.parseInt(numeroDenuncia.getText()));

        if (denunciaDAO.excluir(
                DA.getNumeroDenuncia(),
                DA
        )) {
            limparFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    numeroDenuncia,
                    dataDenuncia,
                    recebidaPor,
                    denunciante,
                    denunciado,
                    logradouro,
                    numeroEndereco,
                    bairro,
                    tipoImovel,
                    tipoDenuncia,
                    detalhesDenuncia,
                    ace1,
                    ace2,
                    aberta,
                    concluido,
                    dataVisita,
                    relatorioVisita,
                    numeroDenunciaPesquisa,
                    buscarBT,
                    imprimir
            );
            bloquearCamposFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    numeroDenuncia,
                    dataDenuncia,
                    recebidaPor,
                    denunciante,
                    denunciado,
                    logradouro,
                    numeroEndereco,
                    bairro,
                    tipoImovel,
                    tipoDenuncia,
                    detalhesDenuncia,
                    ace1,
                    ace2,
                    aberta,
                    concluido,
                    dataVisita,
                    relatorioVisita,
                    numeroDenunciaPesquisa,
                    buscarBT,
                    imprimir
            );

            numeroDenunciaPesquisa.setText("0");

            //exibe mensagem de Excluído com sucesso.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
            alert.setHeaderText(null);
            alert.setContentText("A DENUNCIA DE NÚMERO " + DA.getNumeroDenuncia() + ", FOI EXCLUÍDA COM SUCESSO!!");
            alert.showAndWait();

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastro::requestFocus);//fim do run.

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
            alert.setHeaderText(null);
            alert.setContentText("A DENUNCIA DE NÚMERO " + DA.getNumeroDenuncia() + ", NÃO FOI EXCLUÍDA!!");
            alert.showAndWait();
        }
    }

//     /FIM DO MÉTODO.
    public void preencherComboBoxTipoImovel(ComboBox<DenunciasMetodos> tipoImovel) {

        List<DenunciasMetodos> tipoImovelCB = new ArrayList<>();

        ObservableList<DenunciasMetodos> observableListTipoImovel;

        DenunciasMetodos linha1 = new DenunciasMetodos(1, "Residência");
        DenunciasMetodos linha2 = new DenunciasMetodos(2, "Comércio");
        DenunciasMetodos linha3 = new DenunciasMetodos(3, "Terreno Baldio");
        DenunciasMetodos linha4 = new DenunciasMetodos(4, "Outros");
//        DenunciasMetodos linha5 = new DenunciaMetodos(5, "");
//        DenunciaMetodos linha6 = new DenunciaMetodos(6, "");
//        DenunciaMetodos linha7 = new DenunciaMetodos(7, "");
//        DenunciaMetodos linha8 = new DenunciaMetodos(8, "");
//        DenunciaMetodos linha9 = new DenunciaMetodos(9, "");
//        DenunciaMetodos linha10 = new DenunciaMetodos(10, "");

        tipoImovelCB.add(linha1);
        tipoImovelCB.add(linha2);
        tipoImovelCB.add(linha3);
        tipoImovelCB.add(linha4);
//        inseticidaCB.add(linha5);
//        inseticidaCB.add(linha6);
//        inseticidaCB.add(linha7);
//        inseticidaCB.add(linha8);
//        inseticidaCB.add(linha9);
//        inseticidaCB.add(linha10);

        observableListTipoImovel = FXCollections.observableArrayList(tipoImovelCB);

        tipoImovel.setItems(observableListTipoImovel);
    }

    public void preencherComboBoxTipoDenuncia(ComboBox<DenunciasMetodos> TipoDenuncia) {

        List<DenunciasMetodos> tipoDenunciaCB = new ArrayList<>();

        ObservableList<DenunciasMetodos> observableListTipoDenuncia;

        DenunciasMetodos linha1 = new DenunciasMetodos(1, "Aedes Aegypti");
        DenunciasMetodos linha2 = new DenunciasMetodos(2, "Cães e Gatos");
        DenunciasMetodos linha3 = new DenunciasMetodos(3, "Caixa d'agua");
        DenunciasMetodos linha4 = new DenunciasMetodos(4, "Caramujo");
        DenunciasMetodos linha5 = new DenunciasMetodos(5, "Casa Abandonada");
        DenunciasMetodos linha6 = new DenunciasMetodos(6, "Construção");
        DenunciasMetodos linha7 = new DenunciasMetodos(7, "Escorpião");
        DenunciasMetodos linha8 = new DenunciasMetodos(8, "Imóvel Fechado");
        DenunciasMetodos linha9 = new DenunciasMetodos(9, "Morcego");
        DenunciasMetodos linha10 = new DenunciasMetodos(10, "Pneus");
        DenunciasMetodos linha11 = new DenunciasMetodos(11, "Pombo");
        DenunciasMetodos linha12 = new DenunciasMetodos(12, "Rato");
        DenunciasMetodos linha13 = new DenunciasMetodos(13, "Terreno Baldio");
        DenunciasMetodos linha14 = new DenunciasMetodos(14, "Triatomínio(Barbeiro)");

        tipoDenunciaCB.add(linha1);
        tipoDenunciaCB.add(linha2);
        tipoDenunciaCB.add(linha3);
        tipoDenunciaCB.add(linha4);
        tipoDenunciaCB.add(linha5);
        tipoDenunciaCB.add(linha6);
        tipoDenunciaCB.add(linha7);
        tipoDenunciaCB.add(linha8);
        tipoDenunciaCB.add(linha9);
        tipoDenunciaCB.add(linha10);
        tipoDenunciaCB.add(linha11);
        tipoDenunciaCB.add(linha12);
        tipoDenunciaCB.add(linha13);
        tipoDenunciaCB.add(linha14);

        observableListTipoDenuncia = FXCollections.observableArrayList(tipoDenunciaCB);

        TipoDenuncia.setItems(observableListTipoDenuncia);
    }

    private void relatorios(
            String relatorio,
            String numeroDenuncia
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("numeroDenuncia", numeroDenuncia);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO AO GERAR RELATORIO\n" + ex);
            Logger.getLogger(DenunciasMetodos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(TextField numeroDenuncia) {
        Utilitario util = new Utilitario(conn);
        String numero = numeroDenuncia.getText();

        String relatorio = "../src/relatorios/Denuncia.jasper";
        relatorios(relatorio, numero);
    }

}
