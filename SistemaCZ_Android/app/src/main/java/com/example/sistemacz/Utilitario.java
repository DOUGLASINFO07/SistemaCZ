package com.example.sistemacz;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas borges egidio
 * @since 04/10/2018.
 * 
 */

public class Utilitario {

    //CLASSE DE CONEXÃO.
    private Connection conn;

    /*//CONTRUTOR
    public Utilitario(Connection conn) {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.
*/

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
}
