package com.example.sistemacz;

public class Denuncia {

    int numeroDenuncia;
    String logradouro;
    String numeroImovel;
    String bairro;
    String tipoImovel;
    String tipoDenuncia;
    String detalhes;
    String denunciado;
    String denunciante;

    public Denuncia(int numeroDenuncia,
                    String logradouro,
                    String numeroImovel,
                    String bairro,
                    String tipoImovel,
                    String tipoDenuncia) {
        this.numeroDenuncia = numeroDenuncia;
        this.logradouro = logradouro;
        this.numeroImovel = numeroImovel;
        this.bairro = bairro;
        this.tipoImovel = tipoImovel;
        this.tipoDenuncia = tipoDenuncia;
    }



    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {

        this.denunciante = denunciante;
    }

    public int getNumeroDenuncia() {

        return numeroDenuncia;
    }

    public void setNumeroDenuncia(int numeroDenuncia) {
        this.numeroDenuncia = numeroDenuncia;
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

    public void setNumeroImovel(String numeroImovel)
    {
        this.numeroImovel = numeroImovel;
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
}
