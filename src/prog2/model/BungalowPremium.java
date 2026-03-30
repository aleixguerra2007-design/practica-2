package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * BungalowPremium és la classe filla de Bungalow que representa un tipus específic
 * d'aquest allotjament que té wifi i serveis extra.
 */
public class BungalowPremium extends Bungalow implements Serializable {
    /**
     * Atributs de la classe BungalowPremium
     */
    private String clauWifi;
    private boolean llencolsYTovalloles;

    /**
     * Constructor de la classe BungalowPremium
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
     * @param llencolsYTovalloles (boolean)
     * @param clauWifi (String)
     */
    public BungalowPremium(String nom, String identificador, boolean operatiu, String iluminacio, float mida, int numHabitacions, int placesPersones,
                           int placesPK, boolean terrassa, boolean televisio, boolean aireFred, boolean llencolsYTovalloles,
                           String clauWifi){
        super(nom, identificador, operatiu, iluminacio, mida, numHabitacions, placesPersones, placesPK, terrassa, televisio, aireFred);
        this.llencolsYTovalloles = llencolsYTovalloles;
        this.clauWifi = clauWifi;
    }

    /**
     * Setter de l'atribut clauWifi
     * @param newClauWifi (String)
     */
    public void setClauWifi(String newClauWifi){
        this.clauWifi = newClauWifi;
    }

    /**
     * Getter de l'atribut clauWifi
     * @return String
     */
    public String getClauWifi(){
        return clauWifi;
    }

    /**
     * Setter de l'atribut llencolsYTovalloles
     * @param newLlencolsYTovalloles (boolean)
     */
    public void setLlencolsYTovalloles(boolean newLlencolsYTovalloles){
        this.llencolsYTovalloles = newLlencolsYTovalloles;
    }

    /**
     * Getter de l'atribut llencolsYTovalloles
     * @return boolean
     */
    public boolean getLlencolsYTovalloles(){
        return llencolsYTovalloles;
    }


    /**
     * BungalowPremium està operatiu si té una clau wifi amb un
     * mínim de 8 caràcters i un màxim de 16.
     * @return boolean
     */
    @Override
    public boolean correcteFuncionament() {
        return getAireFred() && clauWifi != null && clauWifi.length() <= 16 && clauWifi.length() >= 8;
    }

    /**
     * Retorna un String amb les dades del BungalowPremium
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " Tipo Premium{ClauWifi = " + getClauWifi() + ", serveisExtra = " + getLlencolsYTovalloles() + "}";
    }
}
