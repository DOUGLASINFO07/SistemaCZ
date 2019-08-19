package util;

import funcionarios.FuncionarioDAO;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyEvent;
import jeanderson.br.util.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author douglas borges egidio
 * @since 04/10/2018.
 * 
 */

public class Utilitario {

    //CLASSE DE CONEXÃO.
    private Connection conn;

    //CONTRUTOR
    public Utilitario(Connection conn) {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //CONTRUTOR
    public Utilitario() {

    }//FIM DO CONSTRUTUOR.

    public String converterDataBrasilAmericano(String data) {

        int dia = Integer.parseInt((String) data.subSequence(0, 2));
        int mes = Integer.parseInt((String) data.subSequence(3, 5));
        int ano = Integer.parseInt((String) data.subSequence(6, 10));

        String diaTeste;
        String mesTeste;
        String dataConvertida;

        if (dia <= 9) {
            diaTeste = "0" + dia;
        } else {
            diaTeste = "" + dia;
        }
        if (mes <= 9) {
            mesTeste = "0" + mes;
        } else {
            mesTeste = "" + mes;
        }
        dataConvertida = ano + "-" + mesTeste + "-" + diaTeste;

        return dataConvertida;
    }

    public String converterDataAmericanoBrasil(String data) {

        int diaVencimento = Integer.parseInt((String) data.subSequence(8, 10));
        int mesVencimento = Integer.parseInt((String) data.subSequence(5, 7));
        int anoVencimento = Integer.parseInt((String) data.subSequence(0, 4));

        String diaVencimentoTeste;
        String mesVencimentoTeste;
        String dataConvertida;

        if (diaVencimento <= 9) {
            diaVencimentoTeste = "0" + diaVencimento;
        } else {
            diaVencimentoTeste = "" + diaVencimento;
        }
        if (mesVencimento <= 9) {
            mesVencimentoTeste = "0" + mesVencimento;
        } else {
            mesVencimentoTeste = "" + mesVencimento;
        }
        dataConvertida = diaVencimentoTeste + "/" + mesVencimentoTeste + "/" + anoVencimento;

        return dataConvertida;
    }

    public String converterCifraoBrasiloAmericano(String valor) {

        String valorConverterCifrao = valor.replace("R$ ", "");
        String valorConverterPonto = valorConverterCifrao.replace(".", "");
        String valorCOnverterVirgula = valorConverterPonto.replace(",", ".");
        if ("R$ ".equals(valorCOnverterVirgula)) {
            valorCOnverterVirgula = "R$ " + 0;
        }

        return valorCOnverterVirgula;
    }

    public String converterCifraoAmericanoBrasil(double valor) {

        Locale ptBr = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);
        String valorRecebido = nf.format(valor);

        return valorRecebido;
    }

    public String gerarParcelasBoleto(String data, int parcelas, int contador) {

//        contador = 1;
        int diaVencimento = Integer.parseInt((String) data.subSequence(0, 2));
        int mesVencimento = Integer.parseInt((String) data.subSequence(3, 5));
        int anoVencimento = Integer.parseInt((String) data.subSequence(6, 10));
        String dataConvertida = null;
        String diaVencimentoTeste;
        String mesVencimentoTeste;

        while (contador <= parcelas) {

            //Instrução que automatiza o vencimento dos boletos
            //a cada parcela a instrução acrescenta um passivo(boleto) com um novo vencimento.
            if (mesVencimento > 12) {
                mesVencimento = 1;
                anoVencimento++;

                if (diaVencimento <= 9) {
                    diaVencimentoTeste = "0" + diaVencimento;
                } else {
                    diaVencimentoTeste = "" + diaVencimento;
                }
                if (mesVencimento <= 9) {
                    mesVencimentoTeste = "0" + mesVencimento;
                } else {
                    mesVencimentoTeste = "" + mesVencimento;
                }
                dataConvertida = anoVencimento + "/" + mesVencimentoTeste + "/" + diaVencimentoTeste;
            } else {
                if (diaVencimento <= 9) {
                    diaVencimentoTeste = "0" + diaVencimento;
                } else {
                    diaVencimentoTeste = "" + diaVencimento;
                }
                if (mesVencimento <= 9) {
                    mesVencimentoTeste = "0" + mesVencimento;
                } else {
                    mesVencimentoTeste = "" + mesVencimento;
                }
                dataConvertida = anoVencimento + "/" + mesVencimentoTeste + "/" + diaVencimentoTeste;
            }

            mesVencimento++;
            //Fim da instrução.
        }
        return dataConvertida;
    }

    public void alertCadastrado(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " cadastrado com sucesso!!");
        mensagem.show();
    }

    public void alertAtualizacao(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.ERROR);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " atualizado com sucesso!!");
        mensagem.show();
    }

    public void alertExcluido(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " excluído com sucesso!!");
        mensagem.show();

    }

    public void alertNaoCadastrado(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " não foi cadastrado!!");
        mensagem.show();
    }

    public void alertNaoAtualizado(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " não foi atualizado!!");
        mensagem.show();
    }

    public void alertNaoExcluído(String objetoDoCadastro) {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + objetoDoCadastro + " não foi excluído!!");
        mensagem.show();
    }

    public void alertConfiraFormulario() {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
        mensagem.setContentText("ATENÇÃO!!\n"
                + "Confira o formulário!!\n"
                + "Todos os campos devem serem preenchidos!!");
        mensagem.show();
    }

