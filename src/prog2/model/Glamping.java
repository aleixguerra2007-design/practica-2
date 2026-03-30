package prog2.model;


import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Glamping és una classe filla de Casa que representa els allotjaments del càmping
 * del tipus glàmping amb un material específic, i una casa de mascotes.
 */
public class Glamping extends Casa implements Serializable {
    /**
     * Atributs de la classe Glamping
     */
    enum Material {TELA, FUSTA}
    private Material material;
    private boolean casaMascotes;

    /**
     * Constructor de la classe Glamping amb paràmetres
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     * @param mida (float)
     * @param numHabitacions (int)
     * @param placesPersones (int)
     * @param material (String)
     * @param casaMascotes (boolean)
     */
    public Glamping(String nom, String identificador, boolean operatiu, String iluminacio, float mida, int numHabitacions,
                    int placesPersones, String material, boolean casaMascotes){
        super(nom, identificador, 5, 3, operatiu, iluminacio, numHabitacions, mida, placesPersones);
        this.material = Material.valueOf(material.toUpperCase());
        this.casaMascotes = casaMascotes;
    }

    /**
     * Setter de l'atribut material
     * @param newMaterial (String)
     */
    public void setMaterial(String newMaterial){
        this.material = Material.valueOf(newMaterial.toUpperCase());
    }

    /**
     * Getter de l'atribut material
     * @return Material
     */
    public Material getMaterial(){
        return material;
    }

    /**
     * Setter de l'atribut casaMascotes
     * @param newCasaMascotes (boolean)
     */
    public void setCasaMascotes(boolean newCasaMascotes){
        this.casaMascotes = newCasaMascotes;
    }

    /**
     * Getter de l'atribut casaMascotes
     * @return boolean
     */
    public boolean getCasaMascotes(){
        return casaMascotes;
    }

    /**
     * El Glampin està operatiu si té casa per a mascotes
     * @return boolean
     */
    @Override
    public boolean correcteFuncionament() {
        return casaMascotes;
    }

    /**
     * Retorna un String amb les dades del Glamping
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " Glamping{Material = " + getMaterial().name() + ", casaMascotes = " + getCasaMascotes() + "}";
    }
}
