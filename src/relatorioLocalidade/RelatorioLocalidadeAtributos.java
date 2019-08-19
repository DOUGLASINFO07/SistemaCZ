package relatorioLocalidade;

/**
 * @author douglas borges egidio
 * @17/12/2018.
 */

public class RelatorioLocalidadeAtributos {

    private String campoPesquisaCB;
    private String campoPesquisaTF;
    private String pesquisarPor;
    private String codigoCT;
    private String nomeCT;
    private String siglaCT;
    private String categoriaCT;
    private String zonaCT;
    private String tipoCT;
    private String observacaoCT;

    public RelatorioLocalidadeAtributos() {
    }

    public RelatorioLocalidadeAtributos(
            String campoPesquisaCB, 
            String campoPesquisaTF, 
            String pesquisarPor, 
            String codigoCT, 
            String nomeCT, 
            String siglaCT, 
            String categoriaCT, 
            String zonaCT, 
            String tipoCT, 
            String observacaoCT
    ) {
        this.campoPesquisaCB = campoPesquisaCB;
        this.campoPesquisaTF = campoPesquisaTF;
        this.pesquisarPor = pesquisarPor;
        this.codigoCT = codigoCT;
        this.nomeCT = nomeCT;
        this.siglaCT = siglaCT;
        this.categoriaCT = categoriaCT;
        this.zonaCT = zonaCT;
        this.tipoCT = tipoCT;
        this.observacaoCT = observacaoCT;
    }
    
    public String getCampoPesquisaCB() {
        return campoPesquisaCB;
    }

    public void setCampoPesquisaCB(String campoPesquisaCB) {
        this.campoPesquisaCB = campoPesquisaCB;
    }

    public String getCampoPesquisaTF() {
        return campoPesquisaTF;
    }

    public void setCampoPesquisaTF(String campoPesquisaTF) {
        this.campoPesquisaTF = campoPesquisaTF;
    }

    public String getPesquisarPor() {
        return pesquisarPor;
    }

    public void setPesquisarPor(String pesquisarPor) {
        this.pesquisarPor = pesquisarPor;
    }

    public String getCodigoCT() {
        return codigoCT;
    }

    public void setCodigoCT(String codigoCT) {
        this.codigoCT = codigoCT;
    }

    public String getNomeCT() {
        return nomeCT;
    }

    public void setNomeCT(String nomeCT) {
        this.nomeCT = nomeCT;
    }

    public String getSiglaCT() {
        return siglaCT;
    }

    public void setSiglaCT(String siglaCT) {
        this.siglaCT = siglaCT;
    }

    public String getCategoriaCT() {
        return categoriaCT;
    }

    public void setCategoriaCT(String categoriaCT) {
        this.categoriaCT = categoriaCT;
    }

    public String getZonaCT() {
        return zonaCT;
    }

    public void setZonaCT(String zonaCT) {
        this.zonaCT = zonaCT;
    }

    public String getTipoCT() {
        return tipoCT;
    }

    public void setTipoCT(String tipoCT) {
        this.tipoCT = tipoCT;
    }

    public String getObservacaoCT() {
        return observacaoCT;
    }

    public void setObservacaoCT(String observacaoCT) {
        this.observacaoCT = observacaoCT;
    }



}
