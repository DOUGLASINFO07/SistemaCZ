package menu;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import util.CarregarPagina;
import util.Relogio;

public class MenuControllerFXML implements Initializable {

    CarregarPagina cp = new CarregarPagina();

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private VBox VBoxCadastro;

    @FXML
    private VBox VBoxLancamento;

    @FXML
    private VBox VBoxRelatorio;

    @FXML
    private Button cadastroMenuBT;

    @FXML
    private Button lancamentoMenuBT;

    @FXML
    private Button relatorioBT;

    @FXML
    private FlowPane flowPaneSubMenu;

    @FXML
    private FlowPane flowPaneBackground;

    @FXML
    void cadastroFuncionarioBTMouse(MouseEvent event) throws IOException, Exception {
        cp.carregarPagina("/funcionarios/Funcionario.fxml");
    }

    @FXML
    void cadastroFuncionarioBTTeclado(KeyEvent event) throws Exception {
         if (event.getCode() == KeyCode.ENTER) {
        cp.carregarPagina("/funcionarios/Funcionario.fxml");
         }
    }

    @FXML
    void cadastroLocalidadeBTMouse(MouseEvent event) {
            cp.carregarPagina("/localidades/Localidade.fxml");
    }

    @FXML
    void cadastroLocalidadeBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/localidades/Localidade.fxml");
        }
    }

    @FXML
    void cadastroQuarteiraoBTMouse(MouseEvent event) {
        cp.carregarPagina("/quarteirao/Quarteirao.fxml");
    }

    @FXML
    void cadastroQuarteiraoBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/quarteirao/Quarteirao.fxml");
        }
    }

    @FXML
    void cadastroAtividadesBTMouse(MouseEvent event) {
        cp.carregarPagina("/atividades/Atividades.fxml");
    }

    @FXML
    void cadastroAtividadesBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/atividades/Atividades.fxml");
        }
    }

    @FXML
    void lancamentoTratamentoFocalBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/servicoTratamentoFocal/ServicoTratamentoFocal.fxml");
        }
    }

    @FXML
    void lancamentoTratamentoFocalBTMouse(MouseEvent event) {
        cp.carregarPagina("/servicoTratamentoFocal/ServicoTratamentoFocal.fxml");
    }

    @FXML
    void denunciaBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/denuncia/Denuncia.fxml");
        }
    }

    @FXML
    void denunciaBTMouse(MouseEvent event) {
        cp.carregarPagina("/denuncia/Denuncia.fxml");
    }

    @FXML
    void relatorioFuncionarioBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/relatorioFuncionario/RelatorioFuncionario.fxml");
        }
    }

    @FXML
    void relatorioFuncionarioBTMouse(MouseEvent event) {
        cp.carregarPagina("/relatorioFuncionario/RelatorioFuncionario.fxml");
    }

    @FXML
    void relatorioLocalidadeBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/relatorioLocalidade/RelatorioLocalidade.fxml");
        }
    }

    @FXML
    void relatorioLocalidadeBTMouse(MouseEvent event) {
        cp.carregarPagina("/relatorioLocalidade/RelatorioLocalidade.fxml");
    }

    @FXML
    void relatorioQuarteiraoBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/relatorioQuarteirao/RelatorioQuarteirao.fxml");
        }
    }

    @FXML
    void relatorioQuarteiraoBTMouse(MouseEvent event) {
        cp.carregarPagina("/relatorioQuarteirao/RelatorioQuarteirao.fxml");
    }

    @FXML
    void relatorioAtividadesBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            cp.carregarPagina("/relatorioAtividades/RelatorioAtividades.fxml");
        }
    }

    @FXML
    void relatorioAtividadesBTMouse(MouseEvent event) {
        cp.carregarPagina("/relatorioAtividades/RelatorioAtividades.fxml");
    }

    @FXML
    void sairBTMouse(MouseEvent event) {
        alertSair();
    }

    @FXML
    void sairBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            alertSair();
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

        cadastroMenuBT.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                VBoxCadastro.setVisible(true);
                VBoxLancamento.setVisible(false);
                VBoxRelatorio.setVisible(false);
            }
        });

        lancamentoMenuBT.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                VBoxCadastro.setVisible(false);
                VBoxLancamento.setVisible(true);
                VBoxRelatorio.setVisible(false);
            }
        });

        relatorioBT.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                VBoxCadastro.setVisible(false);
                VBoxLancamento.setVisible(false);
                VBoxRelatorio.setVisible(true);
            }
        });

        flowPaneSubMenu.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                VBoxCadastro.setVisible(false);
                VBoxLancamento.setVisible(false);
                VBoxRelatorio.setVisible(false);
            }
        });

        flowPaneBackground.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                VBoxCadastro.setVisible(false);
                VBoxLancamento.setVisible(false);
                VBoxRelatorio.setVisible(false);
            }
        });
        
        System.gc();

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
    void lancamentoMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            VBoxLancamento.setVisible(true);
            VBoxCadastro.setVisible(false);
            VBoxRelatorio.setVisible(false);
        }
    }

    @FXML
    void relatorioMenuBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            VBoxLancamento.setVisible(false);
            VBoxCadastro.setVisible(false);
            VBoxRelatorio.setVisible(true);
        }
    }

    private void alertSair() {
        Image img = new Image("imagens/iconeSistemaCZ100x100.png");

        javafx.scene.control.Alert alert4 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert4.setTitle("SISTEMACZ");
        alert4.setContentText("O que deseja fazer?");
        alert4.setGraphic(new ImageView(img));
        alert4.setHeaderText("SISTEMA DE GERENCIAMENTO E CONTROLE DE ZOONOSES");
        alert4.setResizable(true);
        alert4.getDialogPane().setPrefSize(480, 270);

        DialogPane dialogPane = alert4.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/css/Alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog-Pane");

        ButtonType buttonTypeSair = new ButtonType("Sair");
        ButtonType buttonTypeDeslogar = new ButtonType("Deslogar");
        ButtonType buttonTypeCancela = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert4.getButtonTypes()
                .setAll(
                        buttonTypeSair,
                        buttonTypeDeslogar,
                        buttonTypeCancela
                );

        Optional<ButtonType> resultado = alert4.showAndWait();
        if (resultado.get().getText() == "Sair") {
            System.exit(0);
        } else if (resultado.get().getText() == "Deslogar") {
            cp.carregarPagina("/login/Login.fxml");
        } else {
        }
    }

}
