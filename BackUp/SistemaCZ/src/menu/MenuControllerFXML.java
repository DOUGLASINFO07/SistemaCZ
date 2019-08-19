package menu;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import util.Relogio;

public class MenuControllerFXML implements Initializable {

    @FXML
    private Button cadastroFuncionarioBT;

    @FXML
    private Button cadastroLocalidadeBT;

    @FXML
    private Button cadastroQuarteiraoBT;

    @FXML
    private Button lancamentoTratamentoFocalBT;

    @FXML
    private Button relatorioFuncionarioBT;
    
    @FXML
    private Button relatorioLocalidadeBT;
    
    @FXML
    private Button relatorioQuarteiraoBT;
    
    @FXML
    private Button relatorioAtividadesBT;

    @FXML
    private Button sairBT;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Button cadastroMenuBT;

    @FXML
    private VBox VBoxCadastro;

    @FXML
    private VBox VBoxLancamento;

    @FXML
    private VBox VBoxRelatorio;

    @FXML
    private Button cadastroAtividadesBT;

    static Stage stage;
    @FXML
    private Button lancamentoMenuBT;
    @FXML
    private Button denunciaBT;

    public Stage getStage() {
        return stage;
    }//Fim do método

    public void setStage(Stage stage) {
        MenuControllerFXML.stage = stage;
    }//Fim do método setStage().

    public void fecharFuncionario() {
        getStage().close();
    }//FIM DO MÉTODO.

    @FXML
    void cadastroFuncionarioBTMouse(MouseEvent event) throws IOException, Exception {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirFuncionario();
    }

    @FXML
    void cadastroFuncionarioBTTeclado(KeyEvent event) throws Exception {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirFuncionario();
        }
    }

    @FXML
    void cadastroLocalidadeBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getClickCount() == 1) {
            menu.abrirLocalidade();
        }
    }

    @FXML
    void cadastroLocalidadeBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirLocalidade();
        }
    }

    @FXML
    void cadastroQuarteiraoBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirQuarteirao();
    }

    @FXML
    void cadastroQuarteiraoBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirQuarteirao();
        }
    }

    @FXML
    void cadastroAtividadesBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirAtividades();
    }

    @FXML
    void cadastroAtividadesBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirAtividades();
        }
    }

    @FXML
    void lancamentoTratamentoFocalBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirLancamentoTratamentoFocal();
        }
    }

    @FXML
    void lancamentoTratamentoFocalBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirLancamentoTratamentoFocal();
    }

    @FXML
    void denunciaBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirDenuncia();
        }
    }

    @FXML
    void denunciaBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirDenuncia();
    }

    @FXML
    void relatorioFuncionarioBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirRelatorioFuncionario();
        }
    }

    @FXML
    void relatorioFuncionarioBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirRelatorioFuncionario();
    }
    
    @FXML
    void relatorioLocalidadeBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirRelatorioLocalidade();
        }
    }

    @FXML
    void relatorioLocalidadeBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirRelatorioLocalidade();
    }
    
    @FXML
    void relatorioQuarteiraoBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirRelatorioQuarteirao();
        }
    }

    @FXML
    void relatorioQuarteiraoBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirRelatorioQuarteirao();
    }
    
    @FXML
    void relatorioAtividadesBTTeclado(KeyEvent event) {
        MenuMetodos menu = new MenuMetodos();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirRelatorioAtividades();
        }
    }

    @FXML
    void relatorioAtividadesBTMouse(MouseEvent event) {
        MenuMetodos menu = new MenuMetodos();
        menu.abrirRelatorioAtividades();
    }

    @FXML
    void sairBTMouse(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("MENU CONTROLE DE ZOONOSES");
        alert.setHeaderText("ATENÇÃO!!");
        alert.setContentText("TEM CERTEZA QUE DESEJA SAIR DO SISTEMA?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");
        ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            sairBT.getScene().getWindow().hide();
        } else if (result.get() == buttonTypeTwo) {

        } else {

        }
    }

    @FXML
    void sairBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("MENU CONTROLE DE ZOONOSES");
            alert.setHeaderText("ATENÇÃO!!");
            alert.setContentText("TEM CERTEZA QUE DESEJA SAIR DO SISTEMA?");

            ButtonType buttonTypeOne = new ButtonType("Sim");
            ButtonType buttonTypeTwo = new ButtonType("Não");
            ButtonType buttonTypeCancel = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                sairBT.getScene().getWindow().hide();
            } else if (result.get() == buttonTypeTwo) {

            } else {
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Relogio relogio1 = new Relogio(horasLB);
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date1 = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf1.format(date1) + " - Seja Bem Vindo!");
        try {
            relogio1.relogio();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        System.gc();
    }

    @FXML
    void cadastroMenuBTMouse(MouseEvent event) {
        VBoxCadastro.setVisible(true);
        VBoxLancamento.setVisible(false);
        VBoxRelatorio.setVisible(false);
    }

    @FXML
    void cadastroMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            VBoxCadastro.setVisible(true);
            VBoxLancamento.setVisible(false);
            VBoxRelatorio.setVisible(false);
        }
    }

    @FXML
    void lancamentoMenuBTMouse(MouseEvent event) {
        VBoxLancamento.setVisible(true);
        VBoxCadastro.setVisible(false);
        VBoxRelatorio.setVisible(false);
    }

    @FXML
    void lancamentoMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            VBoxLancamento.setVisible(true);
            VBoxCadastro.setVisible(false);
            VBoxRelatorio.setVisible(false);
        }
    }

    @FXML
    void relatorioMenuBTMouse(MouseEvent event) {
        VBoxLancamento.setVisible(false);
        VBoxCadastro.setVisible(false);
        VBoxRelatorio.setVisible(true);
    }

    @FXML
    void relatorioMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            VBoxLancamento.setVisible(false);
            VBoxCadastro.setVisible(false);
            VBoxRelatorio.setVisible(true);
        }
    }

}
