package funcionarios;

import java.util.Objects;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @17/12/2018.
 */

public class FuncionarioAtributos {

    private String nome;
    private String cpf;
    private String rg;
    private String orgaoEmissorRG;
    private String estadoOrgaoEmissorRG;
    private String dataEmissaoRG;
    private String habilitacao;
    private String categoriaHabilitacao;
    private String data1Habilitacao;
    private String dataNascimento;
    private String municipioNascimento;
    private String estadoNascimento;
    private String nomeMae;
    private String nomePai;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String bairroEndereco;
    private String cepEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String email;
    private String telefone;
    private String telefoneContato;
    private String whtasApp;
    private String cargo;
    private String vinculoEmpregaticio;
    private String matricula;
    private String equipe;
    private String areaTrabalho;
    private String situacaoFuncional;
    private String dataAdmissao;
    private String dataDemissao;
    private String formaIngresso;
    private String formaEgresso;
    private String observacao;
    private String fotoFuncionario;

    public FuncionarioAtributos(
            String nome,
            String cpf,
            String rg,
            String orgaoEmissorRG,
            String estadoOrgaoEmissorRG,
            String dataEmissaoRG,
            String habilitacao,
            String categoriaHabilitacao,
            String data1Habilitacao,
            String dataNascimento,
            String municipioNascimento,
            String estadoNascimento,
            String nomeMae,
            String nomePai,
            String logradouroEndereco,
            String numeroEndereco,
            String bairroEndereco,
            String cepEndereco,
            String cidadeEndereco,
            String estadoEndereco,
            String email,
            String telefone,
            String telefoneContato,
            String whtasApp,
            String cargo,
            String vinculoEmpregaticio,
            String matricula,
            String equipe,
            String areaTrabalho,
            String situacaoFuncional,
            String dataAdmissao,
            String dataDemissao,
            String formaIngresso,
            String formaEgresso,
            String observacao,
            String fotoFuncionario
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.orgaoEmissorRG = orgaoEmissorRG;
        this.estadoOrgaoEmissorRG = estadoOrgaoEmissorRG;
        this.dataEmissaoRG = dataEmissaoRG;
        this.habilitacao = habilitacao;
        this.categoriaHabilitacao = categoriaHabilitacao;
        this.data1Habilitacao = data1Habilitacao;
        this.dataNascimento = dataNascimento;
        this.municipioNascimento = municipioNascimento;
        this.estadoNascimento = estadoNascimento;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cepEndereco = cepEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.email = email;
        this.telefone = telefone;
        this.telefoneContato = telefoneContato;
        this.whtasApp = whtasApp;
        this.cargo = cargo;
        this.vinculoEmpregaticio = vinculoEmpregaticio;
        this.matricula = matricula;
        this.equipe = equipe;
        this.areaTrabalho = areaTrabalho;
        this.situacaoFuncional = situacaoFuncional;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.formaIngresso = formaIngresso;
        this.formaEgresso = formaEgresso;
        this.observacao = observacao;
        this.fotoFuncionario = fotoFuncionario;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public FuncionarioAtributos() {

    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissorRG() {
        return orgaoEmissorRG;
    }

    public void setOrgaoEmissorRG(String orgaoEmissorRG) {
        this.orgaoEmissorRG = orgaoEmissorRG;
    }

    public String getEstadoOrgaoEmissorRG() {
        return estadoOrgaoEmissorRG;
    }

    public void setEstadoOrgaoEmissorRG(String estadoOrgaoEmissorRG) {
        this.estadoOrgaoEmissorRG = estadoOrgaoEmissorRG;
    }

    public String getDataEmissaoRG() {
        return dataEmissaoRG;
    }

    public void setDataEmissaoRG(String dataEmissaoRG) {
        this.dataEmissaoRG = dataEmissaoRG;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public String getCategoriaHabilitacao() {
        return categoriaHabilitacao;
    }

    public void setCategoriaHabilitacao(String categoriaHabilitacao) {
        this.categoriaHabilitacao = categoriaHabilitacao;
    }

    public String getData1Habilitacao() {
        return data1Habilitacao;
    }

    public void setData1Habilitacao(String data1Habilitacao) {
        this.data1Habilitacao = data1Habilitacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getWhtasApp() {
        return whtasApp;
    }

    public void setWhtasApp(String whtasApp) {
        this.whtasApp = whtasApp;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getVinculoEmpregaticio() {
        return vinculoEmpregaticio;
    }

    public void setVinculoEmpregaticio(String vinculoEmpregaticio) {
        this.vinculoEmpregaticio = vinculoEmpregaticio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getAreaTrabalho() {
        return areaTrabalho;
    }

    public void setAreaTrabalho(String areaTrabalho) {
        this.areaTrabalho = areaTrabalho;
    }

    public String getSituacaoFuncional() {
        return situacaoFuncional;
    }

    public void setSituacaoFuncional(String situacaoFuncional) {
        this.situacaoFuncional = situacaoFuncional;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getFormaIngresso() {
        return formaIngresso;
    }

    public void setFormaIngresso(String formaIngresso) {
        this.formaIngresso = formaIngresso;
    }

    public String getFormaEgresso() {
        return formaEgresso;
    }

    public void setFormaEgresso(String formaEgresso) {
        this.formaEgresso = formaEgresso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFotoFuncionario() {
        return fotoFuncionario;
    }

    public void setFotoFuncionario(String fotoFuncionario) {
        this.fotoFuncionario = fotoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.rg);
        hash = 83 * hash + Objects.hashCode(this.orgaoEmissorRG);
        hash = 83 * hash + Objects.hashCode(this.estadoOrgaoEmissorRG);
        hash = 83 * hash + Objects.hashCode(this.dataEmissaoRG);
        hash = 83 * hash + Objects.hashCode(this.habilitacao);
        hash = 83 * hash + Objects.hashCode(this.categoriaHabilitacao);
        hash = 83 * hash + Objects.hashCode(this.data1Habilitacao);
        hash = 83 * hash + Objects.hashCode(this.dataNascimento);
        hash = 83 * hash + Objects.hashCode(this.municipioNascimento);
        hash = 83 * hash + Objects.hashCode(this.estadoNascimento);
        hash = 83 * hash + Objects.hashCode(this.nomeMae);
        hash = 83 * hash + Objects.hashCode(this.nomePai);
        hash = 83 * hash + Objects.hashCode(this.logradouroEndereco);
        hash = 83 * hash + Objects.hashCode(this.numeroEndereco);
        hash = 83 * hash + Objects.hashCode(this.bairroEndereco);
        hash = 83 * hash + Objects.hashCode(this.cepEndereco);
        hash = 83 * hash + Objects.hashCode(this.cidadeEndereco);
        hash = 83 * hash + Objects.hashCode(this.estadoEndereco);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.telefoneContato);
        hash = 83 * hash + Objects.hashCode(this.whtasApp);
        hash = 83 * hash + Objects.hashCode(this.cargo);
        hash = 83 * hash + Objects.hashCode(this.vinculoEmpregaticio);
        hash = 83 * hash + Objects.hashCode(this.matricula);
        hash = 83 * hash + Objects.hashCode(this.equipe);
        hash = 83 * hash + Objects.hashCode(this.areaTrabalho);
        hash = 83 * hash + Objects.hashCode(this.situacaoFuncional);
        hash = 83 * hash + Objects.hashCode(this.dataAdmissao);
        hash = 83 * hash + Objects.hashCode(this.dataDemissao);
        hash = 83 * hash + Objects.hashCode(this.formaIngresso);
        hash = 83 * hash + Objects.hashCode(this.formaEgresso);
        hash = 83 * hash + Objects.hashCode(this.observacao);
        hash = 83 * hash + Objects.hashCode(this.fotoFuncionario);
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
        final FuncionarioAtributos other = (FuncionarioAtributos) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.orgaoEmissorRG, other.orgaoEmissorRG)) {
            return false;
        }
        if (!Objects.equals(this.estadoOrgaoEmissorRG, other.estadoOrgaoEmissorRG)) {
            return false;
        }
        if (!Objects.equals(this.dataEmissaoRG, other.dataEmissaoRG)) {
            return false;
        }
        if (!Objects.equals(this.habilitacao, other.habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.categoriaHabilitacao, other.categoriaHabilitacao)) {
            return false;
        }
        if (!Objects.equals(this.data1Habilitacao, other.data1Habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.municipioNascimento, other.municipioNascimento)) {
            return false;
        }
        if (!Objects.equals(this.estadoNascimento, other.estadoNascimento)) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.logradouroEndereco, other.logradouroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.numeroEndereco, other.numeroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.bairroEndereco, other.bairroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.cepEndereco, other.cepEndereco)) {
            return false;
        }
        if (!Objects.equals(this.cidadeEndereco, other.cidadeEndereco)) {
            return false;
        }
        if (!Objects.equals(this.estadoEndereco, other.estadoEndereco)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.telefoneContato, other.telefoneContato)) {
            return false;
        }
        if (!Objects.equals(this.whtasApp, other.whtasApp)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.vinculoEmpregaticio, other.vinculoEmpregaticio)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        if (!Objects.equals(this.areaTrabalho, other.areaTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.situacaoFuncional, other.situacaoFuncional)) {
            return false;
        }
        if (!Objects.equals(this.dataAdmissao, other.dataAdmissao)) {
            return false;
        }
        if (!Objects.equals(this.dataDemissao, other.dataDemissao)) {
            return false;
        }
        if (!Objects.equals(this.formaIngresso, other.formaIngresso)) {
            return false;
        }
        if (!Objects.equals(this.formaEgresso, other.formaEgresso)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return Objects.equals(this.fotoFuncionario, other.fotoFuncionario);
    }

}
