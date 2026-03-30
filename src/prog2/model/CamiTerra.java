package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * CamiTerra és una classe filla d'AccesTerra i representa els accessos del càmping
 * de terra que no tenen accessibilitat amb cotxe.
 */
public class CamiTerra extends AccesTerra implements Serializable {

    /**
     * Constructor de la classe CamiTerra
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     * @param longitud (float)
     */
    public CamiTerra(String nom, boolean estat, float longitud){
        super(nom, estat, longitud);
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
     * Retorna un String amb les dades del camí de terra
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + ", Camí.";
    }
}
