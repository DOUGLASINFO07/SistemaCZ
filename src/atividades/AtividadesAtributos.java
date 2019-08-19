package atividades;

/**
 *
 * @author douglas borges egidio
 * @17/12/2018.
 *
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
        return getAtividade();
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
    
    

}
