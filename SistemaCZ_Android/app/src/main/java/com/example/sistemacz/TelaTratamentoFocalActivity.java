package com.example.sistemacz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaTratamentoFocalActivity extends AppCompatActivity {

    Button buttonBoletimDiario,
            buttonConsultaBoletimDiario,
            buttonConsultarQuarteirao;

    String ace;

    TextView saudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tratamento_focal);

        buttonBoletimDiario = (Button) findViewById(R.id.buttonBoletimDiario);
        buttonConsultaBoletimDiario = (Button) findViewById(R.id.buttonConsultaBoletimDiario);
        buttonConsultarQuarteirao = (Button) findViewById(R.id.buttonQuarteiraoConcluido);

        saudacao = (TextView) findViewById(R.id.textViewSaudacao);

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        saudacao.setText("TRATAMENTO FOCAL");

        buttonBoletimDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novaTela = new Intent(TelaTratamentoFocalActivity.this,
                        BoletimDiarioActivity.class);
                novaTela.putExtra("ace",ace);
                startActivity(novaTela);
                finish();
            }
        });//FIM
    }

    @Override
    public void onBackPressed() {

        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(TelaTratamentoFocalActivity.this);
        //define o titulo
        builder.setTitle("TRATAMENTO FOCAL");
        //define a mensagem
        builder.setMessage("O QUE DESEJA FAZER?");
        //define um botão como positivo
        builder.setPositiveButton("IR PRA TELA DE MENU!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(TelaTratamentoFocalActivity.this, TelaPrincipalActivity.class);
                intent.putExtra("ace",ace);
                startActivity(intent);

                finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("CONTINUAR NESTA TELA!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        //define um botão FECHAR APLICAÇÃO
        builder.setNeutralButton("FECHAR APLICAÇÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finishAffinity();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    };

    }

