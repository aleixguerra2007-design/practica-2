package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {
    public CamiAsfaltat(String nom, boolean estat, float asfalt){
        super(nom, estat, asfalt);
    }

    //Este método devuelve si el acceso del tipo correspondiente es accesible por coche:
    @Override
    public boolean isAccessibilitat(){
        return false;
    }
}
