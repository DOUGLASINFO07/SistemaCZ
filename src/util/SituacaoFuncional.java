package util;

import java.io.Serializable;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @since 11/09/2019
 */
public class SituacaoFuncional implements Serializable {

    private String situacaoFuncional;

    public SituacaoFuncional(String situacaoFuncional) {
        this.situacaoFuncional = situacaoFuncional;
    }

    public SituacaoFuncional() {
    }

    public String getSituacaoFuncional() {
        return situacaoFuncional;
    }

    public void setSituacaoFuncional(String situacaoFuncional) {
        this.situacaoFuncional = situacaoFuncional;
    }

    @Override
    public String toString() {
        return situacaoFuncional;
    }

}
