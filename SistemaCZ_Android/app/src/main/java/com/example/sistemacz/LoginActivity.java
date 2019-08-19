package com.example.sistemacz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button buttonEntrar;
    EditText editTextLogin, editTextSenha;

    String urlLogin = "http://www.dimtech.com.br/sistemacz/login.php";

    StringRequest stringRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        requestQueue = Volley.newRequestQueue(this);

        buttonEntrar = findViewById(R.id.buttonEntrar);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                editTextLogin.setText("douglas");
               editTextSenha.setText("11");

                boolean validado = true;

                if (editTextLogin.getText().length() == 0) {
                    editTextLogin.setError("Campo Login Obrigatório!");
                    editTextLogin.requestFocus();
                    validado = false;
                }

                if (editTextSenha.getText().length() == 0) {
                    editTextSenha.setError("Campo Senha Obrigatório!");
                    editTextSenha.requestFocus();
                    validado = false;
                }

                if (validado) {
                    Toast.makeText(getApplicationContext(), "Validando seus dados... espere...", Toast.LENGTH_SHORT).show();
                    validarLogin();
                }
            }

        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        //define o titulo
        builder.setTitle("BOLETIM DIÁRIO");
        //define a mensagem
        builder.setMessage("SAIR DA TELA BOLETIM DIARIO?");
        //define um botão como positivo
        builder.setPositiveButton("SIM, VOU SAIR!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
               finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("NÃO!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    };

    private void validarLogin() {

        stringRequest = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("LogLogin", response);
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                           boolean isErro = jsonObject.getBoolean("erro");
                           if(isErro){
                               AlertDialog alerta;
                               //Cria o gerador do AlertDialog
                               AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                               //define o titulo
                               builder.setTitle("BOLETIM DIÁRIO");
                               //define a mensagem
                               builder.setMessage("DADOS INCORRETOS!!\n" +
                                       "CONFIRA SEUS DADOS!");
                               //define um botão como positivo
                               builder.setPositiveButton("OK, VOU CONFERIR!", new DialogInterface.OnClickListener() {
                                   public void onClick(DialogInterface arg0, int arg1) {

                                   }
                               });
                                                              //cria o AlertDialog
                               alerta = builder.create();
                               //Exibe
                               alerta.show();
                           }else{
                              //  int perfil = jsonObject.getInt("perfil");
                               // if(perfil == 1){
                                 //   String ace = editTextLogin.getText().toString();
                                 //   Intent novaTela = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
                                  //  startActivity(novaTela);
                                  //  finish();
                               // }else if(perfil == 2){
                                    String ace = editTextLogin.getText().toString();
                                    Intent novaTela = new Intent(LoginActivity.this, TelaPrincipalActivity.class);
                                    novaTela.putExtra("ace",ace);
                                    startActivity(novaTela);
                                    finish();
                                }
                          //  }
                        }catch(Exception e){
                            Log.v("LogLogin", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("login", editTextLogin.getText().toString());
                params.put("senha", editTextSenha.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
