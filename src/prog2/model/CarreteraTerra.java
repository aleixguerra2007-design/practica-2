package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    //Constructor de la clase:
    public CarreteraTerra(String nom, boolean accessibilitat, float longitud, float amplada){
        super(nom, accessibilitat, longitud);
        this.amplada = amplada;
    }
}
