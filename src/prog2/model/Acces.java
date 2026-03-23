package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Acces implements InAcces{
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    //Constructor de la clase:
    public Acces(String nom, boolean accessibilitat){
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = true;
        llistaAllotjaments = new LlistaAllotjaments();
    }


    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
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
     * @return
     */
    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Setter del atributo nom
     * @param nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return llistaAllotjaments;
    }
}
