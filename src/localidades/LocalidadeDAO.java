package localidades;

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
 *
 * @author dougl
 */
public class LocalidadeDAO {

    private final Connection conn;

    LocalidadeAtributos LA = new LocalidadeAtributos();

    Utilitario util = new Utilitario();

    public LocalidadeDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    public boolean salvar(LocalidadeAtributos LA) {

        String sql = "INSERT INTO localidade VALUES (null,?,?,?,?,?,?,?)";
        try {

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, LA.getCodigo());
                stmt.setString(2, LA.getNome());
                stmt.setString(3, LA.getSigla());
                stmt.setString(4, LA.getCategoria());
                stmt.setString(5, LA.getZona());
                stmt.setString(6, LA.getTipo());
                stmt.setString(7, LA.getObservacao());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean atualizar(LocalidadeAtributos LA) {

        String sql = "UPDATE localidade "
                + "SET nome = ?, "
                + "sigla = ?, "
                + "categoria = ?, "
                + "zona = ?, "
                + "tipo = ?, "
                + "observacao = ? "
                + "WHERE codigo = ? ";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, LA.getNome());
                stmt.setString(2, LA.getSigla());
                stmt.setString(3, LA.getCategoria());
                stmt.setString(4, LA.getZona());
                stmt.setString(5, LA.getTipo());
                stmt.setString(6, LA.getObservacao());
                stmt.setString(7, LA.getCodigo());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(
            String codigo,
            LocalidadeAtributos LA
            ) {
        String sql = "DELETE FROM localidade "
                + "WHERE codigo = '"+ codigo +"' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                stmt.setString(1, LA.getMatricula());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void buscarDadosLocalidade(
            String nome,
            LocalidadeAtributos LA
    ) {
        String sql = "SELECT * FROM localidade "
                + "WHERE nome = '" + nome + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LA.setCodigo(rs.getString("codigo"));
                LA.setNome(rs.getString("nome"));
                LA.setSigla(rs.getString("sigla"));
                LA.setCategoria(rs.getString("categoria"));
                LA.setZona(rs.getString("zona"));
                LA.setTipo(rs.getString("tipo"));
                LA.setObservacao(rs.getString("observacao"));
            }
//            rs.close();
//            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<LocalidadeAtributos> listaLocalidade(String nome) {
        List<LocalidadeAtributos> LocalidadeLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM localidade "
                + "WHERE nome LIKE '" + nome + "%' "
                + "ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LocalidadeAtributos LA = new LocalidadeAtributos();
                LA.setNome(rs.getString("nome"));
                LA.setCodigo(rs.getString("codigo"));
                LocalidadeLista.add(LA);
            }
//            stmt.close();
//            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return LocalidadeLista;
    }//FIM DO MÉTODO.

}
