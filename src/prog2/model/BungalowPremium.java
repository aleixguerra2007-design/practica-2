package prog2.model;

public class BungalowPremium extends Bungalow{
    private String clauWifi;
    private boolean llencolsYTovalloles;

    //Constructor de la subclase Bungalow
    public BungalowPremium(String nom, String identificador, String iluminacio, boolean operatiu, float mida, int numHabitacions, int placesPersones,
                           int placesPK, boolean terrassa, boolean televisio, boolean aireFred, boolean llencolsYTovalloles,
                           String clauWifi){
        super(nom, identificador, iluminacio, operatiu, mida, numHabitacions, placesPersones, placesPK, terrassa, televisio, aireFred);
        this.llencolsYTovalloles = llencolsYTovalloles;
        this.clauWifi = clauWifi;
    }

    /*
    Setter del atributo clauWifi
    @param newClauWifi
     */
    public void setClauWifi(String newClauWifi){
        this.clauWifi = newClauWifi;
    }

    /*
    Getter del atributo clauWifi
    @return clauWifi
     */
    public String getClauWifi(){
        return clauWifi;
    }

    /*
    Setter del atributo llencolsYTovalloles
    @param newLlencolsYTovalloles
     */
    public void setLlencolsYTovalloles(boolean newLlencolsYTovalloles){
        this.llencolsYTovalloles = newLlencolsYTovalloles;
    }

    /*
    Getter del atributo llencolsYTovalloles
    @return llencolsYTovalloles
     */
    public boolean getLlencolsYTovalloles(){
        return llencolsYTovalloles;
    }

    /*
    Setter del atributo
     */

    //El Bungalow estará operativo si tiene aire acondicionado y la clave Wifi tiene entre 8 y 16 caracteres
    @Override
    public boolean correcteFuncionament() {
        return getAireFred() && clauWifi != null && clauWifi.length() <= 16 && clauWifi.length() >= 8;
    }

    /*
    Este método devuelve los datos del Bungalow Premium
    @return string con los datos del Bungalow Premium
     */
    @Override
    public String toString(){
        return super.toString() + " Tipo Premium{ClauWifi = " + getClauWifi() + ", serveisExtra = " + getLlencolsYTovalloles() + "}";
    }
}
