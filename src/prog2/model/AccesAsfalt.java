package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * AccesAsfalt és una classe filla d'Acces que representa els accessos del
 * cámping que són d'asfalt. És la classe pare de les classes CarreteraAsfalt
 * i CamiAsfalt. Aquest tipus d'accés té un atribut nou que representa els metres
 * d'asfalt que té (float).
 */
public abstract class AccesAsfalt extends Acces implements Serializable {
    /**
     * Atribut de la classe AccesAsfalt
     */
    private float metresAsfalt;

    /**
     * Constructor de la classe AccesAsfalt amb paràmetres
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param metresAsfalt quantitat de metres d'asfalt de l'accés
     */
    public AccesAsfalt(String nom, boolean estat, float metresAsfalt){
        super(nom, estat);
        this.metresAsfalt = metresAsfalt;
    }

    /**
     * Getter de l'atribut metresAsfalt
     * @return float
     */
    public float getMetresAsfalt() {
        return metresAsfalt;
    }

    /**
     * Setter de l'atribut metresAsfalt
     * @param metresAsfalt quantitat de metres d'asfalt de l'accés
     */
    public void setMetresAsfalt(float metresAsfalt) {
        this.metresAsfalt = metresAsfalt;
    }

    /**
     * Retorna un String amb les dades generals de l'accés i el tipus amb els metres d'asfalt
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + "Tipus: Asfaltat, Metres d'asfalt: " + getMetresAsfalt() + "m";
    }

}
