package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * AccesTerra és una classe filla d'Acces que representa els accessos del
 * cámping que són de terra. És la classe pare de les classes CarreteraTerra
 * i CamiTerra. Aquest tipus d'accés té un atribut nou que representa la longitud
 * en metres que té (float).
 */
public abstract class AccesTerra extends Acces implements Serializable {
    /**
     * Atributs de la classe AccesTerra
     */
    private float longitud;

    /**
     * Constructor de la classe AccesTerra
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param longitud en metres de l'accés
     */
    public AccesTerra(String nom, boolean estat, float longitud){
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Getter de l'atribut longitud
     * @return float
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * Setter de l'atribut longitud
     * @param longitud en metres de l'accés
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    /**
     * Retorna un String amb les dades generals de l'accés i el tipus amb la seva longitud
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + "Tipus: Terra, Longitud: " + getLongitud() + "m";
    }
}