//    public static void somenteNumeros(final TextField textField) {
//        textField.lengthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                if (newValue.intValue() > oldValue.intValue()) {
//                    char ch = textField.getText().charAt(oldValue.intValue());
//                    if (!(ch >= '0' && ch <= '9')) {
//                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
//                    }
//                }
//            }
//        });
//    }
    public static void limitarQuantidadeCaracteres(TextField textField, int limit) {
        UnaryOperator<Change> textLimitFilter = change -> {
            if (change.isContentChange()) {
                int newLength = change.getControlNewText().length();
                if (newLength > limit) {
                    String trimmedText = change.getControlNewText().substring(0, limit);
                    change.setText(trimmedText);
                    int oldLength = change.getControlText().length();
                    change.setRange(0, oldLength);
                }
            }
            return change;
        };
        textField.setTextFormatter(new TextFormatter(textLimitFilter));
    }

    public static void validarTextField(final TextField text) {
        text.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent t) -> {
            if (t.getCharacter().matches("[a-zA-Z\\s,.]+$")) {
//                text.setStyle("-fx-focus-color: #FF0012;");
                t.consume();
            } else {
                text.setStyle(null);
            }
        });
        text.setStyle(null);
    }

    public void relatorio(String relatorio) {
        JasperPrint jasperPrint = null;
        System.out.println(""+relatorio);
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, null, conn);
        } catch (JRException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    //MASCARA PARA MOEDA
    private void posicaoPonteiro(final TextField textField) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Posiciona o cursor sempre a direita.
                textField.positionCaret(textField.getText().length());
            }
        });
    }

    public void campoMoeda(final TextField textField) {
//        textField.setAlignment(Pos.CENTER_RIGHT);

        textField.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() < 13) {
                    Platform.runLater(() -> {

                        String value = textField.getText();
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceAll("([0-9]{1})([0-9]{14})$", "$1.$2");
                        value = value.replaceAll("([0-9]{1})([0-9]{11})$", "$1.$2");
                        value = value.replaceAll("([0-9]{1})([0-9]{8})$", "$1.$2");
                        value = value.replaceAll("([0-9]{1})([0-9]{5})$", "$1.$2");
                        value = value.replaceAll("([0-9]{1})([0-9]{2})$", "$1,$2");
                        textField.setText(value);
                        posicaoPonteiro(textField);
                        textField.textProperty().addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                                if (newValue.length() > 12) {
                                    textField.setText(oldValue);
                                }
                            }
                        });
                    });
                }

            }
        });
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean fieldChange) {
                if (!fieldChange) {
                    final int length = textField.getText().length();
                    if (length > 0 && length < 3) {
                        textField.setText(textField.getText() + "00");
                    }
                }
            }
        });
    }//FIM DA MASCARA MOEDA

    public void dateField(TextField textField) {

        textField.lengthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String value = textField.getText();
                value = value.replaceAll("[a-zA-Z0-9.@]", "");
                textField.setText(value);
                positionCaret(textField);
            }

        });

    }

    private static void positionCaret(final TextField textField) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Posiciona o cursor sempre a direita.
                textField.positionCaret(textField.getText().length());
            }
        });
    }
    
    public static void cpfCnpjField(TextField textField) {

        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, 
                    Boolean aBoolean, Boolean fieldChange) {
                String value = textField.getText();
                if (!fieldChange) {
                    if (textField.getText().length() == 11) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$", "$1.$2.$3-$4");
                    }
                    if (textField.getText().length() == 14) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
                    }
                }
                textField.setText(value);
                if (textField.getText() != value) {
                    textField.setText("");
                    textField.insertText(0, value);
                }

            }
        });
//        maxField(textField, 11);
    }
    
    public void rgField(TextField textField) {

        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, 
                    Boolean aBoolean, Boolean fieldChange) {
                String value = textField.getText();
                if (!fieldChange) {
                    if (textField.getText().length() == 9) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})$", "$1.$2.$3");
                    }
                    if (textField.getText().length() == 8) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})$", "$1.$2.$3");
                    }
                    if (textField.getText().length() == 7) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{1})([0-9]{3})([0-9]{3})$", "$1.$2.$3");
                    }
//                    if (textField.getText().length() == 14) {
//                        value = value.replaceAll("[^0-9]", "");
//                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
//                    }
                }
                textField.setText(value);
                if (textField.getText() != value) {
                    textField.setText("");
                    textField.insertText(0, value);
                }

            }
        });
//        maxField(textField, 11);
    }
    public void CEPField(TextField textField) {

        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, 
                    Boolean aBoolean, Boolean fieldChange) {
                String value = textField.getText();
                if (!fieldChange) {
                    if (textField.getText().length() == 8) {
                        value = value.replaceAll("[^0-9]", "");
                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})$", "$1.$2-$3");
                    }
//                    if (textField.getText().length() == 8) {
//                        value = value.replaceAll("[^0-9]", "");
//                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})$", "$1.$2.$3");
//                    }
//                    if (textField.getText().length() == 7) {
//                        value = value.replaceAll("[^0-9]", "");
//                        value = value.replaceFirst("([0-9]{1})([0-9]{3})([0-9]{3})$", "$1.$2.$3");
//                    }
//                    if (textField.getText().length() == 14) {
//                        value = value.replaceAll("[^0-9]", "");
//                        value = value.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
//                    }
                }
                textField.setText(value);
                if (textField.getText() != value) {
                    textField.setText("");
                    textField.insertText(0, value);
                }

            }
        });
//        maxField(textField, 11);
    }
    
     public void maxField(final TextField textField, final Integer length) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > length)
                    textField.setText(oldValue);
            }
        });
    }
     
     //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

}
