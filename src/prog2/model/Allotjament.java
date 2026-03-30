package prog2.model;

import java.io.Serializable;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * Allotjament és una classe que representa els allotjaments que hi ha en el
 * càmping que tenen un nom, identificador, nivell d'il·luminació, booleà que indica
 * si està operatiu o no, i les estades minimes en temporada alta i baixa. És la classe
 * pare de tots els tipus d'allotjaments: Parcela, Casa (Bungalow, Bungalow Premium,
 * MobilHome, Glamping)
 */
public abstract class Allotjament implements InAllotjament, Serializable {
    /**
     * Atributs de la classe Allotjament
     */
    private String nom;
    private String identificador;
    private String iluminacio;
    private boolean operatiu;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    /**
     * Constructor de la classe Allotjament amb paràmetres
     * @param nom de l'allotjament
     * @param identificador (String)
     * @param estadaMinimaALTA (long)
     * @param estadaMinimaBAIXA (long)
     * @param operatiu (boolean)
     * @param iluminacio (String)
     */
    public Allotjament(String nom, String identificador, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio){
        this.nom = nom;
        this.identificador = identificador;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
    }

    /**
     * Getter de l'atribut nom
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de l'atribut nom
     * @param nom el nom a assignar.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de l'atribut identificador
     * @return String
     */
    public String getId() {
        return identificador;
    }

    /**
     * Setter de l'atribut identificador
     * @param id l'identificador a assignar.
     */
    public void setId(String id) {
        this.identificador = id;
    }

    /**
     * Setter dels atributs estadaMinimaALTA_ i estadaMinimaBAIXA_
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;
    }

    /**
     * Getter dels atributs estadaMinimaALTA_ i estadaMinimaBAIXA_
     * @param temp la temporada (ALTA o BAIXA).
     * @return long
     */
    public long getEstadaMinima(Temp temp){
        switch(temp){
            case ALTA: return estadaMinimaALTA;
            case BAIXA: return estadaMinimaBAIXA;
            default:
                return 0;
        }
    }

    /**
     * Setter de l'atribut iluminacio
     * @param iluminacio String
     */
    public void setIluminacio(String iluminacio){
        this.iluminacio = iluminacio;
    }

    /**
     * Getter de l'atribut iluminacio
     * @return String
     */
    public String getIluminacio() {
        return iluminacio;
    }

    /**
     * Setter de l'atribut operatiu
     * @param operatiu boolean
     */
    public void setOperatiu(boolean operatiu){
        this.operatiu = operatiu;
        if (!operatiu){
            setIluminacio("0%");
        }
    }

    /**
     * Getter de l'atribut operatiu
     * @return boolean
     */
    public boolean isOperatiu(){
        return this.operatiu;
    }

    /**
     * Retorna un String amb les dades generals de l'Allotjament
     * @return String
     */
    @Override
    public String toString(){
        String estat;
        if(operatiu){estat = "operatiu";}
        else{estat = "no operatiu";}
        String resultado = "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: " + getEstadaMinima(InAllotjament.Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(InAllotjament.Temp.BAIXA) + ", Iluminacio: " + getIluminacio() + ", Estat:" +
                estat + ".";
        return resultado;
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca Objecte de tipus TascaManteniment.
     */
    public void tancarAllotjament(TascaManteniment tasca){
        setOperatiu(false);

        //Modificamos la iluminación del alojamiento
        switch(tasca.getTipus()){
            case Reparacio: setIluminacio("50%"); break;
            case Neteja: setIluminacio("100%"); break;
            case RevisioTecnica: setIluminacio("50%"); break;
            case Desinfeccio: setIluminacio("0%"); break;
        }
    };

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public void obrirAllotjament(){
        setOperatiu(true);
        setIluminacio("100%");
    }

    /**
     * Retorna si l'allotjament está operatiu
     * @return boolean
     */
    public abstract boolean correcteFuncionament();
}
