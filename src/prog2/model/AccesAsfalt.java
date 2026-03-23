package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float metresAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, float metresAsfalt){
        super(nom, accessibilitat);
        this.metresAsfalt = metresAsfalt;
    }
}
