package com.example.sistemacz;

public class BoletimDiario {

   private String tipoImovelspinner;
    private String TipoLarvicidaspinner;
    private String TipoVisitaspinner;
    private String FinalQuarteiraospinner;
    private String semana;
    private String numeroQuarteirao;
    private String ladoQuarteirao;
    private String logradouro;
    private String numeroImovel;
    private String sequencia;
    private String complemento;
    private String  depositoEliminado;
    private String quantidadeLarvicida;
    private String depositoTratados;
    private String  observacoes;
    private String cicloSpinner;
    private String bairroSpinner;
    private String  ace;
    private String  data_completa;
    private String hora_atual;
    private String ciclo;

    public BoletimDiario(){

    }

    public BoletimDiario(String tipoVisitaspinner,
                         String numeroQuarteirao,
                         String logradouro,
                         String numeroImovel,
                         String sequencia,
                         String complemento,
                         String bairroSpinner,
                         String ciclo) {
        this.TipoVisitaspinner = tipoVisitaspinner;
        this.numeroQuarteirao = numeroQuarteirao;
        this.logradouro = logradouro;
        this.numeroImovel = numeroImovel;
        this.sequencia = sequencia;
        this.complemento = complemento;
        this.bairroSpinner = bairroSpinner;
        this.ciclo = ciclo;
    }

    public BoletimDiario(String tipoImovelspinner,
                         String tipoLarvicidaspinner,
                         String tipoVisitaspinner,
                         String finalQuarteiraospinner,
                         String semana,
                         String numeroQuarteirao,
                         String ladoQuarteirao,
                         String logradouro,
                         String numeroImovel,
                         String sequencia,
                         String complemento,
                         String depositoEliminado,
                         String quantidadeLarvicida,
                         String depositoTratados,
                         String observacoes,
                         String cicloSpinner,
                         String bairroSpinner,
                         String ace,
                         String data_completa,
                         String hora_atual) {

        this.tipoImovelspinner = tipoImovelspinner;
        this.TipoLarvicidaspinner = tipoLarvicidaspinner;
        this.TipoVisitaspinner = tipoVisitaspinner;
        this.FinalQuarteiraospinner = finalQuarteiraospinner;
        this.semana = semana;
        this.numeroQuarteirao = numeroQuarteirao;
        this.ladoQuarteirao = ladoQuarteirao;
        this.logradouro = logradouro;
        this.numeroImovel = numeroImovel;
        this.sequencia = sequencia;
        this.complemento = complemento;
        this.depositoEliminado = depositoEliminado;
        this.quantidadeLarvicida = quantidadeLarvicida;
        this.depositoTratados = depositoTratados;
        this.observacoes = observacoes;
        this.cicloSpinner = cicloSpinner;
        this.bairroSpinner = bairroSpinner;
        this.ace = ace;
        this.data_completa = data_completa;
        this.hora_atual = hora_atual;
    }

    public String getTipoImovelspinner() {
        return tipoImovelspinner;
    }

    public void setTipoImovelspinner(String tipoImovelspinner) {
        this.tipoImovelspinner = tipoImovelspinner;
    }

    public String getTipoLarvicidaspinner() {
        return TipoLarvicidaspinner;
    }

    public void setTipoLarvicidaspinner(String tipoLarvicidaspinner) {
        TipoLarvicidaspinner = tipoLarvicidaspinner;
    }

    public String getTipoVisitaspinner() {
        return TipoVisitaspinner;
    }

    public void setTipoVisitaspinner(String tipoVisitaspinner) {
        TipoVisitaspinner = tipoVisitaspinner;
    }

    public String getFinalQuarteiraospinner() {
        return FinalQuarteiraospinner;
    }

    public void setFinalQuarteiraospinner(String finalQuarteiraospinner) {
        FinalQuarteiraospinner = finalQuarteiraospinner;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getNumeroQuarteirao() {
        return numeroQuarteirao;
    }

    public void setNumeroQuarteirao(String numeroQuarteirao) {
        this.numeroQuarteirao = numeroQuarteirao;
    }

    public String getLadoQuarteirao() {
        return ladoQuarteirao;
    }

    public void setLadoQuarteirao(String ladoQuarteirao) {
        this.ladoQuarteirao = ladoQuarteirao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroImovel() {
        return numeroImovel;
    }

    public void setNumeroImovel(String numeroImovel) {
        this.numeroImovel = numeroImovel;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDepositoEliminado() {
        return depositoEliminado;
    }

    public void setDepositoEliminado(String depositoEliminado) {
        this.depositoEliminado = depositoEliminado;
    }

    public String getQuantidadeLarvicida() {
        return quantidadeLarvicida;
    }

    public void setQuantidadeLarvicida(String quantidadeLarvicida) {
        this.quantidadeLarvicida = quantidadeLarvicida;
    }

    public String getDepositoTratados() {
        return depositoTratados;
    }

    public void setDepositoTratados(String depositoTratados) {
        this.depositoTratados = depositoTratados;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCicloSpinner() {
        return cicloSpinner;
    }

    public void setCicloSpinner(String cicloSpinner) {
        this.cicloSpinner = cicloSpinner;
    }

    public String getBairroSpinner() {
        return bairroSpinner;
    }

    public void setBairroSpinner(String bairroSpinner) {
        this.bairroSpinner = bairroSpinner;
    }

    public String getAce() {
        return ace;
    }

    public void setAce(String ace) {
        this.ace = ace;
    }

    public String getData_completa() {
        return data_completa;
    }

    public void setData_completa(String data_completa) {
        this.data_completa = data_completa;
    }

    public String getHora_atual() {
        return hora_atual;
    }

    public void setHora_atual(String hora_atual) {
        this.hora_atual = hora_atual;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        ciclo = ciclo;
    }

}
