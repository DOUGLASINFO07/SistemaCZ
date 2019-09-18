package atividades;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import util.Conexao;
import util.Utilitario;

public class AtividadesMetodos{

    Connection conn;

    MenuMetodos menuMetodos = new MenuMetodos();

    AtividadesAtributos AA = new AtividadesAtributos();
    
    Utilitario util = new Utilitario();

    public AtividadesMetodos() {
    }

    public AtividadesMetodos(int posicao, String atividades) {
        AA.setAtividade(atividades);
    }

    @Override
    public String toString() {
        return AA.getAtividade();
    }

    public void limparFormulario(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        atividadesCB.setValue("Selecione");
        dataInicioDP.getEditor().clear();
        dataTerminoDP.getEditor().clear();
        cicloCB.setValue("Selecione");
        observacaoTA.setText("");
        nomeAtividades.setText("");

    }

    public void limparCamposPesquisa(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        tabelaAtividadesTV.getItems().clear();
        imprimirBT.setDisable(true);
    }

    public void liberarCamposFormulario(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        atividadesCB.setDisable(false);
        dataInicioDP.setDisable(false);
        dataTerminoDP.setDisable(false);
        cicloCB.setDisable(false);
        observacaoTA.setDisable(false);
        buscarAtividadesCB.setValue("Selecione uma Atividade");
    }

    public void bloquearCamposFormulario(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        atividadesCB.setDisable(true);
        dataInicioDP.setDisable(true);
        dataTerminoDP.setDisable(true);
        cicloCB.setDisable(true);
        observacaoTA.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn atividades,
            TableColumn nomeAtividade,
            TableView tabelaAtividadesTV,
            ComboBox buscarAtividades
    ) {
        atividades.setCellValueFactory(new PropertyValueFactory("atividade"));
        nomeAtividade.setCellValueFactory(new PropertyValueFactory("nomeAtividade"));
        tabelaAtividadesTV.setItems(atualizaTabela(
                buscarAtividades.getSelectionModel().getSelectedItem().toString()
        ));
    }

    public ObservableList<AtividadesAtributos> atualizaTabela(String buscarAtividades) {
        AtividadesDAO dao = new AtividadesDAO();
        return FXCollections.observableArrayList(dao.listaAtividades(
                buscarAtividades
        ));
    }

    public void verificaAtividades(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT,
            AtividadesAtributos AAA
    ) {
        AtividadesDAO dao = new AtividadesDAO();

        AA.setAtividade(atividadesCB.getSelectionModel().getSelectedItem().toString());
        AA.setCiclo(cicloCB.getSelectionModel().getSelectedItem().toString());

        String idAtividade = null;
        switch (atividadesCB.getSelectionModel().getSelectedItem().toString()) {
            case "Tratamento Focal":
                idAtividade = "T.Focal "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "Reconhecimento Geográfico":
                idAtividade = "RG "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "LIRAa":
                idAtividade = "LIRAa "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "UBV-Pesado":
                idAtividade = "UBV-Pesado "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "UBV-Costal":
                idAtividade = "UBV-Costal "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "Ponto Estratégico - Pesquisa":
                idAtividade = "PE - Pesquisa "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "Pontoestratégico - Tratamento":
                idAtividade = "PE - Trat. Focal "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "LI":
                idAtividade = "LI "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
            case "TPVE":
                idAtividade = "TPVE "
                        + AA.getCiclo() + "-"
                        + dataInicioDP.getEditor().getText(6, 10);
                break;
        }
        AA.setNomeAtividade(idAtividade);

        dao.verificarAtividades(
                AA.getAtividade(),
                AA.getNomeAtividade(),
                AAA
        );
    }

    public void pegarDadoTabela(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividades,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView<AtividadesAtributos> tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        AtividadesAtributos AAA = new AtividadesAtributos();

        String atividades = tabelaAtividadesTV.getSelectionModel().getSelectedItem().getAtividade();
        String nomeCiclo = tabelaAtividadesTV.getSelectionModel().getSelectedItem().getNomeAtividade();

        AtividadesDAO dao = new AtividadesDAO();
        dao.buscarDadosAtividade(atividades, nomeCiclo, AAA);

        atividadesCB.setValue(AAA.getAtividade());
        dataInicioDP.getEditor().setText(AAA.getDataInicio());
        dataTerminoDP.getEditor().setText(AAA.getDatatermino());
        cicloCB.setValue(AAA.getCiclo());
        observacaoTA.setText(AAA.getObservacao());
        nomeAtividades.setText(AAA.getNomeAtividade());
    }

