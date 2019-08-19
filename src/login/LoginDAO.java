package login;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utilitario;

/**
 * @author douglas 
 */

public class LoginDAO {

    private final Connection conn;

    LoginAtributos LA = new LoginAtributos();

    Utilitario util = new Utilitario();

    public LoginDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    public void buscarDadosLogin(
            String nomeLogin,
            String senha,
            LoginAtributos LA
    ) {
        String sql = "SELECT COUNT(nomeLogin) AS contagemNomeLogin FROM login "
                + "WHERE nomeLogin = '" + nomeLogin + "' "
                + "AND senha = '" + senha + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LA.setContagem(rs.getInt("contagemNomeLogin"));
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

}
