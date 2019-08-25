package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author douglas borges egidio
 * @author DIMTech
 * @since 21/08/2019.
 *
 */
public class Notificacao extends Thread {

    private final String titulo;
    private final String texto;
    private final String pathImagem;

    public Notificacao(
            String titulo,
            String texto,
            String pathImagem
    ) {
        this.titulo = titulo;
        this.texto = texto;
        this.pathImagem = pathImagem;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(500);//tempo para exibir a notificação
        } catch (InterruptedException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = new Image(pathImagem);

        Notifications notifications = Notifications.create()
                .title(titulo)
                .text(texto)
                .graphic(new ImageView(img))//node
                .hideAfter(Duration.seconds(5))//tempo de exibicão da notificacao.
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {

                    @Override//método para ação ao clicar na notificação.
                    public void handle(ActionEvent event) {
//                        System.out.println("Houve um clic na notificação!");
                    }

                });

        notifications.darkStyle();
//        notifications.hideCloseButton();//oculta o x da janela.
        Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    notifications.show();//O método deverá ser show, quiser usar uma imagem propria.
//        notifications.showConfirm();
//        notifications.showError();
                }
            });

    }

}
