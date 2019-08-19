package funcionarios;

/**
 *
 * @author douglas borges egidio
 * @17/12/2018.
 *
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
//    private String buscarFuncionario;

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
//            String buscarFuncionario
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
//        this.buscarFuncionario = buscarFuncionario;
    }

    @Override
    public String toString() {
     return getNome();
//        return "FuncionarioAtributos{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", orgaoEmissorRG=" + orgaoEmissorRG + ", estadoOrgaoEmissorRG=" + estadoOrgaoEmissorRG + ", dataEmissaoRG=" + dataEmissaoRG + ", habilitacao=" + habilitacao + ", categoriaHabilitacao=" + categoriaHabilitacao + ", data1Habilitacao=" + data1Habilitacao + ", dataNascimento=" + dataNascimento + ", municipioNascimento=" + municipioNascimento + ", estadoNascimento=" + estadoNascimento + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", logradouroEndereco=" + logradouroEndereco + ", numeroEndereco=" + numeroEndereco + ", bairroEndereco=" + bairroEndereco + ", cepEndereco=" + cepEndereco + ", cidadeEndereco=" + cidadeEndereco + ", estadoEndereco=" + estadoEndereco + ", email=" + email + ", telefone=" + telefone + ", telefoneContato=" + telefoneContato + ", whtasApp=" + whtasApp + ", cargo=" + cargo + ", vinculoEmpregaticio=" + vinculoEmpregaticio + ", matricula=" + matricula + ", equipe=" + equipe + ", areaTrabalho=" + areaTrabalho + ", situacaoFuncional=" + situacaoFuncional + ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + ", formaIngresso=" + formaIngresso + ", formaEgresso=" + formaEgresso + ", observacao=" + observacao + ", fotoFuncionario=" + fotoFuncionario + '}';
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
//
//    public String getBuscarFuncionario() {
//        return buscarFuncionario;
//    }
//
//    public void setBuscarFuncionario(String buscarFuncionario) {
//        this.buscarFuncionario = buscarFuncionario;
//    }
    
    

}
