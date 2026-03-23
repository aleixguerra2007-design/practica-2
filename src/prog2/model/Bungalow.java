package prog2.model;

import static prog2.model.InAllotjament.Temp.ALTA;
import static prog2.model.InAllotjament.Temp.BAIXA;

public class Bungalow extends Casa{
    private int placesPK; //NOTA: 1 o 2
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

    //Constructor de la subclase Bungalow
    public Bungalow(String nom, String identificador, String iluminacio, boolean operatiu, float mida, int numHabitacions, int placesPersones,
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
    
    /*
    Setter del atributo placesPK:
    @param newPlacesPK
     */
    public void setPlacesPK(int newPlacesPK){
        //Dejamos el valor original si el nuevo valor es diferente de 1 y de 2
        if(newPlacesPK == 1 || newPlacesPK == 2) {
            this.placesPK = newPlacesPK;
        }
    }

    /*
    Getter del atributo placesPK
    @return placesPK
     */
    public int getPlacesPK(){
        return placesPK;
    }

    /*
    Setter del atributo terrassa
    @param newTerrassa
     */
    public void setTerrassa(boolean newTerrassa){
        this.terrassa = newTerrassa;
    }

    /*
    Getter del atributo terrassa
    @return terrassa
     */
    public boolean getTerrassa(){
        return terrassa;
    }

    /*
    Setter del atributo televisio
    @param newTelevisio
     */
    public void setTelevisio(boolean newTelevisio){
        this.televisio = newTelevisio;
    }

    /*
    Getter del atributo televisio
    @return televisio
     */
    public boolean getTelevisio(){
        return televisio;
    }

    /*
    Setter del atributo aireFred
    @param newAireFred
     */
    public void setAireFred(boolean newAireFred){
        this.aireFred = newAireFred;
    }

    /*
    Getter del atributo airefred
    @return aireFred
     */
    public boolean getAireFred(){
        return aireFred;
    }

    //El Bungalow estará operativo si tiene aire acondicionado
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    /*
    Este método devuelve los datos del Bungalow
    @return string con los datos del Bungalow
     */
    @Override
    public String toString(){
        return super.toString() + " Bungalow{PlacesPK = " + getPlacesPK() + ", terrassa = " + getTerrassa() + ", televisio = " + getTelevisio() + ", aireFred = " + getAireFred() + "}";
    }
}
