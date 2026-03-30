package prog2.model;

import java.io.Serializable;

import static prog2.model.InAllotjament.Temp.*;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Parcela és una classe filla d'Allotjament que representa els allotjaments del càmping
 * del tipus parcel·la amb una mida concreta y punt de connexió.
 */
public class Parcela extends Allotjament implements Serializable {
    /**
     * Atributs de la classe Parcela
     */
    private double mida;
    private boolean puntConnexio;

    /**
     * Constructor de la classe Parcela
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     * @param mida (double)
     * @param puntConnexio (boolean)
     */
    public Parcela(String nom, String identificador, boolean operatiu, String iluminacio, double mida, boolean puntConnexio){
        super(nom, identificador, 4, 2, operatiu, iluminacio);
        this.mida = mida;
        this.puntConnexio = puntConnexio;
    }

    /**
     * Setter de l'atribut mida
     * @param newMida (double)
     */
    public void setMida(double newMida){
        this.mida = newMida;
    }

    /**
     * Getter de l'atribut mida
     * @return double
     */
    public double getMida(){
        return mida;
    }

    /**
     * Setter de l'atribut puntConnexio
     * @param newPuntConnexio (boolean)
     */
    public void setConnexioElectrica(boolean newPuntConnexio){
        this.puntConnexio = newPuntConnexio;
    }

    /**
     * Getter de l'atribut puntConnexio
     * @return boolean
     */
    public boolean isConnexioElectrica(){
        return puntConnexio;
    }

    /**
     * La Parcela està operativa si té punt de connexió
     * @return boolean
     */
    @Override
    public boolean correcteFuncionament() {
       return puntConnexio;
    }

    /**
     * Retorna un String amb les dades de la Parcela
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " Parcela{mida=" + getMida() + ", connexioElectrica=" + isConnexioElectrica() + "}";
    }


}