    public void salvarAtividades(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividadesTF,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        AA.setAtividade(atividadesCB.getSelectionModel().getSelectedItem().toString());

        if (dataInicioDP.getEditor().getText().equals("")) {
            AA.setDataInicio(null);
        } else {
            AA.setDataInicio(util.converterDataBrasilAmericano(dataInicioDP.getEditor().getText()));
        }

        if (dataTerminoDP.getEditor().getText().equals("")) {
            AA.setDatatermino(null);
        } else {
            AA.setDatatermino(util.converterDataBrasilAmericano(dataTerminoDP.getEditor().getText()));
        }

        AA.setCiclo(cicloCB.getSelectionModel().getSelectedItem().toString());
        AA.setObservacao(observacaoTA.getText());

        String idAtividade = null;
        switch (atividadesCB.getSelectionModel().getSelectedItem().toString()) {
            case "Tratamento Focal":
                idAtividade = "T.Focal "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "Reconhecimento Geográfico":
                idAtividade = "RG "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "LIRAa":
                idAtividade = "LIRAa "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "UBV-Pesado":
                idAtividade = "UBV-Pesado "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "UBV-Costal":
                idAtividade = "UBV-Costal "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "Ponto Estratégico - Pesquisa":
                idAtividade = "PE - Pesquisa "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "Pontoestratégico - Tratamento":
                idAtividade = "PE - Trat. Focal "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "LI":
                idAtividade = "LI "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
            case "TPVE":
                idAtividade = "TPVE "
                        + AA.getCiclo() + "-"
                        + dataTerminoDP.getEditor().getText(6, 10);
                break;
        }

        AA.setNomeAtividade(idAtividade);

        if (atividadesCB.getValue().equals("Selecione")
                || dataInicioDP.equals("")
                || dataTerminoDP.equals("")
                || cicloCB.getValue().equals("Selecione")) {
            
            util.alertSimples("CADASTRO DE ATIVIDADES", "ATENÇÃO!"
                    + "\nConfira o formulário!"
                    + "\nTodos os campos devem ser preenchidos!");

//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE ATIVIDADES");
//            alert.setHeaderText(null);
//            alert.setContentText("CONFIRA O FORMULÁRIO!!!\n A ATIVIDADE " + AA.getNomeAtividade() + ", NÃO FOI SALVA!!");
//            alert.showAndWait();

            Platform.runLater(atividadesCB::requestFocus);

        } else {
            //Confere se está tudo ok com o banco de dados
            AtividadesDAO atividadesDAO = new AtividadesDAO();
            AtividadesAtributos atividadesAtributo = new AtividadesAtributos(
                    AA.getAtividade(),
                    AA.getDataInicio(),
                    AA.getDatatermino(),
                    AA.getCiclo(),
                    AA.getObservacao(),
                    AA.getAtividadesContadas(),
                    AA.getNomeAtividade()
            );

            if (atividadesDAO.salvar(atividadesAtributo)) {
                //exibe mensagem de cadastrado com sucesso.
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE ATIVIDADES");
                alert.setHeaderText(null);
                alert.setContentText("ATIVIDADE " + AA.getNomeAtividade() + ", FOI CADASTRADA COM SUCESSO!!");
                alert.showAndWait();

                limparFormulario(
                        novoCadastroBT,
                        voltarMenuBT,
                        salvarBT,
                        excluirBT,
                        atividadesCB,
                        dataInicioDP,
                        dataTerminoDP,
                        cicloCB,
                        observacaoTA,
                        nomeAtividadesTF,
                        buscarAtividadesCB,
                        nomeAtividadeTC,
                        cicloAtividadeTC,
                        tabelaAtividadesTV,
                        listarTodosBT,
                        imprimirBT
                );

                bloquearCamposFormulario(
                        novoCadastroBT,
                        voltarMenuBT,
                        salvarBT,
                        excluirBT,
                        atividadesCB,
                        dataInicioDP,
                        dataTerminoDP,
                        cicloCB,
                        observacaoTA,
                        nomeAtividadesTF,
                        buscarAtividadesCB,
                        nomeAtividadeTC,
                        cicloAtividadeTC,
                        tabelaAtividadesTV,
                        listarTodosBT,
                        imprimirBT
                );

            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE ATIVIDADES");
                alert.setHeaderText(null);
                alert.setContentText("ATIVIDADE " + AA.getAtividade() + ", NÃO FOI CADASTRADA!!");
                alert.showAndWait();
            }
        }
    }

