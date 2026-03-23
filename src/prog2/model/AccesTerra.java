package prog2.model;

public abstract class AccesTerra extends Acces{
    private float longitud;

    //Constructor de la clase
    public AccesTerra(String nom, boolean accessibilitat, float longitud){
        super(nom, accessibilitat);
        this.longitud = longitud;
    }
}
