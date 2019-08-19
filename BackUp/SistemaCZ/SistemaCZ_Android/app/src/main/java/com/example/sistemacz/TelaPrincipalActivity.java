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

    TextView buttonBoletimDiario,
    buttonDenuncia,
    buttonConsultarBoletimDiario,
    buttonConsultarQuarteiraoConcluido;

    String ace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        buttonBoletimDiario = (Button) findViewById(R.id.buttonBoletimDiario);
        buttonConsultarBoletimDiario = (Button) findViewById(R.id.buttonConsultarBoletimDiario);
        buttonConsultarQuarteiraoConcluido = (Button) findViewById(R.id.buttonConsultarQuarteiraoConcluido);
        buttonDenuncia = (Button) findViewById(R.id.buttonDenuncia);

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        //METODO DO BOTAO EXCLUIR.
        buttonBoletimDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent novaTela = new Intent(TelaPrincipalActivity.this, LancarServicoActivity.class);
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
                finish();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    };

}
