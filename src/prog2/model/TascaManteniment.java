package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * TascaManteniment és una classe que representa les tasques realitzades en el càmping per
 * mantenir el correcte funcionament dels allotjaments. Cada objecte d'aquesta classe té un tipus
 * concret, un identificador, allotjament assignat, una data i els dies que trigarà.
 */
public class TascaManteniment implements InTascaManteniment, Serializable {

    public static enum TipusTascaManteniment {Reparacio, Neteja, RevisioTecnica, Desinfeccio}

    /**
     * Atributs de la classe TascaManteniment
     */
    private int num;
    private Allotjament allotjament;
    private String data;
    private TipusTascaManteniment tipus;
    private int dies;

    /**
     * Constructor de la classe TascaManteniment
     * @param num identificador (int)
     * @param tipus (Neteja, Reparacio, RevisioTecnica o Desinfeccio)
     * @param allotjament assignat (Allotjament)
     * @param data (String)
     * @param dies (int)
     */
    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies){
        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    /**
     * Retorna el número identificador de la tasca.
     *
     * @return int
     */
    @Override
    public int getNum() {
        return this.num;
    }

    /**
     * Retorna el tipus de tasca de manteniment.
     *
     * @return TipusTascaManteniment
     */
    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return this.tipus;
    }

    /**
     * Retorna l'allotjament associat a la tasca.
     *
     * @return Allotjament
     */
    @Override
    public Allotjament getAllotjament() {
        return this.allotjament;
    }

    /**
     * Retorna la data de registre de la tasca.
     *
     * @return String
     */
    @Override
    public String getData() {
        return this.data;
    }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     *
     * @return int
     */
    @Override
    public int getDies() {
        return this.dies;
    }

    /**
     * Assigna un nou número identificador a la tasca.
     *
     * @param num_ Número identificador de la tasca.
     */
    @Override
    public void setNum(int num_) {
        this.num = num_;
    }

    /**
     * Assigna el tipus de tasca de manteniment.
     *
     * @param tipus_ Tipus de tasca.
     */
    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

    /**
     * Assigna l'allotjament associat a la tasca.
     *
     * @param allotjament_ Allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    /**
     * Assigna la data de registre de la tasca.
     *
     * @param data_ Data de la tasca.
     */
    @Override
    public void setData(String data_) {
        this.data = data_;
    }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     *
     * @param dies_ Nombre de dies.
     */
    @Override
    public void setDies(int dies_) {
        this.dies = dies_;
    }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     *
     * @return String amb el percentatge d'il·luminació.
     */
    @Override
    public String getIluminacioAllotjament() {
        return allotjament.getIluminacio();
    }

    /**
     * Retorna un String amb les dades de la tasca de manteniment
     * @return String
     */
    @Override
    public String toString(){
        return "Num: " + num + ", Tipus: " + tipus + ", Allotjament: " + allotjament.getId() + ", Data: " + data + ", Dies: " + dies + ".";
    }
}
