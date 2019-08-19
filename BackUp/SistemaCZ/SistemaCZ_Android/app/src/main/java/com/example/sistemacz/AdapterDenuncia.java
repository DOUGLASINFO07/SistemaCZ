package com.example.sistemacz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class AdapterDenuncia
        extends RecyclerView.Adapter<AdapterDenuncia.DenunciaViewHolder>
        implements View.OnClickListener, View.OnLongClickListener {

    String URLbuscarDenuncia = "http://www.dimtech.com.br/sistemacz/buscarDenuncia.php";

    String numeroDenunciaPesquisa;
    String bairroPesquisa;
    String logradouroPesquisa;
    String numeroImovelPesquisa;
    String tipoImovelPesquisa;
    String tipoDenunciaPesquisa;

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

    private Context mCtx;
    private List<Denuncia> denunciaLista;

    public AdapterDenuncia(Context mCtx, List<Denuncia> denunciaLista) {
        this.mCtx = mCtx;
        denunciaLista = denunciaLista;
    }

    @Override
    public DenunciaViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_lista_denuncia_lancada, null);
        return new DenunciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DenunciaViewHolder holder, int position) {
        Denuncia denuncia = denunciaLista.get(position);
        holder.textViewNumeroDenuncia.setText(denuncia.getNumeroDenuncia());
        holder.textViewBairro.setText(denuncia.getBairro());
        holder.textViewLogradouro.setText(denuncia.getLogradouro());
        holder.textViewNumeroImovel.setText(denuncia.getNumeroImovel());
        holder.textViewTipoImovel.setText(denuncia.getTipoImovel());
        holder.textViewTipoDenuncia.setText(denuncia.getTipoDenuncia());
    }

    @Override
    public int getItemCount() {
        return denunciaLista.size();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    class DenunciaViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNumeroDenuncia,
                textViewBairro,
                textViewLogradouro,
                textViewNumeroImovel,
                textViewTipoImovel,
                textViewTipoDenuncia;

        private Context context;

        public DenunciaViewHolder(final View itemView) {
            super(itemView);

            this.context = context;

            textViewNumeroDenuncia = (TextView) itemView.findViewById(R.id.textViewNumeroDenuncia);
            textViewBairro = (TextView) itemView.findViewById(R.id.textViewBairro);
            textViewLogradouro = (TextView) itemView.findViewById(R.id.textViewLogradouro);
            textViewNumeroImovel = (TextView) itemView.findViewById(R.id.textViewNumeroImovel);
            textViewTipoImovel = (TextView) itemView.findViewById(R.id.textViewTipoImovel);
            textViewTipoDenuncia = (TextView) itemView.findViewById(R.id.textViewTipoDenuncia);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {

                        numeroDenunciaPesquisa = denunciaLista.get(pos).getNumeroDenuncia();

                        RequestQueue requestQueue6 = Volley.newRequestQueue(mCtx.getApplicationContext());
                        StringRequest stringRequest6 = new StringRequest(Request.Method.POST, URLbuscarDenuncia,
                                new Response.Listener<String>() {

                                    @Override
                                    public void onResponse(String response) {
                                        Intent intent = new Intent(v.getContext(), LancarServicoActivity.class);
                                        Bundle b = new Bundle();
                                        JSONObject jsonObject = null;
                                        //PRIMEIRO TRY/CATCH
                                        try {
                                            jsonObject = new JSONObject(response);

                                            numeroDenunciaEditar = jsonObject.getInt("numeroDenuncia");
                                            denuncianteEditar = jsonObject.getString("denunciante");
                                            denunciadoEditar = jsonObject.getString("denunciado");
                                            logradouroEditar = jsonObject.getString("logradouro");
                                            numeroImovelEditar = jsonObject.getString("numeroImovel");
                                            bairroEditar = jsonObject.getString("bairro");
                                            tipoImovelEditar = jsonObject.getString("tipoImovel");
                                            tipoDenunciaEditar = jsonObject.getString("tipoDenuncia");
                                            detalhesDenunciaEditar = jsonObject.getString("detalhes");

                                            b.putInt("numeroDenuncia", numeroDenunciaEditar);
                                            b.putString("denunciante", denuncianteEditar);
                                            b.putString("denunciado", denunciadoEditar);
                                            b.putString("logradouro", logradouroEditar);
                                            b.putString("numeroImovel", numeroImovelEditar);
                                            b.putString("bairro", bairroEditar);
                                            b.putString("tipoImovel", tipoImovelEditar);
                                            b.putString("tipoDenuncia", tipoDenunciaEditar);
                                            b.putString("detalhes", detalhesDenunciaEditar);

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
                                params.put("bumeroDenuncia", numeroDenunciaPesquisa);
                                return params;
                            }
                        };
                        requestQueue6.add(stringRequest6);
                    }
                }
            });
        }
    }
}