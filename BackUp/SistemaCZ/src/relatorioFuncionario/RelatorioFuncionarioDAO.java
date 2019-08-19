package relatorioFuncionario;

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
 * @since 20/03/2019
 */

public class RelatorioFuncionarioDAO {

    private final Connection conn;

    RelatorioFuncionarioAtributos RFA = new RelatorioFuncionarioAtributos();

    Utilitario util = new Utilitario();

    public RelatorioFuncionarioDAO() {
        this.conn = new Conexao().abrirConexao();
    }

//    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
//    public void buscarFoto(
//            String nome,
//            RelatorioFuncionarioAtributos fa
//    ) {
//        String sql = "SELECT * FROM RelatorioFuncionario "
//                + "WHERE nome = '" + nome + "'";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                fa.setFotoRelatorioFuncionario(rs.getString("fotoRelatorioFuncionario"));
//            }
//            stmt.execute();
//            stmt.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(RelatorioFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }//FIM DO MÉTODO.
    
    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<RelatorioFuncionarioAtributos> listaRelatorioFuncionario(
            String pesquisa,
            String pesquisarPor
    ) {
        List<RelatorioFuncionarioAtributos> RelatorioFuncionarioLista = new ArrayList<>();
        String sqlListar = null;

        switch (pesquisarPor) {
            case "NOME DO FUNCIONÁRIO":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE nome LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "MATRÍCULA":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE matricula LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "SITUAÇÃO FUNCIONAL":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE situacaoFuncionario LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "CARGO":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE cargo LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "ÁREA DE TRABALHO":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE areaTrabalho LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "EQUIPE":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE equipe LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "VÍNCULO EMPREGATÍCIO":
                sqlListar = "SELECT * FROM funcionario "
                        + "WHERE vinculoEmpregaticio LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "TODOS":
                sqlListar = "SELECT * FROM funcionario "
                        + "ORDER BY nome";
                break;
            default:
                break;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RelatorioFuncionarioAtributos RFA = new RelatorioFuncionarioAtributos();
                RFA.setNomeCT(rs.getString("nome"));
                RFA.setMatriculaCT(rs.getString("matricula"));
                RFA.setSituacaoFuncionalCT(rs.getString("situacaoFuncionario"));
                RFA.setCargoCT(rs.getString("cargo"));
                RFA.setAreaTrabalhoCT(rs.getString("areaTrabalho"));
                RFA.setEquipeCT(rs.getString("equipe"));
                RFA.setVinculoEmpregaticioCT(rs.getString("vinculoEmpregaticio"));
                RelatorioFuncionarioLista.add(RFA);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return RelatorioFuncionarioLista;
    }//FIM DO MÉTODO.

}
