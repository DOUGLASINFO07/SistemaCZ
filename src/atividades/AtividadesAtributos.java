package atividades;

import java.util.Objects;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @17/12/2018.
 */

public class AtividadesAtributos {

    private String atividade;
    private String dataInicio;
    private String datatermino ;
    private String ciclo;
    private String observacao;
    private int atividadesContadas;
    private String nomeAtividade;

    public AtividadesAtributos(
            String atividade, 
            String dataInicio, 
            String datatermino, 
            String ciclo, 
            String observacao,
            int atividadesContadas,
            String nomeAtividade
    ) {
        this.atividade = atividade;
        this.dataInicio = dataInicio;
        this.datatermino = datatermino;
        this.ciclo = ciclo;
        this.observacao = observacao;
        this.atividadesContadas = atividadesContadas;
        this.nomeAtividade = nomeAtividade;
    }

    @Override
    public String toString() {
        return atividade;
    }

    public AtividadesAtributos() {

    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(String datatermino) {
        this.datatermino = datatermino;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getAtividadesContadas() {
        return atividadesContadas;
    }

    public void setAtividadesContadas(int atividadesContadas) {
        this.atividadesContadas = atividadesContadas;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.atividade);
        hash = 17 * hash + Objects.hashCode(this.dataInicio);
        hash = 17 * hash + Objects.hashCode(this.datatermino);
        hash = 17 * hash + Objects.hashCode(this.ciclo);
        hash = 17 * hash + Objects.hashCode(this.observacao);
        hash = 17 * hash + this.atividadesContadas;
        hash = 17 * hash + Objects.hashCode(this.nomeAtividade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtividadesAtributos other = (AtividadesAtributos) obj;
        if (this.atividadesContadas != other.atividadesContadas) {
            return false;
        }
        if (!Objects.equals(this.atividade, other.atividade)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.datatermino, other.datatermino)) {
            return false;
        }
        if (!Objects.equals(this.ciclo, other.ciclo)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.nomeAtividade, other.nomeAtividade)) {
            return false;
        }
        return true;
    }
    
    

}
