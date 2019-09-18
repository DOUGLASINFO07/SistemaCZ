package quarteirao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import menu.MenuMetodos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.CarregarPagina;
import util.Conexao;
import util.Utilitario;

public class QuarteiraoMetodos {

    MenuMetodos menuMetodos = new MenuMetodos();

    QuarteiraoAtributos QA = new QuarteiraoAtributos();

    CarregarPagina cp = new CarregarPagina();
    
    Utilitario util = new Utilitario();

    public QuarteiraoMetodos() {
    }

    public QuarteiraoMetodos(int posicao, String localidade) {
        QA.setLocalidade(localidade);
    }

    @Override
    public String toString() {
        return QA.getLocalidade();
    }

    public void limparFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            Button listarTodosBT
    ) {
        localidade.getSelectionModel().select("Selecione");
        rgCB.getSelectionModel().select("Selecione");
        macroArea.setValue("Selecione");
        microArea.setValue("Selecione");
        supervisor.getSelectionModel().select("Selecione");
        ace.getSelectionModel().select("Selecione");
        observacao.setText("");
        quarteirao.setText("0");
        residencia.setText("0");
        comercio.setText("0");
        terrenoBaldio.setText("0");
        pontoEstrategico.setText("0");
        outros.setText("0");
        habitantes.setText("0");
        caes.setText("0");
        gatos.setText("0");
        ratosSim.setSelected(true);
        ratosNao.setSelected(false);
    }

    public void limparCamposPesquisa(
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarRG,
            TableView tabelaQuarteiraoTV,
            TextField totalQuarteirao,
            TextField totalImoveis,
            Button imprimir
    ) {
        buscarQuarteiraoCB.getSelectionModel().select("Selecione uma Localidade");
        buscarRG.getSelectionModel().select("Selecione um RG");
        tabelaQuarteiraoTV.getItems().clear();
        buscarRG.setDisable(true);
        totalImoveis.setText("0");
        totalQuarteirao.setText("0");
    }

    public void liberarCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            Button listarTodosBT
    ) {
        localidade.setDisable(false);
        rgCB.setDisable(false);
        macroArea.setDisable(false);
        microArea.setDisable(false);
        supervisor.setDisable(false);
        ace.setDisable(false);
        observacao.setDisable(false);
        quarteirao.setDisable(false);
        residencia.setDisable(false);
        comercio.setDisable(false);
        terrenoBaldio.setDisable(false);
        pontoEstrategico.setDisable(false);
        outros.setDisable(false);
        habitantes.setDisable(false);
        caes.setDisable(false);
        gatos.setDisable(false);
        ratosSim.setDisable(false);
        ratosNao.setDisable(false);
    }

    public void bloquearCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            Button listarTodosBT
    ) {
        localidade.setDisable(true);
        rgCB.setDisable(true);
        macroArea.setDisable(true);
        microArea.setDisable(true);
        supervisor.setDisable(true);
        ace.setDisable(true);
        observacao.setDisable(true);
        quarteirao.setDisable(true);
        residencia.setDisable(true);
        comercio.setDisable(true);
        terrenoBaldio.setDisable(true);
        pontoEstrategico.setDisable(true);
        outros.setDisable(true);
        habitantes.setDisable(true);
        caes.setDisable(true);
        gatos.setDisable(true);
        ratosSim.setDisable(true);
        ratosNao.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn total,
            TableColumn quarteirao,
            TableView tabelaQuarteiraoTV,
            ComboBox buscarLocalidade,
            ComboBox buscarRG
    ) {
        total.setCellValueFactory(new PropertyValueFactory("totalImoveis"));
        quarteirao.setCellValueFactory(new PropertyValueFactory("quarteirao"));
        tabelaQuarteiraoTV.setItems(atualizaTabela(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getSelectionModel().getSelectedItem().toString()
        ));
    }

    public ObservableList<QuarteiraoAtributos> atualizaTabela(String buscarLocalidade, String buscarRG) {
        QuarteiraoDAO dao = new QuarteiraoDAO();
        return FXCollections.observableArrayList(dao.listaQuarteirao(
                buscarLocalidade,
                buscarRG
        ));
    }

    public void iniciarTabelaFormulario(
            TableColumn total,
            TableColumn quarteirao,
            TableView tabelaQuarteiraoTV,
            ComboBox buscarLocalidade,
            ComboBox buscarRG
    ) {
        total.setCellValueFactory(new PropertyValueFactory("totalImoveis"));
        quarteirao.setCellValueFactory(new PropertyValueFactory("quarteirao"));
        tabelaQuarteiraoTV.setItems(atualizaTabelaFormuario(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getValue().toString()
        ));
    }

    public ObservableList<QuarteiraoAtributos> atualizaTabelaFormuario(String buscarLocalidade, String buscarRG) {
        QuarteiraoDAO dao = new QuarteiraoDAO();
        return FXCollections.observableArrayList(dao.listaQuarteiraoFormulario(
                buscarLocalidade,
                buscarRG
        ));
    }

    public void somaTabela(
            ComboBox buscarLocalidade,
            ComboBox buscarRG,
            TextField totalQuarteirao,
            TextField totalImoveisQuarteirao
    ) {
        QuarteiraoDAO dao = new QuarteiraoDAO();
        dao.somaTotalQuarteirao(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getSelectionModel().getSelectedItem().toString(),
                QA
        );
        QuarteiraoDAO dao1 = new QuarteiraoDAO();
        dao1.somaImoveisLocalidade(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getSelectionModel().getSelectedItem().toString(),
                QA
        );

        totalQuarteirao.setText("" + QA.getTotalQuarteirao());
        totalImoveisQuarteirao.setText("" + QA.getTotalImoveisLocalidade());
    }

    public void somaTabelaFormulario(
            ComboBox buscarLocalidade,
            ComboBox buscarRG,
            TextField totalQuarteirao,
            TextField totalImoveisQuarteirao
    ) {
        QuarteiraoDAO dao = new QuarteiraoDAO();
        dao.somaTotalQuarteirao(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getEditor().getText(),
                QA
        );
        QuarteiraoDAO dao1 = new QuarteiraoDAO();
        dao1.somaImoveisLocalidade(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getEditor().getText(),
                QA
        );
        totalQuarteirao.setText("" + QA.getTotalQuarteirao());
        totalImoveisQuarteirao.setText("" + QA.getTotalImoveisLocalidade());
    }

    public void verificaQuarteirao(
            ComboBox buscarLocalidade,
            ComboBox buscarRG,
            TextField quarteirao,
            QuarteiraoAtributos QA
    ) {
        QuarteiraoDAO dao = new QuarteiraoDAO();
        dao.verificarQuarteirao(
                buscarLocalidade.getSelectionModel().getSelectedItem().toString(),
                buscarRG.getEditor().getText(),
                Integer.parseInt(quarteirao.getText()),
                QA
        );
    }

    public void pegarDadoTabela(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarRG,
            TableView<QuarteiraoAtributos> tabelaQuarteiraoTV,
            Button listarTodosBT
    ) {
//        QuarteiraoAtributos QA = new QuarteiraoAtributos();

        int quarteiraoQT = tabelaQuarteiraoTV.getSelectionModel().getSelectedItem().getQuarteirao();
        String RGQT = buscarRG.getSelectionModel().getSelectedItem().toString();

        QuarteiraoDAO dao = new QuarteiraoDAO();
        dao.buscarDadosBairro("" + quarteiraoQT, RGQT, QA);

        localidade.setValue(QA.getLocalidade());
        rgCB.setValue(QA.getRg());
        macroArea.setValue(QA.getMacroArea());
        microArea.setValue(QA.getMicroArea());
        supervisor.setValue(QA.getSupervisor());
        ace.setValue(QA.getAce());
        observacao.setText(QA.getObservacao());
        quarteirao.setText("" + QA.getQuarteirao());
        residencia.setText("" + QA.getResidencia());
        comercio.setText("" + QA.getComercio());
        terrenoBaldio.setText("" + QA.getTerrenoBaldio());
        pontoEstrategico.setText("" + QA.getPontoEstrategico());
        outros.setText("" + QA.getOutros());
        habitantes.setText("" + QA.getHabitantes());
        caes.setText("" + QA.getCaes());
        gatos.setText("" + QA.getGatos());

        if (QA.getRatos().equals("Sim")) {
            ratosSim.setSelected(true);
            ratosNao.setSelected(false);
        } else {
            ratosSim.setSelected(false);
            ratosNao.setSelected(true);
        }
    }

    public void salvarQuarteirao(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            Button listarTodosBT
    ) {
        QA.setLocalidade(localidade.getSelectionModel().getSelectedItem().toString());
        QA.setRg(rgCB.getSelectionModel().getSelectedItem().toString());
        QA.setMacroArea(macroArea.getSelectionModel().getSelectedItem().toString());
        QA.setMicroArea(microArea.getSelectionModel().getSelectedItem().toString());
        QA.setSupervisor(supervisor.getSelectionModel().getSelectedItem().toString());
        QA.setAce(ace.getSelectionModel().getSelectedItem().toString());
        QA.setObservacao(observacao.getText());
        QA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        QA.setResidencia(Integer.parseInt(residencia.getText()));
        QA.setComercio(Integer.parseInt(comercio.getText()));
        QA.setTerrenoBaldio(Integer.parseInt(terrenoBaldio.getText()));
        QA.setPontoEstrategico(Integer.parseInt(pontoEstrategico.getText()));
        QA.setOutros(Integer.parseInt(outros.getText()));
        QA.setHabitantes(Integer.parseInt(habitantes.getText()));
        QA.setCaes(Integer.parseInt(caes.getText()));
        QA.setGatos(Integer.parseInt(gatos.getText()));

        if (ratosSim.isSelected()) {
            QA.setRatos("Sim");
        } else {
            QA.setRatos("Não");
        }

        if (localidade.getValue().equals("Selecione")
                || rgCB.getValue().equals("Selecione")
                || macroArea.getValue().equals("Selecione")
                || microArea.getValue().equals("Selecione")
                || supervisor.getValue().equals("Selecione")
                || ace.getValue().equals("Selecione")
                || quarteirao.getText().equals("0")
                || !ratosSim.isSelected()
                && !ratosNao.isSelected()) {

            util.alertSimples("CADASTRO DE QUARTEIRÃO", "CONFIRA O FORMULÁRIO!!!"
                    + "\n Todos os campos devem ser preenchidos!!");

            Platform.runLater(() -> {
                localidade.requestFocus();
            });
        } else {
            //Confere se está tudo ok com o banco de dados
            QuarteiraoDAO quarteiraoDAO = new QuarteiraoDAO();
            QuarteiraoAtributos quarteiraoAtributo = new QuarteiraoAtributos(
                    QA.getLocalidade(),
                    QA.getRg(),
                    QA.getMacroArea(),
                    QA.getMicroArea(),
                    QA.getSupervisor(),
                    QA.getAce(),
                    QA.getObservacao(),
                    QA.getQuarteirao(),
                    QA.getResidencia(),
                    QA.getComercio(),
                    QA.getTerrenoBaldio(),
                    QA.getPontoEstrategico(),
                    QA.getOutros(),
                    QA.getHabitantes(),
                    QA.getCaes(),
                    QA.getGatos(),
                    QA.getRatos(),
                    QA.getTotalQuarteirao(),
                    QA.getTotalImoveis(),
                    QA.getTotalImoveisLocalidade()
            );

            if (residencia.getText().equals("0")
                    && comercio.getText().equals("0")
                    && terrenoBaldio.getText().equals("0")
                    && pontoEstrategico.getText().equals("0")
                    && outros.getText().equals("0")) {
                util.alertSimples("CADASTRO DE QUARTEIRÃO", "CONFIRA O FORMULÁRIO!!!"
                        + "\n O Total de Imóveis não pode ser 0!!");

            } else {
                if (quarteiraoDAO.salvar(quarteiraoAtributo)) {

                    util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                            + " da localidade " + QA.getLocalidade() + ",\nfoi cadastrado com sucesso!!");

                    quarteirao.setText("0");
                    observacao.setText("");
                    residencia.setText("0");
                    comercio.setText("0");
                    terrenoBaldio.setText("0");
                    pontoEstrategico.setText("0");
                    outros.setText("0");
                    habitantes.setText("0");
                    caes.setText("0");
                    gatos.setText("0");
                    ratosSim.setSelected(true);
                    ratosNao.setSelected(false);

                } else {

                    util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                            + " da localidade " + QA.getLocalidade() + ", não foi cadastrado!!");

                }
            }
        }
    }

    public void atualizarQuarteirao(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            TextField totalQuarteirao,
            TextField totalImoveis,
            Button listarTodosBT
    ) {
        QA.setLocalidade(localidade.getSelectionModel().getSelectedItem().toString());
        QA.setRg(rgCB.getSelectionModel().getSelectedItem().toString());
        QA.setMacroArea(macroArea.getSelectionModel().getSelectedItem().toString());
        QA.setMicroArea(microArea.getSelectionModel().getSelectedItem().toString());
        QA.setSupervisor(supervisor.getSelectionModel().getSelectedItem().toString());
        QA.setAce(ace.getSelectionModel().getSelectedItem().toString());
        QA.setObservacao(observacao.getText());
        QA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        QA.setResidencia(Integer.parseInt(residencia.getText()));
        QA.setComercio(Integer.parseInt(comercio.getText()));
        QA.setTerrenoBaldio(Integer.parseInt(terrenoBaldio.getText()));
        QA.setPontoEstrategico(Integer.parseInt(pontoEstrategico.getText()));
        QA.setOutros(Integer.parseInt(outros.getText()));
        QA.setHabitantes(Integer.parseInt(habitantes.getText()));
        QA.setCaes(Integer.parseInt(caes.getText()));
        QA.setGatos(Integer.parseInt(gatos.getText()));

        if (ratosSim.isSelected()) {
            QA.setRatos("Sim");
        } else {
            QA.setRatos("Não");
        }

        if (localidade.getValue().equals("Selecione")
                || rgCB.getValue().equals("")
                || macroArea.getValue().equals("Selecione")
                || microArea.getValue().equals("Selecione")
                || supervisor.getValue().equals("Selecione")
                || ace.getValue().equals("Selecione")
                || quarteirao.getText().equals("0")
                || !ratosSim.isSelected()
                && !ratosNao.isSelected()) {

            util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                    + " da localidade " + QA.getLocalidade() + ",\nnão foi Atualizado!!");

        } else {

            //Confere se está tudo ok com o banco de dados
            QuarteiraoDAO quarteiraoDAO = new QuarteiraoDAO();
            QuarteiraoAtributos quarteiraoAtributo = new QuarteiraoAtributos(
                    QA.getLocalidade(),
                    QA.getRg(),
                    QA.getMacroArea(),
                    QA.getMicroArea(),
                    QA.getSupervisor(),
                    QA.getAce(),
                    QA.getObservacao(),
                    QA.getQuarteirao(),
                    QA.getResidencia(),
                    QA.getComercio(),
                    QA.getTerrenoBaldio(),
                    QA.getPontoEstrategico(),
                    QA.getOutros(),
                    QA.getHabitantes(),
                    QA.getCaes(),
                    QA.getGatos(),
                    QA.getRatos(),
                    QA.getTotalQuarteirao(),
                    QA.getTotalImoveis(),
                    QA.getTotalImoveisLocalidade()
            );

            if (quarteiraoDAO.atualizar(quarteiraoAtributo)) {
                limparFormulario(
                        novoCadastro,
                        voltarMenuBT,
                        salvarBT,
                        atualizarBT,
                        excluirBT,
                        localidade,
                        rgCB,
                        macroArea,
                        microArea,
                        supervisor,
                        ace,
                        observacao,
                        quarteirao,
                        residencia,
                        comercio,
                        terrenoBaldio,
                        pontoEstrategico,
                        outros,
                        habitantes,
                        caes,
                        gatos,
                        ratosSim,
                        ratosNao,
                        buscarQuarteiraoCB,
                        buscarDataRG,
                        tabelaQuarteiraoTV,
                        listarTodosBT
                );

                bloquearCamposFormulario(
                        novoCadastro,
                        voltarMenuBT,
                        salvarBT,
                        atualizarBT,
                        excluirBT,
                        localidade,
                        rgCB,
                        macroArea,
                        microArea,
                        supervisor,
                        ace,
                        observacao,
                        quarteirao,
                        residencia,
                        comercio,
                        terrenoBaldio,
                        pontoEstrategico,
                        outros,
                        habitantes,
                        caes,
                        gatos,
                        ratosSim,
                        ratosNao,
                        buscarQuarteiraoCB,
                        buscarDataRG,
                        tabelaQuarteiraoTV,
                        listarTodosBT
                );
                tabelaQuarteiraoTV.getItems().clear();

                util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                        + " da localidade " + QA.getLocalidade() + ",\n foi Atualizado com sucesso!!");

                totalQuarteirao.setText("0");
                totalImoveis.setText("0");
            } else {

                util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                        + " da localidade " + QA.getLocalidade() + ",\nnão foi Atualizado!!");

            }
        }
    }

    public void excluirQuarteirao(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            ComboBox localidade,
            ComboBox rgCB,
            ComboBox macroArea,
            ComboBox microArea,
            ComboBox supervisor,
            ComboBox ace,
            TextArea observacao,
            TextField quarteirao,
            TextField residencia,
            TextField comercio,
            TextField terrenoBaldio,
            TextField pontoEstrategico,
            TextField outros,
            TextField habitantes,
            TextField caes,
            TextField gatos,
            CheckBox ratosSim,
            CheckBox ratosNao,
            ComboBox buscarQuarteiraoCB,
            ComboBox buscarDataRG,
            TableView tabelaQuarteiraoTV,
            TextField totalQuarteirao,
            TextField totalImoveis,
            Button listarTodosBT
    ) {
        //Confere se está tudo ok com o banco de dados.
        QuarteiraoDAO quarteiraoDAO = new QuarteiraoDAO();
        QA.setQuarteirao(Integer.parseInt(quarteirao.getText()));
        QA.setRg(rgCB.getSelectionModel().getSelectedItem().toString());

        if (quarteiraoDAO.excluir(
                QA.getQuarteirao(),
                QA.getRg(),
                QA
        )) {

            limparFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidade,
                    rgCB,
                    macroArea,
                    microArea,
                    supervisor,
                    ace,
                    observacao,
                    quarteirao,
                    residencia,
                    comercio,
                    terrenoBaldio,
                    pontoEstrategico,
                    outros,
                    habitantes,
                    caes,
                    gatos,
                    ratosSim,
                    ratosNao,
                    buscarQuarteiraoCB,
                    buscarDataRG,
                    tabelaQuarteiraoTV,
                    listarTodosBT
            );

            bloquearCamposFormulario(
                    novoCadastro,
                    voltarMenuBT,
                    salvarBT,
                    atualizarBT,
                    excluirBT,
                    localidade,
                    rgCB,
                    macroArea,
                    microArea,
                    supervisor,
                    ace,
                    observacao,
                    quarteirao,
                    residencia,
                    comercio,
                    terrenoBaldio,
                    pontoEstrategico,
                    outros,
                    habitantes,
                    caes,
                    gatos,
                    ratosSim,
                    ratosNao,
                    buscarQuarteiraoCB,
                    buscarDataRG,
                    tabelaQuarteiraoTV,
                    listarTodosBT
            );

            tabelaQuarteiraoTV.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.

            util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                    + " da localidade " + QA.getLocalidade() + ",\n foi Excluído com sucesso!!");

            totalQuarteirao.setText("0");
            totalImoveis.setText("0");
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastro::requestFocus);//fim do run.

        } else {

            util.alertSimples("CADASTRO DE QUARTEIRÃO", "O quarteirão " + QA.getQuarteirao()
                    + " da localidade " + QA.getLocalidade() + ",\nnão foi Excluído!!");

        }
    }

