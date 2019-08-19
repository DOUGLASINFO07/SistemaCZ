package relatorioFuncionario;

import javafx.scene.control.TableColumn;

/**
 * @author douglas borges egidio
 * @17/12/2018.
 */
public class RelatorioFuncionarioAtributos {

    private String campoPesquisaCB;
    private String campoPesquisaTF;
    private String pesquisarPor;
    private String nomeCT;
    private String matriculaCT;
    private String situacaoFuncionalCT;
    private String cargoCT;
    private String areaTrabalhoCT;
    private String equipeCT;
    private String vinculoEmpregaticioCT;

    public RelatorioFuncionarioAtributos() {
    }

    public RelatorioFuncionarioAtributos(
            String campoPesquisaCB, 
            String campoPesquisaTF, 
            String pesquisarPor, 
            String nomeCT, 
            String matriculaCT, 
            String situacaoFuncionalCT, 
            String cargoCT, 
            String areaTrabalhoCT, 
            String equipeCT, 
            String vinculoEmpregaticioCT
    ) {
        this.campoPesquisaCB = campoPesquisaCB;
        this.campoPesquisaTF = campoPesquisaTF;
        this.pesquisarPor = pesquisarPor;
        this.nomeCT = nomeCT;
        this.matriculaCT = matriculaCT;
        this.situacaoFuncionalCT = situacaoFuncionalCT;
        this.cargoCT = cargoCT;
        this.areaTrabalhoCT = areaTrabalhoCT;
        this.equipeCT = equipeCT;
        this.vinculoEmpregaticioCT = vinculoEmpregaticioCT;
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

    public String getNomeCT() {
        return nomeCT;
    }

    public void setNomeCT(String nomeCT) {
        this.nomeCT = nomeCT;
    }

    public String getMatriculaCT() {
        return matriculaCT;
    }

    public void setMatriculaCT(String matriculaCT) {
        this.matriculaCT = matriculaCT;
    }

    public String getSituacaoFuncionalCT() {
        return situacaoFuncionalCT;
    }

    public void setSituacaoFuncionalCT(String situacaoFuncionalCT) {
        this.situacaoFuncionalCT = situacaoFuncionalCT;
    }

    public String getCargoCT() {
        return cargoCT;
    }

    public void setCargoCT(String cargoCT) {
        this.cargoCT = cargoCT;
    }

    public String getAreaTrabalhoCT() {
        return areaTrabalhoCT;
    }

    public void setAreaTrabalhoCT(String areaTrabalhoCT) {
        this.areaTrabalhoCT = areaTrabalhoCT;
    }

    public String getEquipeCT() {
        return equipeCT;
    }

    public void setEquipeCT(String equipeCT) {
        this.equipeCT = equipeCT;
    }

    public String getVinculoEmpregaticioCT() {
        return vinculoEmpregaticioCT;
    }

    public void setVinculoEmpregaticioCT(String vinculoEmpregaticioCT) {
        this.vinculoEmpregaticioCT = vinculoEmpregaticioCT;
    }



}
