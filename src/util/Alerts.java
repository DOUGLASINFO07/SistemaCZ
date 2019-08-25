package util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

/**
 * @author douglas borges egidio
 * @DIMTech
 * @since 22/08/2019
 */
public class Alerts {

    //alert simples sem cabecalho.
    public void alertSimples(
            String titulo,
            String contexto,
            String css,
            String dialogPaneCSS
    ) {

        javafx.scene.control.Alert alert1 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert1.setTitle(titulo);
        alert1.setContentText(contexto);
        alert1.setHeaderText(null);

        DialogPane dialogPane = alert1.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        alert1.showAndWait();

    }

    //Alert com cabecalho.
    public void alertCabecalho(
            String titulo,
            String contexto,
            String css,
            String cabecalho,
            String dialogPaneCSS
    ) {
        javafx.scene.control.Alert alert2 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert2.setTitle(titulo);
        alert2.setContentText(contexto);
        alert2.setHeaderText(cabecalho);

        DialogPane dialogPane = alert2.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        alert2.showAndWait();

    }

    //alert com caixa de texto, com informações.
    public void alertException(
            String titulo,
            String contexto,
            String css,
            String cabecalho,
            String dialogPaneCSS,
            String exception
    ) {

        javafx.scene.control.Alert alert3 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert3.setTitle(titulo);
        alert3.setContentText(contexto);
        alert3.setHeaderText(cabecalho);

        DialogPane dialogPane = alert3.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        Exception ex = new FileNotFoundException("Acesso Ilegal");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);

        TextArea area = new TextArea(stringWriter.toString());
        alert3.getDialogPane().setExpandableContent(area);
        alert3.showAndWait();

    }

    //alert com opção de executar um metodo, dependendo de qual botão for pressionado.
    public void alertBotaoOpcao(
            String titulo,
            String contexto,
            String css,
            String cabecalho,
            String dialogPaneCSS
    ) {

        javafx.scene.control.Alert alert4 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert4.setTitle(titulo);
        alert4.setContentText(contexto);
        alert4.setHeaderText(cabecalho);

        DialogPane dialogPane = alert4.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        Optional<ButtonType> resultado = alert4.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            System.out.println("Botao Ok precionado!");
        } else {
            System.out.println("Botao Cancel precionado!");
        }

    }

    //alert com varias opções de botões que executa um metodo, dependendo de qual botão for pressionado.
    public void alertTresBotoes(
            String titulo,
            String contexto,
            String css,
            String cabecalho,
            String dialogPaneCSS
    ) {

        javafx.scene.control.Alert alert5 = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert5.setTitle(titulo);
        alert5.setContentText(contexto);
        alert5.setHeaderText(cabecalho);

        DialogPane dialogPane = alert5.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        ButtonType buttonType01 = new ButtonType("Um");
        ButtonType buttonType02 = new ButtonType("Dois");
        ButtonType buttonType03 = new ButtonType("Três");
        ButtonType buttonType04 = new ButtonType("Cancela", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert5.getButtonTypes()
                .setAll(
                        buttonType01,
                        buttonType02,
                        buttonType03,
                        buttonType04
                );

        Optional<ButtonType> resultado = alert5.showAndWait();
       
        switch (resultado.get().getText()) {
            case "Um":
                System.out.println("Botao pressionado Um!");
                break;
            case "Dois":
                System.out.println("Botao pressionado Dois!");
                break;
            case "Três":
                System.out.println("Botão pressionado Três!");
                break;
            default:
                System.out.println("Botão pressionado Cancela!");
        }
    }

    //alert com opcao de entrada de informação.
    public void alertOpcaoEntrada(
            String titulo,
            String contexto,
            String css,
            String cabecalho,
            String dialogPaneCSS
    ) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setContentText(contexto);
        dialog.setHeaderText(cabecalho);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource(css).toExternalForm());
        dialogPane.getStyleClass().add(dialogPaneCSS);

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            System.out.println("Nome: " + resultado.get());
        }

    }

}
