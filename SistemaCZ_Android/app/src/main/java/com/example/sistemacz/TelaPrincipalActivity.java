package com.example.sistemacz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipalActivity extends AppCompatActivity {

    TextView saudacao, telaMenu;

    Button buttonBoletimDiario,
    buttonDenuncia;


    String ace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        buttonBoletimDiario = (Button) findViewById(R.id.buttonBoletimDiario);
        buttonDenuncia = (Button) findViewById(R.id.buttonDenuncia);

        saudacao = (TextView) findViewById(R.id.textViewSaudacao);
        telaMenu = (TextView) findViewById(R.id.textViewMenu);

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        saudacao.setText("Olá "+ace+", Bem Vindo!");
        telaMenu.setText("TELA DE MENU");


        //METODO DO BOTAO EXCLUIR.
        buttonBoletimDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent novaTela = new Intent(TelaPrincipalActivity.this, TelaTratamentoFocalActivity.class);
                novaTela.putExtra("ace",ace);
                startActivity(novaTela);
                finish();

            }
        });//FIM

        //METODO DO BOTAO EXCLUIR.
        buttonDenuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent novaTela = new Intent(TelaPrincipalActivity.this, TelaDenunciaActivity.class);
                novaTela.putExtra("ace",ace);
                startActivity(novaTela);
                finish();

            }
        });//FIM

    }//FIM DO CREATE

    @Override
    public void onBackPressed() {

        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(TelaPrincipalActivity.this);
        //define o titulo
        builder.setTitle("BOLETIM DIÁRIO");
        //define a mensagem
        builder.setMessage("O QUE DESEJA FAZER?");
        //define um botão como positivo
        builder.setPositiveButton("IR PRA TELA DE LOGIN!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(TelaPrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("FECHAR O PROGRAMA!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //FECHA TODOS OS ACTIVITY.
                finishAffinity();//FIM
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    };

}
