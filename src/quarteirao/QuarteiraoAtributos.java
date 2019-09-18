package quarteirao;

import java.util.Objects;

/**
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @17/12/2018.
 */

public class QuarteiraoAtributos {

    private String localidade;
    private String rg;
    private String macroArea;
    private String microArea;
    private String supervisor;
    private String ace;
    private String observacao;
    private int quarteirao;
    private int residencia;
    private int comercio;
    private int terrenoBaldio;
    private int pontoEstrategico;
    private int outros;
    private int habitantes;
    private int caes;
    private int gatos;
    private String ratos;
    private int totalQuarteirao;
    private int totalImoveis;
    private int totalImoveisLocalidade;

    public QuarteiraoAtributos(
            String localidade,
            String rg,
            String macroArea,
            String microArea,
            String supervisor,
            String ace,
            String observacao,
            int quarteirao,
            int residencia,
            int comercio,
            int terrenoBaldio,
            int pontoEstrategico,
            int outros,
            int habitantes,
            int caes,
            int gatos,
            String ratos,
            int totalQuarteirao,
            int totalImoveis,
            int totalImoveisLocalidade
    ) {
        this.localidade = localidade;
        this.rg = rg;
        this.macroArea = macroArea;
        this.microArea = microArea;
        this.supervisor = supervisor;
        this.ace = ace;
        this.observacao = observacao;
        this.quarteirao = quarteirao;
        this.residencia = residencia;
        this.comercio = comercio;
        this.terrenoBaldio = terrenoBaldio;
        this.pontoEstrategico = pontoEstrategico;
        this.outros = outros;
        this. habitantes =  habitantes;
        this.caes = caes;
        this.gatos = gatos;
        this.ratos = ratos;
        this.totalQuarteirao = totalQuarteirao;
        this.totalImoveis = totalImoveis;
        this.totalImoveisLocalidade = totalImoveisLocalidade;
    }

    @Override
    public String toString() {
        return getLocalidade();
    }

    public QuarteiraoAtributos() {

    }

    public int getTotalImoveisLocalidade() {
        return totalImoveisLocalidade;
    }

    public void setTotalImoveisLocalidade(int totalImoveisLocalidade) {
        this.totalImoveisLocalidade = totalImoveisLocalidade;
    }
    
    public int getTotalQuarteirao() {
        return totalQuarteirao;
    }

    public void setTotalQuarteirao(int totalQuarteirao) {
        this.totalQuarteirao = totalQuarteirao;
    }

    public int getTotalImoveis() {
        return totalImoveis;
    }

    public void setTotalImoveis(int totalImoveis) {
        this.totalImoveis = totalImoveis;
    }
    
    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMacroArea() {
        return macroArea;
    }

    public void setMacroArea(String macroArea) {
        this.macroArea = macroArea;
    }

    public String getMicroArea() {
        return microArea;
    }

    public void setMicroArea(String microArea) {
        this.microArea = microArea;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAce() {
        return ace;
    }

    public void setAce(String ace) {
        this.ace = ace;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        this.quarteirao = quarteirao;
    }

    public int getResidencia() {
        return residencia;
    }

    public void setResidencia(int residencia) {
        this.residencia = residencia;
    }

    public int getComercio() {
        return comercio;
    }

    public void setComercio(int comercio) {
        this.comercio = comercio;
    }

    public int getTerrenoBaldio() {
        return terrenoBaldio;
    }

    public void setTerrenoBaldio(int terrenoBaldio) {
        this.terrenoBaldio = terrenoBaldio;
    }

    public int getPontoEstrategico() {
        return pontoEstrategico;
    }

    public void setPontoEstrategico(int pontoEstrategico) {
        this.pontoEstrategico = pontoEstrategico;
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public int getCaes() {
        return caes;
    }

    public void setCaes(int caes) {
        this.caes = caes;
    }

    public int getGatos() {
        return gatos;
    }

    public void setGatos(int gatos) {
        this.gatos = gatos;
    }

    public String getRatos() {
        return ratos;
    }

    public void setRatos(String ratos) {
        this.ratos = ratos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.localidade);
        hash = 59 * hash + Objects.hashCode(this.rg);
        hash = 59 * hash + Objects.hashCode(this.macroArea);
        hash = 59 * hash + Objects.hashCode(this.microArea);
        hash = 59 * hash + Objects.hashCode(this.supervisor);
        hash = 59 * hash + Objects.hashCode(this.ace);
        hash = 59 * hash + Objects.hashCode(this.observacao);
        hash = 59 * hash + this.quarteirao;
        hash = 59 * hash + this.residencia;
        hash = 59 * hash + this.comercio;
        hash = 59 * hash + this.terrenoBaldio;
        hash = 59 * hash + this.pontoEstrategico;
        hash = 59 * hash + this.outros;
        hash = 59 * hash + this.habitantes;
        hash = 59 * hash + this.caes;
        hash = 59 * hash + this.gatos;
        hash = 59 * hash + Objects.hashCode(this.ratos);
        hash = 59 * hash + this.totalQuarteirao;
        hash = 59 * hash + this.totalImoveis;
        hash = 59 * hash + this.totalImoveisLocalidade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuarteiraoAtributos other = (QuarteiraoAtributos) obj;
        if (this.quarteirao != other.quarteirao) {
            return false;
        }
        if (this.residencia != other.residencia) {
            return false;
        }
        if (this.comercio != other.comercio) {
            return false;
        }
        if (this.terrenoBaldio != other.terrenoBaldio) {
            return false;
        }
        if (this.pontoEstrategico != other.pontoEstrategico) {
            return false;
        }
        if (this.outros != other.outros) {
            return false;
        }
        if (this.habitantes != other.habitantes) {
            return false;
        }
        if (this.caes != other.caes) {
            return false;
        }
        if (this.gatos != other.gatos) {
            return false;
        }
        if (this.totalQuarteirao != other.totalQuarteirao) {
            return false;
        }
        if (this.totalImoveis != other.totalImoveis) {
            return false;
        }
        if (this.totalImoveisLocalidade != other.totalImoveisLocalidade) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.macroArea, other.macroArea)) {
            return false;
        }
        if (!Objects.equals(this.microArea, other.microArea)) {
            return false;
        }
        if (!Objects.equals(this.supervisor, other.supervisor)) {
            return false;
        }
        if (!Objects.equals(this.ace, other.ace)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.ratos, other.ratos)) {
            return false;
        }
        return true;
    }


}
