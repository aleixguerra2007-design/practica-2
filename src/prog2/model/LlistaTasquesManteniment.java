package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * LlistaTasquesManteniment és una classe que engloba a la classe TascaManteniment, amb l'objectiu de
 * gestionar diversos objectes d'aquesta classe amb una ArrayList. D'aquesta manera, aquí trobem métodes
 * que permeten afegir noves tasques de manteniment a la llista, buidar-la, completar una tasca concreta, mostrar
 * l'informació de les tasques registrades...
 */
public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {
    /**
     * Atribut de la classe LlistaTasquesManteniment
     */
    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    /**
     * Constructor de la classe LlistaTasquesManteniment per defecte
     */
    public LlistaTasquesManteniment(){
        this.llistaTasquesManteniment = new ArrayList<>();
    }

    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     *
     * @param num         Número d'identificació de la tasca.
     * @param tipus       Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data        Data quan genera la tasca
     * @param dies        Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        //Nos aseguramos de que el tipo de tarea exista:
        if(!tipus.equals("Neteja") && !tipus.equals("Reparacio") && !tipus.equals("RevisioTecnica") && !tipus.equals("Desinfeccio")){
            throw new ExcepcioCamping("No existeix el tipus de tasca indicat");
        }

        //Comprobamos que el alojamiento indicado no tiene una tarea ya asignada:
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        TascaManteniment tasca;
        while(it.hasNext()){
            tasca = it.next();
            if(tasca.getAllotjament().getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("L'allotjament ja té una tasca de manteniment assignada.");
            }
        }

        //Creamos un objeto de la clase TascaManteniment y lo añadimos a la lista:
        TascaManteniment newTasca = new TascaManteniment(num, TascaManteniment.TipusTascaManteniment.valueOf(tipus), allotjament, data, dies);
        llistaTasquesManteniment.add(newTasca);
        allotjament.tancarAllotjament(newTasca);
    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     *
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        //Lanzamos excepción si la lista de tareas está vacía
        if(llistaTasquesManteniment.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap tasca de manteniment registrada.");
        }

        boolean encontrado = false;

        //Recorremos la lista de tareas para eliminar la tarea indicada
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        TascaManteniment tascaManteniment;
        while(it.hasNext() && !encontrado){
            tascaManteniment = it.next();
            if(tascaManteniment.getNum() == tasca.getNum()){
                it.remove();
                encontrado = true;
            }
        }
        if(!encontrado){
            throw new ExcepcioCamping("Aquesta tasca no esta registrada.");
        }

        tasca.getAllotjament().obrirAllotjament();

    }

    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        //Lanzamos excepción si la lista de tareas está vacía
        if(llistaTasquesManteniment.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap tasca de manteniment registrada.");
        }

        String resultado = "";

        //Recorremos la lista de tareas llamando al método toString de cada una
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        TascaManteniment tasca;
        while(it.hasNext()){
            tasca = it.next();
            resultado += tasca.toString() + "\n";
        }

        return resultado;
    }

    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     *
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        boolean encontrado = false;

        //Buscamos la tarea indicada en la lista de tareas:
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        TascaManteniment tasca;
        TascaManteniment tascaBuscada = null;

        while(it.hasNext() && !encontrado){
            tasca = it.next();
            if(tasca.getNum() == num){
                encontrado = true;
                tascaBuscada = tasca;
            }
        }
        if(!encontrado){
            throw new ExcepcioCamping("No existeix cap tasca amb aquest identificador.");
        }

        return tascaBuscada;
    }
}
