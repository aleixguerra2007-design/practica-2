package prog2.model;



public abstract class Casa extends Allotjament{
    private int numHabitacions;
    private float mida;
    private int placesPersones;

    public Casa(String nom, String identificador, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio,
                int numHabitacions, float mida, int placesPersones){
        super(nom, identificador, estadaMinimaALTA, estadaMinimaBAIXA, operatiu, iluminacio);
        this.numHabitacions = numHabitacions;
        this.mida = mida;
        this.placesPersones = placesPersones;
    }

    /*
    Setter del atributo numHabitacions
    @param  newNumHabitacions
     */
    public void setNumHabitacions(int newNumHabitacions){
        this.numHabitacions = newNumHabitacions;
    }

    /*
    Getter del atributo numHabitacions
    @return numHabitacions
     */
    public int getNumHabitacions(){
        return numHabitacions;
    }

    /*
    Setter del atributo mida
    @param newMida
     */
    public void setMida(float newMida){
        this.mida = newMida;
    }

    /*
    Getter del atributo mida
    @return mida
     */
    public float getMida(){
        return mida;
    }

    /*
    Setter del atributo placesPersones
    @param newPlacesPersones
     */
    public void setPlacesPersones(int newPlacesPersones){
        this.placesPersones = newPlacesPersones;
    }

    /*
    Getter del atributo placesPersones
    @return placesPersones
     */
    public int getPlacesPersones(){
        return placesPersones;
    }

    /*
    Este método devuelve los datos del alojamiento relacionados con la clase Casa
    @return String con los datos de la casa
     */
    @Override
    public String toString(){
        return super.toString() + " Habitacions = " + getNumHabitacions() + ", mida = " + getMida() + ", placesPersones = " + getPlacesPersones() + ".";
    }
}
