package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String identificador;
    private String iluminacio;
    private boolean operatiu;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    //Constructor de la clase Allotjament:
    public Allotjament(String nom, String identificador, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio){
        this.nom = nom;
        this.identificador = identificador;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
    }

    /*
    Getter del atributo nom
    @return nom
    */
    public String getNom() {
        return nom;
    }

    /*
    Setter del atributo nom
    @param nom
    */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /*
    Getter del atributo id
    @return id
     */
    public String getId() {
        return identificador;
    }

    /*
    Setter del atributo id
    @param id
     */
    public void setId(String id) {
        this.identificador = id;
    }

    /*
    Setter de los atributos estadaMinimaBAIXA y estadaMinimaALTA
    @param estadaMinimaALTA_
    @param estadaMinimaBAIXA_
    */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;
    }

    /*
    Getter de los atributos estadaMinimaBAIXA y estadaMinimaALTA dependiendo de la temporada
    @param temp (temporada alta o baja)
    @return estadaMinimaALTA (case temp==ALTA) // estadaMinimaBAIXA (case temp==BAIXA)
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
     * Setter del atributo iluminacio
     * @param iluminacio
     */
    public void setIluminacio(String iluminacio){
        this.iluminacio = iluminacio;
    }

    /**
     * Getter del atributo iluminacio
     * @return iluminacio
     */
    public String getIluminacio() {
        return iluminacio;
    }

    /**
     * Setter del atributo operatiu
     * @param operatiu
     */
    public void setOperatiu(boolean operatiu){
        this.operatiu = operatiu;
    }

    /**
     * Getter del atributo operatiu
     * @return
     */
    public boolean isOperatiu(){
        return this.operatiu;
    }
    /*
    Este método devuelve los datos relacionados con el alojamiento
    @return resultado: datos del alojamientos
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
    public void tancarAllotjament(TascaManteniment tasca);

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public void obrirAllotjament();

    //Este método indica si el alojamiento está operativo
    //@return true si está operativo, false en caso contrario.
    public abstract boolean correcteFuncionament();
}
