package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Relogio extends Application {

    // criando o Label que vai informar as horas
    private Label lblRelogio;

    public Relogio(Label lblRelogio) {
        this.lblRelogio = lblRelogio;
    }

    // SimpleDateFormat é a classe do Java que transforma datas para Strings 
    // usando o formato passado
    private SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");

    // isso poderia ser emitido no Java 8
    public static void main(String[] args) {
        launch();
    }

    public void relogio() throws Exception {
        // criamos a fonte usando o método de fábrica.
        Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 16);
        lblRelogio.setFont(font);

        // vamos colocar um pequeno efeito no label pra deixar ele bonitin
        lblRelogio.setTextFill(Color.GRAY);

        // agora ligamos um loop infinito que roda a cada segundo e atualiza nosso label chamando atualizaHoras.
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void atualizaHoras() {
        Date agora = new Date();
            lblRelogio.setText( formatador.format(agora)  + " hrs.");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

}
