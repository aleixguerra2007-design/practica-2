package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt{
    private float pesMax;

    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pesMax){
        super(nom, estat, asfalt);
        this.pesMax = pesMax;
    }

    //Este método devuelve si el acceso del tipo correspondiente es accesible por coche:
    @Override
    public boolean isAccessibilitat(){
        return true;
    }
}
