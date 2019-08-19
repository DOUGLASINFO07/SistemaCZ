package quarteirao;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import util.Utilitario;

/**
 *
 * @author dougl
 */
public class QuarteiraoDAO {

    private Connection conn;

    QuarteiraoAtributos QA = new QuarteiraoAtributos();

    Utilitario util = new Utilitario();

    public QuarteiraoDAO() {
        
        this.conn = new Conexao().abrirConexao();
    }

    public boolean salvar(QuarteiraoAtributos QA) {

        String sql = "INSERT INTO quarteirao VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, QA.getLocalidade());
                stmt.setString(2, QA.getRg());
                stmt.setString(3, QA.getMacroArea());
                stmt.setString(4, QA.getMicroArea());
                stmt.setString(5, QA.getSupervisor());
                stmt.setString(6, QA.getAce());
                stmt.setString(7, QA.getObservacao());
                stmt.setInt(8, QA.getQuarteirao());
                stmt.setInt(9, QA.getResidencia());
                stmt.setInt(10, QA.getComercio());
                stmt.setInt(11, QA.getTerrenoBaldio());
                stmt.setInt(12, QA.getPontoEstrategico());
                stmt.setInt(13, QA.getOutros());
                stmt.setInt(14, QA.getCaes());
                stmt.setInt(15, QA.getGatos());
                stmt.setString(16, QA.getRatos());
                stmt.setInt(17, QA.getHabitantes()
                );
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            return false;
        }
    }

    public boolean atualizar(QuarteiraoAtributos QA) {

        String sql = "UPDATE quarteirao "
                + "SET macroArea = ?, "
                + "microArea = ?, "
                + "supervisor = ?, "
                + "ace = ?, "
                + "observacao = ?, "
                + "residencias = ?, "
                + "comercios = ?, "
                + "terrenoBaldio = ?, "
                + "pontoEstrategico = ?, "
                + "outros = ?, "
                + "caes = ?, "
                + "gatos = ?, "
                + "ratos = ?, "
                + "habitantes = ? "
                + "WHERE localidade = ? "
                + "AND quarteirao = ? "
                + "AND rg = ? ";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, QA.getMacroArea());
                stmt.setString(2, QA.getMicroArea());
                stmt.setString(3, QA.getSupervisor());
                stmt.setString(4, QA.getAce());
                stmt.setString(5, QA.getObservacao());
                stmt.setInt(6, QA.getResidencia());
                stmt.setInt(7, QA.getComercio());
                stmt.setInt(8, QA.getTerrenoBaldio());
                stmt.setInt(9, QA.getPontoEstrategico());
                stmt.setInt(10, QA.getOutros());
                stmt.setInt(11, QA.getCaes());
                stmt.setInt(12, QA.getGatos());
                stmt.setString(13, QA.getRatos());
                stmt.setInt(14, QA.getHabitantes());
                stmt.setString(15, QA.getLocalidade());
                stmt.setInt(16, QA.getQuarteirao());
                stmt.setString(17, QA.getRg());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(
            int quarteirao,
            String rg,
            QuarteiraoAtributos QA
    ) {
        String sql = "DELETE FROM quarteirao "
                + "WHERE quarteirao = '" + quarteirao + "' "
                + "AND rg = '" + rg + "' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void buscarDadosBairro(
            String quarteirao,
            String rg,
            QuarteiraoAtributos QA
    ) {
        String sql = "SELECT * FROM quarteirao "
                + "WHERE quarteirao = '" + quarteirao + "' "
                + "AND rg = '" + rg + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QA.setLocalidade(rs.getString("localidade"));
                QA.setRg(rs.getString("rg"));
                QA.setMacroArea(rs.getString("macroArea"));
                QA.setMicroArea(rs.getString("microArea"));
                QA.setSupervisor(rs.getString("supervisor"));
                QA.setAce(rs.getString("ace"));
                QA.setObservacao(rs.getString("observacao"));
                QA.setQuarteirao(rs.getInt("quarteirao"));
                QA.setResidencia(rs.getInt("residencias"));
                QA.setComercio(rs.getInt("comercios"));
                QA.setTerrenoBaldio(rs.getInt("terrenoBaldio"));
                QA.setPontoEstrategico(rs.getInt("pontoEstrategico"));
                QA.setOutros(rs.getInt("outros"));
                QA.setCaes(rs.getInt("caes"));
                QA.setGatos(rs.getInt("gatos"));
                QA.setRatos(rs.getString("ratos"));
                QA.setHabitantes(rs.getInt("habitantes"));
//                stmt.execute();
            }
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<QuarteiraoAtributos> listaQuarteirao(String localidade, String rg) {
        List<QuarteiraoAtributos> QuarteiraoLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM quarteirao "
                + "WHERE localidade = '" + localidade + "' "
                + "AND rg = '" + rg + "' "
                + "ORDER BY quarteirao ASC";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QuarteiraoAtributos QA = new QuarteiraoAtributos();

                QA.setTotalImoveis(
                        (rs.getInt("residencias"))
                        + (rs.getInt("comercios"))
                        + (rs.getInt("terrenobaldio"))
                        + (rs.getInt("pontoEstrategico"))
                        + (rs.getInt("outros"))
                );
                QA.setQuarteirao(rs.getInt("quarteirao"));
                QuarteiraoLista.add(QA);
            }
            stmt.close();
            rs.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return QuarteiraoLista;
    }//FIM DO MÉTODO.

    public List<QuarteiraoAtributos> listaQuarteiraoFormulario(String localidade, String rg) {
        List<QuarteiraoAtributos> QuarteiraoLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM quarteirao "
                + "WHERE localidade = '" + localidade + "' "
                + "AND rg = '" + rg + "' "
                + "ORDER BY quarteirao ASC";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QuarteiraoAtributos QA = new QuarteiraoAtributos();

                QA.setTotalImoveis(
                        (rs.getInt("residencias"))
                        + (rs.getInt("comercios"))
                        + (rs.getInt("terrenobaldio"))
                        + (rs.getInt("pontoEstrategico"))
                        + (rs.getInt("outros"))
                );
                QA.setQuarteirao(rs.getInt("quarteirao"));
                QuarteiraoLista.add(QA);
            }
            stmt.close();
            rs.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return QuarteiraoLista;
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
            listaLocalidade.add("Selecione");
            localidade.setItems(listaLocalidade);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }
    
    public void listaLocalidadePesquisa(ComboBox localidade) {

        ObservableList<String> listaLocalidade = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM localidade ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaLocalidade.add(rs.getString("nome"));
            }
            listaLocalidade.add("Selecione uma Localidade");
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
            listaFuncionario.add("Selecione");
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
            listaFuncionario.add("Selecione");
            ace.setItems(listaFuncionario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaRG(ComboBox buscarRG) {

        ObservableList<String> listaRG = FXCollections.observableArrayList();
        String sqlListar = "SELECT DISTINCT rg FROM quarteirao ORDER BY rg desc";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaRG.add(rs.getString("rg"));
            }
            listaRG.add("Selecione um RG");
            buscarRG.setItems(listaRG);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void somaTotalQuarteirao(String localidade, String rg, QuarteiraoAtributos QA) {

        String sqlListar = "SELECT COUNT(quarteirao) AS somaQuarteirao "
                + "FROM quarteirao WHERE localidade LIKE '" + localidade + "' "
                + "AND rg LIKE '" + rg + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QA.setTotalQuarteirao(rs.getInt("somaQuarteirao"));
            }
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada soma Total de quarteirão!!");
        }
    }

    public void somaImoveisLocalidade(String localidade, String rg, QuarteiraoAtributos QA) {

        int soma;
        QA.setTotalImoveisLocalidade(0);

        String sqlListar = "SELECT * "
                + "FROM quarteirao WHERE localidade LIKE '" + localidade + "' "
                + "AND rg LIKE '" + rg + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                soma = rs.getInt("residencias")
                        + rs.getInt("comercios")
                        + rs.getInt("terrenobaldio")
                        + rs.getInt("pontoEstrategico")
                        + rs.getInt("outros");
                QA.setTotalImoveisLocalidade(QA.getTotalImoveisLocalidade() + soma);
            }

            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada soma total de imoveis localidade!!");
        }
    }

    public void verificarQuarteirao(String localidade, String rg, int quarteirao, QuarteiraoAtributos QA) {

        String sqlListar = "SELECT COUNT(quarteirao) AS somaQuarteirao "
                + "FROM quarteirao WHERE localidade LIKE '" + localidade + "' "
                + "AND rg LIKE '" + rg + "' "
                + "AND quarteirao LIKE '" + quarteirao + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                QA.setTotalQuarteirao(rs.getInt("somaQuarteirao"));
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuarteiraoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
