package prog2.model;

public class CamiTerra extends AccesTerra{

    //Constructor de la clase:
    public CamiTerra(String nom, boolean estat, float longitud){
        super(nom, estat, longitud);
    }

    //Este método devuelve si el acceso del tipo correspondiente es accesible por coche:
    @Override
    public boolean isAccessibilitat(){
        return false;
    }
}
