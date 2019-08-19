package localidades;

import funcionarios.*;

/**
 *
 * @author douglas borges egidio
 * @17/12/2018.
 *
 */
public class LocalidadeAtributos {
 

    private String codigo;
    private String nome;
    private String sigla;
    private String categoria;
    private String zona;
    private String tipo;
    private String observacao;

    public LocalidadeAtributos() {

    }

    public LocalidadeAtributos(
            String codigo, 
            String nome, 
            String sigla, 
            String categoria, 
            String zona, 
            String tipo, 
            String observacao
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
        this.categoria = categoria;
        this.zona = zona;
        this.tipo = tipo;
        this.observacao = observacao;
    }
    
    @Override
    public String toString() {
     return getNome();
//        return "FuncionarioAtributos{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", orgaoEmissorRG=" + orgaoEmissorRG + ", estadoOrgaoEmissorRG=" + estadoOrgaoEmissorRG + ", dataEmissaoRG=" + dataEmissaoRG + ", habilitacao=" + habilitacao + ", categoriaHabilitacao=" + categoriaHabilitacao + ", data1Habilitacao=" + data1Habilitacao + ", dataNascimento=" + dataNascimento + ", municipioNascimento=" + municipioNascimento + ", estadoNascimento=" + estadoNascimento + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", logradouroEndereco=" + logradouroEndereco + ", numeroEndereco=" + numeroEndereco + ", bairroEndereco=" + bairroEndereco + ", cepEndereco=" + cepEndereco + ", cidadeEndereco=" + cidadeEndereco + ", estadoEndereco=" + estadoEndereco + ", email=" + email + ", telefone=" + telefone + ", telefoneContato=" + telefoneContato + ", whtasApp=" + whtasApp + ", cargo=" + cargo + ", vinculoEmpregaticio=" + vinculoEmpregaticio + ", matricula=" + matricula + ", equipe=" + equipe + ", areaTrabalho=" + areaTrabalho + ", situacaoFuncional=" + situacaoFuncional + ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + ", formaIngresso=" + formaIngresso + ", formaEgresso=" + formaEgresso + ", observacao=" + observacao + ", fotoFuncionario=" + fotoFuncionario + '}';
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
