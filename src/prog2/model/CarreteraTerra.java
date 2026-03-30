package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * CarreteraTerra és una classe filla d'AccésTerra que representa els accessos de terra
 * del càmping als allotjaments, que tenen accessibilitat amb cotxe i una amplada concreta.
 */
public class CarreteraTerra extends AccesTerra implements Serializable {

    /**
     * Atributs de la classe CarreteraTerra
     */
    private float amplada;

    /**
     * Constructor de la classe CarreteraTerra amb paràmetres
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param longitud (float)
     * @param amplada (float)
     */
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada){
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    /**
     * Retorna true, ja que les carreteres permeten l'accés amb cotxe
     * @return boolean
     */
    @Override
    public boolean isAccessibilitat(){
        return true;
    }

    /**
     * Getter de l'atribut amplada
     *
     * @return float
     */
    public float getAmplada() {
        return amplada;
    }

    /**
     * Setter de l'atribut amplada
     * @param amplada float
     */
    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    /**
     * Retorna un String amb les dades de la carretera de terra
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + ", Carretera amb amplada: " + getAmplada() + "m .";
    }
}
