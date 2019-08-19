package com.example.sistemacz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DenunciaActivity extends AppCompatActivity {

    Button buttonSalvar,
            buttonCorrigir,
            buttonExcluir,
            buttonLimpar,
            buttonListar;

    EditText numeroDenuncia,
            denunciante,
            denunciado,
            logradouro,
            numeroImovel,
            detalhes;

    Spinner bairroSpinner,
            tipImovelSpinner,
            tipoDenunciaSpinner;

    String URLSalvarDenunica = "http://www.dimtech.com.br/sistemacz/salvar1.php";
    String URLListarBairro = "http://www.dimtech.com.br/sistemacz/listarBairro.php";
    String URLListarDenuncia = "http://www.dimtech.com.br/sistemacz/listarBoletimDiario.php";
    String URLCorrigirDenuncia = "http://www.dimtech.com.br/sistemacz/corrigir.php";
    String URLExcluirDenuncia = "http://www.dimtech.com.br/sistemacz/apagar.php";

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
    String denuncianteEditar;
    String denunciadoEditar;
    String aceEditarEditar;
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
        buttonListar = (Button) findViewById(R.id.buttonListar);
        buttonLimpar = (Button) findViewById(R.id.buttonLimpar);
/*
        textViewNumeroDenuncia = (TextView) itemView.findViewById(R.id.textViewNumeroDenuncia);
        textViewBairro = (TextView) itemView.findViewById(R.id.textViewBairro);
        textViewLogradouro = (TextView) itemView.findViewById(R.id.textViewLogradouro);
        textViewNumeroImovel = (TextView) itemView.findViewById(R.id.textViewNumeroImovel);
        textViewTipoImovel = (TextView) itemView.findViewById(R.id.textViewTipoImovel);
        textViewTipoDenuncia = (TextView) itemView.findViewById(R.id.textViewTipoDenuncia);
      */

        Intent it = getIntent();
        ace = it.getStringExtra("ace");

        Bundle b = getIntent().getExtras();

        if (b != null) {

            numeroDenunciaEditar = b.getInt("numeroDenuncia");
            denuncianteEditar = b.getString("denunciante");
            denunciadoEditar = b.getString("denunciado");
            logradouroEditar = b.getString("logradouro");
            numeroImovelEditar = b.getString("numeroImovel");
            bairroEditar = b.getString("bairro");
            tipoImovelEditar = b.getString("tipoImovel");
            tipoDenunciaEditar = b.getString("tipoDenuncia");
            detalhesDenunciaEditar = b.getString("detalhes");

            tipoDenunciaSpinner.getBackground().setColorFilter(
                    Color.parseColor("#DCAE1D"), PorterDuff.Mode.SRC_ATOP);
            tipoDenunciaLista.add("**Selecione o Tipo de Denuncia!**");
            tipoDenunciaLista.add("Aedes Aegypti");
            tipoDenunciaLista.add("Cães e Gatos");
            tipoDenunciaLista.add("Caixa d'agua");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Casa Abandonada");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoDenunciaLista.add("Caramujo");
            tipoImovelSpinner.setAdapter(new ArrayAdapter<String>(
                    LancarServicoActivity.this,
                    R.layout.spinner_dropdown, tipoImovelLista));
            tipoImovelPesquisa = tipoImovelLista.indexOf(tipoImovelEditar);
            tipoImovelSpinner.setSelection(tipoImovelPesquisa);


    }
}
