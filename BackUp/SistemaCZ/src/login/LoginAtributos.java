package login;

/**
 * @author douglas borges egidio
 * @27/02/2019.
 */

public class LoginAtributos {
 

    private String nomeLogin;
    private String senha;
    private int contagem;

    public LoginAtributos() {

    }

    public LoginAtributos(
            String nomeLogin, 
            String senha,
            int contagem
    ) {
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.contagem = contagem;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getContagem() {
        return contagem;
    }

    public void setContagem(int contagem) {
        this.contagem = contagem;
    }

}
