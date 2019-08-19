package servicoTratamentoFocal;

/**
 * @author douglas borges egidio
 * @17/12/2018.
 */

public class ServicoTratamentoFocalAtributos {

    private String rg;
    private String localidade;
    private String categoria;
    private String tipo;
    private String zona;
    private String data;
    private String semana;
    private String ciclo;
    private String ace;
    private String supervisor;
    private String trabalhouQuarteirao;
    private String observacao;
    private int quarteirao;
    private String lados;
    private int residencia;
    private int comercio;
    private int terrenoBaldio;
    private int outros;
    private int visitaResgate;
    private int eliminado;
    private int tratado;
    private String larvicida;
    private double quantidadeLarvicida;
    private int quantTratados;
    private String situacaoQuarteirao;
    private int SomaParaConferirServicoLancado;
    private int SomaParaConferirServicoLancadoConcluido;

    public ServicoTratamentoFocalAtributos(
            String rg, 
            String localidade, 
            String categoria, 
            String tipo, 
            String zona,
            String data, 
            String semana,
            String ciclo, 
            String ace, 
            String supervisor, 
            String trabalhouQuarteirao, 
            String observacao, 
            int quarteirao, 
            String lados, 
            int residencia, 
            int comercio, 
            int terrenoBaldio,
            int outros,
            int visitaResgate, 
            int eliminado, 
            int tratado,
            String larvicida,
            double quantidadeLarvicida, 
            int quantTratados, 
            String situacaoQuarteirao
    ) {
        this.rg = rg;
        this.localidade = localidade;
        this.categoria = categoria;
        this.tipo = tipo;
        this.zona = zona;
        this.data = data;
        this.semana = semana;
        this.ciclo = ciclo;
        this.ace = ace;
        this.supervisor = supervisor;
        this.trabalhouQuarteirao = trabalhouQuarteirao;
        this.observacao = observacao;
        this.quarteirao = quarteirao;
        this.lados = lados;
        this.residencia = residencia;
        this.comercio = comercio;
        this.terrenoBaldio = terrenoBaldio;
        this.outros = outros;
        this.visitaResgate = visitaResgate;
        this.eliminado = eliminado;
        this.tratado = tratado;
        this.larvicida = larvicida;
        this.quantidadeLarvicida = quantidadeLarvicida;
        this.quantTratados = quantTratados;
        this.situacaoQuarteirao = situacaoQuarteirao;
    }
    
    @Override
    public String toString() {
        return getLarvicida();
    }

    public ServicoTratamentoFocalAtributos() {

    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAce() {
        return ace;
    }

    public void setAce(String ace) {
        this.ace = ace;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTrabalhouQuarteirao() {
        return trabalhouQuarteirao;
    }

    public void setTrabalhouQuarteirao(String trabalhouQuarteirao) {
        this.trabalhouQuarteirao = trabalhouQuarteirao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getLados() {
        return lados;
    }

    public void setLados(String lados) {
        this.lados = lados;
    }

    public int getResidencia() {
        return residencia;
    }

    public void setResidencia(int residencia) {
        this.residencia = residencia;
    }

    public int getComercio() {
        return comercio;
    }

    public void setComercio(int comercio) {
        this.comercio = comercio;
    }

    public int getTerrenoBaldio() {
        return terrenoBaldio;
    }

    public void setTerrenoBaldio(int terrenoBaldio) {
        this.terrenoBaldio = terrenoBaldio;
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }

    public int getVisitaResgate() {
        return visitaResgate;
    }

    public void setVisitaResgate(int visitaResgate) {
        this.visitaResgate = visitaResgate;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    public int getTratado() {
        return tratado;
    }

    public void setTratado(int tratado) {
        this.tratado = tratado;
    }

    public String getLarvicida() {
        return larvicida;
    }

    public void setLarvicida(String larvicida) {
        this.larvicida = larvicida;
    }

    public double getQuantidadeLarvicida() {
        return quantidadeLarvicida;
    }

    public void setQuantidadeLarvicida(double quantidadeLarvicida) {
        this.quantidadeLarvicida = quantidadeLarvicida;
    }

    public int getQuantTratados() {
        return quantTratados;
    }

    public void setQuantTratados(int quantTratados) {
        this.quantTratados = quantTratados;
    }

    public String getSituacaoQuarteirao() {
        return situacaoQuarteirao;
    }

    public void setSituacaoQuarteirao(String situacaoQuarteirao) {
        this.situacaoQuarteirao = situacaoQuarteirao;
    }

    public int getSomaParaConferirServicoLancado() {
        return SomaParaConferirServicoLancado;
    }

    public void setSomaParaConferirServicoLancado(int SomaParaConferirServicoLancado) {
        this.SomaParaConferirServicoLancado = SomaParaConferirServicoLancado;
    }
    
    public int getSomaParaConferirServicoLancadoConcluido() {
        return SomaParaConferirServicoLancadoConcluido;
    }

    public void setSomaParaConferirServicoLancadoConcluido(int SomaParaConferirServicoLancadoConcluido) {
        this.SomaParaConferirServicoLancadoConcluido = SomaParaConferirServicoLancadoConcluido;
    }

}
