package servicoTratamentoFocal;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import util.Utilitario;

/**
 * @author douglas borges egidio
 * @since 20/03/2019
 */

public class ServicoTratamentoFocalDAO {

    Connection conn;

    ServicoTratamentoFocalAtributos STF = new ServicoTratamentoFocalAtributos();

    Utilitario util = new Utilitario();

    public ServicoTratamentoFocalDAO() {
        this.conn = new Conexao().abrirConexao();
    }

//       public ServicoTratamentoFocalDAO() {
//    }

    public boolean salvar(ServicoTratamentoFocalAtributos STF) {
        String sql = "INSERT INTO servicotratamentofocal VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, STF.getRg());
                stmt.setString(2, STF.getLocalidade());
                stmt.setString(3, STF.getCategoria());
                stmt.setString(4, STF.getTipo());
                stmt.setString(5, STF.getZona());
                stmt.setString(6, STF.getData());
                stmt.setString(7, STF.getSemana());
                stmt.setString(8, STF.getCiclo());
                stmt.setString(9, STF.getAce());
                stmt.setString(10, STF.getSupervisor());
                stmt.setString(11, STF.getTrabalhouQuarteirao());
                stmt.setString(12, STF.getObservacao());
                stmt.setInt(13, STF.getQuarteirao());
                stmt.setString(14, STF.getLados());
                stmt.setInt(15, STF.getResidencia());
                stmt.setInt(16, STF.getComercio());
                stmt.setInt(17, STF.getTerrenoBaldio());
                stmt.setInt(18, STF.getOutros());
                stmt.setInt(19, STF.getVisitaResgate());
                stmt.setInt(20, STF.getEliminado());
                stmt.setInt(21, STF.getTratado());
                stmt.setString(22, STF.getLarvicida());
                stmt.setDouble(23, STF.getQuantidadeLarvicida());
                stmt.setInt(24, STF.getQuantTratados());
                stmt.setString(25, STF.getSituacaoQuarteirao()
                );
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            return false;
        }
    }

    public boolean atualizar(ServicoTratamentoFocalAtributos STF) {

        String sql = "UPDATE servicotratamentofocal "
                + "SET localidade = ?, "
                + "categoria = ?, "
                + "tipo = ?, "
                + "zona = ?, "
                + "data = ?, "
                + "semana = ?, "
                + "ace = ?, "
                + "supervisor = ?, "
                + "comoTrabalhou = ?, "
                + "observacao = ?, "
                + "lado = ?, "
                + "residencia = ?, "
                + "comercio = ?, "
                + "terrenoBaldio = ?, "
                + "outros = ?, "
                + "visitaResgate = ?, "
                + "eliminado = ?, "
                + "imovelTratado = ?, "
                + "larvicida = ?, "
                + "quantLarvicida = ?, "
                + "quantTratado = ?, "
                + "situacaoQuarteirao = ? "
                + "WHERE quarteirao = ? "
                + "AND rg = ? "
                + "AND ciclo = ? ";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, STF.getLocalidade());
                stmt.setString(2, STF.getCategoria());
                stmt.setString(3, STF.getTipo());
                stmt.setString(4, STF.getZona());
                stmt.setString(5, STF.getData());
                stmt.setString(6, STF.getSemana());
                stmt.setString(7, STF.getAce());
                stmt.setString(8, STF.getSupervisor());
                stmt.setString(9, STF.getTrabalhouQuarteirao());
                stmt.setString(10, STF.getObservacao());
                stmt.setString(11, STF.getLados());
                stmt.setInt(12, STF.getResidencia());
                stmt.setInt(13, STF.getComercio());
                stmt.setInt(14, STF.getTerrenoBaldio());
                stmt.setInt(15, STF.getOutros());
                stmt.setInt(16, STF.getVisitaResgate());
                stmt.setInt(17, STF.getEliminado());
                stmt.setInt(18, STF.getTratado());
                stmt.setString(19, STF.getLarvicida());
                stmt.setDouble(20, STF.getQuantidadeLarvicida());
                stmt.setInt(21, STF.getQuantTratados());
                stmt.setString(22, STF.getSituacaoQuarteirao());
                stmt.setInt(23, STF.getQuarteirao());
                stmt.setString(24, STF.getRg());
                stmt.setString(25, STF.getCiclo());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(
            int quarteirao,
            String data,
            String Ace,
            ServicoTratamentoFocalAtributos STF
    ) {
        String sql = "DELETE FROM servicotratamentofocal "
                + "WHERE quarteirao = '" + quarteirao + "' "
                + "AND data = '" + data + "' "
                + "AND ace = '" + Ace + "' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void buscarDadosServicoTratamentoFocal(
            int quarteirao,
            String localidade,
            String data,
            String ace,
            ServicoTratamentoFocalAtributos STFA
    ) {
        String sql = "SELECT * FROM servicotratamentofocal "
                + "WHERE quarteirao = '" + quarteirao + "' "
                + "AND localidade = '" + localidade + "' "
                + "AND ace = '" + ace + "' "
                + "AND data = '" + util.converterDataBrasilAmericano(data) + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                STFA.setRg(rs.getString("rg"));
                STFA.setLocalidade(rs.getString("localidade"));
                STFA.setCategoria(rs.getString("categoria"));
                STFA.setTipo(rs.getString("tipo"));
                STFA.setZona(rs.getString("zona"));
                STFA.setData(rs.getString("data"));
                STFA.setSemana(rs.getString("semana"));
                STFA.setCiclo(rs.getString("ciclo"));
                STFA.setAce(rs.getString("ace"));
                STFA.setSupervisor(rs.getString("supervisor"));
                STFA.setTrabalhouQuarteirao(rs.getString("comoTrabalhou"));
                STFA.setObservacao(rs.getString("observacao"));
                STFA.setQuarteirao(rs.getInt("quarteirao"));
                STFA.setLados(rs.getString("lado"));
                STFA.setResidencia(rs.getInt("residencia"));
                STFA.setComercio(rs.getInt("comercio"));
                STFA.setTerrenoBaldio(rs.getInt("terrenoBaldio"));
                STFA.setOutros(rs.getInt("outros"));
                STFA.setVisitaResgate(rs.getInt("VisitaResgate"));
                STFA.setEliminado(rs.getInt("eliminado"));
                STFA.setTratado(rs.getInt("imovelTratado"));
                STFA.setLarvicida(rs.getString("larvicida"));
                STFA.setQuantidadeLarvicida(rs.getInt("quantLarvicida"));
                STFA.setQuantTratados(rs.getInt("quantTratado"));
                STFA.setSituacaoQuarteirao(rs.getString("situacaoQuarteirao"));
            }
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<ServicoTratamentoFocalAtributos> listaServicoTratamentoFocal(String localidade, String ciclo) {
        List<ServicoTratamentoFocalAtributos> ServicoTratamentoFocalLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM servicotratamentofocal "
                + "WHERE localidade = '" + localidade + "' "
                + "AND ciclo = '" + ciclo + "' "
                + "ORDER BY quarteirao ASC";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServicoTratamentoFocalAtributos STF = new ServicoTratamentoFocalAtributos();
                STF.setQuarteirao(rs.getInt("quarteirao"));
                STF.setData(util.converterDataAmericanoBrasil(rs.getString("data")));
                STF.setSemana(rs.getString("semana"));
                STF.setCiclo(rs.getString("ciclo"));
                STF.setAce(rs.getString("ace"));
                STF.setSituacaoQuarteirao(rs.getString("situacaoQuarteirao"));
                ServicoTratamentoFocalLista.add(STF);
            }
            stmt.close();
            rs.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista de servico não retornada !!");
            return null;
        }
        return ServicoTratamentoFocalLista;
    }//FIM DO MÉTODO.

    public void listaSupervisor(ComboBox supervisor) {

        ObservableList<String> listaFuncionario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE cargo = 'supervisor de Área' "
                + "ORDER BY nome";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaFuncionario.add(rs.getString("nome"));
            }
