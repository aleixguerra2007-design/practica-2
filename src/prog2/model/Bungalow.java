package prog2.model;

import java.io.Serializable;

import static prog2.model.InAllotjament.Temp.ALTA;
import static prog2.model.InAllotjament.Temp.BAIXA;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Bungalow és una classe filla de Casa que representa un tipus d'allotjament
 * dins del càmping que té més atributs: places de pàrquing, booleans que indican si hi ha
 * terrassa, televisió o aireFred. És la classe pare de BungalowPremium.
 */
public class Bungalow extends Casa implements Serializable {
    /**
     * Atributs de la classe Bungalow:
     */
    private int placesPK; //NOTA: 1 o 2
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

    /**
     * Constructor de la classe Bungalow amb paràmetres
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     * @param mida (float)
     * @param numHabitacions (int)
     * @param placesPersones (int)
     * @param placesPK (1 o 2)
     * @param terrassa (boolean)
     * @param televisio (boolean)
     * @param aireFred (boolean)
     */
    public Bungalow(String nom, String identificador, boolean operatiu, String iluminacio, float mida, int numHabitacions, int placesPersones,
                    int placesPK, boolean terrassa, boolean televisio, boolean aireFred){
        super(nom, identificador, 7, 4, operatiu, iluminacio,  numHabitacions, mida, placesPersones);

        //Asignamos 1 por defecto si el valor dado es diferente de 1 y 2:
        if(placesPK != 1 && placesPK != 2) {
            this.placesPK = 1;
        }
        else{
            this.placesPK = placesPK;
        }
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aireFred = aireFred;
    }

    /**
     * Setter de l'atribut placesPk
     * @param newPlacesPK (int)
     */
    public void setPlacesPK(int newPlacesPK){
        //Dejamos el valor original si el nuevo valor es diferente de 1 y de 2
        if(newPlacesPK == 1 || newPlacesPK == 2) {
            this.placesPK = newPlacesPK;
        }
    }

    /**
     * Getter de l'atribut placesPK
     * @return int
     */
    public int getPlacesPK(){
        return placesPK;
    }

    /**
     * Setter de l'atribut terrassa
     * @param newTerrassa (boolean)
     */
    public void setTerrassa(boolean newTerrassa){
        this.terrassa = newTerrassa;
    }

    /**
     * Getter de l'atribut terrassa
     * @return boolean
     */
    public boolean getTerrassa(){
        return terrassa;
    }

    /**
     * Setter de l'atribut televisio
     * @param newTelevisio (boolean)
     */
    public void setTelevisio(boolean newTelevisio){
        this.televisio = newTelevisio;
    }

    /**
     * Getter de l'atribut televisio
     * @return boolean
     */
    public boolean getTelevisio(){
        return televisio;
    }

    /**
     * Setter de l'atribut aireFred
     * @param newAireFred (boolean)
     */
    public void setAireFred(boolean newAireFred){
        this.aireFred = newAireFred;
    }

    /**
     * Getter de l'atribut aireFred
     * @return boolean
     */
    public boolean getAireFred(){
        return aireFred;
    }

    /**
     * Bungalow està operatiu si aireFred == true;
     * @return boolean
     */
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    /**
     * Retorna un String amb les dades del Bungalow
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + " Bungalow{PlacesPK = " + getPlacesPK() + ", terrassa = " + getTerrassa() + ", televisio = " + getTelevisio() + ", aireFred = " + getAireFred() + "}";
    }
}
