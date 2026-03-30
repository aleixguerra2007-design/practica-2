package prog2.model;


import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Casa és una classefilla d'Allotjament que representa els allotjaments del càmping
 * que tenen un nombre d'habitacions, mida i places de persones concret. És la classe
 * pare de Bungalow (Bungalow Premium), MobilHome i Glamping.
 */
public abstract class Casa extends Allotjament implements Serializable {
    /**
     * Atributs de la classe Casa
     */
    private int numHabitacions;
    private float mida;
    private int placesPersones;

    /**
     * Constructor de la classe Casa
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param estadaMinimaALTA (long)
     * @param estadaMinimaBAIXA (long)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     * @param numHabitacions (int)
     * @param mida (float)
     * @param placesPersones (int)
     */
    public Casa(String nom, String identificador, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio,
                int numHabitacions, float mida, int placesPersones){
        super(nom, identificador, estadaMinimaALTA, estadaMinimaBAIXA, operatiu, iluminacio);
        this.numHabitacions = numHabitacions;
        this.mida = mida;
        this.placesPersones = placesPersones;
    }

    /**
     * Setter de l'atribut numHabitacions
     * @param newNumHabitacions (int)
     */
    public void setNumHabitacions(int newNumHabitacions){
        this.numHabitacions = newNumHabitacions;
    }

    /**
     * Getter de l'atribut numHabitacions
     * @return int
     */
    public int getNumHabitacions(){
        return numHabitacions;
    }

    /**
     * Setter de l'atribut mida
     * @param newMida (float)
     */
    public void setMida(float newMida){
        this.mida = newMida;
    }

    /**
     * Getter de l'atribut mida
     * @return float
     */
    public float getMida(){
        return mida;
    }

    /**
     * Setter de l'atribut placesPersones
     * @param newPlacesPersones (int)
     */
    public void setPlacesPersones(int newPlacesPersones){
        this.placesPersones = newPlacesPersones;
    }

    /**
     * Getter de l'atribut placesPersones
     * @return int
     */
    public int getPlacesPersones(){
        return placesPersones;
    }

    /**
     * Retorna un String amb les dades generals de la Casa
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " Habitacions = " + getNumHabitacions() + ", mida = " + getMida() + ", placesPersones = " + getPlacesPersones() + ".";
    }
}
