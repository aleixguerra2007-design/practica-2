package prog2.model;

import static prog2.model.InAllotjament.Temp.*;

public class Parcela extends Allotjament{
    private double mida;
    private boolean puntConnexio;

    //Constructor de la subclase Parcela;
    public Parcela(String nom, String identificador, boolean operatiu, String iluminacio, double mida, boolean puntConnexio){
        super(nom, identificador, 4, 2, operatiu, iluminacio);
        this.mida = mida;
        this.puntConnexio = puntConnexio;
    }

    /*
    Setter del atributo mida
    @param newMida
     */
    public void setMida(double newMida){
        this.mida = newMida;
    }

    /*
    Getter del atributo mida:
    @return valor de la medida de la parcela
     */
    public double getMida(){
        return mida;
    }
    /*
    Setter del atributo puntConnexio
    @param newPuntConnexio
     */
    public void setConnexioElectrica(boolean newPuntConnexio){
        this.puntConnexio = newPuntConnexio;
    }

    /*
    Getter del atributo puntConnexio
    @return: dato booleano que indica si hay punto de conexión eléctrica (true) o no (false)
     */
    public boolean isConnexioElectrica(){
        return puntConnexio;
    }

    //La parcela está operativa si tiene punto de conexión:
    @Override
    public boolean correcteFuncionament() {
       return puntConnexio;
    }

    /*
    Este método devuelve los datos de la parcela
    @return string con los datos de la parcela
     */
    @Override
    public String toString(){
        return super.toString() + " Parcela{mida=" + getMida() + ", connexioElectrica=" + isConnexioElectrica() + "}";
    }


}
