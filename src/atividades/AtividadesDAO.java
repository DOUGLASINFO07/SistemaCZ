package atividades;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import util.Utilitario;

/**
 * @author douglas borges egidio.
 * @author DouglasInfo07.
 * @since 15/09/2019.
 */

public class AtividadesDAO {

    private final Connection conn;

    AtividadesAtributos AA = new AtividadesAtributos();

    Utilitario util = new Utilitario();

    public AtividadesDAO() {

        this.conn = new Conexao().abrirConexao();
    }

    public boolean salvar(AtividadesAtributos AA) {

        String sql = "INSERT INTO atividades VALUES (null,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, AA.getAtividade());
                stmt.setString(2, AA.getDataInicio());
                stmt.setString(3, AA.getDatatermino());
                stmt.setString(4, AA.getCiclo());
                stmt.setString(5, AA.getObservacao());
                stmt.setString(6, AA.getNomeAtividade());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            return false;
        }
    }

    public boolean excluir(
            String atividades,
            String nomeAtividade,
            AtividadesAtributos AA
    ) {
        String sql = "DELETE FROM atividades "
                + "WHERE atividades = '" + atividades + "' "
                + "AND nomeAtividade = '" + nomeAtividade + "' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            return false;
        }
    }

    public void buscarDadosAtividade(
            String atividades,
            String nomeAtividade,
            AtividadesAtributos AA
    ) {
        String sql = "SELECT * FROM atividades "
                + "WHERE atividades = '" + atividades + "' "
                + "AND nomeAtividade = '" + nomeAtividade + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AA.setAtividade(rs.getString("atividades"));
                AA.setDataInicio(util.converterDataAmericanoBrasil(rs.getString("dataInicio")));
                AA.setDatatermino(util.converterDataAmericanoBrasil(rs.getString("dataTermino")));
                AA.setCiclo(rs.getString("ciclo"));
                AA.setObservacao(rs.getString("observacao"));
                AA.setNomeAtividade(rs.getString("nomeAtividade"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<AtividadesAtributos> listaAtividades(String atividades) {

        List<AtividadesAtributos> AtividadesLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM atividades "
                + "WHERE atividades = '" + atividades + "' "
                + "ORDER BY nomeAtividade DESC";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AtividadesAtributos AA = new AtividadesAtributos();
                AA.setAtividade(rs.getString("atividades"));
                AA.setNomeAtividade(rs.getString("nomeAtividade"));
                AtividadesLista.add(AA);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            System.out.println("Lista não retornada!!");
            return null;
        }
        return AtividadesLista;
    }//FIM DO MÉTODO.

    public void verificarAtividades(String atividades, String nomeAtividade, AtividadesAtributos AA) {

        System.out.println("" + atividades);
        System.out.println("" + nomeAtividade);
        String sqlListar = "SELECT COUNT(atividades) AS somaAtividades "
                + "FROM atividades WHERE atividades LIKE '" + atividades + "' "
                + "AND nomeAtividade LIKE '" + nomeAtividade + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AA.setAtividadesContadas(rs.getInt("somaAtividades"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
