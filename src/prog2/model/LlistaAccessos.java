package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * LlistaAccessos és una classe que engloba a la classe Acces, amb la finalitat
 * de gestionar un nombre concret d'objectes d'aquesta última classe amb una ArrayList; per tant,
 * aquí hi ha métodes que permeten afegir accessos a la llista, buidar-la, mostrar les dades dels
 * accessos registrats, actualitzar-los...
 */
public class LlistaAccessos implements InLlistaAccessos, Serializable {

    /**
     * Atributs de la classe llistaAccessos
     */
    private ArrayList<Acces> llistaAccessos;

    /**
     * Constructor de la classe LListaAccessos per defecte
     */
    public LlistaAccessos(){
        this.llistaAccessos = new ArrayList<>();
    }

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

        //Lanzamos excepción si el acceso ya está en la lista
        Iterator<Acces> iterator = llistaAccessos.iterator();
        Acces acces;
        while(iterator.hasNext()){
            acces = iterator.next();
            if(acces.getNom().equals(acc.getNom())){
                throw new ExcepcioCamping("Aquest accés ja esta a la llista");
            }
        }

        //Añadimos el acceso nuevo a la lista
        llistaAccessos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String resultado = "";
        Acces acces;
        Iterator<Acces> iterator = llistaAccessos.iterator();
        while(iterator.hasNext()){
            acces = iterator.next();
            if(acces.getEstat() == estat){
                resultado += acces.toString() + "\n";
            }
        }

        //Lanzamos excepción en caso de que no haya accesos con el estado indicado
        if(resultado.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap accés amb l'estat passat com a paràmetre");
        }
        return resultado;
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        //Lanzamos excepción en caso de que la lista esté vacía.
        if (llistaAccessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap accés registrat");
        }

        Acces acces;
        Iterator<Acces> iterator = llistaAccessos.iterator();

        //Recorremos la lista de accesos y modificamos su estado dependiendo de si contienen alojamientos operativos o no
        while(iterator.hasNext()){
            acces = iterator.next();
            if(acces.getAAllotjaments().containsAllotjamentOperatiu()){
                acces.obrirAcces();
            }
            else{
                acces.tancarAcces();
            }
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        //Lanzamos excepción en caso de que la lista esté vacía.
        if (llistaAccessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap accés registrat");
        }

        int accNoAccessibles = 0;

        //Recorremos la lista de accesos
        Iterator<Acces> it = llistaAccessos.iterator();
        Acces acces;
        while(it.hasNext()){
            acces = it.next();
            if(!acces.isAccessibilitat()){
                accNoAccessibles++;
            }
        }

        return accNoAccessibles;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        //Lanzamos excepción en caso de que la lista esté vacía.
        if (llistaAccessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap accés registrat");
        }

        float totalMetresLongitud = 0;

        //Recorremos la lista de accesos
        Acces acces;
        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()){
            acces = it.next();
            if(acces instanceof AccesTerra){
                AccesTerra accesTerra = (AccesTerra) acces;
                totalMetresLongitud += accesTerra.getLongitud();
            }
        }

        //Si no hay ningún acceso de tierra registrado, lanzamos excepción
        if(totalMetresLongitud == 0){
            throw new ExcepcioCamping("No hi ha cap accés de terra registrat");
        }

        return totalMetresLongitud;
    }
}
