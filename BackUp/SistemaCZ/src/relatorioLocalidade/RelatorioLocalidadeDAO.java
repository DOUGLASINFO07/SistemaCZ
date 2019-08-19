package relatorioLocalidade;

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
 * @since 08/03/2019
 */

public class RelatorioLocalidadeDAO {

    private final Connection conn;

    RelatorioLocalidadeAtributos RLA = new RelatorioLocalidadeAtributos();

    Utilitario util = new Utilitario();

    public RelatorioLocalidadeDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<RelatorioLocalidadeAtributos> listaRelatorioLocalidade(
            String pesquisa,
            String pesquisarPor
    ) {
        List<RelatorioLocalidadeAtributos> RelatorioLocalidadeLista = new ArrayList<>();
        String sqlListar = null;
        switch (pesquisarPor) {
            case "CÓDIGO DE RG":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE codigo LIKE '" + pesquisa + "%' "
                        + "ORDER BY codigo ASC";
                break;
            case "LOCALIDADE":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE nome LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "SIGLA":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE sigla LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "CATEGORIA":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE categoria LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "ZONA":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE zona LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "TIPO":
                sqlListar = "SELECT * FROM localidade "
                        + "WHERE tipo LIKE '" + pesquisa + "%' "
                        + "ORDER BY nome";
                break;
            case "TODOS":
                sqlListar = "SELECT * FROM localidade "
                        + "ORDER BY nome";
                break;
            default:
                break;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RelatorioLocalidadeAtributos RLA = new RelatorioLocalidadeAtributos();
                RLA.setCodigoCT(rs.getString("codigo"));
                RLA.setNomeCT(rs.getString("nome"));
                RLA.setSiglaCT(rs.getString("sigla"));
                RLA.setCategoriaCT(rs.getString("categoria"));
                RLA.setZonaCT(rs.getString("zona"));
                RLA.setTipoCT(rs.getString("tipo"));
                RLA.setObservacaoCT(rs.getString("observacao"));
                RelatorioLocalidadeLista.add(RLA);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioLocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return RelatorioLocalidadeLista;
    }//FIM DO MÉTODO.

}
