package prog2.model;

public abstract class AccesTerra extends Acces{
    private float longitud;

    //Constructor de la clase
    public AccesTerra(String nom, boolean estat, float longitud){
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Getter del atributo longitud
     * @return longitud
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * Setter del atributo longitud
     * @param longitud
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

}