//            listaFuncionario.add("Selecione");
            supervisor.setItems(listaFuncionario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//            listaFuncionario.add("Selecione");
            ace.setItems(listaFuncionario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaCiclo(ComboBox quarteirao) {

        ObservableList<String> listaCiclo = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM atividades WHERE atividades = 'Tratamento Focal' ORDER BY nomeAtividade DESC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaCiclo.add(rs.getString("nomeAtividade"));
            }
            quarteirao.setItems(listaCiclo);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista de quarteirao não retornada!!");
        }
    }
    
    public void listaLocalidade( ComboBox localidade) {

        ObservableList<String> listaLocalidade = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM localidade  ORDER BY nome ASC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaLocalidade.add(rs.getString("nome"));
            }
                listaLocalidade.add("SELECIONE UMA LOCALIDADE");
            localidade.setItems(listaLocalidade);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista de quarteirao não retornada!!");
        }
    }

    public void verificarServicoTratamentoFocal(String rg, String ace, String data, String quarteirao, ServicoTratamentoFocalAtributos STF) {

        String sqlListar = "SELECT COUNT(quarteirao) AS somaServicoTratamentoFocal "
                + "FROM servicotratamentofocal "
                + "WHERE rg = '" + rg + "' "
                + "AND data = '" + util.converterDataBrasilAmericano(data) + "' "
                + "AND ace = '" + ace + "' "
                + "AND quarteirao = '" + quarteirao + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                STF.setSomaParaConferirServicoLancado(rs.getInt("somaServicoTratamentoFocal"));
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificarServicoTratamentoFocalConcluido(
            String rg, 
            String quarteirao, 
            String ciclo,
            ServicoTratamentoFocalAtributos STF
    ) {
        String sqlListar = "SELECT COUNT(ace) AS somaACE "
                + "FROM servicotratamentofocal "
                + "WHERE rg = '" + rg + "' "
                + "AND situacaoQuarteirao = 'Concluído' "
                + "AND ciclo = '" + ciclo + "' "
                + "AND quarteirao = '" + quarteirao + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                STF.setSomaParaConferirServicoLancadoConcluido(rs.getInt("somaACE"));
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarLocalidade(
            TextField rg,
            ServicoTratamentoFocalAtributos STFA
    ) {
        String sql = "SELECT * FROM localidade "
                + "WHERE codigo = '" + rg.getText() + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                STFA.setLocalidade(rs.getString("nome"));
                STFA.setCategoria(rs.getString("categoria"));
                STFA.setTipo(rs.getString("tipo"));
                STFA.setZona(rs.getString("zona"));
            }
//            rs.close();
//            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
    public void buscarCiclo(
            DatePicker data,
            ServicoTratamentoFocalAtributos STFA
    ) {
        if(data.getEditor().getText() != ""){
        String sql = "SELECT * FROM atividades "
                + "WHERE dataInicio <= '" + util.converterDataBrasilAmericano(data.getEditor().getText()) + "' "
                + "AND dataTermino >= '" + util.converterDataBrasilAmericano(data.getEditor().getText()) + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                STFA.setCiclo(rs.getString("nomeAtividade"));
            }
//            rs.close();
//            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoTratamentoFocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//FIM DO MÉTODO.
}
