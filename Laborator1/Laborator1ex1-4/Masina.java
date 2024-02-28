public class Masina {
    public String denumire;
    private String marca;
    public Masina(String denumire, String marca){
        this.denumire=denumire;
        this.marca=marca;
    }
    public String getDenumire(){
        return denumire;
    }
    public String getMarca(){
        return marca;
    }
    public void setDenumire(String denumire){
        this.denumire=denumire;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
}
