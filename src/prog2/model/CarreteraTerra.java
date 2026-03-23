package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    //Constructor de la clase:
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada){
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    //Este método devuelve si el acceso del tipo correspondiente es accesible por coche:
    @Override
    public boolean isAccessibilitat(){
        return true;
    }
}
