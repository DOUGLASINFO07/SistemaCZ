package funcionarios;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utilitario;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07 15/09/2019
 */
public class FuncionarioDAO {

    private final Connection conn;

    FuncionarioAtributos FA = new FuncionarioAtributos();

    Utilitario util = new Utilitario();

    public FuncionarioDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    public boolean salvar(FuncionarioAtributos FA) {

        String sql = "INSERT INTO funcionario VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, FA.getNome());
                stmt.setString(2, FA.getCpf());
                stmt.setString(3, FA.getRg());
                stmt.setString(4, FA.getOrgaoEmissorRG());
                stmt.setString(5, FA.getEstadoOrgaoEmissorRG());
                stmt.setString(6, FA.getDataEmissaoRG());
                stmt.setString(7, FA.getHabilitacao());
                stmt.setString(8, FA.getCategoriaHabilitacao());
                stmt.setString(9, FA.getData1Habilitacao());
                stmt.setString(10, FA.getDataNascimento());
                stmt.setString(11, FA.getMunicipioNascimento());
                stmt.setString(12, FA.getEstadoNascimento());
                stmt.setString(13, FA.getNomeMae());
                stmt.setString(14, FA.getNomePai());
                stmt.setString(15, FA.getLogradouroEndereco());
                stmt.setString(16, FA.getNumeroEndereco());
                stmt.setString(17, FA.getBairroEndereco());
                stmt.setString(18, FA.getCepEndereco());
                stmt.setString(19, FA.getCidadeEndereco());
                stmt.setString(20, FA.getEstadoEndereco());
                stmt.setString(21, FA.getEmail());
                stmt.setString(22, FA.getTelefone());
                stmt.setString(23, FA.getTelefoneContato());
                stmt.setString(24, FA.getWhtasApp());
                stmt.setString(25, FA.getCargo());
                stmt.setString(26, FA.getVinculoEmpregaticio());
                stmt.setString(27, FA.getMatricula());
                stmt.setString(28, FA.getEquipe());
                stmt.setString(29, FA.getAreaTrabalho());
                stmt.setString(30, FA.getSituacaoFuncional());
                stmt.setString(31, FA.getDataAdmissao());
                stmt.setString(32, FA.getDataDemissao());
                stmt.setString(33, FA.getFormaIngresso());
                stmt.setString(34, FA.getFormaEgresso());
                stmt.setString(35, FA.getObservacao());
                stmt.setString(36, FA.getFotoFuncionario());

                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            util.alertSimples("CADASTRO DE FUNCIONÁRIOS", "" + ex);
            return false;
        }
    }

    public boolean atualizar(FuncionarioAtributos FA) {

        String sql = "UPDATE funcionario "
                + "SET nome = ?, "
                + "cpf = ?, "
                + "rg = ?, "
                + "orgaoEmissorRG = ?, "
                + "estadoOrgaoEmissorRG = ?, "
                + "dataEmissaoRG = ?, "
                + "habilitacao = ?, "
                + "categoriaHabilitacao = ?, "
                + "data1Habilitacao = ?, "
                + "dataNascimento = ?, "
                + "municipioNascimento = ?, "
                + "estadoNascimento = ?, "
                + "nomeMae = ?, "
                + "nomePai = ?, "
                + "logradouroEndereco = ?, "
                + "numeroEndereco = ?, "
                + "bairroEndereco = ?, "
                + "cepEndereco = ?, "
                + "cidadeEndereco = ?, "
                + "estadoEndereco = ?, "
                + "email = ?, "
                + "telefone = ?, "
                + "telefoneContato = ?, "
                + "whatsApp = ?, "
                + "cargo = ?, "
                + "vinculoEmpregaticio = ?, "
                + "equipe = ?, "
                + "areaTrabalho = ?, "
                + "situacaoFuncionario = ?, "
                + "dataAdmissao = ?, "
                + "dataDemissao = ?, "
                + "formaIngresso = ?, "
                + "formaEgresso = ?, "
                + "observacao = ?, "
                + "fotoFuncionario = ? "
                + "WHERE matricula = ? ";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, FA.getNome());
                stmt.setString(2, FA.getCpf());
                stmt.setString(3, FA.getRg());
                stmt.setString(4, FA.getOrgaoEmissorRG());
                stmt.setString(5, FA.getEstadoOrgaoEmissorRG());
                stmt.setString(6, FA.getDataEmissaoRG());
                stmt.setString(7, FA.getHabilitacao());
                stmt.setString(8, FA.getCategoriaHabilitacao());
                stmt.setString(9, FA.getData1Habilitacao());
                stmt.setString(10, FA.getDataNascimento());
                stmt.setString(11, FA.getMunicipioNascimento());
                stmt.setString(12, FA.getEstadoNascimento());
                stmt.setString(13, FA.getNomeMae());
                stmt.setString(14, FA.getNomePai());
                stmt.setString(15, FA.getLogradouroEndereco());
                stmt.setString(16, FA.getNumeroEndereco());
                stmt.setString(17, FA.getBairroEndereco());
                stmt.setString(18, FA.getCepEndereco());
                stmt.setString(19, FA.getCidadeEndereco());
                stmt.setString(20, FA.getEstadoEndereco());
                stmt.setString(21, FA.getEmail());
                stmt.setString(22, FA.getTelefone());
                stmt.setString(23, FA.getTelefoneContato());
                stmt.setString(24, FA.getWhtasApp());
                stmt.setString(25, FA.getCargo());
                stmt.setString(26, FA.getVinculoEmpregaticio());
                stmt.setString(27, FA.getEquipe());
                stmt.setString(28, FA.getAreaTrabalho());
                stmt.setString(29, FA.getSituacaoFuncional());
                stmt.setString(30, FA.getDataAdmissao());
                stmt.setString(31, FA.getDataDemissao());
                stmt.setString(32, FA.getFormaIngresso());
                stmt.setString(33, FA.getFormaEgresso());
                stmt.setString(34, FA.getObservacao());
                stmt.setString(35, FA.getFotoFuncionario());
                stmt.setString(36, FA.getMatricula());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(
            String matricula,
            FuncionarioAtributos FA
    ) {
        String sql = "DELETE FROM funcionario "
                + "WHERE matricula = '" + matricula + "' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public void buscarFoto(
            String nome,
            FuncionarioAtributos fa
    ) {
        String sql = "SELECT * FROM funcionario "
                + "WHERE nome = '" + nome + "'";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fa.setFotoFuncionario(rs.getString("fotoFuncionario"));

            }
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void buscarDadosFuncionario(
            String nome,
            FuncionarioAtributos FA
    ) {
        String sql = "SELECT * FROM funcionario "
                + "WHERE nome LIKE '" + nome + "%'";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FA.setNome(rs.getString("nome"));
                FA.setCpf(rs.getString("cpf"));
                FA.setRg(rs.getString("rg"));
                FA.setOrgaoEmissorRG(rs.getString("orgaoEmissorRG"));
                FA.setEstadoOrgaoEmissorRG(rs.getString("estadoOrgaoEmissorRG"));
                FA.setDataEmissaoRG(rs.getString("dataEmissaoRG"));
                FA.setHabilitacao(rs.getString("habilitacao"));
                FA.setCategoriaHabilitacao(rs.getString("categoriaHabilitacao"));
                FA.setData1Habilitacao(rs.getString("data1habilitacao"));
                FA.setDataNascimento(rs.getString("dataNascimento"));
                FA.setMunicipioNascimento(rs.getString("municipioNascimento"));
                FA.setEstadoNascimento(rs.getString("estadoNascimento"));
                FA.setNomeMae(rs.getString("nomeMae"));
                FA.setNomePai(rs.getString("nomePai"));
                FA.setLogradouroEndereco(rs.getString("logradouroEndereco"));
                FA.setNumeroEndereco(rs.getString("numeroEndereco"));
                FA.setBairroEndereco(rs.getString("bairroEndereco"));
                FA.setCepEndereco(rs.getString("cepEndereco"));
                FA.setCidadeEndereco(rs.getString("cidadeEndereco"));
                FA.setEstadoEndereco(rs.getString("estadoEndereco"));
                FA.setEmail(rs.getString("email"));
                FA.setTelefone(rs.getString("telefone"));
                FA.setTelefoneContato(rs.getString("telefoneContato"));
                FA.setWhtasApp(rs.getString("whatsApp"));
                FA.setCargo(rs.getString("cargo"));
                FA.setVinculoEmpregaticio(rs.getString("vinculoEmpregaticio"));
                FA.setMatricula(rs.getString("matricula"));
                FA.setEquipe(rs.getString("equipe"));
                FA.setAreaTrabalho(rs.getString("areaTrabalho"));
                FA.setSituacaoFuncional(rs.getString("situacaoFuncionario"));
                FA.setDataAdmissao(rs.getString("dataAdmissao"));
                FA.setDataDemissao(rs.getString("dataDemissao"));
                FA.setFormaIngresso(rs.getString("formaIngresso"));
                FA.setFormaEgresso(rs.getString("formaEgresso"));
                FA.setObservacao(rs.getString("observacao"));
                FA.setFotoFuncionario(rs.getString("fotoFuncionario"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<FuncionarioAtributos> listaFuncionario(String nome) {
        List<FuncionarioAtributos> FuncionarioLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE nome LIKE '" + nome + "%' "
                + "ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionarioAtributos FA = new FuncionarioAtributos();
                FA.setNome(rs.getString("nome"));
                FA.setEquipe(rs.getString("equipe"));
                FuncionarioLista.add(FA);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return FuncionarioLista;
    }//FIM DO MÉTODO.

}
