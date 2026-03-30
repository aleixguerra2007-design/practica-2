package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Camping es la classe principal en el model de la representació del càmping.
 * Aquesta classe gestiona els allotjaments del cámping, les tasques de manteniment,
 * i els accessos, alhora que l'operativitat dels primers i els ultims segons les tasques
 * de manteniment que hagin registrades. Aquí hi ha métodes que permeten afegir aquestes tasques,
 * completar-les, llistar l'informació desitjada, etc.
 */
public class Camping implements InCamping, Serializable {
    /**
     * Atributs de la classe Camping
     */
    private String nom;
    private LlistaAccessos llistaAccessos;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    /**
     * Constructor de la classe Camping amb paràmetres
     * @param nom del càmping
     */
    public Camping(String nom){
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
    }

    /**
     * Retorna el nom del càmping.
     *
     * @return String
     */
    @Override
    public String getNomCamping() {
        return this.nom;
    }

    /**
     * Llista els allotjaments segons el seu estat.
     *
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista els accessos segons l'estat indicat.
     *
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        infoEstat = infoEstat.toLowerCase();
        if(infoEstat.equals("obert")){
            return llistaAccessos.llistarAccessos(true);
        }
        else if(infoEstat.equals("tancat")){
            return llistaAccessos.llistarAccessos(false);
        }
        else{
            throw new ExcepcioCamping("Estat no valid");
        }
    }

    /**
     * Llista les tasques registrades al càmping.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca al registre del càmping.
     *
     * @param num           Número identificador de la tasca.
     * @param tipus         Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data          Data en què s'ha registrat la tasca.
     * @param dies          Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        //Buscamos el alojamiento con el id indicado:
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);

        //Añadimos la tarea a la lista:
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);

        //Actualizamos el estado de los accesos:
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     *
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        //Buscamos la tarea con ese número identificador
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);

        //Completamos la tarea:
        llistaTasquesManteniment.completarTascaManteniment(tasca);

        //Actualizamos los accesos:
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        try {
            int resultado = llistaAccessos.calculaAccessosNoAccessibles();
            return resultado;
        }
        catch(ExcepcioCamping e) {
            return 0;
        }
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() {
        try{
            float resultado = llistaAccessos.calculaMetresTerra();
            return resultado;
        }
        catch (ExcepcioCamping e){
            return 0;
        }
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        File fichero = new File(camiDesti);

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti));
            oos.writeObject(this);
            oos.close();
        }catch(IOException e){
            throw new ExcepcioCamping("No s'ha pogut guardar el càmping");
        }
    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    @Override
    public void inicialitzaDadesCamping(){
        try {
            llistaAccessos.buidar();

            float asfalt = 200;
            Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
            llistaAccessos.afegirAcces(Acc1);

            asfalt = 800;
            float pesMaxim = 10000;
            Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc2);

            float longitud = 100;
            Acces Acc3 = new CamiTerra("A3", true, longitud);
            llistaAccessos.afegirAcces(Acc3);

            longitud = 200;
            float amplada = 3;
            Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc4);

            asfalt = 350;
            Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
            llistaAccessos.afegirAcces(Acc5);

            asfalt = 800;
            pesMaxim = 12000;
            Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc6);

            asfalt = 100;
            Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
            llistaAccessos.afegirAcces(Acc7);

            asfalt = 800;
            pesMaxim = 10000;
            Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc8);

            longitud = 50;
            Acces Acc9 = new CamiTerra("A9", true, longitud);
            llistaAccessos.afegirAcces(Acc9);

            longitud = 400;
            amplada = 4;
            Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc10);

            longitud = 80;
            Acces Acc11 = new CamiTerra("A11", true, longitud);
            llistaAccessos.afegirAcces(Acc11);

            longitud = 800;
            amplada = 5;
            Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc12);


            /* Pistes */
            llistaAllotjaments.buidar();


            // Afegir parcel·les:
            //------------------------------

            String nom = "Parcel·la Nord";
            String idAllotjament = "ALL1";
            float mida = 64.0f;
            boolean connexioElectrica = true;

            Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL1);

            nom = "Parcel·la Sud";
            idAllotjament = "ALL2";

            Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL2);

            // Afegir bungalows:
            //------------------------------

            nom = "Bungalow Nord";
            idAllotjament = "ALL3";
            mida = 22f;
            int habitacions = 2;
            int placesPersones = 4;
            int placesParquing = 1;
            boolean terrassa = true;
            boolean tv = true;
            boolean aireFred = true;

            Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            llistaAllotjaments.afegirAllotjament(ALL3);


            // Afegir bungalows premium:
            //------------------------------
            nom = "Bungallow Sud";
            idAllotjament = "ALL4";
            mida = 27f;
            habitacions = 2;
            placesPersones = 6;
            placesParquing = 1;
            terrassa = true;
            tv = true;
            aireFred = true;
            boolean serveisExtra = true;
            String codiWifi = "CampingDelMarBP1";

            BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            llistaAllotjaments.afegirAllotjament(ALL4);

            // Afegir Glamping:
            //------------------------------

            nom = "Glamping Nord";
            idAllotjament = "ALL5";
            mida = 20f;
            habitacions = 1;
            placesPersones = 2;
            String material = "Tela";
            boolean casaMascota = true;

            Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
            llistaAllotjaments.afegirAllotjament(ALL5);


            // Afegir Mobil-Home:
            //------------------------------

            nom = "Mobil-Home Sud";
            idAllotjament = "ALL6";
            mida = 20f;
            habitacions = 2;
            placesPersones = 4;
            boolean terrassaBarbacoa = true;

            MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
            llistaAllotjaments.afegirAllotjament(ALL6);

            /* Accés */
            Acc1.afegirAllotjament(ALL1);
            Acc1.afegirAllotjament(ALL2);
            Acc2.afegirAllotjament(ALL1);
            Acc2.afegirAllotjament(ALL2);
            Acc3.afegirAllotjament(ALL3);
            Acc4.afegirAllotjament(ALL3);
            Acc5.afegirAllotjament(ALL4);
            Acc6.afegirAllotjament(ALL4);
            Acc7.afegirAllotjament(ALL5);
            Acc7.afegirAllotjament(ALL6);
            Acc8.afegirAllotjament(ALL5);
            Acc8.afegirAllotjament(ALL6);
            Acc9.afegirAllotjament(ALL2);
            Acc10.afegirAllotjament(ALL2);
            Acc11.afegirAllotjament(ALL6);
            Acc12.afegirAllotjament(ALL6);
        }
        catch(Exception e){
            throw new RuntimeException(e);
            //System.out.println("excepcion en inicialitzaDadesCamping: " + e.getMessage());
        }

    }

    /**
     * Cerca un allotjament pel nom
     *
     * @param nomAllotjament nom de l'allotjament
     * @return Allotjament
     */
    public Allotjament getAllotjamentByName(String nomAllotjament) throws ExcepcioCamping{
        return llistaAllotjaments.getAllotjamentByName(nomAllotjament);
    }
}
