package localidades;

import java.util.Objects;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @17/12/2018.
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.sigla);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.zona);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.observacao);
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
        final LocalidadeAtributos other = (LocalidadeAtributos) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.zona, other.zona)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.observacao, other.observacao);
    }

}
