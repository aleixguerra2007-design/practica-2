package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float metresAsfalt;

    public AccesAsfalt(String nom, boolean estat, float metresAsfalt){
        super(nom, estat);
        this.metresAsfalt = metresAsfalt;
    }
}
