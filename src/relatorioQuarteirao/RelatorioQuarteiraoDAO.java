package relatorioQuarteirao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import quarteirao.QuarteiraoDAO;

/**
 * @author douglas borges egidio
 * @since 08/03/2019
 */

public class RelatorioQuarteiraoDAO {

    private final Connection conn;

    RelatorioQuarteiraoAtributos RLA = new RelatorioQuarteiraoAtributos();

    public RelatorioQuarteiraoDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<RelatorioQuarteiraoAtributos> listaRelatorioQuarteirao(
            String pesquisa,
            String pesquisa2,
            String pesquisarPor
    ) {
        List<RelatorioQuarteiraoAtributos> RelatorioQuarteiraoLista = new ArrayList<>();
        String sqlListar = null;
        switch (pesquisarPor) {
            case "LOCALIDADE":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE localidade LIKE '" + pesquisa + "%' "
                        + "AND rg LIKE '" + pesquisa2 + "' "
                        + "ORDER BY rg ASC";
                break;
            case "MACRO ÁREA":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE macroArea LIKE '" + pesquisa + "%' "
                        + "AND rg LIKE '" + pesquisa2 + "' "
                        + "ORDER BY microArea";
                break;
            case "MICRO ÁREA":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE microArea LIKE '" + pesquisa + "%' "
                        + "AND rg LIKE '" + pesquisa2 + "' "
                        + "ORDER BY ace";
                break;
            case "SUPERVISOR":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE supervisor LIKE '" + pesquisa + "%' "
                        + "AND rg LIKE '" + pesquisa2 + "' "
                        + "ORDER BY rg desc";
                break;
            case "ACE":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE ace LIKE '" + pesquisa + "%' "
                        + "AND rg LIKE '" + pesquisa2 + "' "
                        + "ORDER BY rg desc";
                break;
            case "RG":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE rg LIKE '" + pesquisa + "%' "
                        + "ORDER BY localidade";
                break;
            case "TODOS":
                sqlListar = "SELECT * FROM quarteirao "
                        + "WHERE rg LIKE '" + pesquisa2 + "%' "
                        + "ORDER BY localidade";
                break;
            default:
                break;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RelatorioQuarteiraoAtributos RLA = new RelatorioQuarteiraoAtributos();
                RLA.setLocalidadeCT(rs.getString("localidade"));
                RLA.setMacroAreaCT(rs.getString("macroArea"));
                RLA.setMicroAreaCT(rs.getString("microArea"));
                RLA.setSupervisorCT(rs.getString("supervisor"));
                RLA.setAceCT(rs.getString("ace"));
                RLA.setRgCT(rs.getString("rg"));
                RLA.setQuarteiraoCT(rs.getInt("quarteirao"));
                RLA.setResidenciaCT(rs.getInt("residencias"));
                RLA.setComercioCT(rs.getInt("comercios"));
                RLA.setTerrenoBaldioCT(rs.getInt("terrenoBaldio"));
                RLA.setPECT(rs.getInt("pontoEstrategico"));
                RLA.setOutrosCT(rs.getInt("outros"));
                
                RLA.setTotalCT((rs.getInt("residencias"))+(
                        rs.getInt("comercios"))+
                        (rs.getInt("terrenoBaldio"))+
                        (rs.getInt("pontoEstrategico"))+
                        (rs.getInt("outros"))
                );
                
                RLA.setHabitanteCT(rs.getInt("habitantes"));
                RelatorioQuarteiraoLista.add(RLA);
            }
            stmt.close();
            rs.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioQuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return RelatorioQuarteiraoLista;
    }//FIM DO MÉTODO.
    
     public void listaLocalidade(ComboBox localidade) {

        ObservableList<String> listaLocalidade = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM localidade ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaLocalidade.add(rs.getString("nome"));
            }
            localidade.setItems(listaLocalidade);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }
    
    public void listaSupervisor(ComboBox supervisor) {

        ObservableList<String> listaFuncionario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE cargo = 'Supervisor de Área' "
                + "ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaFuncionario.add(rs.getString("nome"));
            }
            supervisor.setItems(listaFuncionario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaACE(ComboBox ace) {

        ObservableList<String> listaFuncionario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE cargo = 'Agente de Endemias' "
                + "ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaFuncionario.add(rs.getString("nome"));
            }
            ace.setItems(listaFuncionario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaRG(ComboBox rg) {

        ObservableList<String> listaRG = FXCollections.observableArrayList();
        String sqlListar = "SELECT DISTINCT rg FROM quarteirao ORDER BY rg desc";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaRG.add(rs.getString("rg"));
            }
            rg.setItems(listaRG);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

}
