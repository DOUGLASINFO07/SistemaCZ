package localidades;

import java.sql.Connection;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import jeanderson.br.util.MaskFormatter;
import menu.MenuMetodos;
import util.Categoria;
import util.Utilitario;

/**
 *
 * @author dougl
 */
public class LocalidadeMetodo{

    Connection conn;

    Utilitario util = new Utilitario();

    MenuMetodos menuMetodos = new MenuMetodos();

    LocalidadeAtributos LA = new LocalidadeAtributos();

    public LocalidadeMetodo() {
    }

    public LocalidadeMetodo(int posicao, String categoria) {
        LA.setCategoria(categoria);
    }

    @Override
    public String toString() {
        return LA.getCategoria();
    }

    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

//    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
//    private static Stage stage;
//
//    public Stage getStage() {
//        return stage;
//    }
//
//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }
//
//////    public static void main(String[] args) {
//////        launch(args);
//////    }
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/localidades/Localidade.fxml"));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/iconeSistemaCZ.png")));
//        Scene scene = new Scene(root);
//        stage.setTitle("Cadastro de Localidades");
//        stage.setFullScreen(true);
//        stage.setScene(scene);
//        stage.show();
//        setStage(stage);
//    }
//    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.
//
//    //MÉTODO FECHAR USUARIO.
//    public void fecharLocalidade() {
//        getStage().close();
//    }//FIM DO MÉTODO FECHAR USUARIO.
//
//    //MÉTODO QUE ABRE A TELA MENU.
//    public void abrirMenu() {
//        try {
////            menuMetodos.start(new Stage());
//            fecharLocalidade();
//        } catch (Exception ex) {
//            Logger.getLogger(LocalidadeMetodo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.

    public void limparFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
        codigoTF.setText("");
        nomeTF.setText("");
        siglaTF.setText("");
        categoriaCB.setValue("Selecione");
        zonaUrbanaRB.setSelected(true);
        zonaRuralRB.setSelected(false);
        tipoSedeRB.setSelected(true);
        tipoOutrosRB.setSelected(false);
        observacaoTA.setText("");
    }

    public void liberarCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
        codigoTF.setDisable(false);
        nomeTF.setDisable(false);
        siglaTF.setDisable(false);
        categoriaCB.setDisable(false);
        zonaUrbanaRB.setDisable(false);
        zonaRuralRB.setDisable(false);
        tipoSedeRB.setDisable(false);
        tipoOutrosRB.setDisable(false);
        observacaoTA.setDisable(false);
    }

    public void bloquearCamposFormulario(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
        codigoTF.setDisable(true);
        nomeTF.setDisable(true);
        siglaTF.setDisable(true);
        categoriaCB.setDisable(true);
        zonaUrbanaRB.setDisable(true);
        zonaRuralRB.setDisable(true);
        tipoSedeRB.setDisable(true);
        tipoOutrosRB.setDisable(true);
        observacaoTA.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn codigoRG,
            TableView tabelaLocalidade,
            TextField buscarLocalidade
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        codigoRG.setCellValueFactory(new PropertyValueFactory("codigo"));
        tabelaLocalidade.setItems(atualizaTabela(buscarLocalidade.getText()));
    }

    public ObservableList<LocalidadeAtributos> atualizaTabela(String buscarLocalidade) {
        LocalidadeDAO dao = new LocalidadeDAO();
        return FXCollections.observableArrayList(dao.listaLocalidade(buscarLocalidade));
    }

    public void pegarDadoTabela(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
//        LocalidadeAtributos LA = new LocalidadeAtributos();
        String nome = tabelaLocalidadeTV.getSelectionModel().getSelectedItem().toString();
        LocalidadeDAO dao = new LocalidadeDAO();
        dao.buscarDadosLocalidade(nome, LA);
        codigoTF.setText(String.valueOf(LA.getCodigo()));
        nomeTF.setText(LA.getNome());
        siglaTF.setText(LA.getSigla());
        categoriaCB.setValue(LA.getCategoria());
        if (LA.getZona().equals("Urbana")) {
            zonaUrbanaRB.setSelected(true);
            zonaRuralRB.setSelected(false);
        } else {
            zonaUrbanaRB.setSelected(false);
            zonaRuralRB.setSelected(true);
        }
        if (LA.getTipo().equals("Sede")) {
            tipoSedeRB.setSelected(true);
            tipoOutrosRB.setSelected(false);
        } else {
            tipoSedeRB.setSelected(false);
            tipoOutrosRB.setSelected(true);
        }
        observacaoTA.setText(LA.getObservacao());
    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void salvarLocalidade(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {

        LA.setCodigo(codigoTF.getText());
        LA.setNome(nomeTF.getText());
        LA.setSigla(siglaTF.getText());
        LA.setCategoria(categoriaCB.getSelectionModel().getSelectedItem().toString());

        if (zonaUrbanaRB.isSelected()) {
            LA.setZona("Urbana");
        } else {
            LA.setZona("Rural");
        }

        if (tipoSedeRB.isSelected()) {
            LA.setTipo("Sede");
        } else {
            LA.setTipo("Outros");
        }

        LA.setObservacao(observacaoTA.getText());

        if (nomeTF.getText().equals("")
                || codigoTF.getText().equals("")
                || siglaTF.getText().equals("")
                || categoriaCB.getValue().equals("Selecione")
                || !zonaUrbanaRB.isSelected()
                && !zonaRuralRB.isSelected()
                || !tipoSedeRB.isSelected()
                && !tipoOutrosRB.isSelected()
                || observacaoTA.equals("")) {

            util.alertSimples("CADASTRO DE LOCALIDADES", "ATENÇÃO!!\n Confira o formulário!\nTodos os campos devem ser preenchidos!");

//            util.alertConfiraFormulario();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    codigoTF.requestFocus();
                }
            });
        } else {

            //Confere se está tudo ok com o banco de dados
            LocalidadeDAO localidadeDAO = new LocalidadeDAO();
            LocalidadeAtributos localidadeAtributo = new LocalidadeAtributos(
                    LA.getCodigo(),
                    LA.getNome(),
                    LA.getSigla(),
                    LA.getCategoria(),
                    LA.getZona(),
                    LA.getTipo(),
                    LA.getObservacao()
            );

            if (localidadeDAO.salvar(localidadeAtributo)) {
                limparFormulario(
                        novoCadastro,
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
                bloquearCamposFormulario(
                        novoCadastro,
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
                //exibe mensagem de cadastrado com sucesso.

//                 public void alertCadastrado(String objetoDoCadastro) {
//        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
//        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
//        mensagem.setContentText("ATENÇÃO!!\n"
//                + objetoDoCadastro + " cadastrado com sucesso!!");
//        mensagem.show();
//    }
                util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade cadastrada com sucesso!!");

//                util.alertCadastrado("Localidade " + nomeTF.getText());//Fim do if.

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Platform.runLater(novoCadastro::requestFocus);
                    }
                });
                salvarBT.setDisable(true);
            } else {
                util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade não foi cadastrada com sucesso!!");
//                util.alertNaoCadastrado("Localidade " + nomeTF.getText());
            }
        }
    }

    public void atualizarLocalidade(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
        LA.setCodigo(codigoTF.getText());
        LA.setNome(nomeTF.getText());
        LA.setSigla(siglaTF.getText());
        LA.setCategoria(categoriaCB.getSelectionModel().getSelectedItem().toString());

        if (zonaUrbanaRB.isSelected()) {
            LA.setZona("Urbana");
        } else {
            LA.setZona("Rural");
        }

        if (tipoSedeRB.isSelected()) {
            LA.setTipo("Sede");
        } else {
            LA.setTipo("Outros");
        }

        LA.setObservacao(observacaoTA.getText());

        if (nomeTF.getText().equals("")
                || codigoTF.getText().equals("")
                || siglaTF.getText().equals("")
                || categoriaCB.getValue().equals("Selecione")
                || !zonaUrbanaRB.isSelected()
                && !zonaRuralRB.isSelected()
                || !tipoSedeRB.isSelected()
                && !tipoOutrosRB.isSelected()
                || observacaoTA.equals("")) {

            util.alertSimples("CADASTRO DE LOCALIDADES", "ATENÇÃO!!\n Confira o formulário!\nTodos os campos devem ser preenchidos!");

//            util.alertConfiraFormulario();
        } else {

            //Confere se está tudo ok com o banco de dados
            LocalidadeDAO localidadeDAO = new LocalidadeDAO();
            LocalidadeAtributos localidadeAtributo = new LocalidadeAtributos(
                    LA.getCodigo(),
                    LA.getNome(),
                    LA.getSigla(),
                    LA.getCategoria(),
                    LA.getZona(),
                    LA.getTipo(),
                    LA.getObservacao()
            );
            if (localidadeDAO.atualizar(localidadeAtributo)) {
                limparFormulario(
                        novoCadastro,
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

                bloquearCamposFormulario(
                        novoCadastro,
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

                tabelaLocalidadeTV.getItems().clear();
                
                 util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade atualizada com sucesso!!");

//                util.alertAtualizacao("Localidade " + nomeTF.getText());//Fim do if.

            } else {
                
                util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade não foi atualizada!!");
//                util.alertNaoAtualizado("Localidade " + nomeTF.getText());
            }
        }
    }

    public void excluirLocalidade(
            Button novoCadastro,
            Button voltarMenuBT,
            Button salvarBT,
            Button atualizarBT,
            Button excluirBT,
            TextField codigoTF,
            TextField nomeTF,
            TextField siglaTF,
            ComboBox categoriaCB,
            CheckBox zonaUrbanaRB,
            CheckBox zonaRuralRB,
            CheckBox tipoSedeRB,
            CheckBox tipoOutrosRB,
            TextArea observacaoTA,
            TableView tabelaLocalidadeTV,
            TextField buscarLocalidadeTF,
            Button listarTodosBT
    ) {
        //Confere se está tudo ok com o banco de dados.
        LocalidadeDAO localidadeDAO = new LocalidadeDAO();
        LA.setCodigo(codigoTF.getText());

        if (localidadeDAO.excluir(String.valueOf(LA.getCodigo()), LA)) {

//            File img = new File("../src/" + LA.getFotoLocalidade());
//            img.delete();
            limparFormulario(
                    novoCadastro,
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

            bloquearCamposFormulario(
                    novoCadastro,
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
            tabelaLocalidadeTV.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade excluída com sucesso!!");
//            util.alertExcluido("Localidade " + nomeTF.getText());//Fim do if.
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastro::requestFocus);//fim do run.
        } else {
            util.alertSimples("CADASTRO DE LOCALIDADES", "Localidade não foi excluída!!");
//            util.alertNaoExcluído("Localidade " + nomeTF.getText());
        }
    }

    public void preencherComboBoxCategoria(ComboBox<Categoria> categoria) {

        ObservableList<Categoria> observableListCategoria;

        //cria lista de dados para ser exibido no comboBox.
        List<Categoria> listCategoria = new ArrayList<>();
        listCategoria.add(new Categoria("Bairro"));
        listCategoria.add(new Categoria("Condominio"));
        listCategoria.add(new Categoria("Povoado"));
        listCategoria.add(new Categoria("Vila"));
        listCategoria.add(new Categoria("Outros"));

        // Pega os dados da lista e cria uma lista no formato para o combobox
        observableListCategoria = FXCollections.observableArrayList(listCategoria);

        //Insere os dados no comboBox
        categoria.setItems(observableListCategoria);
        Callback<ListView<Categoria>, ListCell<Categoria>> factory = lv -> new ListCell<Categoria>() {
            @Override
            protected void updateItem(Categoria item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getBairro());
            }
        };
        categoria.setCellFactory(factory);
        categoria.setButtonCell(factory.call(null));

    }

    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorios/Localidade.jasper";
        util.relatorio(relatorio);
    }

}
