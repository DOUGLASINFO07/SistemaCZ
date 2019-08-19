package servicoTratamentoFocal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import menu.MenuMetodos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;
import util.Utilitario;

public class ServicoTratamentoFocalMetodos extends Application {

    Connection conn;

    MenuMetodos menuMetodos = new MenuMetodos();

    ServicoTratamentoFocalAtributos STFA = new ServicoTratamentoFocalAtributos();

    Utilitario util = new Utilitario();

    public ServicoTratamentoFocalMetodos() {
    }

    public ServicoTratamentoFocalMetodos(int posicao, String semana) {
        STFA.setSemana(semana);
    }

    @Override
    public String toString() {
        return STFA.getSemana();
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
        Parent root = FXMLLoader.load(getClass().getResource("/servicoTratamentoFocal/ServicoTratamentoFocal.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro de Servico Tratamento Focal");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODO FECHAR USUARIO.
    public void fecharServicoTratamentoFocal() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        try {
            menuMetodos.start(new Stage());
            fecharServicoTratamentoFocal();
        } catch (Exception ex) {
            Logger.getLogger(ServicoTratamentoFocalMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        rg.setText("");
        localidade.setText("");
        categoria.setText("");
        tipo.setText("");
        zona.setText("");
        data.getEditor().clear();
        semana.getSelectionModel().select("Sel.");
        ciclo.setText("");
        ace.getSelectionModel().select("Selecione");
        supervisor.getSelectionModel().select("Selecione");
        individualmente.setSelected(true);
        emConjunto.setSelected(false);
        observacao.setText("");
        quarteirao.setText("0");
        lados.setText("");
        residencia.setText("0");
        comercio.setText("0");
        terrenoBaldio.setText("0");
        outros.setText("0");
        visitaResgate.setText("0");
        eliminado.setText("0");
        tratado.setText("0");
        larvicida.getSelectionModel().select("Pyriproxyfen");
        quantidadeLarvicida.setText("0");
        quantTratados.setText("0");
        emTratamento.setSelected(true);
        concluído.setSelected(false);
    }

    public void limparCamposPesquisa(
            ComboBox buscarLocalidadeCB,
            ComboBox buscarQuarteirao,
            TableView tabelaServicoTratamentoFocalTV,
            Button imprimir,
            Button listar
    ) {
        buscarLocalidadeCB.getSelectionModel().select("SELECIONE UMA LOCALIDADE");
        buscarQuarteirao.getSelectionModel().select("SELECIONE UM CICLO");
        tabelaServicoTratamentoFocalTV.getItems().clear();
    }

    public void liberarCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        rg.setEditable(true);
        quarteirao.setEditable(true);

        rg.setDisable(false);
        localidade.setDisable(false);
        categoria.setDisable(false);
        tipo.setDisable(false);
        zona.setDisable(false);
        data.setDisable(false);
        semana.setDisable(false);
        ciclo.setDisable(false);
        ace.setDisable(false);
        supervisor.setDisable(false);
        observacao.setDisable(false);
        quarteirao.setDisable(false);
        lados.setDisable(false);
        residencia.setDisable(false);
        comercio.setDisable(false);
        terrenoBaldio.setDisable(false);
        outros.setDisable(false);
        visitaResgate.setDisable(false);
        eliminado.setDisable(false);
        tratado.setDisable(false);
        larvicida.setDisable(false);
        quantidadeLarvicida.setDisable(false);
        quantTratados.setDisable(false);
        individualmente.setDisable(false);
        emConjunto.setDisable(false);
        emTratamento.setDisable(false);
        concluído.setDisable(false);
    }

    public void bloquearCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        rg.setDisable(true);
        localidade.setDisable(true);
        categoria.setDisable(true);
        tipo.setDisable(true);
        zona.setDisable(true);
        data.setDisable(true);
        semana.setDisable(true);
        ciclo.setDisable(true);
        ace.setDisable(true);
        supervisor.setDisable(true);
        observacao.setDisable(true);
        quarteirao.setDisable(true);
        lados.setDisable(true);
        residencia.setDisable(true);
        comercio.setDisable(true);
        terrenoBaldio.setDisable(true);
        outros.setDisable(true);
        visitaResgate.setDisable(true);
        eliminado.setDisable(true);
        tratado.setDisable(true);
        larvicida.setDisable(true);
        quantidadeLarvicida.setDisable(true);
        quantTratados.setDisable(true);
        individualmente.setDisable(true);
        emConjunto.setDisable(true);
        emTratamento.setDisable(true);
        concluído.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn quarteirao,
            TableColumn data,
            TableColumn semana,
            TableColumn ciclo,
            TableColumn ace,
            TableColumn situacaoQuarteirao,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidade,
            ComboBox buscarCiclo
    ) {
        quarteirao.setCellValueFactory(new PropertyValueFactory("quarteirao"));
        data.setCellValueFactory(new PropertyValueFactory("data"));
        semana.setCellValueFactory(new PropertyValueFactory("semana"));
        ciclo.setCellValueFactory(new PropertyValueFactory("ciclo"));
        ace.setCellValueFactory(new PropertyValueFactory("ace"));
        situacaoQuarteirao.setCellValueFactory(new PropertyValueFactory("situacaoQuarteirao"));
        tabelaServicoTratamentoFocalTV.setItems(atualizaTabela(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarCiclo.getSelectionModel().getSelectedItem().toString()
        ));
    }

    public ObservableList<ServicoTratamentoFocalAtributos> atualizaTabela(
            String buscarLocalidade,
            String buscarCiclo
    ) {
        ServicoTratamentoFocalDAO dao = new ServicoTratamentoFocalDAO();
        return FXCollections.observableArrayList(dao.listaServicoTratamentoFocal(
                buscarLocalidade,
                buscarCiclo
        ));
    }

    public void verificaServicoTratamentoFocal(
            TextField rg,
            ComboBox ace,
            DatePicker data,
            TextField quarteirao,
            ServicoTratamentoFocalAtributos STFA
    ) {
        ServicoTratamentoFocalDAO dao = new ServicoTratamentoFocalDAO();
        dao.verificarServicoTratamentoFocal(
                rg.getText(),
                ace.getSelectionModel().getSelectedItem().toString(),
                data.getEditor().getText(),
                quarteirao.getText(),
                STFA
        );
    }

    public void verificaServicoTratamentoFocalConcluido(
            TextField rg,
            TextField quarteirao,
            TextField ciclo,
            ServicoTratamentoFocalAtributos STFA
    ) {
        ServicoTratamentoFocalDAO dao = new ServicoTratamentoFocalDAO();
        dao.verificarServicoTratamentoFocalConcluido(
                rg.getText(),
                quarteirao.getText(),
                ciclo.getText(),
                STFA
        );
    }

    public void pegarDadoTabela(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView<ServicoTratamentoFocalAtributos> tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        String localidadePesquisa = buscarLocalidadeCB.getSelectionModel().getSelectedItem().toString();
        int quarteiraoPesquisa = tabelaServicoTratamentoFocalTV.getSelectionModel().getSelectedItem().getQuarteirao();
        String dataPesquisa = tabelaServicoTratamentoFocalTV.getSelectionModel().getSelectedItem().getData();
        String acePesquisa = tabelaServicoTratamentoFocalTV.getSelectionModel().getSelectedItem().getAce();

        ServicoTratamentoFocalDAO dao = new ServicoTratamentoFocalDAO();
        dao.buscarDadosServicoTratamentoFocal(quarteiraoPesquisa, localidadePesquisa, dataPesquisa, acePesquisa, STFA);

        
        rg.setText(STFA.getRg());
        localidade.setText(STFA.getLocalidade());
        categoria.setText(STFA.getCategoria());
        tipo.setText(STFA.getTipo());
        zona.setText(STFA.getZona());
        data.getEditor().setText(util.converterDataAmericanoBrasil(STFA.getData()));
        semana.setValue(STFA.getSemana());
        ciclo.setText(STFA.getCiclo());
        ace.setValue(STFA.getAce());
        supervisor.setValue(STFA.getSupervisor());

        if (STFA.getTrabalhouQuarteirao().equals("Individualmente")) {
            individualmente.setSelected(true);
            emConjunto.setSelected(false);
        } else {
            individualmente.setSelected(false);
            emConjunto.setSelected(true);
        }

        observacao.setText(STFA.getObservacao());
        quarteirao.setText("" + STFA.getQuarteirao());
        lados.setText(STFA.getLados());
        residencia.setText("" + STFA.getResidencia());
        comercio.setText("" + STFA.getComercio());
        terrenoBaldio.setText("" + STFA.getTerrenoBaldio());
        outros.setText("" + STFA.getOutros());
        visitaResgate.setText("" + STFA.getVisitaResgate());
        eliminado.setText("" + STFA.getEliminado());
        tratado.setText("" + STFA.getTratado());
        larvicida.setValue(STFA.getLarvicida());
        quantidadeLarvicida.setText("" + STFA.getQuantidadeLarvicida());
        quantTratados.setText("" + STFA.getQuantTratados());

        if (STFA.getSituacaoQuarteirao().equals("Em Tratamento")) {
            emTratamento.setSelected(true);
            concluído.setSelected(false);
        } else {
            emTratamento.setSelected(false);
            concluído.setSelected(true);
        }
    }

    public void salvarServicoTratamentoFocal(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {

        STFA.setRg(rg.getText());
        STFA.setLocalidade(localidade.getText());
        STFA.setCategoria(categoria.getText());
        STFA.setTipo(tipo.getText());
        STFA.setZona(zona.getText());
        STFA.setSemana(semana.getSelectionModel().getSelectedItem().toString());
        STFA.setCiclo(ciclo.getText());

        if (data.getEditor().getText().equals("")) {
            STFA.setData(null);
        } else {
            STFA.setData(util.converterDataBrasilAmericano(data.getEditor().getText()));
        }

        if (individualmente.isSelected()) {
            STFA.setTrabalhouQuarteirao("Individualmente");
        } else {
            STFA.setTrabalhouQuarteirao("Em Conjunto");
        }

        STFA.setAce(ace.getSelectionModel().getSelectedItem().toString());
        STFA.setSupervisor(supervisor.getSelectionModel().getSelectedItem().toString());

        STFA.setObservacao(observacao.getText());
        STFA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        STFA.setLados(lados.getText());
        STFA.setResidencia(Integer.parseInt(residencia.getText()));
        STFA.setComercio(Integer.parseInt(comercio.getText()));
        STFA.setTerrenoBaldio(Integer.parseInt(terrenoBaldio.getText()));
        STFA.setOutros(Integer.parseInt(outros.getText()));
        STFA.setVisitaResgate(Integer.parseInt(visitaResgate.getText()));
        STFA.setEliminado(Integer.parseInt(eliminado.getText()));
        STFA.setTratado(Integer.parseInt(tratado.getText()));
        STFA.setLarvicida(larvicida.getSelectionModel().getSelectedItem().toString());
        STFA.setQuantidadeLarvicida(Double.parseDouble(quantidadeLarvicida.getText().replace(",", ".")));
        STFA.setQuantTratados(Integer.parseInt(quantTratados.getText()));

        if (emTratamento.isSelected()) {
            STFA.setSituacaoQuarteirao("Em Tratamento");
        } else {
            STFA.setSituacaoQuarteirao("Concluído");
        }

        if (STFA.getRg().equals("")
                || STFA.getData().equals("")
                || STFA.getSemana().equals("Sel.")
                || STFA.getAce().equals("Selecione")
                || STFA.getSupervisor().equals("Selecione")
                || STFA.getQuarteirao() == 0
                || STFA.getLados().equals("")
                || !emTratamento.isSelected()
                && !concluído.isSelected()
                || !individualmente.isSelected()
                && !emConjunto.isSelected()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
            alert.setHeaderText(null);
            alert.setContentText("CONFIRA O FORMULÁRIO!!!\n O QUARTEIRÃO " + STFA.getQuarteirao()
                    + " DA LOCALIDADE " + STFA.getLocalidade() + ", NÃO FOI SALVO!!");
            alert.showAndWait();

            Platform.runLater(() -> {
                quarteirao.requestFocus();
            });
        } else {
            //Confere se está tudo ok com o banco de dados
            ServicoTratamentoFocalDAO quarteiraoDAO = new ServicoTratamentoFocalDAO();
            ServicoTratamentoFocalAtributos quarteiraoAtributo = new ServicoTratamentoFocalAtributos(
                    STFA.getRg(),
                    STFA.getLocalidade(),
                    STFA.getCategoria(),
                    STFA.getTipo(),
                    STFA.getZona(),
                    STFA.getData(),
                    STFA.getSemana(),
                    STFA.getCiclo(),
                    STFA.getAce(),
                    STFA.getSupervisor(),
                    STFA.getTrabalhouQuarteirao(),
                    STFA.getObservacao(),
                    STFA.getQuarteirao(),
                    STFA.getLados(),
                    STFA.getResidencia(),
                    STFA.getComercio(),
                    STFA.getTerrenoBaldio(),
                    STFA.getOutros(),
                    STFA.getVisitaResgate(),
                    STFA.getEliminado(),
                    STFA.getTratado(),
                    STFA.getLarvicida(),
                    STFA.getQuantidadeLarvicida(),
                    STFA.getQuantTratados(),
                    STFA.getSituacaoQuarteirao()
            );
            verificaServicoTratamentoFocal(
                    rg,
                    ace,
                    data,
                    quarteirao,
                    STFA
            );
            verificaServicoTratamentoFocalConcluido(
                    rg,
                    quarteirao,
                    ciclo,
                    STFA
            );
            if (STFA.getSomaParaConferirServicoLancado() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                alert.setHeaderText(null);
                alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " COM ESTA DATA JÁ FOI LANÇADO!!");
                alert.showAndWait();
                Platform.runLater(quarteirao::requestFocus);//fim do run.
            } else {
                if ((STFA.getSomaParaConferirServicoLancadoConcluido() > 0)
                        && (STFA.getVisitaResgate() == 0)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                    alert.setHeaderText(null);
                    alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " JÁ FOI LANÇADO COMO CONCLUÍDO, ENTÃO,\n"
                            + " DEVE TRATA-SE DE UM RESGATE, COM ISSO O NÚMERO DE IMÓVEIS RESGATADOS DEVE SER O MESMO DE IMÓVEIS TRABALHADOS");
                    alert.showAndWait();
                    STFA.setSomaParaConferirServicoLancadoConcluido(0);
                    emTratamento.setSelected(true);
                } else {
                    if ((STFA.getSituacaoQuarteirao().equals("Concluído")) && STFA.getSomaParaConferirServicoLancadoConcluido() > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                        alert.setHeaderText(null);
                        alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " JÁ FOI LANÇADO COMO CONCLUÍDO!!");
                        alert.showAndWait();
                        STFA.setSomaParaConferirServicoLancadoConcluido(0);
                    } else {
                        if (STFA.getQuantTratados() > 0
                                && (STFA.getQuantidadeLarvicida() == 0.0
                                || STFA.getTratado() == 0)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                            alert.setHeaderText(null);
                            alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                    + "* \nIMÓVEIS TRATADOS."
                                    + "* \nQUANTIDADE DE LARVICIDA."
                                    + "* \nQUANTIDADE DE TRATADOS."
                                    + "\n\nCONFIRA O FORMULÁRIO!!");
                            alert.showAndWait();
                        } else {
                            if (STFA.getQuantidadeLarvicida() > 0.0
                                    && (STFA.getTratado() == 0
                                    || STFA.getQuantTratados() == 0)) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                alert.setHeaderText(null);
                                alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                        + "* \nIMÓVEIS TRATADOS."
                                        + "* \nQUANTIDADE DE LARVICIDA."
                                        + "* \nQUANTIDADE DE TRATADOS."
                                        + "\n\nCONFIRA O FORMULÁRIO!!");
                                alert.showAndWait();
                            } else {
                                if (STFA.getTratado() > 0
                                        && (STFA.getQuantidadeLarvicida() == 0.0
                                        || STFA.getQuantTratados() == 0)) {
                                    Alert alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                    alert.setHeaderText(null);
                                    alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                            + "* \nIMÓVEIS TRATADOS."
                                            + "* \nQUANTIDADE DE LARVICIDA."
                                            + "* \nQUANTIDADE DE TRATADOS."
                                            + "\n\nCONFIRA O FORMULÁRIO!!");
                                    alert.showAndWait();
                                } else {
                                    if (STFA.getTratado() > (STFA.getResidencia()
                                            + STFA.getComercio()
                                            + STFA.getTerrenoBaldio() + STFA.getOutros())) {
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                        alert.setHeaderText(null);
                                        alert.setContentText("O TOTAL DE IMOVEIS TRATADO É MAIOR QUE O TOTAL DE IMÓVEIS TRABALHADOS!!"
                                                + "\nCONFIRA O FORMULÁRIO!!");
                                        alert.showAndWait();
                                    } else {
                                        if (STFA.getVisitaResgate() > (STFA.getResidencia()
                                                + STFA.getComercio()
                                                + STFA.getTerrenoBaldio() + STFA.getOutros())) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                            alert.setHeaderText(null);
                                            alert.setContentText("O TOTAL DE RESGATE É MAIOR QUE O TOTAL DE IMÓVEIS TRABALHADOS!!"
                                                    + "\nCONFIRA O FORMULÁRIO!!");
                                            alert.showAndWait();
                                        } else {
                                            if (residencia.getText().equals("0") || residencia.getText().equals("")
                                                    && comercio.getText().equals("0") || comercio.getText().equals("")
                                                    && terrenoBaldio.getText().equals("0") || terrenoBaldio.getText().equals("")
                                                    && outros.getText().equals("0") || outros.getText().equals("")) {
                                                Alert alert = new Alert(AlertType.INFORMATION);
                                                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                alert.setHeaderText(null);
                                                alert.setContentText("O TOTAL DE IMÓVEIS NÃO PODE SER ZERO!!\n"
                                                        + "CONFIRA O FORMULÁRIO!!");
                                                alert.showAndWait();
                                            } else {
                                                if (quarteiraoDAO.salvar(quarteiraoAtributo)) {
                                                    //exibe mensagem de cadastrado com sucesso.
                                                    Alert alert = new Alert(AlertType.INFORMATION);
                                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                    alert.setHeaderText(null);
                                                    alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                                                            + " DA LOCALIDADE " + STFA.getLocalidade() + ", FOI CADASTRADO COM SUCESSO!!");
                                                    alert.showAndWait();

                                                    quarteirao.setText("0");
                                                    lados.setText("0");
                                                    observacao.setText("");
                                                    residencia.setText("0");
                                                    comercio.setText("0");
                                                    terrenoBaldio.setText("0");
                                                    outros.setText("0");
                                                    visitaResgate.setText("0");
                                                    eliminado.setText("0");
                                                    tratado.setText("0");
                                                    quantidadeLarvicida.setText("0");
                                                    quantTratados.setText("0");
                                                    emTratamento.setSelected(true);
                                                    concluído.setSelected(false);

                                                } else {
                                                    Alert alert = new Alert(AlertType.INFORMATION);
                                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                    alert.setHeaderText(null);
                                                    alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                                                            + " DA LOCALIDADE " + STFA.getLocalidade() + ", NÃO FOI CADASTRADO!!");
                                                    alert.showAndWait();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void atualizarServicoTratamentoFocal(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        STFA.setRg(rg.getText());
        STFA.setLocalidade(localidade.getText());
        STFA.setCategoria(categoria.getText());
        STFA.setTipo(tipo.getText());
        STFA.setZona(zona.getText());
        STFA.setSemana(semana.getSelectionModel().getSelectedItem().toString());
        STFA.setCiclo(ciclo.getText());
        if (data.getEditor().getText().equals("")) {
            STFA.setData(null);
        } else {
            STFA.setData(util.converterDataBrasilAmericano(data.getEditor().getText()));
        }
        if (individualmente.isSelected()) {
            STFA.setTrabalhouQuarteirao("Individualmente");
        } else {
            STFA.setTrabalhouQuarteirao("Em Conjunto");
        }
        STFA.setAce(ace.getSelectionModel().getSelectedItem().toString());
        STFA.setSupervisor(supervisor.getSelectionModel().getSelectedItem().toString());
        STFA.setObservacao(observacao.getText());
        STFA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        STFA.setLados(lados.getText());
        STFA.setResidencia(Integer.parseInt(residencia.getText()));
        STFA.setComercio(Integer.parseInt(comercio.getText()));
        STFA.setTerrenoBaldio(Integer.parseInt(terrenoBaldio.getText()));
        STFA.setOutros(Integer.parseInt(outros.getText()));
        STFA.setVisitaResgate(Integer.parseInt(visitaResgate.getText()));
        STFA.setEliminado(Integer.parseInt(eliminado.getText()));
        STFA.setTratado(Integer.parseInt(tratado.getText()));
        STFA.setLarvicida(larvicida.getSelectionModel().getSelectedItem().toString());
        STFA.setQuantidadeLarvicida(Double.parseDouble(quantidadeLarvicida.getText().replace(",", ".")));
        STFA.setQuantTratados(Integer.parseInt(quantTratados.getText()));
        if (emTratamento.isSelected()) {
            STFA.setSituacaoQuarteirao("Em Tratamento");
        } else {
            STFA.setSituacaoQuarteirao("Concluído");
        }
        if (STFA.getRg().equals("")
                || STFA.getData().equals("")
                || STFA.getSemana().equals("Sel.")
                || STFA.getAce().equals("Selecione")
                || STFA.getSupervisor().equals("Selecione")
                || STFA.getQuarteirao() == 0
                || STFA.getLados().equals("")
                || !emTratamento.isSelected()
                && !concluído.isSelected()
                || !individualmente.isSelected()
                && !emConjunto.isSelected()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
            alert.setHeaderText(null);
            alert.setContentText("CONFIRA O FORMULÁRIO!!!\n O QUARTEIRÃO " + STFA.getQuarteirao()
                    + " DA LOCALIDADE " + STFA.getLocalidade() + ", NÃO FOI ATUALIZADO!!");
            alert.showAndWait();
        } else {
            //Confere se está tudo ok com o banco de dados
            ServicoTratamentoFocalDAO quarteiraoDAO = new ServicoTratamentoFocalDAO();
            ServicoTratamentoFocalAtributos quarteiraoAtributo = new ServicoTratamentoFocalAtributos(
                    STFA.getRg(),
                    STFA.getLocalidade(),
                    STFA.getCategoria(),
                    STFA.getTipo(),
                    STFA.getZona(),
                    STFA.getData(),
                    STFA.getSemana(),
                    STFA.getCiclo(),
                    STFA.getAce(),
                    STFA.getSupervisor(),
                    STFA.getTrabalhouQuarteirao(),
                    STFA.getObservacao(),
                    STFA.getQuarteirao(),
                    STFA.getLados(),
                    STFA.getResidencia(),
                    STFA.getComercio(),
                    STFA.getTerrenoBaldio(),
                    STFA.getOutros(),
                    STFA.getVisitaResgate(),
                    STFA.getEliminado(),
                    STFA.getTratado(),
                    STFA.getLarvicida(),
                    STFA.getQuantidadeLarvicida(),
                    STFA.getQuantTratados(),
                    STFA.getSituacaoQuarteirao()
            );
            verificaServicoTratamentoFocal(
                    rg,
                    ace,
                    data,
                    quarteirao,
                    STFA
            );
            verificaServicoTratamentoFocalConcluido(
                    rg,
                    quarteirao,
                    ciclo,
                    STFA
            );
//            if (STFA.getSomaParaConferirServicoLancado() > 0) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
//                alert.setHeaderText(null);
//                alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " JÁ FOI LANÇADO!!");
//                alert.showAndWait();
//                Platform.runLater(quarteirao::requestFocus);//fim do run.
//            } else {
                if ((STFA.getSomaParaConferirServicoLancadoConcluido() > 0)
                        && (STFA.getVisitaResgate() == 0)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                    alert.setHeaderText(null);
                    alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " JÁ FOI LANÇADO COMO CONCLUÍDO, ENTÃO,\n"
                            + "DEVE TRATAR-SE DE UM RESGATE, COM ISSO O NÚMERO DE IMÓVEIS RESGATADOS DEVE SER O MESMO DE IMÓVEIS TRABALHADOS");
                    alert.showAndWait();
                    STFA.setSomaParaConferirServicoLancadoConcluido(0);
                    emTratamento.setSelected(true);
                } else {
                    if ((STFA.getSituacaoQuarteirao().equals("Concluído")) && STFA.getSomaParaConferirServicoLancadoConcluido() > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE QUARTEIRÕES");
                        alert.setHeaderText(null);
                        alert.setContentText("O QUARTEIRÃO " + quarteirao.getText() + " JÁ FOI LANÇADO COMO CONCLUÍDO!!");
                        alert.showAndWait();
                        STFA.setSomaParaConferirServicoLancadoConcluido(0);
                    } else {
                        if (STFA.getQuantTratados() > 0
                                && (STFA.getQuantidadeLarvicida() == 0.0
                                || STFA.getTratado() == 0)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                            alert.setHeaderText(null);
                            alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                    + "* \nIMÓVEIS TRATADOS."
                                    + "* \nQUANTIDADE DE LARVICIDA."
                                    + "* \nQUANTIDADE DE TRATADOS."
                                    + "\n\nCONFIRA O FORMULÁRIO!!");
                            alert.showAndWait();
                        } else {
                            if (STFA.getQuantidadeLarvicida() > 0.0
                                    && (STFA.getTratado() == 0
                                    || STFA.getQuantTratados() == 0)) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                alert.setHeaderText(null);
                                alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                        + "* \nIMÓVEIS TRATADOS."
                                        + "* \nQUANTIDADE DE LARVICIDA."
                                        + "* \nQUANTIDADE DE TRATADOS."
                                        + "\n\nCONFIRA O FORMULÁRIO!!");
                                alert.showAndWait();
                            } else {
                                if (STFA.getTratado() > 0
                                        && (STFA.getQuantidadeLarvicida() == 0.0
                                        || STFA.getQuantTratados() == 0)) {
                                    Alert alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                    alert.setHeaderText(null);
                                    alert.setContentText("HÁ INCONCISTENCIA DE DADOS ENTRE: "
                                            + "* \nIMÓVEIS TRATADOS."
                                            + "* \nQUANTIDADE DE LARVICIDA."
                                            + "* \nQUANTIDADE DE TRATADOS."
                                            + "\n\nCONFIRA O FORMULÁRIO!!");
                                    alert.showAndWait();
                                } else {
                                    if (STFA.getTratado() > (STFA.getResidencia()
                                            + STFA.getComercio()
                                            + STFA.getTerrenoBaldio() + STFA.getOutros())) {
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                        alert.setHeaderText(null);
                                        alert.setContentText("O TOTAL DE IMOVEIS TRATADO É MAIOR QUE O TOTAL DE IMÓVEIS TRABALHADOS!!"
                                                + "\nCONFIRA O FORMULÁRIO!!");
                                        alert.showAndWait();
                                    } else {
                                        if (STFA.getVisitaResgate() > (STFA.getResidencia()
                                                + STFA.getComercio()
                                                + STFA.getTerrenoBaldio() + STFA.getOutros())) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                            alert.setHeaderText(null);
                                            alert.setContentText("O TOTAL DE RESGATE É MAIOR QUE O TOTAL DE IMÓVEIS TRABALHADOS!!"
                                                    + "\nCONFIRA O FORMULÁRIO!!");
                                            alert.showAndWait();
                                        } else {
                                            if (residencia.getText().equals("0") || residencia.getText().equals("")
                                                    && comercio.getText().equals("0") || comercio.getText().equals("")
                                                    && terrenoBaldio.getText().equals("0") || terrenoBaldio.getText().equals("")
                                                    && outros.getText().equals("0") || outros.getText().equals("")) {
                                                Alert alert = new Alert(AlertType.INFORMATION);
                                                alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                alert.setHeaderText(null);
                                                alert.setContentText("O TOTAL DE IMÓVEIS NÃO PODE SER ZERO!!\n"
                                                        + "CONFIRA O FORMULÁRIO!!");
                                                alert.showAndWait();
                                            } else {
                                                if (quarteiraoDAO.atualizar(quarteiraoAtributo)) {
                                                    limparFormulario(
                                                            novoCadastro,
                                                            voltarMenuBT,
                                                            salvarBT,
                                                            atualizarBT,
                                                            excluirBT,
                                                            rg,
                                                            localidade,
                                                            categoria,
                                                            tipo,
                                                            zona,
                                                            data,
                                                            semana,
                                                            ciclo,
                                                            ace,
                                                            supervisor,
                                                            observacao,
                                                            quarteirao,
                                                            lados,
                                                            residencia,
                                                            comercio,
                                                            terrenoBaldio,
                                                            outros,
                                                            visitaResgate,
                                                            eliminado,
                                                            tratado,
                                                            larvicida,
                                                            quantidadeLarvicida,
                                                            quantTratados,
                                                            individualmente,
                                                            emConjunto,
                                                            emTratamento,
                                                            concluído,
                                                            tabelaServicoTratamentoFocalTV,
                                                            buscarLocalidadeCB,
                                                            listarBT,
                                                            imprimir
                                                    );
                                                    bloquearCamposFormulario(
                                                            novoCadastro,
                                                            voltarMenuBT,
                                                            salvarBT,
                                                            atualizarBT,
                                                            excluirBT,
                                                            rg,
                                                            localidade,
                                                            categoria,
                                                            tipo,
                                                            zona,
                                                            data,
                                                            semana,
                                                            ciclo,
                                                            ace,
                                                            supervisor,
                                                            observacao,
                                                            quarteirao,
                                                            lados,
                                                            residencia,
                                                            comercio,
                                                            terrenoBaldio,
                                                            outros,
                                                            visitaResgate,
                                                            eliminado,
                                                            tratado,
                                                            larvicida,
                                                            quantidadeLarvicida,
                                                            quantTratados,
                                                            individualmente,
                                                            emConjunto,
                                                            emTratamento,
                                                            concluído,
                                                            tabelaServicoTratamentoFocalTV,
                                                            buscarLocalidadeCB,
                                                            listarBT,
                                                            imprimir
                                                    );
                                                    tabelaServicoTratamentoFocalTV.getItems().clear();
                                                    Alert alert = new Alert(AlertType.INFORMATION);
                                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                    alert.setHeaderText(null);
                                                    alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                                                            + " DA LOCALIDADE " + STFA.getLocalidade() + ", FOI ATUALIZADO COM SUCESSO!!");
                                                    alert.showAndWait();
                                                } else {
                                                    Alert alert = new Alert(AlertType.INFORMATION);
                                                    alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
                                                    alert.setHeaderText(null);
                                                    alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                                                            + " DA LOCALIDADE " + STFA.getLocalidade() + ", NÃO FOI CADASTRADO!!");
                                                    alert.showAndWait();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
//                }
            }
        }
    }

    public void excluirServicoTratamentoFocal(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField rg,
            TextField localidade,
            TextField categoria,
            TextField tipo,
            TextField zona,
            DatePicker data,
            ComboBox semana,
            TextField ciclo,
            ComboBox ace,
            ComboBox supervisor,
            TextArea observacao,
            TextField quarteirao,
            TextField lados,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField outros,
            TextField visitaResgate,
            TextField eliminado,
            TextField tratado,
            ComboBox larvicida,
            TextField quantidadeLarvicida,
            TextField quantTratados,
            CheckBox individualmente,
            CheckBox emConjunto,
            CheckBox emTratamento,
            CheckBox concluído,
            TableView tabelaServicoTratamentoFocalTV,
            ComboBox buscarLocalidadeCB,
            Button listarBT,
            Button imprimir
    ) {
        //Confere se está tudo ok com o banco de dados.
        ServicoTratamentoFocalDAO quarteiraoDAO = new ServicoTratamentoFocalDAO();
        STFA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        STFA.setData(util.converterDataBrasilAmericano(data.getEditor().getText()));
        STFA.setAce(ace.getSelectionModel().getSelectedItem().toString());

        if (quarteiraoDAO.excluir(
                STFA.getQuarteirao(),
                STFA.getData(),
                STFA.getAce(),
                STFA
        )) {
            limparFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    rg,
                    localidade,
                    categoria,
                    tipo,
                    zona,
                    data,
                    semana,
                    ciclo,
                    ace,
                    supervisor,
                    observacao,
                    quarteirao,
                    lados,
                    residencia,
                    comercio,
                    terrenoBaldio,
                    outros,
                    visitaResgate,
                    eliminado,
                    tratado,
                    larvicida,
                    quantidadeLarvicida,
                    quantTratados,
                    individualmente,
                    emConjunto,
                    emTratamento,
                    concluído,
                    tabelaServicoTratamentoFocalTV,
                    buscarLocalidadeCB,
                    listarBT,
                    imprimir
            );

            bloquearCamposFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    rg,
                    localidade,
                    categoria,
                    tipo,
                    zona,
                    data,
                    semana,
                    ciclo,
                    ace,
                    supervisor,
                    observacao,
                    quarteirao,
                    lados,
                    residencia,
                    comercio,
                    terrenoBaldio,
                    outros,
                    visitaResgate,
                    eliminado,
                    tratado,
                    larvicida,
                    quantidadeLarvicida,
                    quantTratados,
                    individualmente,
                    emConjunto,
                    emTratamento,
                    concluído,
                    tabelaServicoTratamentoFocalTV,
                    buscarLocalidadeCB,
                    listarBT,
                    imprimir
            );

            tabelaServicoTratamentoFocalTV.getItems().clear();
            //exibe mensagem de Excluído com sucesso.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
            alert.setHeaderText(null);
            alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                    + " DA LOCALIDADE " + STFA.getLocalidade() + ", FOI EXCLUÍDO COM SUCESSO!!");
            alert.showAndWait();

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastro::requestFocus);//fim do run.

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - LANÇAMENTO SERVIÇO TRATAMENTO FOCAL");
            alert.setHeaderText(null);
            alert.setContentText("QUARTEIRÃO " + STFA.getQuarteirao()
                    + " DA LOCALIDADE " + STFA.getLocalidade() + ", NÃO FOI EXCLUÍDO!!");
            alert.showAndWait();
        }
    }

//     /FIM DO MÉTODO.
    public void preencherComboBoxSemana(ComboBox<ServicoTratamentoFocalMetodos> semana) {

        List<ServicoTratamentoFocalMetodos> semanaCB = new ArrayList<>();

        ObservableList<ServicoTratamentoFocalMetodos> observableListSemana;

        ServicoTratamentoFocalMetodos linha1 = new ServicoTratamentoFocalMetodos(1, "1");
        ServicoTratamentoFocalMetodos linha2 = new ServicoTratamentoFocalMetodos(2, "2");
        ServicoTratamentoFocalMetodos linha3 = new ServicoTratamentoFocalMetodos(3, "3");
        ServicoTratamentoFocalMetodos linha4 = new ServicoTratamentoFocalMetodos(4, "4");
        ServicoTratamentoFocalMetodos linha5 = new ServicoTratamentoFocalMetodos(5, "5");
        ServicoTratamentoFocalMetodos linha6 = new ServicoTratamentoFocalMetodos(6, "6");
        ServicoTratamentoFocalMetodos linha7 = new ServicoTratamentoFocalMetodos(7, "7");
        ServicoTratamentoFocalMetodos linha8 = new ServicoTratamentoFocalMetodos(8, "8");
        ServicoTratamentoFocalMetodos linha9 = new ServicoTratamentoFocalMetodos(9, "9");
        ServicoTratamentoFocalMetodos linha10 = new ServicoTratamentoFocalMetodos(10, "10");
        ServicoTratamentoFocalMetodos linha11 = new ServicoTratamentoFocalMetodos(11, "11");
        ServicoTratamentoFocalMetodos linha12 = new ServicoTratamentoFocalMetodos(12, "12");
        ServicoTratamentoFocalMetodos linha13 = new ServicoTratamentoFocalMetodos(13, "13");
        ServicoTratamentoFocalMetodos linha14 = new ServicoTratamentoFocalMetodos(14, "14");
        ServicoTratamentoFocalMetodos linha15 = new ServicoTratamentoFocalMetodos(15, "15");
        ServicoTratamentoFocalMetodos linha16 = new ServicoTratamentoFocalMetodos(16, "16");
        ServicoTratamentoFocalMetodos linha17 = new ServicoTratamentoFocalMetodos(17, "17");
        ServicoTratamentoFocalMetodos linha18 = new ServicoTratamentoFocalMetodos(18, "18");
        ServicoTratamentoFocalMetodos linha19 = new ServicoTratamentoFocalMetodos(19, "19");
        ServicoTratamentoFocalMetodos linha20 = new ServicoTratamentoFocalMetodos(20, "20");
        ServicoTratamentoFocalMetodos linha21 = new ServicoTratamentoFocalMetodos(21, "21");
        ServicoTratamentoFocalMetodos linha22 = new ServicoTratamentoFocalMetodos(22, "22");
        ServicoTratamentoFocalMetodos linha23 = new ServicoTratamentoFocalMetodos(23, "23");
        ServicoTratamentoFocalMetodos linha24 = new ServicoTratamentoFocalMetodos(24, "24");
        ServicoTratamentoFocalMetodos linha25 = new ServicoTratamentoFocalMetodos(25, "25");
        ServicoTratamentoFocalMetodos linha26 = new ServicoTratamentoFocalMetodos(26, "26");
        ServicoTratamentoFocalMetodos linha27 = new ServicoTratamentoFocalMetodos(27, "27");
        ServicoTratamentoFocalMetodos linha28 = new ServicoTratamentoFocalMetodos(28, "28");
        ServicoTratamentoFocalMetodos linha29 = new ServicoTratamentoFocalMetodos(29, "29");
        ServicoTratamentoFocalMetodos linha30 = new ServicoTratamentoFocalMetodos(30, "30");
        ServicoTratamentoFocalMetodos linha31 = new ServicoTratamentoFocalMetodos(31, "31");
        ServicoTratamentoFocalMetodos linha32 = new ServicoTratamentoFocalMetodos(32, "32");
        ServicoTratamentoFocalMetodos linha33 = new ServicoTratamentoFocalMetodos(33, "33");
        ServicoTratamentoFocalMetodos linha34 = new ServicoTratamentoFocalMetodos(34, "34");
        ServicoTratamentoFocalMetodos linha35 = new ServicoTratamentoFocalMetodos(35, "35");
        ServicoTratamentoFocalMetodos linha36 = new ServicoTratamentoFocalMetodos(36, "36");
        ServicoTratamentoFocalMetodos linha37 = new ServicoTratamentoFocalMetodos(37, "37");
        ServicoTratamentoFocalMetodos linha38 = new ServicoTratamentoFocalMetodos(38, "38");
        ServicoTratamentoFocalMetodos linha39 = new ServicoTratamentoFocalMetodos(39, "39");
        ServicoTratamentoFocalMetodos linha40 = new ServicoTratamentoFocalMetodos(40, "40");
        ServicoTratamentoFocalMetodos linha41 = new ServicoTratamentoFocalMetodos(41, "41");
        ServicoTratamentoFocalMetodos linha42 = new ServicoTratamentoFocalMetodos(42, "42");
        ServicoTratamentoFocalMetodos linha43 = new ServicoTratamentoFocalMetodos(43, "43");
        ServicoTratamentoFocalMetodos linha44 = new ServicoTratamentoFocalMetodos(44, "44");
        ServicoTratamentoFocalMetodos linha45 = new ServicoTratamentoFocalMetodos(45, "45");
        ServicoTratamentoFocalMetodos linha46 = new ServicoTratamentoFocalMetodos(46, "46");
        ServicoTratamentoFocalMetodos linha47 = new ServicoTratamentoFocalMetodos(47, "47");
        ServicoTratamentoFocalMetodos linha48 = new ServicoTratamentoFocalMetodos(48, "48");
        ServicoTratamentoFocalMetodos linha49 = new ServicoTratamentoFocalMetodos(49, "49");
        ServicoTratamentoFocalMetodos linha50 = new ServicoTratamentoFocalMetodos(50, "50");
        ServicoTratamentoFocalMetodos linha51 = new ServicoTratamentoFocalMetodos(51, "51");
        ServicoTratamentoFocalMetodos linha52 = new ServicoTratamentoFocalMetodos(52, "52");

        semanaCB.add(linha1);
        semanaCB.add(linha2);
        semanaCB.add(linha3);
        semanaCB.add(linha4);
        semanaCB.add(linha5);
        semanaCB.add(linha6);
        semanaCB.add(linha7);
        semanaCB.add(linha8);
        semanaCB.add(linha9);
        semanaCB.add(linha10);
        semanaCB.add(linha11);
        semanaCB.add(linha12);
        semanaCB.add(linha13);
        semanaCB.add(linha14);
        semanaCB.add(linha15);
        semanaCB.add(linha16);
        semanaCB.add(linha17);
        semanaCB.add(linha18);
        semanaCB.add(linha19);
        semanaCB.add(linha20);
        semanaCB.add(linha21);
        semanaCB.add(linha22);
        semanaCB.add(linha23);
        semanaCB.add(linha24);
        semanaCB.add(linha25);
        semanaCB.add(linha26);
        semanaCB.add(linha27);
        semanaCB.add(linha28);
        semanaCB.add(linha29);
        semanaCB.add(linha30);
        semanaCB.add(linha31);
        semanaCB.add(linha32);
        semanaCB.add(linha33);
        semanaCB.add(linha34);
        semanaCB.add(linha35);
        semanaCB.add(linha36);
        semanaCB.add(linha37);
        semanaCB.add(linha38);
        semanaCB.add(linha39);
        semanaCB.add(linha40);
        semanaCB.add(linha41);
        semanaCB.add(linha42);
        semanaCB.add(linha43);
        semanaCB.add(linha44);
        semanaCB.add(linha45);
        semanaCB.add(linha46);
        semanaCB.add(linha47);
        semanaCB.add(linha48);
        semanaCB.add(linha49);
        semanaCB.add(linha50);
        semanaCB.add(linha51);
        semanaCB.add(linha52);

        observableListSemana = FXCollections.observableArrayList(semanaCB);

        semana.setItems(observableListSemana);
    }

    public void preencherComboBoxInseticida(ComboBox<ServicoTratamentoFocalMetodos> inseticida) {

        List<ServicoTratamentoFocalMetodos> inseticidaCB = new ArrayList<>();

        ObservableList<ServicoTratamentoFocalMetodos> observableListInseticida;

        ServicoTratamentoFocalMetodos linha1 = new ServicoTratamentoFocalMetodos(1, "Pyriproxyfen");
//        ServicoTratamentoFocalMetodos linha2 = new ServicoTratamentoFocalMetodos(2, "");
//        ServicoTratamentoFocalMetodos linha3 = new ServicoTratamentoFocalMetodos(3, "");
//        ServicoTratamentoFocalMetodos linha4 = new ServicoTratamentoFocalMetodos(4, "");
//        ServicoTratamentoFocalMetodos linha5 = new ServicoTratamentoFocalMetodos(5, "");
//        ServicoTratamentoFocalMetodos linha6 = new ServicoTratamentoFocalMetodos(6, "");
//        ServicoTratamentoFocalMetodos linha7 = new ServicoTratamentoFocalMetodos(7, "");
//        ServicoTratamentoFocalMetodos linha8 = new ServicoTratamentoFocalMetodos(8, "");
//        ServicoTratamentoFocalMetodos linha9 = new ServicoTratamentoFocalMetodos(9, "");
//        ServicoTratamentoFocalMetodos linha10 = new ServicoTratamentoFocalMetodos(10, "");

        inseticidaCB.add(linha1);
//        inseticidaCB.add(linha2);
//        inseticidaCB.add(linha3);
//        inseticidaCB.add(linha4);
//        inseticidaCB.add(linha5);
//        inseticidaCB.add(linha6);
//        inseticidaCB.add(linha7);
//        inseticidaCB.add(linha8);
//        inseticidaCB.add(linha9);
//        inseticidaCB.add(linha10);

        observableListInseticida = FXCollections.observableArrayList(inseticidaCB);

        inseticida.setItems(observableListInseticida);
    }

    private void relatorios(
            String relatorio,
            String localidade,
            String ciclo
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("localidade", localidade);
        filtro.put("ciclo", ciclo);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO AO GERAR RELATORIO\n" + ex);
            Logger.getLogger(ServicoTratamentoFocalMetodos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(ComboBox localidadeCB, ComboBox quarteiraoCB) {
        Utilitario util = new Utilitario(conn);
        String localidade = localidadeCB.getSelectionModel().getSelectedItem().toString();
        String quarteirao = quarteiraoCB.getSelectionModel().getSelectedItem().toString();

        String relatorio = "../src/relatorios/ServicoTratamentoFocal.jasper";
        relatorios(relatorio, localidade, quarteirao);
    }

}