//     /FIM DO MÉTODO.
    public void preencherComboBoxMacroArea(ComboBox<QuarteiraoMetodos> macroArea) {

        List<QuarteiraoMetodos> macroAreaCB = new ArrayList<>();

        ObservableList<QuarteiraoMetodos> observableListMacroArea;

        QuarteiraoMetodos linha1 = new QuarteiraoMetodos(1, "01 - A");
        QuarteiraoMetodos linha2 = new QuarteiraoMetodos(2, "01 - B");
        QuarteiraoMetodos linha3 = new QuarteiraoMetodos(3, "01 - C");
        QuarteiraoMetodos linha4 = new QuarteiraoMetodos(4, "01 - D");
        QuarteiraoMetodos linha5 = new QuarteiraoMetodos(5, "01 - E");
        QuarteiraoMetodos linha6 = new QuarteiraoMetodos(6, "01 - F");
        QuarteiraoMetodos linha7 = new QuarteiraoMetodos(7, "01 - G");
        QuarteiraoMetodos linha8 = new QuarteiraoMetodos(8, "01 - H");
        QuarteiraoMetodos linha9 = new QuarteiraoMetodos(9, "01 - I");

        macroAreaCB.add(linha1);
        macroAreaCB.add(linha2);
        macroAreaCB.add(linha3);
        macroAreaCB.add(linha4);
        macroAreaCB.add(linha5);
        macroAreaCB.add(linha6);
        macroAreaCB.add(linha7);
        macroAreaCB.add(linha8);
        macroAreaCB.add(linha9);

        observableListMacroArea = FXCollections.observableArrayList(macroAreaCB);

        macroArea.setItems(observableListMacroArea);
    }

    public void preencherComboBoxMicroArea(ComboBox<QuarteiraoMetodos> microArea) {

        List<QuarteiraoMetodos> microAreaCB = new ArrayList<>();

        ObservableList<QuarteiraoMetodos> observableListMicroArea;

        QuarteiraoMetodos linha1 = new QuarteiraoMetodos(1, "Micro 01");
        QuarteiraoMetodos linha2 = new QuarteiraoMetodos(2, "Micro 02");
        QuarteiraoMetodos linha3 = new QuarteiraoMetodos(3, "Micro 03");
        QuarteiraoMetodos linha4 = new QuarteiraoMetodos(4, "Micro 04");
        QuarteiraoMetodos linha5 = new QuarteiraoMetodos(5, "Micro 05");
        QuarteiraoMetodos linha6 = new QuarteiraoMetodos(6, "Micro 06");
        QuarteiraoMetodos linha7 = new QuarteiraoMetodos(7, "Micro 07");
        QuarteiraoMetodos linha8 = new QuarteiraoMetodos(8, "Micro 08");
        QuarteiraoMetodos linha9 = new QuarteiraoMetodos(9, "Micro 09");
        QuarteiraoMetodos linha10 = new QuarteiraoMetodos(10, "Micro 10");

        microAreaCB.add(linha1);
        microAreaCB.add(linha2);
        microAreaCB.add(linha3);
        microAreaCB.add(linha4);
        microAreaCB.add(linha5);
        microAreaCB.add(linha6);
        microAreaCB.add(linha7);
        microAreaCB.add(linha8);
        microAreaCB.add(linha9);
        microAreaCB.add(linha10);

        observableListMicroArea = FXCollections.observableArrayList(microAreaCB);

        microArea.setItems(observableListMicroArea);
    }

    private void relatorios(
            String relatorio,
            String localidade,
            String rg
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("localidade", localidade);
        filtro.put("rg", rg);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO AO GERAR RELATORIO\n" + ex);
            Logger.getLogger(QuarteiraoMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(ComboBox localidadeCB, ComboBox rgCB) {
        String localidade = localidadeCB.getSelectionModel().getSelectedItem().toString();
        String rg = rgCB.getSelectionModel().getSelectedItem().toString();
        String relatorio = "../src/relatorios/Quarteirao.jasper";
        relatorios(relatorio, localidade, rg);
    }

}
