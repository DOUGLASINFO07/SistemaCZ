package relatorioAtividades;

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

public class RelatorioAtividadesDAO {

    private final Connection conn;

    Utilitario util = new Utilitario();

    public RelatorioAtividadesDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<RelatorioAtividadesAtributos> listaRelatorioAtividades(
            String pesquisa
    ) {
        List<RelatorioAtividadesAtributos> RelatorioAtividadesLista = new ArrayList<>();
        String sqlListar = null;

        switch (pesquisa) {
            case "Todos":
                sqlListar = "SELECT * FROM atividades "
                        + "ORDER BY nomeAtividade DESC";
                break;
            default:
                sqlListar = "SELECT * FROM atividades "
                        + "WHERE atividades LIKE '" + pesquisa + "%' "
                        + "ORDER BY nomeAtividade DESC";
                break;
        }
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
        RelatorioAtividadesAtributos RAA1 = new RelatorioAtividadesAtributos();
                RAA1.setTipoAtividadeCT(rs.getString("atividades"));
                RAA1.setDataInicial(util.converterDataAmericanoBrasil(rs.getString("dataInicio")));
                RAA1.setDatatermino(util.converterDataAmericanoBrasil(rs.getString("dataTermino")));
                RAA1.setCiclo(rs.getString("nomeAtividade"));
                RelatorioAtividadesLista.add(RAA1);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioAtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return RelatorioAtividadesLista;
    }//FIM DO MÉTODO.

}
