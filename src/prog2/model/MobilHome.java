package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaAmbBarbacoa;

    public MobilHome(String nom, String identificador, String iluminacio, boolean operatiu, float mida, int numHabitacions,
                     int placesPersones, boolean terrassaAmbBarbacoa){
        super(nom, identificador,5, 3, operatiu, iluminacio,  numHabitacions, mida, placesPersones);
        this.terrassaAmbBarbacoa = terrassaAmbBarbacoa;
    }

    /*
    Setter del atributo terrassaAmbBarbacoa
    @param newTerrassaAmbBarbacoa
     */
    public void setTerrassaAmbBarbacoa(boolean newTerrassaAmbBarbacoa){
        this.terrassaAmbBarbacoa = newTerrassaAmbBarbacoa;
    }

    /*
    Getter del atributo terrassaAmbBarbacoa
    @return terrassaAmbBarbacoa
     */
    public boolean getTerrassaAmbBarbacoa(){
        return terrassaAmbBarbacoa;
    }

    //El Mobile-Home estará operativo si tiene terraza con barbacoa
    @Override
    public boolean correcteFuncionament() {
        return terrassaAmbBarbacoa;
    }

    /*
    Este método devuelve los datos del Mobil-Home
    @return String con los datos del Glamping
     */
    @Override
    public String toString(){
        return super.toString() + "Mobil-Home{TerrassaAmbBarbacoa = " + getTerrassaAmbBarbacoa() + "}";
    }
}