    public void excluirAtividades(
            Button novoCadastroBT,
            Button voltarMenuBT,
            Button salvarBT,
            Button excluirBT,
            ComboBox atividadesCB,
            DatePicker dataInicioDP,
            DatePicker dataTerminoDP,
            ComboBox cicloCB,
            TextArea observacaoTA,
            TextField nomeAtividadesTF,
            ComboBox buscarAtividadesCB,
            TableColumn nomeAtividadeTC,
            TableColumn cicloAtividadeTC,
            TableView tabelaAtividadesTV,
            Button listarTodosBT,
            Button imprimirBT
    ) {
        //Confere se está tudo ok com o banco de dados.
        AtividadesDAO atividadesDAO = new AtividadesDAO();
        AA.setAtividade(atividadesCB.getSelectionModel().getSelectedItem().toString());
        AA.setNomeAtividade(nomeAtividadesTF.getText());

        if (atividadesDAO.excluir(
                AA.getAtividade(),
                AA.getNomeAtividade(),
                AA
        )) {
            limparFormulario(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    excluirBT,
                    atividadesCB,
                    dataInicioDP,
                    dataTerminoDP,
                    cicloCB,
                    observacaoTA,
                    nomeAtividadesTF,
                    buscarAtividadesCB,
                    nomeAtividadeTC,
                    cicloAtividadeTC,
                    tabelaAtividadesTV,
                    listarTodosBT,
                    imprimirBT
            );

            bloquearCamposFormulario(
                    novoCadastroBT,
                    voltarMenuBT,
                    salvarBT,
                    excluirBT,
                    atividadesCB,
                    dataInicioDP,
                    dataTerminoDP,
                    cicloCB,
                    observacaoTA,
                    nomeAtividadesTF,
                    buscarAtividadesCB,
                    nomeAtividadeTC,
                    cicloAtividadeTC,
                    tabelaAtividadesTV,
                    listarTodosBT,
                    imprimirBT
            );
            tabelaAtividadesTV.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE ATIVIDADES");
            alert.setHeaderText(null);
            alert.setContentText("ATIVIDADE " + AA.getNomeAtividade() + ", FOI EXCLUÍDA COM SUCESSO!!");
            alert.showAndWait();

            buscarAtividadesCB.setValue("Selecione uma Atividade");

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CONTROLE DE ZOONOSES - CADASTRO DE ATIVIDADES");
            alert.setHeaderText(null);
            alert.setContentText("ATIVIDADE " + AA.getNomeAtividade() + ", NÃO FOI EXCLUÍDA!!");
            alert.showAndWait();
        }
    }

//     /FIM DO MÉTODO.
    public void preencherComboBoxAtividades(ComboBox<AtividadesMetodos> atividades) {

        List<AtividadesMetodos> atividadesCB = new ArrayList<>();

        ObservableList<AtividadesMetodos> observableListAtividades;

        AtividadesMetodos linha1 = new AtividadesMetodos(1, "Tratamento Focal");
        AtividadesMetodos linha2 = new AtividadesMetodos(2, "Reconhecimento Geográfico");
        AtividadesMetodos linha3 = new AtividadesMetodos(3, "LIRAa");
        AtividadesMetodos linha4 = new AtividadesMetodos(4, "UBV-Pesado");
        AtividadesMetodos linha5 = new AtividadesMetodos(5, "UBV-Costal");
        AtividadesMetodos linha6 = new AtividadesMetodos(6, "Ponto Estratégico - Pesquisa");
        AtividadesMetodos linha7 = new AtividadesMetodos(7, "Pontoestratégico - Tratamento");
        AtividadesMetodos linha8 = new AtividadesMetodos(8, "LI");
        AtividadesMetodos linha9 = new AtividadesMetodos(9, "TPVE");
        AtividadesMetodos linha10 = new AtividadesMetodos(01, "Selecione uma Atividade");

        atividadesCB.add(linha1);
        atividadesCB.add(linha2);
        atividadesCB.add(linha3);
        atividadesCB.add(linha4);
        atividadesCB.add(linha5);
        atividadesCB.add(linha6);
        atividadesCB.add(linha7);
        atividadesCB.add(linha8);
        atividadesCB.add(linha9);
        atividadesCB.add(linha10);

        observableListAtividades = FXCollections.observableArrayList(atividadesCB);

        atividades.setItems(observableListAtividades);
    }

