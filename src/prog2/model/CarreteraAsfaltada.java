package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * CarreteraAsfaltada és una classe filla d'AccesAsfaltat que representa els accessos d'asfalt
 * del càmping als allotjaments, que tenen accessibilitat amb cotxe i un pes màxim d'aquests.
 */
public class CarreteraAsfaltada extends AccesAsfalt implements Serializable {
    /**
     * Atributs de la classe CarreteraAsfaltada
     */
    private float pesMax;

    /**
     * Constructor de la classe CarreteraAsfaltada
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param asfalt (float)
     * @param pesMax (float)
     */
    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pesMax){
        super(nom, estat, asfalt);
        this.pesMax = pesMax;
    }

    /**
     * Getter de l'atribut pesMax
     *
     * @return float
     */
    public float getPesMax() {
        return pesMax;
    }

    /**
     * Setter de l'atribut pesMax
     * @param pesMax (float)
     */
    public void setPesMax(float pesMax) {
        this.pesMax = pesMax;
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
     * Retorna un String amb les dades de la carretera asfaltada.
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + ", Carretera amb pes màxim: "  + getPesMax() + "kg.";
    }
}
