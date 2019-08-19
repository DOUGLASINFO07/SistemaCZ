package com.example.sistemacz;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LancarServicoActivity extends AppCompatActivity {

    Button buttonSalvar,
            buttonCorrigir,
            buttonExcluir,
            buttonLimpar,
            buttonListar;

    EditText semana,
            numeroQuarteirao,
            ladoQuarteirao,
            logradouro,
            numeroImovel,
            sequencia,
            complemento,
            depositoEliminado,
            quantidadeLarvicida,
            depositoTratados,
            observacoes;

    Spinner cicloSpinner,
            bairroSpinner,
            tipoImovelSpinner,
            tipoVisitaSpinner,
            tipoLarvicidaSpinner,
            finalQuarteiraoSpinner;

    TextView textViewNumeroQuateirao,
            textViewBairro,
            textViewLogradouro,
            textViewNumeroImovel,
            textViewSequencia,
            textViewComplemento,
            textViewTipoVisita,
            textViewTotalProducao;

    String URLSalvar = "http://www.dimtech.com.br/sistemacz/salvar1.php";
    String URLListarBairro = "http://www.dimtech.com.br/sistemacz/listarBairro.php";
    String URLListarCiclo = "http://www.dimtech.com.br/sistemacz/listarCiclo.php";
    String URLListarBoletimDiario = "http://www.dimtech.com.br/sistemacz/listarBoletimDiario.php";
    String URLCorrigir = "http://www.dimtech.com.br/sistemacz/corrigir.php";
    String URLExcluir = "http://www.dimtech.com.br/sistemacz/apagar.php";
    String URLbuscarBoletimDiario = "http://www.dimtech.com.br/sistemacz/buscarBoletimDiario.php";

    public RecyclerView recyclerView;

    StringRequest stringRequest;
    RequestQueue requestQueue;

    String ace;

    String data_completa, hora_atual;

    ArrayList<String> bairroLista;
    ArrayList<String> cicloLista;
    ArrayList<String> tipoImovelLista;
    ArrayList<String> tipoVisitaLista;
    ArrayList<String> tipoLarvicidaLista;
    ArrayList<String> finalQuarteiraoLista;

    List<BoletimDiario> boletimDiarioLista;

    int cicloPesquisa;
    int bairroPesquisa;
    int tipoImovelPesquisa;
    int tipoVisitaPesquisa;
    int tipoLarvicidaPesquisa;
    int quarteiraoConcluidoPesquisa;

    String cicloEditar = null;
    String bairroEditar = null;
    String aceEditar = null;
    String data_completaEditar = null;
    String hora_atualEditar = null;
    String semanaEditar = null;
    String numeroQuarteiraoEditar = null;
    String ladoQuarteiraoEditar = null;
    String logradouroEditar = null;
    String numeroImovelEditar = null;
    String sequenciaEditar = null;
    String complementoEditar = null;
    String depositoEliminadoEditar = null;
    String quantidadeLarvicidaEditar = null;
    String depositoTratadosEditar = null;
    String observacoesEditar = null;
    String tipoImovelEditar = null;
    String tipoLarvicidaEditar = null;
    String tipoVisitaEditar = null;
    String finalQuarteiraoEditar = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancar_servico);

        bairroLista = new ArrayList<>();
        cicloLista = new ArrayList<>();
        tipoImovelLista = new ArrayList<>();
        tipoVisitaLista = new ArrayList<>();
        tipoLarvicidaLista = new ArrayList<>();
        finalQuarteiraoLista = new ArrayList<>();

        listarBoletimDiario();

        requestQueue = Volley.newRequestQueue(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        data_completa = dateFormat.format(data_atual);
        hora_atual = dateFormat_hora.format(data_atual);

        //((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
        //       .hideSoftInputFromWindow(cicloSpinner.getWindowToken(), 0);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonCorrigir = (Button) findViewById(R.id.buttonCorrigir);
        buttonExcluir = (Button) findViewById(R.id.buttonExcluir);
        buttonListar = (Button) findViewById(R.id.buttonListar);
        buttonLimpar = (Button) findViewById(R.id.buttonLimpar);

        semana = (EditText) findViewById(R.id.editTextDenunciante);
        numeroQuarteirao = (EditText) findViewById(R.id.editTextDenunciado);
        ladoQuarteirao = (EditText) findViewById(R.id.editTextLogradouro);
        logradouro = (EditText) findViewById(R.id.editTextLogradouro);
        numeroImovel = (EditText) findViewById(R.id.editTextNumeroImovel);
        sequencia = (EditText) findViewById(R.id.editTextSequencia);
        complemento = (EditText) findViewById(R.id.editTextComplemento);
        depositoEliminado = (EditText) findViewById(R.id.editTextDepositoEliminado);
        quantidadeLarvicida = (EditText) findViewById(R.id.editTextQuantidadeLarvicida);
        depositoTratados = (EditText) findViewById(R.id.editTextDepositoTratado);
        observacoes = (EditText) findViewById(R.id.editTextObservacoes);

        cicloSpinner = (Spinner) findViewById(R.id.spinnerCiclo);
        bairroSpinner = (Spinner) findViewById(R.id.spinnerBairro);
        tipoImovelSpinner = (Spinner) findViewById(R.id.spinnerTipoImovel);
        tipoLarvicidaSpinner = (Spinner) findViewById(R.id.spinnerTipoLarvicida);
        tipoVisitaSpinner = (Spinner) findViewById(R.id.spinnerTipoVisita);
        finalQuarteiraoSpinner = (Spinner) findViewById(R.id.spinnerFinalQuarteirao);

        textViewNumeroQuateirao = (TextView) findViewById(R.id.textViewNumeroImovel);
        textViewBairro = (TextView) findViewById(R.id.textViewLogradouro);
        textViewLogradouro = (TextView) findViewById(R.id.textViewLogradouro);
        textViewNumeroImovel = (TextView) findViewById(R.id.textViewNumeroImovel);
        textViewSequencia = (TextView) findViewById(R.id.textViewDetalhes);
        textViewComplemento = (TextView) findViewById(R.id.textViewComplemento);
        textViewTipoVisita = (TextView) findViewById(R.id.textViewTipoDenuncia);
        textViewTotalProducao = (TextView) findViewById(R.id.textViewTotalProducao);

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        Bundle b = getIntent().getExtras();

        if (b != null) {

            aceEditar = b.getString("ace");
            data_completaEditar = b.getString("data");
            hora_atualEditar = b.getString("hora");
            cicloEditar = b.getString("ciclo");
            semanaEditar = b.getString("semana");
            bairroEditar = b.getString("bairro");
            numeroQuarteiraoEditar = b.getString("numeroQuarteirao");
            ladoQuarteiraoEditar = b.getString("ladoQuarteirao");
            logradouroEditar = b.getString("logradouro");
            numeroImovelEditar = b.getString("numeroImovel");
            sequenciaEditar = b.getString("sequencia");
            complementoEditar = b.getString("complemento");
            tipoImovelEditar = b.getString("tipoImovel");
            tipoVisitaEditar = b.getString("tipoVisita");
            depositoEliminadoEditar = b.getString("depositoEliminado");
            tipoLarvicidaEditar = b.getString("tipoLarvicida");
            quantidadeLarvicidaEditar = b.getString("quantidadeLarvicida");
            depositoTratadosEditar = b.getString("depositoTratado");
            observacoesEditar = b.getString("observacao");
            finalQuarteiraoEditar = b.getString("terminoQuarteirao");


            tipoImovelSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoImovelLista.add("**SELECIONE AQUI!**");
            tipoImovelLista.add("Residencia");
            tipoImovelLista.add("Comércio");
            tipoImovelLista.add("Terreno Baldio");
            tipoImovelLista.add("Outros");
            tipoImovelSpinner.setAdapter(new ArrayAdapter<String>(
                    LancarServicoActivity.this,
                    R.layout.spinner_dropdown, tipoImovelLista));
            tipoImovelPesquisa = tipoImovelLista.indexOf(tipoImovelEditar);
            tipoImovelSpinner.setSelection(tipoImovelPesquisa);

            tipoLarvicidaSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoLarvicidaLista.add("**SELECIONE AQUI!**");
            tipoLarvicidaLista.add("Piryproxyfen");
            tipoLarvicidaLista.add("Temefos");
            tipoLarvicidaSpinner.setAdapter(new ArrayAdapter(
                    this, R.layout.spinner_dropdown,
                    tipoLarvicidaLista));
            tipoLarvicidaPesquisa = tipoLarvicidaLista.indexOf(tipoLarvicidaEditar);
            tipoLarvicidaSpinner.setSelection(tipoLarvicidaPesquisa);

            tipoVisitaSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoVisitaLista.add("**SELECIONE AQUI!**");
            tipoVisitaLista.add("Normal");
            tipoVisitaLista.add("Resgate");
            tipoVisitaSpinner.setAdapter(new ArrayAdapter(
                    LancarServicoActivity.this,
                    R.layout.spinner_dropdown,
                    tipoVisitaLista));
            tipoVisitaPesquisa = tipoVisitaLista.indexOf(tipoVisitaEditar);
            tipoVisitaSpinner.setSelection(tipoVisitaPesquisa);

            finalQuarteiraoSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            finalQuarteiraoLista.add("**SELECIONE AQUI!**");
            finalQuarteiraoLista.add("Concluido");
            finalQuarteiraoLista.add("Em Andamento");
            finalQuarteiraoSpinner.setAdapter(new ArrayAdapter<String>(
                    LancarServicoActivity.this,
                    R.layout.spinner_dropdown,
                    finalQuarteiraoLista));
            quarteiraoConcluidoPesquisa = finalQuarteiraoLista.indexOf(finalQuarteiraoEditar);
            finalQuarteiraoSpinner.setSelection(quarteiraoConcluidoPesquisa);

            semana.setText(semanaEditar);
            numeroQuarteirao.setText(numeroQuarteiraoEditar);
            ladoQuarteirao.setText(ladoQuarteiraoEditar);
            logradouro.setText(logradouroEditar);
            numeroImovel.setText(numeroImovelEditar);
            sequencia.setText(sequenciaEditar);
            complemento.setText(complementoEditar);
            depositoEliminado.setText(depositoEliminadoEditar);
            quantidadeLarvicida.setText(quantidadeLarvicidaEditar);
            depositoTratados.setText(depositoTratadosEditar);
            observacoes.setText(observacoesEditar);

            if (bairroEditar != null) {
                bairroSpinner.setEnabled(false);
                cicloSpinner.setEnabled(false);
                numeroQuarteirao.setEnabled(false);
                logradouro.setEnabled(false);
                numeroImovel.setEnabled(false);
                sequencia.setEnabled(false);
                complemento.setEnabled(false);
                tipoImovelSpinner.setEnabled(false);
            }


            //MÉTODO PARA POPULAR O SPINNER BAIRRO
            RequestQueue requestQueue5 = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest5 = new StringRequest(Request.Method.GET, URLListarBairro,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                // JSONObject jsonObject = new JSONObject(response);
                                //converting the string to json array object
                                JSONArray array = new JSONArray(response);
                                //traversing through all the object
                                for (int i = 0; i < array.length(); i++) {
                                    //getting product object from json array
                                    JSONObject localidade = array.getJSONObject(i);

                                    String bairro = localidade.getString("nome");
                                    bairroLista.add(bairro);
                                }
                                bairroSpinner.getBackground().setColorFilter(
                                        Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
                                bairroSpinner.setAdapter(new ArrayAdapter<String>(
                                        LancarServicoActivity.this,
                                        R.layout.spinner_dropdown, bairroLista));
                                bairroPesquisa = bairroLista.indexOf(bairroEditar);
                                bairroSpinner.setSelection(bairroPesquisa);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
            requestQueue5.add(stringRequest5);
            //FIM do método para popular o spinner Bairro.

            //MÉTODO PARA POPULAR O SPINNER CICLO
            RequestQueue requestQueue6 = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest6 = new StringRequest(Request.Method.GET, URLListarCiclo,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                // JSONObject jsonObject = new JSONObject(response);
                                //converting the string to json array object
                                JSONArray array = new JSONArray(response);
                                //traversing through all the object
                                for (int i = 0; i < array.length(); i++) {
                                    //getting product object from json array
                                    JSONObject Ciclo = array.getJSONObject(i);

                                    String ciclo = Ciclo.getString("nomeAtividade");
                                    cicloLista.add(ciclo);
                                }
                                cicloSpinner.getBackground().setColorFilter(
                                        Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
                                cicloSpinner.setAdapter(new ArrayAdapter<String>(
                                        LancarServicoActivity.this,
                                        R.layout.spinner_dropdown
                                        , cicloLista));

                                cicloPesquisa = cicloLista.indexOf(cicloEditar);

                                cicloSpinner.setSelection(cicloPesquisa);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
            requestQueue6.add(stringRequest6);
            //FIM DO MÉTODO POPULAR SPINNER CICLO.


        }


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        boletimDiarioLista = new ArrayList<>();

        //INICIO DO METODO DO BOTAO SALVAR.
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado = true;
                if ("SELECIONE AQUI!".equals(cicloSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Ciclo é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    cicloSpinner.requestFocus();
                    validado = false;
                }
                if (semana.getText().length() == 0) {
                    semana.setError("Campo Obrigatório!");
                    semana.requestFocus();
                    validado = false;
                }
                if ("SELECIONE AQUI!".equals(bairroSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    bairroSpinner.requestFocus();
                    validado = false;
                }
                if (numeroQuarteirao.getText().length() == 0) {
                    numeroQuarteirao.setError("Campo Obrigatório!");
                    numeroQuarteirao.requestFocus();
                    validado = false;
                }
                if (ladoQuarteirao.getText().length() == 0) {
                    ladoQuarteirao.setError("Campo Obrigatório!");
                    ladoQuarteirao.requestFocus();
                    validado = false;
                }
                if (logradouro.getText().length() == 0) {
                    logradouro.setError("Campo Obrigatório!");
                    logradouro.requestFocus();
                    validado = false;
                }
                if (numeroImovel.getText().length() == 0) {
                    numeroImovel.setError("Campo Obrigatório!");
                    numeroImovel.requestFocus();
                    validado = false;
                }
                if ("SELECIONE AQUI!".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Tipo de Imovel é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    tipoImovelSpinner.requestFocus();
                    validado = false;
                }
                if ("SELECIONE AQUI!".equals(tipoVisitaSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Tipo de Visita é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    tipoVisitaSpinner.requestFocus();
                    validado = false;
                }
                if ("SELECIONE AQUI!".equals(finalQuarteiraoSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Final de Quarteirão é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    finalQuarteiraoSpinner.requestFocus();
                    validado = false;
                }
                if (validado) {
                    Toast.makeText(getApplicationContext(), "VALIDANDO OS DADOS... AGUARDE...",
                            Toast.LENGTH_SHORT).show();
                    salvar();
                    Toast.makeText(getApplicationContext(), "DADOS SALVO!!",
                            Toast.LENGTH_SHORT).show();
                    //  METODO PARA ACULTAR TECLADO
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
                }
            }
        }); //FIM

        //INICIO DO METODO DO BOTAO SALVAR.
        buttonCorrigir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alerta;
                //Cria o gerador do AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                //define o titulo
                builder.setTitle("BOLETIM DIÁRIO");
                //define a mensagem
                builder.setMessage("CONFIRMA A CORREÇÃO?");
                //define um botão como positivo
                builder.setPositiveButton("SIM, PODE CONFIRMAR!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        boolean validado = true;
                        if ("SELECIONE AQUI!".equals(cicloSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Ciclo é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            cicloSpinner.requestFocus();
                            validado = false;
                        }
                        if (semana.getText().length() == 0) {
                            semana.setError("Campo Obrigatório!");
                            semana.requestFocus();
                            validado = false;
                        }
                        if ("SELECIONE AQUI!".equals(bairroSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            bairroSpinner.requestFocus();
                            validado = false;
                        }
                        if (numeroQuarteirao.getText().length() == 0) {
                            numeroQuarteirao.setError("Campo Obrigatório!");
                            numeroQuarteirao.requestFocus();
                            validado = false;
                        }
                        if (ladoQuarteirao.getText().length() == 0) {
                            ladoQuarteirao.setError("Campo Obrigatório!");
                            ladoQuarteirao.requestFocus();
                            validado = false;
                        }
                        if (logradouro.getText().length() == 0) {
                            logradouro.setError("Campo Obrigatório!");
                            logradouro.requestFocus();
                            validado = false;
                        }
                        if (numeroImovel.getText().length() == 0) {
                            numeroImovel.setError("Campo Obrigatório!");
                            numeroImovel.requestFocus();
                            validado = false;
                        }
                        if ("SELECIONE AQUI!".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Tipo de Imovel é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            tipoImovelSpinner.requestFocus();
                            validado = false;
                        }
                        if ("SELECIONE AQUI!".equals(tipoVisitaSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Tipo de Visita é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            tipoVisitaSpinner.requestFocus();
                            validado = false;
                        }
                        if ("SELECIONE AQUI!".equals(finalQuarteiraoSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Final de Quarteirão é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            finalQuarteiraoSpinner.requestFocus();
                            validado = false;
                        }
                        if (validado) {
                            Toast.makeText(getApplicationContext(), "VALIDANDO OS DADOS... AGUARDE...",
                                    Toast.LENGTH_SHORT).show();
                            atualizar();
                            Toast.makeText(getApplicationContext(), "DADOS CORRIGIDOS!!",
                                    Toast.LENGTH_SHORT).show();
                            //  METODO PARA ACULTAR TECLADO
                            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                                    .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
                        }

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


            }
        }); //FIM

        //METODO DO BOTAO EXCLUIR.
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alerta;
                //Cria o gerador do AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                //define o titulo
                builder.setTitle("BOLETIM DIÁRIO");
                //define a mensagem
                builder.setMessage("CONFIRMA A EXCLUSÃO?");
                //define um botão como positivo
                builder.setPositiveButton("OK, PODE EXCLUIR!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Toast.makeText(getApplicationContext(), "VALIDANDO OS DADOS... AGUARDE...",
                                Toast.LENGTH_SHORT).show();
                        excluir();

                        Toast.makeText(getApplicationContext(), "DADOS EXCLUÍDOS!!",
                                Toast.LENGTH_SHORT).show();

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

                //  METODO PARA ACULTAR TECLADO
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
            }
        });//FIM

        //METODO BOTAO LISTAR
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Listando!!!", Toast.LENGTH_LONG).show();
                listarBoletimDiario();
                Toast.makeText(getApplicationContext(),
                        "lista Concluida!!!", Toast.LENGTH_LONG).show();
                //  METODO PARA ACULTAR TECLADO
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
            }
        });//FIM

        //METODO BOTAO LISTAR
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                semana.setText("");
                numeroQuarteirao.setText("");
                ladoQuarteirao.setText("");
                logradouro.setText("");
                numeroImovel.setText("");
                sequencia.setText("");
                complemento.setText("");
                depositoEliminado.setText("");
                quantidadeLarvicida.setText("");
                depositoTratados.setText("");
                observacoes.setText("");

                bairroSpinner.setSelection(0);
                tipoImovelSpinner.setSelection(0);
                tipoVisitaSpinner.setSelection(0);
                tipoLarvicidaSpinner.setSelection(0);
                finalQuarteiraoSpinner.setSelection(0);
                cicloSpinner.setSelection(0);

                bairroSpinner.setEnabled(true);
                cicloSpinner.setEnabled(true);
                numeroQuarteirao.setEnabled(true);
                logradouro.setEnabled(true);
                numeroImovel.setEnabled(true);
                sequencia.setEnabled(true);
                complemento.setEnabled(true);
                tipoImovelSpinner.setEnabled(true);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
            }
        });//FIM

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
       // getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
       // getSupportActionBar().setTitle("Seu titulo aqui");


    }//FIM DO ON CREATE




    @Override
    public void onBackPressed() {

        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
        //define o titulo
        builder.setTitle("BOLETIM DIÁRIO");
        //define a mensagem
        builder.setMessage("SAIR DA TELA BOLETIM DIARIO?");
        //define um botão como positivo
        builder.setPositiveButton("SIM, VOU SAIR!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Intent intent = new Intent(LancarServicoActivity.this, TelaPrincipalActivity.class);
                startActivity(intent);
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

    //METODO QUE ADICIONA NA LISTA, OS IMÓVEIS LANÇADOS.
    private void listarBoletimDiario() {
        RequestQueue requestQueue8 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest8 = new StringRequest(Request.Method.GET, URLListarBoletimDiario,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //MÉTODO PARA LIMPA RO RECYCLERVIEW
                        // boletimDiarioLista.clear();
                        //FIM.
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);
                            boletimDiarioLista.clear();
                            textViewTotalProducao.setText("" + 0);
                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                textViewTotalProducao.setText("" + (i + 1));

                                //getting product object from json array
                                JSONObject boletim = array.getJSONObject(i);

                                //adding the product to product list
                                boletimDiarioLista.add(new BoletimDiario(
                                        boletim.getString("tipoVisita"),
                                        boletim.getString("numeroQuarteirao"),
                                        boletim.getString("logradouro"),
                                        boletim.getString("numeroImovel"),
                                        boletim.getString("sequencia"),
                                        boletim.getString("complemento"),
                                        boletim.getString("bairro"),
                                        boletim.getString("ciclo")
                                ));

                            }
                            //creating adapter object and setting it to recyclerView
                            AdapterBoletimDiario adapter = new AdapterBoletimDiario(
                                    LancarServicoActivity.this,
                                    boletimDiarioLista);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("data", data_completa);
                return params;
            }
        };
        requestQueue8.add(stringRequest8);
    }//FIM.

    //INICIO DO METODO QUE REALIZA A EXCLUSÃO DOS IMOVEIS TRABALHADOSS.
    private void excluir() {

        stringRequest = new StringRequest(Request.Method.POST, URLExcluir,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObjectExcluir = null;
                        int isErro;
                        //PRIMEIRO TRY/CATCH
                        try {
                            jsonObjectExcluir = new JSONObject(response);
                            isErro = jsonObjectExcluir.getInt("erro");
                            //SEGUNDO TRY CATCH
                            try {
                                if (isErro == 1) {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("ESTE IMÓVEL NÃO EXISTE!!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, VOU CONFERIR O QUE ACONTECEU!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();
                                    cicloSpinner.requestFocus();
                                } else {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("ESTE IMÓVEL FOI EXCLUÍDO COM SUCESSO!!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, ENTENDIDO!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();

                                    semana.setText("");
                                    numeroQuarteirao.setText("");
                                    ladoQuarteirao.setText("");
                                    logradouro.setText("");
                                    numeroImovel.setText("");
                                    sequencia.setText("");
                                    complemento.setText("");
                                    depositoEliminado.setText("");
                                    quantidadeLarvicida.setText("");
                                    depositoTratados.setText("");
                                    observacoes.setText("");

                                    bairroSpinner.setSelection(0);
                                    tipoImovelSpinner.setSelection(0);
                                    tipoVisitaSpinner.setSelection(0);
                                    tipoLarvicidaSpinner.setSelection(0);
                                    finalQuarteiraoSpinner.setSelection(0);
                                    cicloSpinner.setSelection(0);

                                    bairroSpinner.setEnabled(true);
                                    cicloSpinner.setEnabled(true);
                                    numeroQuarteirao.setEnabled(true);
                                    logradouro.setEnabled(true);
                                    numeroImovel.setEnabled(true);
                                    sequencia.setEnabled(true);
                                    complemento.setEnabled(true);
                                    tipoImovelSpinner.setEnabled(true);

                                    listarBoletimDiario();

                                }
                            } catch (Exception e) {
                                Log.v("ERRO EXCLUIR", e.getMessage());
                            }//FIM DO SEGUNDO TRY
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }//FIM DO PRIMEIRO TRY.
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("ace", ace);
                params.put("data", data_completa);
                params.put("hora", hora_atual);
                params.put("ciclo", cicloSpinner.getSelectedItem().toString());
                params.put("semana", semana.getText().toString());
                params.put("bairro", bairroSpinner.getSelectedItem().toString());
                params.put("numeroQuarteirao", numeroQuarteirao.getText().toString());
                params.put("ladoQuarteirao", ladoQuarteirao.getText().toString());
                params.put("logradouro", logradouro.getText().toString());
                params.put("numeroImovel", numeroImovel.getText().toString());
                params.put("sequencia", sequencia.getText().toString());
                params.put("complemento", complemento.getText().toString());
                params.put("tipoImovel", tipoImovelSpinner.getSelectedItem().toString());
                params.put("tipoVisita", tipoVisitaSpinner.getSelectedItem().toString());
                params.put("depositoEliminado", depositoEliminado.getText().toString());
                params.put("tipoLarvicida", tipoLarvicidaSpinner.getSelectedItem().toString());
                params.put("quantidadeLarvicida", quantidadeLarvicida.getText().toString());
                params.put("depositoTratado", depositoTratados.getText().toString());
                params.put("observacao", observacoes.getText().toString());
                params.put("terminoQuarteirao", finalQuarteiraoSpinner.getSelectedItem().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }//FIM.

    //INICIO DO METODO QUE ATUALIZA OS DADOS.
    private void atualizar() {
        RequestQueue requestQueue9 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest9 = new StringRequest(Request.Method.POST, URLCorrigir,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObjectAtualizar;
                        int isErro;
                        //PRIMEIRO TRY/CATCH
                        try {
                            jsonObjectAtualizar = new JSONObject(response);
                            isErro = jsonObjectAtualizar.getInt("erro");
                            //SEGUNDO TRY CATCH
                            try {
                                if (isErro == 1) {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("OS DADOS DESTE IMOVEL ESTÃO CORRETOS!!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, ENTENDIDO!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();
                                    cicloSpinner.requestFocus();
                                } else {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("ESTE IMÓVEL FOI CORRIGIDO COM SUCESSO!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, ENTENDIDO!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();

                                    semana.setText("");
                                    numeroQuarteirao.setText("");
                                    ladoQuarteirao.setText("");
                                    logradouro.setText("");
                                    numeroImovel.setText("");
                                    sequencia.setText("");
                                    complemento.setText("");
                                    depositoEliminado.setText("");
                                    quantidadeLarvicida.setText("");
                                    depositoTratados.setText("");
                                    observacoes.setText("");

                                    bairroSpinner.setSelection(0);
                                    tipoImovelSpinner.setSelection(0);
                                    tipoVisitaSpinner.setSelection(0);
                                    tipoLarvicidaSpinner.setSelection(0);
                                    finalQuarteiraoSpinner.setSelection(0);
                                    cicloSpinner.setSelection(0);

                                    bairroSpinner.setEnabled(true);
                                    cicloSpinner.setEnabled(true);
                                    numeroQuarteirao.setEnabled(true);
                                    logradouro.setEnabled(true);
                                    numeroImovel.setEnabled(true);
                                    sequencia.setEnabled(true);
                                    complemento.setEnabled(true);
                                    tipoImovelSpinner.setEnabled(true);

                                    listarBoletimDiario();
                                }
                            } catch (Exception e) {
                                Log.v("ERRO ATUALIZAR.", e.getMessage());
                            }//FIM DO SEGUNDO TRY
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }//FIM DO PRIMEIRO TRY.
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("ace", ace);
                params.put("data", data_completa);
                params.put("hora", hora_atual);
                params.put("ciclo", cicloSpinner.getSelectedItem().toString());
                params.put("semana", semana.getText().toString());
                params.put("bairro", bairroSpinner.getSelectedItem().toString());
                params.put("numeroQuarteirao", numeroQuarteirao.getText().toString());
                params.put("ladoQuarteirao", ladoQuarteirao.getText().toString());
                params.put("logradouro", logradouro.getText().toString());
                params.put("numeroImovel", numeroImovel.getText().toString());
                params.put("sequencia", sequencia.getText().toString());
                params.put("complemento", complemento.getText().toString());
                params.put("tipoImovel", tipoImovelSpinner.getSelectedItem().toString());
                params.put("tipoVisita", tipoVisitaSpinner.getSelectedItem().toString());
                params.put("depositoEliminado", depositoEliminado.getText().toString());
                params.put("tipoLarvicida", tipoLarvicidaSpinner.getSelectedItem().toString());
                params.put("quantidadeLarvicida", quantidadeLarvicida.getText().toString());
                params.put("depositoTratado", depositoTratados.getText().toString());
                params.put("observacao", observacoes.getText().toString());
                params.put("terminoQuarteirao", finalQuarteiraoSpinner.getSelectedItem().toString());
                return params;
            }
        };
        requestQueue9.add(stringRequest9);
    }//FIM.

    //INICIO DO MÉTODO SALVAR
    private void salvar() {
        // RequestQueue requestQueue6 = Volley.newRequestQueue(getApplicationContext());
        stringRequest = new StringRequest(Request.Method.POST, URLSalvar,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        int isErro;
                        //PRIMEIRO TRY/CATCH
                        try {
                            jsonObject = new JSONObject(response);
                            isErro = jsonObject.getInt("erro");
                            //SEGUNDO TRY CATCH
                            try {
                                if (isErro == 1) {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("ESTE IMÓVEL JÁ FOI LANÇADO!!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, VOU CONFERIR O QUE ACONTECEU!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();
                                    cicloSpinner.requestFocus();
                                } else {
                                    AlertDialog alerta;
                                    //Cria o gerador do AlertDialog
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LancarServicoActivity.this);
                                    //define o titulo
                                    builder.setTitle("BOLETIM DIÁRIO");
                                    //define a mensagem
                                    builder.setMessage("IMÓVEL CADASTRADO COM SUCESSO!!");
                                    //define um botão como positivo
                                    builder.setPositiveButton("OK, ENTENDIDO!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface arg0, int arg1) {
                                        }
                                    });
                                    //cria o AlertDialog
                                    alerta = builder.create();
                                    //Exibe
                                    alerta.show();
                                    semana.setText("");
                                    numeroQuarteirao.setText("");
                                    ladoQuarteirao.setText("");
                                    logradouro.setText("");
                                    numeroImovel.setText("");
                                    sequencia.setText("");
                                    complemento.setText("");
                                    depositoEliminado.setText("");
                                    quantidadeLarvicida.setText("");
                                    depositoTratados.setText("");
                                    observacoes.setText("");

                                    bairroSpinner.setSelection(0);
                                    tipoImovelSpinner.setSelection(0);
                                    tipoVisitaSpinner.setSelection(0);
                                    tipoLarvicidaSpinner.setSelection(0);
                                    finalQuarteiraoSpinner.setSelection(0);
                                    cicloSpinner.setSelection(0);

                                    listarBoletimDiario();
                                }
                            } catch (Exception e) {
                                Log.v("CadastrarError", e.getMessage());
                            }///FIM DO SEGUNDO TRY

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }//FIM DO PRIMEIRO TRY.
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("ace", ace);
                params.put("data", data_completa);
                params.put("hora", hora_atual);
                params.put("ciclo", cicloSpinner.getSelectedItem().toString());
                params.put("semana", semana.getText().toString());
                params.put("bairro", bairroSpinner.getSelectedItem().toString());
                params.put("numeroQuarteirao", numeroQuarteirao.getText().toString());
                params.put("ladoQuarteirao", ladoQuarteirao.getText().toString());
                params.put("logradouro", logradouro.getText().toString());
                params.put("numeroImovel", numeroImovel.getText().toString());
                params.put("sequencia", sequencia.getText().toString());
                params.put("complemento", complemento.getText().toString());
                params.put("tipoImovel", tipoImovelSpinner.getSelectedItem().toString());
                params.put("tipoVisita", tipoVisitaSpinner.getSelectedItem().toString());
                params.put("depositoEliminado", depositoEliminado.getText().toString());
                params.put("tipoLarvicida", tipoLarvicidaSpinner.getSelectedItem().toString());
                params.put("quantidadelarvicida", quantidadeLarvicida.getText().toString());
                params.put("depositoTratado", depositoTratados.getText().toString());
                params.put("observacao", observacoes.getText().toString());
                params.put("terminoQuarteriao", finalQuarteiraoSpinner.getSelectedItem().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }//FIM

    //INICIO DO MÉTODO SALVAR
    public void buscarBoletimDiario() {
        RequestQueue requestQueue6 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest6 = new StringRequest(Request.Method.POST, URLbuscarBoletimDiario,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        //PRIMEIRO TRY/CATCH
                        try {
                            jsonObject = new JSONObject(response);

                            aceEditar = jsonObject.getString("ace");
                            data_completaEditar = jsonObject.getString("data");
                            hora_atualEditar = jsonObject.getString("hora");
                            cicloEditar = jsonObject.getString("ciclo");
                            semanaEditar = jsonObject.getString("semana");
                            bairroEditar = jsonObject.getString("bairro");
                            numeroQuarteiraoEditar = jsonObject.getString("numeroQuarteirao");
                            ladoQuarteiraoEditar = jsonObject.getString("ladoQuarteirao");
                            logradouroEditar = jsonObject.getString("logradouro");
                            numeroImovelEditar = jsonObject.getString("numeroImovel");
                            sequenciaEditar = jsonObject.getString("sequencia");
                            complementoEditar = jsonObject.getString("complemento");
                            tipoImovelEditar = jsonObject.getString("tipoImovel");
                            tipoVisitaEditar = jsonObject.getString("tipoVisita");
                            depositoEliminadoEditar = jsonObject.getString("depositoEliminado");
                            quantidadeLarvicidaEditar = jsonObject.getString("quantidadeLarvicida");
                            depositoTratadosEditar = jsonObject.getString("depositoTratado");
                            observacoesEditar = jsonObject.getString("observacao");
                            //tipoLarvicida = jsonObject.getString("erro");
                            finalQuarteiraoEditar = jsonObject.getString("terminoQuarteirao");

                            semana.setText(semanaEditar);
                            numeroQuarteirao.setText(numeroQuarteiraoEditar);
                            ladoQuarteirao.setText(ladoQuarteiraoEditar);
                            logradouro.setText(logradouroEditar);
                            numeroImovel.setText(numeroImovelEditar);
                            sequencia.setText(sequenciaEditar);
                            complemento.setText(complementoEditar);
                            depositoEliminado.setText(depositoEliminadoEditar);
                            quantidadeLarvicida.setText(quantidadeLarvicidaEditar);
                            depositoTratados.setText(depositoTratadosEditar);
                            observacoes.setText(observacoesEditar);

                            System.out.println(tipoImovelEditar);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                //params.put("ciclo", cicloPesquisa);
                //params.put("bairro", bairroPesquisa);
                // params.put("logradouro", logradouroPesquisa);
                //  params.put("numeroImovel", numeroImovelPesquisa);
                //  params.put("sequencia", sequenciaPesquisa);
                //  params.put("complemento", complementoPesquisa);
                return params;
            }
        };
        requestQueue6.add(stringRequest6);
    }//FIM
}
