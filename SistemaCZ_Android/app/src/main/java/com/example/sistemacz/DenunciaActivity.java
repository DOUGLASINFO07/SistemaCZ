package com.example.sistemacz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
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

public class DenunciaActivity extends AppCompatActivity {

    Button buttonSalvar,
            buttonCorrigir,
            buttonExcluir,
            buttonListar,
            buttonNova;

    EditText numeroDenuncia,
            denunciante,
            denunciado,
            logradouro,
            numeroImovel,
            detalhes;

    Spinner bairroSpinner,
            tipoImovelSpinner,
            tipoDenunciaSpinner;

    TextView totalProducao;

    String URLSalvarDenunica = "http://www.dimtech.com.br/sistemacz/denuncia/salvarDenuncia.php";
    String URLListarBairro = "http://www.dimtech.com.br/sistemacz/denuncia/listarBairro.php";
    String URLListarDenuncia = "http://www.dimtech.com.br/sistemacz/denuncia/listarDenuncia.php";
    String URLCorrigirDenuncia = "http://www.dimtech.com.br/sistemacz/denuncia/corrigirDenuncia.php";
    String URLExcluirDenuncia = "http://www.dimtech.com.br/sistemacz/denuncia/apagarDenuncia.php";
    String URLContarNumeroDenuncia = "http://www.dimtech.com.br/sistemacz/denuncia/contarNumeroDenuncia.php";

    public RecyclerView recyclerView;

    StringRequest stringRequest;
    RequestQueue requestQueue;

    String ace;

    String data_completa, hora_atual;

    ArrayList<String> bairroLista;
    ArrayList<String> tipoImovelLista;
    ArrayList<String> tipoDenunciaLista;

    List<Denuncia> denunciaLista;

    int bairroPesquisa;
    int tipoImovelPesquisa;
    int tipoDenunciaPesquisa;

