package util;

import java.io.Serializable;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @since 11/09/2019
 */
public class Categoria implements Serializable {

    private String bairro;

    public Categoria(String bairro) {
        this.bairro = bairro;
    }

    public Categoria() {
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return bairro;
    }

}