    public void preencherComboBoxCiclo(ComboBox<AtividadesMetodos> ciclo) {

        List<AtividadesMetodos> cicloCB = new ArrayList<>();

        ObservableList<AtividadesMetodos> observableListMicro;

        AtividadesMetodos linha1 = new AtividadesMetodos(1, "01");
        AtividadesMetodos linha2 = new AtividadesMetodos(2, "02");
        AtividadesMetodos linha3 = new AtividadesMetodos(3, "03");
        AtividadesMetodos linha4 = new AtividadesMetodos(4, "04");
        AtividadesMetodos linha5 = new AtividadesMetodos(5, "05");
        AtividadesMetodos linha6 = new AtividadesMetodos(6, "06");
        AtividadesMetodos linha7 = new AtividadesMetodos(7, "07");
        AtividadesMetodos linha8 = new AtividadesMetodos(8, "08");
        AtividadesMetodos linha9 = new AtividadesMetodos(9, "09");
        AtividadesMetodos linha10 = new AtividadesMetodos(10, "10");
        AtividadesMetodos linha11 = new AtividadesMetodos(10, "11");
        AtividadesMetodos linha12 = new AtividadesMetodos(10, "12");
        AtividadesMetodos linha13 = new AtividadesMetodos(10, "13");
        AtividadesMetodos linha14 = new AtividadesMetodos(10, "14");
        AtividadesMetodos linha15 = new AtividadesMetodos(10, "15");
        AtividadesMetodos linha16 = new AtividadesMetodos(10, "16");
        AtividadesMetodos linha17 = new AtividadesMetodos(10, "17");
        AtividadesMetodos linha18 = new AtividadesMetodos(10, "18");
        AtividadesMetodos linha19 = new AtividadesMetodos(10, "19");
        AtividadesMetodos linha20 = new AtividadesMetodos(10, "20");
        AtividadesMetodos linha21 = new AtividadesMetodos(10, "21");
        AtividadesMetodos linha22 = new AtividadesMetodos(10, "22");
        AtividadesMetodos linha23 = new AtividadesMetodos(10, "23");
        AtividadesMetodos linha24 = new AtividadesMetodos(10, "24");
        AtividadesMetodos linha25 = new AtividadesMetodos(10, "25");

        cicloCB.add(linha1);
        cicloCB.add(linha2);
        cicloCB.add(linha3);
        cicloCB.add(linha4);
        cicloCB.add(linha5);
        cicloCB.add(linha6);
        cicloCB.add(linha7);
        cicloCB.add(linha8);
        cicloCB.add(linha9);
        cicloCB.add(linha10);
        cicloCB.add(linha11);
        cicloCB.add(linha12);
        cicloCB.add(linha13);
        cicloCB.add(linha14);
        cicloCB.add(linha15);
        cicloCB.add(linha16);
        cicloCB.add(linha17);
        cicloCB.add(linha18);
        cicloCB.add(linha19);
        cicloCB.add(linha20);
        cicloCB.add(linha21);
        cicloCB.add(linha22);
        cicloCB.add(linha23);
        cicloCB.add(linha24);
        cicloCB.add(linha25);

        observableListMicro = FXCollections.observableArrayList(cicloCB);

        ciclo.setItems(observableListMicro);
    }

    private void relatorios(
            String relatorio,
            String atividades
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("atividades", atividades);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO AO GERAR RELATORIO\n" + ex);
            Logger.getLogger(AtividadesMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void gerarRelatorio(
            //            ComboBox atividadesCB, ComboBox cicloCB
            TableView<AtividadesAtributos> tabelaAtividadesTV
    ) {
        String atividades = tabelaAtividadesTV.getSelectionModel().getSelectedItem().getAtividade();

//        String atividades = atividadesCB.getSelectionModel().getSelectedItem().toString();
//        String ciclo = cicloCB.getSelectionModel().getSelectedItem().toString();
        String relatorio = "../src/relatorios/Atividades.jasper";
        relatorios(relatorio, atividades);
    }

}