    int numeroDenunciaEditar;
    String dataDenunciaEditar;
    String recebidaPorEditar;
    String denuncianteEditar;
    String denunciadoEditar;
    String logradouroEditar;
    String numeroImovelEditar;
    String bairroEditar;
    String tipoImovelEditar;
    String tipoDenunciaEditar;
    String detalhesDenunciaEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);

        //METODO DESABILITAR EDITTEXT PARA INSERIR TEXTO.
        // numeroDenuncia.setInputType(InputType.TYPE_NULL);

        bairroLista = new ArrayList<>();
        tipoImovelLista = new ArrayList<>();
        tipoDenunciaLista = new ArrayList<>();

        listarDenuncia();

        requestQueue = Volley.newRequestQueue(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        data_completa = dateFormat.format(data_atual);
        hora_atual = dateFormat_hora.format(data_atual);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonCorrigir = (Button) findViewById(R.id.buttonCorrigir);
        buttonExcluir = (Button) findViewById(R.id.buttonExcluir);
        buttonNova = (Button) findViewById(R.id.buttonNova);
        buttonListar = (Button) findViewById(R.id.buttonListar);

        totalProducao = (TextView) findViewById(R.id.textViewTotalProducao);

        numeroDenuncia = (EditText) findViewById(R.id.editTextNumeroDenuncia);
        denunciante = (EditText) findViewById(R.id.editTextDenunciante);
        denunciado = (EditText) findViewById(R.id.editTextDenunciado);
        logradouro = (EditText) findViewById(R.id.editTextLogradouro);
        numeroImovel = (EditText) findViewById(R.id.editTextNumeroImovel);
        detalhes = (EditText) findViewById(R.id.editTextDetalhes);

        bairroSpinner = (Spinner) findViewById(R.id.spinnerBairro);
        tipoImovelSpinner = (Spinner) findViewById(R.id.spinnerTipoImovel);
        tipoDenunciaSpinner = (Spinner) findViewById(R.id.spinnerTipoDenuncia);

        denunciante.setEnabled(false);
        denunciado.setEnabled(false);
        logradouro.setEnabled(false);
        numeroImovel.setEnabled(false);
        bairroSpinner.setEnabled(false);
        tipoImovelSpinner.setEnabled(false);
        tipoDenunciaSpinner.setEnabled(false);
        detalhes.setEnabled(false);

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        Bundle bundleDenuncia = getIntent().getExtras();

        if (bundleDenuncia != null) {

            numeroDenunciaEditar = bundleDenuncia.getInt("numeroDenuncia");
            dataDenunciaEditar = bundleDenuncia.getString("dataDenuncia");
            recebidaPorEditar = bundleDenuncia.getString("recebidaPor");
            denuncianteEditar = bundleDenuncia.getString("denunciante");
            denunciadoEditar = bundleDenuncia.getString("denunciado");
            logradouroEditar = bundleDenuncia.getString("logradouro");
            numeroImovelEditar = bundleDenuncia.getString("numeroEndereco");
            bairroEditar = bundleDenuncia.getString("bairro");
            tipoImovelEditar = bundleDenuncia.getString("tipoImovel");
            tipoDenunciaEditar = bundleDenuncia.getString("tipoDenuncia");
            detalhesDenunciaEditar = bundleDenuncia.getString("detalhesDenuncia");

            tipoDenunciaSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoDenunciaLista.add("** SELECIONE AQUI! **");
            tipoDenunciaLista.add("Aedes Aegypti");
            tipoDenunciaLista.add("Cães e Gatos");
            tipoDenunciaLista.add("Caixa d'agua");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Casa Abandonada");
            tipoDenunciaLista.add("Construção");
            tipoDenunciaLista.add("Escorpião");
            tipoDenunciaLista.add("Imóvel Fechado");
            tipoDenunciaLista.add("Morcego");
            tipoDenunciaLista.add("Pneus");
            tipoDenunciaLista.add("Pombo");
            tipoDenunciaLista.add("Rato");
            tipoDenunciaLista.add("Terreno Baldio");
            tipoDenunciaLista.add("Triatomínio(Barbeiro)");
            tipoDenunciaSpinner.setAdapter(new ArrayAdapter<String>(
                    DenunciaActivity.this,
                    R.layout.spinner_dropdown, tipoDenunciaLista));
            tipoDenunciaPesquisa = tipoDenunciaLista.indexOf(tipoDenunciaEditar);
            tipoDenunciaSpinner.setSelection(tipoDenunciaPesquisa);

            tipoImovelSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoImovelLista.add("** SELECIONE AQUI! **");
            tipoImovelLista.add("Residência");
            tipoImovelLista.add("Comércio");
            tipoImovelLista.add("Terreno Baldio");
            tipoImovelLista.add("Outros");
            tipoImovelSpinner.setAdapter(new ArrayAdapter<String>(
                    DenunciaActivity.this,
                    R.layout.spinner_dropdown, tipoImovelLista));
            tipoImovelPesquisa = tipoImovelLista.indexOf(tipoImovelEditar);
            tipoImovelSpinner.setSelection(tipoImovelPesquisa);

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
                                        DenunciaActivity.this,
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

            numeroDenuncia.setText("" + numeroDenunciaEditar);
            denunciante.setText(denuncianteEditar);
            denunciado.setText(denunciadoEditar);
            logradouro.setText(logradouroEditar);
            numeroImovel.setText(numeroImovelEditar);
            detalhes.setText(detalhesDenunciaEditar);

            if(dataDenunciaEditar != null) {
                buttonCorrigir.setVisibility(View.VISIBLE);
                buttonExcluir.setVisibility(View.VISIBLE);
                numeroDenuncia.setEnabled(false);
                denunciante.setEnabled(true);
                denunciado.setEnabled(true);
                logradouro.setEnabled(true);
                numeroImovel.setEnabled(true);
                bairroSpinner.setEnabled(true);
                tipoImovelSpinner.setEnabled(true);
                tipoDenunciaSpinner.setEnabled(true);
                detalhes.setEnabled(true);
            }else{
                buttonCorrigir.setVisibility(View.INVISIBLE);
                buttonExcluir.setVisibility(View.INVISIBLE);

            }
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        denunciaLista = new ArrayList<>();

        //contarNumeroDenuncia();

        //INICIO DO METODO DO BOTAO SALVAR.
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado = true;
                if ("** SELECIONE AQUI! **".equals(bairroSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    bairroSpinner.requestFocus();
                    validado = false;
                }
                if (denunciante.getText().length() == 0) {
                    denunciante.setError("Campo Obrigatório!");
                    denunciante.requestFocus();
                    validado = false;
                }
                if ("** SELECIONE AQUI **!".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    tipoImovelSpinner.requestFocus();
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
                if ("** SELECIONE AQUI! **".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Campo Tipo de Imovel é Obrigatório!!!", Toast.LENGTH_LONG).show();
                    tipoImovelSpinner.requestFocus();
                    validado = false;
                }
                if (detalhes.getText().length() == 0) {
                    detalhes.setError("Campo Obrigatório!");
                    detalhes.requestFocus();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                //define o titulo
                builder.setTitle("CONTROLE DE DENÚNCIAS");
                //define a mensagem
                builder.setMessage("CONFIRMA A CORREÇÃO?");
                //define um botão como positivo
                builder.setPositiveButton("SIM, PODE CONFIRMAR!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        boolean validado = true;
                        if ("** SELECIONE AQUI! **".equals(bairroSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            bairroSpinner.requestFocus();
                            validado = false;
                        }
                        if (denunciante.getText().length() == 0) {
                            denunciante.setError("Campo Obrigatório!");
                            denunciante.requestFocus();
                            validado = false;
                        }
                        if ("** SELECIONE AQUI **!".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Bairro é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            tipoImovelSpinner.requestFocus();
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
                        if ("** SELECIONE AQUI! **".equals(tipoImovelSpinner.getSelectedItem().toString())) {
                            Toast.makeText(getApplicationContext(),
                                    "Campo Tipo de Imovel é Obrigatório!!!", Toast.LENGTH_LONG).show();
                            tipoImovelSpinner.requestFocus();
                            validado = false;
                        }
                        if (detalhes.getText().length() == 0) {
                            detalhes.setError("Campo Obrigatório!");
                            detalhes.requestFocus();
                            validado = false;
                        }
                        if (validado) {
                            Toast.makeText(getApplicationContext(), "VALIDANDO OS DADOS... AGUARDE...",
                                    Toast.LENGTH_SHORT).show();

                            atualizar();

                            //   Toast.makeText(getApplicationContext(), "DADOS CORRIGIDOS!!",
                            //        Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                //define o titulo
                builder.setTitle("CONTROLE  DE DENÚNCIA");
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

                listarDenuncia();

                numeroDenuncia.setEnabled(false);
                denunciante.setEnabled(false);
                denunciado.setEnabled(false);
                logradouro.setEnabled(false);
                numeroImovel.setEnabled(false);
                bairroSpinner.setEnabled(false);
                tipoImovelSpinner.setEnabled(false);
                tipoDenunciaSpinner.setEnabled(false);
                detalhes.setEnabled(false);



                Toast.makeText(getApplicationContext(),
                        "lista Concluida!!!", Toast.LENGTH_LONG).show();
                //  METODO PARA ACULTAR TECLADO
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
            }
        });//FIM

        //METODO BOTAO LISTAR
        buttonNova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contarNumeroDenuncia();

                numeroDenuncia.setText("");
                denunciante.setText("");
                denunciado.setText("");
                logradouro.setText("");
                numeroImovel.setText("");
                detalhes.setText("");

                bairroSpinner.setSelection(0);
                tipoImovelSpinner.setSelection(0);
                tipoDenunciaSpinner.setSelection(0);

                numeroDenuncia.setEnabled(false);
                denunciante.setEnabled(true);
                denunciado.setEnabled(true);
                logradouro.setEnabled(true);
                numeroImovel.setEnabled(true);
                bairroSpinner.setEnabled(true);
                tipoImovelSpinner.setEnabled(true);
                tipoDenunciaSpinner.setEnabled(true);
                detalhes.setEnabled(true);

                denunciante.requestFocus();

                buttonSalvar.setVisibility(View.VISIBLE);
                buttonCorrigir.setVisibility(View.INVISIBLE);
                buttonExcluir.setVisibility(View.INVISIBLE);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
            }
        });//FIM

    }//FIM DO CREATE().

    public void contarNumeroDenuncia() {
        RequestQueue requestQueueDenuncia = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestDenuncia = new StringRequest(Request.Method.POST, URLContarNumeroDenuncia,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObjectDenuncia = null;
                        int isErro;
                        //PRIMEIRO TRY/CATCH
                        try {
                            jsonObjectDenuncia = new JSONObject(response);
                            numeroDenuncia.setText("" + (jsonObjectDenuncia.getInt("contagem") + 1));
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
        );
        requestQueueDenuncia.add(stringRequestDenuncia);
    }

    @Override
    public void onBackPressed() {

        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
        //define o titulo
        builder.setTitle("CONTROLE DE DENÚNCIA");
        //define a mensagem
        builder.setMessage("SAIR DA TELA GERAR DENÚNCIA?");
        //define um botão como positivo
        builder.setPositiveButton("SIM, VOU SAIR!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Intent intent = new Intent(DenunciaActivity.this, TelaDenunciaActivity.class);
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

        //define um botão como FECHAR APLICAÇÃO.
        builder.setNeutralButton("FECHAR APLICAÇÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finishAffinity();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }//FIM DO OnBackPressed().

    //METODO QUE ADICIONA NA LISTA, OS IMÓVEIS LANÇADOS.
    private void listarDenuncia() {
        RequestQueue requestQueue8 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest8 = new StringRequest(Request.Method.GET, URLListarDenuncia,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //MÉTODO PARA LIMPA RO RECYCLERVIEW
                        // boletimDiarioLista.clear();
                        //FIM.
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);
                            denunciaLista.clear();
                            totalProducao.setText("" + 0);
                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                totalProducao.setText("" + (i + 1));

                                //getting product object from json array
                                JSONObject denuncia = array.getJSONObject(i);

                                //adding the product to product list
                                denunciaLista.add(new Denuncia(
                                        denuncia.getInt("numeroDenuncia"),
                                        denuncia.getString("logradouro"),
                                        denuncia.getString("numeroEndereco"),
                                        denuncia.getString("bairro"),
                                        denuncia.getString("tipoImovel"),
                                        denuncia.getString("tipoDenuncia")
                                ));

                                buttonSalvar.setVisibility(View.INVISIBLE);

                            }
                            //creating adapter object and setting it to recyclerView
                            AdapterDenuncia adapter = new AdapterDenuncia(
                                    DenunciaActivity.this,
                                    denunciaLista);
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

        final Utilitario util = new Utilitario();

        RequestQueue requestQueueExcluir = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestExcluir = new StringRequest(Request.Method.POST, URLExcluirDenuncia,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObjectExcluir = null;

                        AlertDialog alerta;
                        //Cria o gerador do AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                        //define o titulo
                        builder.setTitle("CONTROLE DE DENÚNCIAS");
                        //define a mensagem
                        builder.setMessage("ESTE DENUNCIA FOI EXCLUÍDA COM SUCESSO!!");
                        //define um botão como positivo
                        builder.setPositiveButton("OK, ENTENDIDO!!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                        //cria o AlertDialog
                        alerta = builder.create();
                        //Exibe
                        alerta.show();

                        numeroDenuncia.setText("");
                        denunciante.setText("");
                        denunciado.setText("");
                        logradouro.setText("");
                        numeroImovel.setText("");
                        detalhes.setText("");

                        bairroSpinner.setSelection(0);
                        tipoImovelSpinner.setSelection(0);
                        tipoDenunciaSpinner.setSelection(0);

                        numeroDenuncia.setEnabled(false);
                        denunciante.setEnabled(false);
                        denunciado.setEnabled(false);
                        logradouro.setEnabled(false);
                        numeroImovel.setEnabled(false);
                        bairroSpinner.setEnabled(false);
                        tipoImovelSpinner.setEnabled(false);
                        tipoDenunciaSpinner.setEnabled(false);
                        detalhes.setEnabled(false);

                        listarDenuncia();

                        buttonCorrigir.setVisibility(View.INVISIBLE);
                        buttonExcluir.setVisibility(View.INVISIBLE);

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

                params.put("numeroDenuncia", "" + numeroDenunciaEditar);

                return params;
            }
        };
        requestQueueExcluir.add(stringRequestExcluir);
    }//FIM.

    //INICIO DO METODO QUE ATUALIZA OS DADOS.
    private void atualizar() {

        final Utilitario util = new Utilitario();

        RequestQueue requestQueueAtualizar = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestAtualizar = new StringRequest(Request.Method.POST, URLCorrigirDenuncia,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObjectAtualizar;

                        AlertDialog alerta;
                        //Cria o gerador do AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                        //define o titulo
                        builder.setTitle("CONTROLE DE DENÚNCIAS");
                        //define a mensagem
                        builder.setMessage("ESTA DENUNCIA FOI CORRIGIDA COM SUCESSO!");
                        //define um botão como positivo
                        builder.setPositiveButton("OK, ENTENDIDO!!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                        //cria o AlertDialog
                        alerta = builder.create();
                        //Exibe
                        alerta.show();

                        numeroDenuncia.setText("");
                        denunciante.setText("");
                        denunciado.setText("");
                        logradouro.setText("");
                        numeroImovel.setText("");
                        detalhes.setText("");

                        bairroSpinner.setSelection(0);
                        tipoImovelSpinner.setSelection(0);
                        tipoDenunciaSpinner.setSelection(0);

                        numeroDenuncia.setEnabled(false);
                        denunciante.setEnabled(false);
                        denunciado.setEnabled(false);
                        logradouro.setEnabled(false);
                        numeroImovel.setEnabled(false);
                        bairroSpinner.setEnabled(false);
                        tipoImovelSpinner.setEnabled(false);
                        tipoDenunciaSpinner.setEnabled(false);
                        detalhes.setEnabled(false);

                        listarDenuncia();

                        buttonCorrigir.setVisibility(View.INVISIBLE);
                        buttonExcluir.setVisibility(View.INVISIBLE);
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
                params.put("numeroDenuncia", "" + numeroDenunciaEditar);
                params.put("denunciante", denunciante.getText().toString());
                params.put("denunciado", denunciado.getText().toString());
                params.put("logradouro", logradouro.getText().toString());
                params.put("numeroEndereco", numeroImovel.getText().toString());
                params.put("bairro", bairroSpinner.getSelectedItem().toString());
                params.put("tipoImovel", tipoImovelSpinner.getSelectedItem().toString());
                params.put("tipoDenuncia", tipoDenunciaSpinner.getSelectedItem().toString());
                params.put("detalhesDenuncia", detalhes.getText().toString());

                return params;
            }
        };
        requestQueueAtualizar.add(stringRequestAtualizar);
    }//FIM.

    //INICIO DO MÉTODO SALVAR
    private void salvar() {

        final Utilitario util = new Utilitario();

        RequestQueue requestQueueSalvar = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestSalvar = new StringRequest(Request.Method.POST, URLSalvarDenunica,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if (response == "" + 2) {
                                AlertDialog alerta;
                                //Cria o gerador do AlertDialog
                                AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                                //define o titulo
                                builder.setTitle("CONTROLE DE DENÚNCIAS");
                                //define a mensagem
                                builder.setMessage("ESTA DENUNCIA JÁ FOI LANÇADA!!");
                                //define um botão como positivo
                                builder.setPositiveButton("OK, VOU CONFERIR O QUE ACONTECEU!!", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface arg0, int arg1) {
                                    }
                                });
                                //cria o AlertDialog
                                alerta = builder.create();
                                //Exibe
                                alerta.show();
                                denunciante.requestFocus();
                            } else {
                                AlertDialog alerta;
                                //Cria o gerador do AlertDialog
                                AlertDialog.Builder builder = new AlertDialog.Builder(DenunciaActivity.this);
                                //define o titulo
                                builder.setTitle("CONTROLE DE DENÚNCIAS");
                                //define a mensagem
                                builder.setMessage("DENUNCIA CADASTRADA COM SUCESSO!!");
                                //define um botão como positivo
                                builder.setPositiveButton("OK, ENTENDIDO!", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface arg0, int arg1) {
                                    }
                                });
                                //cria o AlertDialog
                                alerta = builder.create();
                                //Exibe
                                alerta.show();

                                numeroDenuncia.setText("");
                                denunciante.setText("");
                                denunciado.setText("");
                                logradouro.setText("");
                                numeroImovel.setText("");
                                detalhes.setText("");

                                bairroSpinner.setSelection(0);
                                tipoImovelSpinner.setSelection(0);
                                tipoDenunciaSpinner.setSelection(0);

                                numeroDenuncia.setEnabled(false);
                                denunciante.setEnabled(false);
                                denunciado.setEnabled(false);
                                logradouro.setEnabled(false);
                                numeroImovel.setEnabled(false);
                                bairroSpinner.setEnabled(false);
                                tipoImovelSpinner.setEnabled(false);
                                tipoDenunciaSpinner.setEnabled(false);
                                detalhes.setEnabled(false);

                                listarDenuncia();

                                buttonSalvar.setVisibility(View.INVISIBLE);

                            }
                        } catch (Exception e) {
                            Log.v("Cad. Denuncias Error", e.getMessage());
                        }///FIM DO SEGUNDO TRY
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
                params.put("numeroDenuncia", "" + numeroDenuncia.getText().toString());
                params.put("data", util.converterDataBrasilAmericano(data_completa));
                params.put("recebidaPor", ace);
                params.put("denunciante", denunciante.getText().toString());
                params.put("denunciado", denunciado.getText().toString());
                params.put("logradouro", logradouro.getText().toString());
                params.put("numeroEndereco", numeroImovel.getText().toString());
                params.put("bairro", bairroSpinner.getSelectedItem().toString());
                params.put("tipoImovel", tipoImovelSpinner.getSelectedItem().toString());
                params.put("tipoDenuncia", tipoDenunciaSpinner.getSelectedItem().toString());
                params.put("detalhesDenuncia", detalhes.getText().toString());

                return params;
            }
        };
        requestQueueSalvar.add(stringRequestSalvar);
    }//FIM

}