package com.example.sistemacz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterBoletimDiario extends RecyclerView.Adapter<AdapterBoletimDiario.BoletimDiarioViewHolder>
        implements View.OnClickListener, View.OnLongClickListener {


    String URLbuscarBoletimDiario = "http://www.dimtech.com.br/sistemacz/buscarBoletimDiario.php";


    String bairroPesquisa;
    String logradouroPesquisa;
    String numeroImovelPesquisa;
    String sequenciaPesquisa;
    String complementoPesquisa;
    String cicloPesquisa;

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

    private Context mCtx;
    private List<BoletimDiario> boletimDiarioLista;

    public AdapterBoletimDiario(Context mCtx, List<BoletimDiario> boletimDiarioLista) {
        this.mCtx = mCtx;
        this.boletimDiarioLista = boletimDiarioLista;
    }

    @Override
    public BoletimDiarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_lista_imoveis_trabalhados, null);
        return new BoletimDiarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BoletimDiarioViewHolder holder, int position) {
        BoletimDiario boletimDiario = boletimDiarioLista.get(position);

        holder.textViewQuarteirao.setText(boletimDiario.getNumeroQuarteirao());
        holder.textViewBairro.setText(boletimDiario.getBairroSpinner());
        holder.textViewLogradouro.setText(boletimDiario.getLogradouro());
        holder.textViewNumeroImovel.setText(boletimDiario.getNumeroImovel());
        holder.textViewSequencia.setText(boletimDiario.getSequencia());
        holder.textViewComplemento.setText(boletimDiario.getComplemento());
        holder.textViewTipoVisita.setText(boletimDiario.getTipoVisitaspinner());
        holder.textViewCiclo.setText(boletimDiario.getCiclo());
    }

    @Override
    public int getItemCount() {
        return boletimDiarioLista.size();
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    class BoletimDiarioViewHolder extends RecyclerView.ViewHolder {

        TextView textViewQuarteirao,
                textViewBairro,
                textViewLogradouro,
                textViewNumeroImovel,
                textViewSequencia,
                textViewComplemento,
                textViewTipoVisita,
                textViewCiclo;

        private Context context;

        public BoletimDiarioViewHolder(final View itemView) {
            super(itemView);

            this.context = context;

            textViewQuarteirao = (TextView) itemView.findViewById(R.id.textViewQuarteirao);
            textViewBairro = (TextView) itemView.findViewById(R.id.textViewBairro);
            textViewLogradouro = (TextView) itemView.findViewById(R.id.textViewLogradouro);
            textViewNumeroImovel = (TextView) itemView.findViewById(R.id.textViewNumeroImovel);
            textViewSequencia = (TextView) itemView.findViewById(R.id.textViewTipoImovel);
            textViewComplemento = (TextView) itemView.findViewById(R.id.textViewComplemento);
            textViewTipoVisita = (TextView) itemView.findViewById(R.id.textViewTipoDenuncia);
            textViewCiclo = (TextView) itemView.findViewById(R.id.textViewCiclo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    String numeroQuarteirao = "";
                    String bairro = "";
                    String logradouro = "";
                    String numeroImovel = "";
                    String sequencia = "";
                    String complemento = "";
                    String tipoVisita = "";
                    String ciclo = "";

                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        numeroQuarteirao = boletimDiarioLista.get(pos).getNumeroQuarteirao();
                        bairro = boletimDiarioLista.get(pos).getBairroSpinner();
                        logradouro = boletimDiarioLista.get(pos).getLogradouro();
                        numeroImovel = boletimDiarioLista.get(pos).getNumeroImovel();
                        sequencia = boletimDiarioLista.get(pos).getSequencia();
                        complemento = boletimDiarioLista.get(pos).getComplemento();
                        tipoVisita = boletimDiarioLista.get(pos).getTipoVisitaspinner();
                        ciclo = boletimDiarioLista.get(pos).getCiclo();


                        bairroPesquisa = boletimDiarioLista.get(pos).getBairroSpinner();
                        cicloPesquisa = boletimDiarioLista.get(pos).getCiclo();
                        logradouroPesquisa = boletimDiarioLista.get(pos).getLogradouro();
                        sequenciaPesquisa = boletimDiarioLista.get(pos).getSequencia();
                        complementoPesquisa = boletimDiarioLista.get(pos).getComplemento();
                        numeroImovelPesquisa = boletimDiarioLista.get(pos).getNumeroImovel();



                        RequestQueue requestQueue6 = Volley.newRequestQueue(mCtx.getApplicationContext());
                        StringRequest stringRequest6 = new StringRequest(Request.Method.POST, URLbuscarBoletimDiario,
                                new Response.Listener<String>() {

                                    @Override
                                    public void onResponse(String response) {
                                        Intent intent = new Intent(v.getContext(), LancarServicoActivity.class);
                                        Bundle b = new Bundle();
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
                                            tipoLarvicidaEditar = jsonObject.getString("tipoLarvicida");
                                            quantidadeLarvicidaEditar = jsonObject.getString("quantidadeLarvicida");
                                            depositoTratadosEditar = jsonObject.getString("depositoTratado");
                                            observacoesEditar = jsonObject.getString("observacao");
                                            finalQuarteiraoEditar = jsonObject.getString("terminoQuarteirao");

                                            b.putString("ace", aceEditar);
                                            b.putString("data", data_completaEditar);
                                            b.putString("hora", hora_atualEditar);
                                            b.putString("ciclo", cicloEditar);
                                            b.putString("semana", semanaEditar);
                                            b.putString("bairro", bairroEditar);
                                            b.putString("numeroQuarteirao", numeroQuarteiraoEditar);
                                            b.putString("ladoQuarteirao", ladoQuarteiraoEditar);
                                            b.putString("logradouro", logradouroEditar);
                                            b.putString("numeroImovel", numeroImovelEditar);
                                            b.putString("sequencia", sequenciaEditar);
                                            b.putString("complemento", complementoEditar);
                                            b.putString("tipoImovel", tipoImovelEditar);
                                            b.putString("tipoVisita", tipoVisitaEditar);
                                            b.putString("depositoEliminado", depositoEliminadoEditar);
                                            b.putString("tipoLarvicida", tipoLarvicidaEditar);
                                            b.putString("quantidadeLarvicida", quantidadeLarvicidaEditar);
                                            b.putString("depositoTratado", depositoTratadosEditar);
                                            b.putString("observacao", observacoesEditar);
                                            b.putString("terminoQuarteirao", finalQuarteiraoEditar);
                                            intent.putExtras(b);
                                            v.getContext().startActivity(intent);

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
                                params.put("ciclo", cicloPesquisa);
                                params.put("bairro", bairroPesquisa);
                                params.put("logradouro", logradouroPesquisa);
                                params.put("numeroImovel", numeroImovelPesquisa);
                                params.put("sequencia", sequenciaPesquisa);
                                params.put("complemento", complementoPesquisa);
                                return params;
                            }
                        };
                        requestQueue6.add(stringRequest6);



                    }
                }
            });
        }
    }

    //INICIO DO MÉTODO SALVAR
    public void buscarBoletimDiario() {
        RequestQueue requestQueue6 = Volley.newRequestQueue(mCtx.getApplicationContext());
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
                            tipoLarvicidaEditar = jsonObject.getString("tipoLarvicida");
                            quantidadeLarvicidaEditar = jsonObject.getString("quantidadeLarvicida");
                            depositoTratadosEditar = jsonObject.getString("depositoTratado");
                            observacoesEditar = jsonObject.getString("observacao");
                            //tipoLarvicida = jsonObject.getString("erro");
                            finalQuarteiraoEditar = jsonObject.getString("terminoQuarteirao");

                            //System.out.println(semanaEditar);

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
                params.put("ciclo", cicloPesquisa);
                params.put("bairro", bairroPesquisa);
                params.put("logradouro", logradouroPesquisa);
                params.put("numeroImovel", numeroImovelPesquisa);
                params.put("sequencia", sequenciaPesquisa);
                params.put("complemento", complementoPesquisa);
                return params;
            }
        };
        requestQueue6.add(stringRequest6);
    }//FIM
}
