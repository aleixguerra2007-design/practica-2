package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * CamiAsfaltat és una classe filla d'AccesAsfaltat i representa els accessos del càmping
 * que sòn d'asfalt i que no tenen accessibilitat amb cotxe.
 */
public class CamiAsfaltat extends AccesAsfalt implements Serializable {
    /**
     * Constructor de la classe CamiAsfaltat
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param asfalt (float)
     */
    public CamiAsfaltat(String nom, boolean estat, float asfalt){
        super(nom, estat, asfalt);
    }

    /**
     * Retorna false, ja que el camí no permet l'accés amb cotxe
     *
     * @return boolean
     */
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

    /**
     * Retorna un String amb les dades del CamiAsfaltat
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + ", Camí.";
    }
}
