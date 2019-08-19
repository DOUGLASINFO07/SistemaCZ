package denuncia;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import util.Utilitario;

/**
 * @author douglas borges egidio
 */
public class DenunciaDAO {

    Connection conn;

    DenunciaAtributos d = new DenunciaAtributos();

    Utilitario util = new Utilitario();

    public DenunciaDAO() {
        this.conn = new Conexao().abrirConexao();
    }

    public boolean salvar(DenunciaAtributos d) {
        String sql = "INSERT INTO denuncia VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, d.getNumeroDenuncia());
                stmt.setString(2, d.getDataDenuncia());
                stmt.setString(3, d.getRecebidaPor());
                stmt.setString(4, d.getDenunciante());
                stmt.setString(5, d.getDenunciado());
                stmt.setString(6, d.getLogradouro());
                stmt.setString(7, d.getNumeroEndereco());
                stmt.setString(8, d.getBairro());
                stmt.setString(9, d.getTipoImovel());
                stmt.setString(10, d.getTipoDenuncia());
                stmt.setString(11, d.getDetalhesDenuncia());
                stmt.setString(12, d.getAce1());
                stmt.setString(13, d.getAce2());
                stmt.setString(14, d.getSituacaoVisita());
                stmt.setString(15, d.getDataVisita());
                stmt.setString(16, d.getDetalhesVisita()
                );
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("" + ex);
            alert.show();
            return false;
        }
    }

    public boolean atualizar(DenunciaAtributos d) {

        String sql = "UPDATE denuncia "
                + "SET dataDenuncia = ?, "
                + "recebidaPor = ?, "
                + "denunciante = ?, "
                + "denunciado = ?, "
                + "logradouro = ?, "
                + "numeroEndereco = ?, "
                + "bairro = ?, "
                + "tipoImovel = ?, "
                + "tipoDenuncia = ?, "
                + "detalhesDenuncia = ?, "
                + "ace1 = ?, "
                + "ace2 = ?, "
                + "situacaoVisita = ?, "
                + "dataVisita = ?, "
                + "detalhesVisita = ? "
                + "WHERE numeroDenuncia = ? ";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, d.getDataDenuncia());
                stmt.setString(2, d.getRecebidaPor());
                stmt.setString(3, d.getDenunciante());
                stmt.setString(4, d.getDenunciado());
                stmt.setString(5, d.getLogradouro());
                stmt.setString(6, d.getNumeroEndereco());
                stmt.setString(7, d.getBairro());
                stmt.setString(8, d.getTipoImovel());
                stmt.setString(9, d.getTipoDenuncia());
                stmt.setString(10, d.getDetalhesDenuncia());
                stmt.setString(11, d.getAce1());
                stmt.setString(12, d.getAce2());
                stmt.setString(13, d.getSituacaoVisita());
                stmt.setString(14, d.getDataVisita());
                stmt.setString(15, d.getDetalhesVisita());
                stmt.setInt(16, d.getNumeroDenuncia());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(
            int numeroDenuncia,
            DenunciaAtributos d
    ) {
        String sql = "DELETE FROM denuncia "
                + "WHERE numeroDenuncia = '" + numeroDenuncia + "' ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void buscarDadosDenuncia(
            int numeroDenuncia,
            DenunciaAtributos d
    ) {
        String sql = "SELECT * FROM denuncia "
                + "WHERE numeroDenuncia = '" + numeroDenuncia + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d.setNumeroDenuncia(rs.getInt("numeroDenuncia"));
                d.setDataDenuncia(rs.getString("dataDenuncia"));
                d.setRecebidaPor(rs.getString("recebidaPor"));
                d.setDenunciante(rs.getString("denunciante"));
                d.setDenunciado(rs.getString("denunciado"));
                d.setLogradouro(rs.getString("logradouro"));
                d.setNumeroEndereco(rs.getString("numeroEndereco"));
                d.setBairro(rs.getString("bairro"));
                d.setTipoImovel(rs.getString("tipoImovel"));
                d.setTipoDenuncia(rs.getString("tipoDenuncia"));
                d.setDetalhesDenuncia(rs.getString("detalhesDenuncia"));
                d.setAce1(rs.getString("ace1"));
                d.setAce2(rs.getString("ace2"));
                d.setSituacaoVisita(rs.getString("situacaoVisita"));
                d.setDataVisita(rs.getString("dataVisita"));
                d.setDetalhesVisita(rs.getString("detalhesVisita"));
            }
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    public void listaACE(ComboBox ace) {

        ObservableList<String> listaFuncionario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE areaTrabalho = 'Denuncias e Notificações' "
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
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaACEDenuncia(ComboBox ace) {

        ObservableList<String> listaFuncionario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM funcionario "
                + "WHERE areaTrabalho = 'Escritório' "
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
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }

    public void listaLocalidade(ComboBox localidade) {

        ObservableList<String> listaLocalidade = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM localidade  ORDER BY nome ASC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaLocalidade.add(rs.getString("nome"));
            }
            localidade.setItems(listaLocalidade);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista de quarteirao não retornada!!");
        }
    }

    public void verificarDenunciaLancadaDia(
            String logradouro,
            String numeroEndereco,
            String dataDenuncia,
            DenunciaAtributos d
    ) {
        String sqlListar = "SELECT COUNT(numeroDenuncia) AS somaDenuncia "
                + "FROM denuncia "
                + "WHERE logradouro = '" + logradouro + "' "
                + "AND dataDenuncia = '" + util.converterDataBrasilAmericano(dataDenuncia) + "' "
                + "AND numeroEndereco = '" + numeroEndereco + "' ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d.setSomaParaConferirDenunciaLancadaDia(rs.getInt("somaDenuncia"));
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contagemNumeroDenuncia(
            DenunciaAtributos d
    ) {
        String sqlListar = "SELECT * FROM denuncia "
                + "WHERE numeroDenuncia = (SELECT MAX(numeroDenuncia) FROM denuncia) ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d.setSomaNumeroDenuncia(rs.getInt("numeroDenuncia"));
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
