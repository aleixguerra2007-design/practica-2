package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.ExcepcioCamping;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * LlistaAllotjaments és una classe que engloba a la classe Allotjaments per així gestionar
 * diversos objectes d'aquesta última classe amb una ArrayList; per tant, aquí es defineixen métodes
 * que permeten afegir allotjaments a la lista, buidar-la, mostrar l'informació dels allotjaments amb un
 * estat concret, cercar per el nom o id...
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    /**
     * Atribut de la classe LlistaAllotjaments
     */
    private ArrayList<Allotjament>  llistaAllotjaments;

    /**
     * Constructor de la classe LlistaAllotjaments per defecte
     */
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

        //Ponemos en minúscula el string estat
        estat = estat.toLowerCase();
        String resultat = "";

        //Mostramos todos los alojamientos si se desea
        boolean mostrarTodos = estat.equals("tots");

        Iterator<Allotjament> itAllotjaments = llistaAllotjaments.iterator();
        Allotjament allotjament;
        while(itAllotjaments.hasNext()){
            allotjament = itAllotjaments.next();
            if((allotjament.isOperatiu() && estat.equals("operatiu")) || mostrarTodos) {
                resultat += allotjament.toString() + "\n";
            } else if((!allotjament.isOperatiu() && estat.equals("no operatiu")) || mostrarTodos) {
                resultat += allotjament.toString() + "\n";
            }
        }

        if(resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat: " + estat);
        }

        return resultat;
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

    /**
     * Devuelve un String con los nombres de los alojamientos almacenados
     *
     * @return nombres de los alojamientos
     */
    public String nomsAllotjaments(){
        String nombres = "";
        int total = llistaAllotjaments.size();
        int contador = 0;

        Iterator <Allotjament> iterator = llistaAllotjaments.iterator();
        Allotjament allotjament;
        while(iterator.hasNext()){
            allotjament = iterator.next();
            nombres += allotjament.getNom();
            if(contador != total - 1){
                nombres += ", ";
            }
            contador++;
        }
        return nombres;
    }

    /**
     * Busca un allotjament concreto pel nom:
     *
     * @param nomAllotjament (String)
     * @return Allotjament
     */
    public Allotjament getAllotjamentByName(String nomAllotjament) throws ExcepcioCamping{
        Allotjament allotjamentBuscado = null;
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        Allotjament allotjament;
        while(it.hasNext()){
            allotjament = it.next();
            if(allotjament.getNom().equals(nomAllotjament)){
                allotjamentBuscado = allotjament;
                return allotjamentBuscado;
            }
        }
        throw new ExcepcioCamping("No hi ha cap allotjament amb el nom: " + nomAllotjament);
    }
}
