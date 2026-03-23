package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt{
    private float pesMax;

    public CarreteraAsfaltada(String nom, boolean accessibilitat, float asfalt, float pesMax){
        super(nom, accessibilitat, asfalt);
        this.pesMax = pesMax;
    }
}
