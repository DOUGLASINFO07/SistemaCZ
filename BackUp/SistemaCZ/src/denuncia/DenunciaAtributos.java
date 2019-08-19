package denuncia;

/**
 * @author douglas borges egidio
 * @19/02/2019
 */

public class DenunciaAtributos {

    private int numeroDenuncia;
    private String dataDenuncia;
    private String recebidaPor;
    private String denunciante;
    private String denunciado;
    private String logradouro;
    private String numeroEndereco;
    private String bairro;
    private String tipoImovel;
    private String tipoDenuncia;
    private String detalhesDenuncia;
    private String ace1;
    private String ace2;
    private String situacaoVisita;
    private String dataVisita;
    private String detalhesVisita;
    private int somaParaConferirDenunciaLancadaDia;
    private int somaNumeroDenuncia;

    public DenunciaAtributos(
            int numeroDenuncia, 
            String dataDenuncia, 
            String recebidaPor, 
            String denunciante, 
            String denunciado, 
            String logradouro, 
            String numeroEndereco, 
            String bairro, 
            String tipoImovel, 
            String tipoDenuncia, 
            String detalhesDenuncia, 
            String ace1, 
            String ace2, 
            String situacaoVisita, 
            String dataVisita, 
            String detalhesVisita,
            int somaParaConferirDenunciaLancadaDia,
            int somaNumeroDenuncia
    ) {
        this.numeroDenuncia = numeroDenuncia;
        this.dataDenuncia = dataDenuncia;
        this.recebidaPor = recebidaPor;
        this.denunciante = denunciante;
        this.denunciado = denunciado;
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.tipoImovel = tipoImovel;
        this.tipoDenuncia = tipoDenuncia;
        this.detalhesDenuncia = detalhesDenuncia;
        this.ace1 = ace1;
        this.ace2 = ace2;
        this.situacaoVisita = situacaoVisita;
        this.dataVisita = dataVisita;
        this.detalhesVisita = detalhesVisita;
        this.somaParaConferirDenunciaLancadaDia = somaParaConferirDenunciaLancadaDia;
        this.somaNumeroDenuncia = somaNumeroDenuncia;
    }

    public DenunciaAtributos() {
        
    }
    
    @Override
    public String toString() {
        return getTipoImovel();
    }

    public int getNumeroDenuncia() {
        return numeroDenuncia;
    }

    public void setNumeroDenuncia(int numeroDenuncia) {
        this.numeroDenuncia = numeroDenuncia;
    }

    public String getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(String dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public String getRecebidaPor() {
        return recebidaPor;
    }

    public void setRecebidaPor(String recebidaPor) {
        this.recebidaPor = recebidaPor;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(String tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getDetalhesDenuncia() {
        return detalhesDenuncia;
    }

    public void setDetalhesDenuncia(String detalhesDenuncia) {
        this.detalhesDenuncia = detalhesDenuncia;
    }

    public String getAce1() {
        return ace1;
    }

    public void setAce1(String ace1) {
        this.ace1 = ace1;
    }

    public String getAce2() {
        return ace2;
    }

    public void setAce2(String ace2) {
        this.ace2 = ace2;
    }

    public String getSituacaoVisita() {
        return situacaoVisita;
    }

    public void setSituacaoVisita(String situacaoVisita) {
        this.situacaoVisita = situacaoVisita;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getDetalhesVisita() {
        return detalhesVisita;
    }

    public void setDetalhesVisita(String detalhesVisita) {
        this.detalhesVisita = detalhesVisita;
    }

    public int getSomaParaConferirDenunciaLancadaDia() {
        return somaParaConferirDenunciaLancadaDia;
    }

    public void setSomaParaConferirDenunciaLancadaDia(int somaParaConferirDenunciaLancadaDia) {
        this.somaParaConferirDenunciaLancadaDia = somaParaConferirDenunciaLancadaDia;
    }

    public int getSomaNumeroDenuncia() {
        return somaNumeroDenuncia;
    }

    public void setSomaNumeroDenuncia(int somaNumeroDenuncia) {
        this.somaNumeroDenuncia = somaNumeroDenuncia;
    }
    
    
}
