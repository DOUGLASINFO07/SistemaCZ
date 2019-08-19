package relatorioAtividades;

/**
 * @author douglas borges egidio
 * @25/03/2019
 */

public class RelatorioAtividadesAtributos {
    
    

    private String tipoAtividadeCT;
    private String dataInicial;
    private String datatermino;
    private String ciclo;
    private String pesquisarPor;

    public RelatorioAtividadesAtributos() {
    }

    public RelatorioAtividadesAtributos(
            String tipoAtividadeCT, 
            String dataInicial, 
            String datatermino, 
            String ciclo,
            String pesquisarPor
    ) {
        this.tipoAtividadeCT = tipoAtividadeCT;
        this.dataInicial = dataInicial;
        this.datatermino = datatermino;
        this.ciclo = ciclo;
        this.pesquisarPor = pesquisarPor;
    }

    public String getPesquisarPor() {
        return pesquisarPor;
    }

    public void setPesquisarPor(String pesquisarPor) {
        this.pesquisarPor = pesquisarPor;
    }

    public String getTipoAtividadeCT() {
        return tipoAtividadeCT;
    }

    public void setTipoAtividadeCT(String tipoAtividadeCT) {
        this.tipoAtividadeCT = tipoAtividadeCT;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
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
    
}
