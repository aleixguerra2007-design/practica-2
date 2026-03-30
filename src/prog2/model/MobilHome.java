package prog2.model;

import java.io.Serializable;


/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * MobilHome és una classe filla de Casa que representa un allotjament en el cámping
 * del tipus Mobil-Home que pot tenir una terrassa amb barbacoa.
 */
public class MobilHome extends Casa implements Serializable {
    /**
     * Atribut de la classe MobilHome
     */
    private boolean terrassaAmbBarbacoa;

    /**
     * Constructor de la classe MobilHome
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     * @param mida (float)
     * @param numHabitacions (int)
     * @param placesPersones (int)
     * @param terrassaAmbBarbacoa (boolean)
     */
    public MobilHome(String nom, String identificador, boolean operatiu, String iluminacio, float mida, int numHabitacions,
                     int placesPersones, boolean terrassaAmbBarbacoa){
        super(nom, identificador,5, 3, operatiu, iluminacio,  numHabitacions, mida, placesPersones);
        this.terrassaAmbBarbacoa = terrassaAmbBarbacoa;
    }

    /**
     * Setter de l'atribut terrassaAmbBarbacoa
     * @param newTerrassaAmbBarbacoa (boolean)
     */
    public void setTerrassaAmbBarbacoa(boolean newTerrassaAmbBarbacoa){
        this.terrassaAmbBarbacoa = newTerrassaAmbBarbacoa;
    }

    /**
     * Getter de l'atribut terrassaAmbBarbacoa
     * @return boolean
     */
    public boolean getTerrassaAmbBarbacoa(){
        return terrassaAmbBarbacoa;
    }

    /**
     * El MobilHome está operatiu si té terrassa amb barbacoa
     * @return boolean
     */
    @Override
    public boolean correcteFuncionament() {
        return terrassaAmbBarbacoa;
    }

    /**
     * Retorna un String amb les dades del MobilHome
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + "Mobil-Home{TerrassaAmbBarbacoa = " + getTerrassaAmbBarbacoa() + "}";
    }
}
