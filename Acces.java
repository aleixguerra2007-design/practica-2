package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Acces és una classe que representa els accessos als diferents
 * allotjaments del càmping. És la classe pare de les classes AccesAsfalt i AccesTerra
 * (i, per tant, de CarreteraAsfaltada, CarreteraTerra, CamiAsfaltat, CamiTerra)
 * Cada objecte d'aquesta classe té associat un nom, un estat, un booleà que indica accessibilitat
 * amb cotxe o no i un objecte de la classe LlistaAllotjaments que conté els allotjaments conectats
 * amb l'accés.
 */
public abstract class Acces implements InAcces, Serializable {
    /**
     * Atributs de la classe Acces
     */
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    /**
     * Constructor de la classe Acces amb paràmetres:
     *
     * @param nom de l'accés
     * @param estat (Obert o tancat)
     */
    public Acces(String nom, boolean estat){
        this.nom = nom;
        this.accessibilitat = isAccessibilitat();
        this.estat = estat;
        llistaAllotjaments = new LlistaAllotjaments();
    }


    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament nou
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        try{
            llistaAllotjaments.afegirAllotjament(allotjament);
        } catch(ExcepcioCamping e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {
        this.estat = true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return boolean
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return String
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Setter de l'atribut nom
     * @param nom nou de l'accés
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return boolean
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return LlistaAllotjaments
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() { return llistaAllotjaments; }

    /**
     * Retorna un String amb les dades generals del Acces
     *
     * @return String
     */
    @Override
    public String toString(){
        return "Nom: " + getNom() + ", Accessibilitat amb cotxe: " + isAccessibilitat() + ", Estat: " + getEstat() +
                ", Allotjaments: " + llistaAllotjaments.nomsAllotjaments() + ", ";
    }
}
