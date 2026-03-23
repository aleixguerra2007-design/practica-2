package prog2.model;


public class Glamping extends Casa{
    enum Material {TELA, FUSTA}
    private Material material;
    private boolean casaMascotes;

    public Glamping(String nom, String identificador, String iluminacio, boolean operatiu, Mida mida, int numHabitacions,
                    int placesPersones, Material material, boolean casaMascotes){
        super(nom, identificador, 3, 3, operatiu, iluminacio, numHabitacions, mida, placesPersones);
        this.material = material;
        this.casaMascotes = casaMascotes;
    }

    /*
    Setter del atributo material
    @param newMaterial
     */
    public void setMaterial(Material newMaterial){
        this.material = newMaterial;
    }

    /*
    Getter del atributo material
    @return material
     */
    public Material getMaterial(){
        return material;
    }

    /*
    Setter del atributo casaMascotes
    @param newCasaMascotes
     */
    public void setCasaMascotes(boolean newCasaMascotes){
        this.casaMascotes = newCasaMascotes;
    }

    /*
    Getter del atributo casaMascotes
    @return casaMascotes
     */
    public boolean getCasaMascotes(){
        return casaMascotes;
    }

    //El Glamping estará operativo si tiene casa para mascotas
    @Override
    public boolean correcteFuncionament() {
        return casaMascotes;
    }

    /*
    Este método devuelve los datos del Glamping
    @return String con los datos del Glamping
     */
    @Override
    public String toString(){
        return super.toString() + " Glamping{Material = " + getMaterial().name() + ", casaMascotes = " + getCasaMascotes() + "}";
    }
}
