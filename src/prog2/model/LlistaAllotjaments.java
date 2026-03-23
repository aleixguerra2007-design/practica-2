package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.ExcepcioCamping;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament>  llistaAllotjaments;

    //Constructor de la clase:
    public LlistaAllotjaments(){
        this.llistaAllotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        //Comprobamos que el alojamiento no está ya en la lista
        String id = allotjament.getId();
        Iterator<Allotjament> itAllotjaments= llistaAllotjaments.iterator();
        Allotjament allotjament1;
        while(itAllotjaments.hasNext()){
            allotjament1 = itAllotjaments.next();
            String id1 = allotjament1.getId();
            if(id1.equals(id)){
                throw new ExcepcioCamping("L'allotjament amb identificador " + allotjament.getId() + " ja està registrat.");
            }
        }

        //Añadimos el alojamiento a la lista
        llistaAllotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        int coincidencias = 0;
        //Buscamos los alojamientos que coincidan con el estado indicado:
        Iterator<Allotjament> allotjamentIterator = llistaAllotjaments.iterator();
        Allotjament allotjament;
        while(allotjamentIterator.hasNext()){
            allotjament = allotjamentIterator.next();
            //TODO
        }
        return "";
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();;
        Allotjament allotjament;
        while(iterator.hasNext()){
            allotjament = iterator.next();
            if(allotjament.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();
        Allotjament allotjament1;
        while(iterator.hasNext()){
            allotjament1 = iterator.next();
            //Comprobamos con el id del alojamiento
            if(allotjament1.getId().equals(allotjament.getId())){
                return true;
            }
        }
        return false;
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Allotjament allotjament;
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();
        while(iterator.hasNext()){
            allotjament = iterator.next();
            if(allotjament.getId().equals(id)){
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat l'allotjament amb identificador " + id + ".");
    }
}
