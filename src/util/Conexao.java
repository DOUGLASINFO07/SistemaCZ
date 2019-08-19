package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author dougl
 */
public class Conexao {

    //MÉTODO QUE ABRI A CONEXÃO COM O BANCO DE DADOS.
    public Connection abrirConexao() {
        try {
            String bancodados = "sistemacz";
            String url = "jdbc:mysql://sistemacz.mysql.uhserver.com/" + bancodados + "?verifyServerCertificate=false&useSSL=true";
            String usuario = "sistemacz";
            String senha = "030182.dtb";
//            String bancodados = "sistemaCZ";
//            String url = "jdbc:mysql://localhost/" + bancodados + "?verifyServerCertificate=false&useSSL=true";
//            String usuario = "root";
//            String senha = "";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro de conxão com o banco de dados", ButtonType.OK);
            alert.setTitle("SISTEMA GERENCIAMENTO DE CONTROLE DE ZOONOSES");
//            alert.setContentText(""+ex);
            alert.setHeaderText("CARA, ALGUMA COISA ACONTECEU!!\n"
                    + "NÃO FOI POSSÍVEL CONECTAR COM O BANCO DE DADOS!!");
            alert.show();
            System.out.println("Não Abriu conexão");
            throw new RuntimeException(ex);
        }

    }//FIM DO MÉTODO ABRIRCONEXAO().

    public Connection fecharConexao() {
        return null;

    }
}
