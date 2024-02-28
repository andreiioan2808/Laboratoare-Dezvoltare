public class MasinaMain {
    public static void main(String[] args){
        Masina masina1=new Masina("Logan", "Dacia");
        //System.out.println("Denumire: "+ masina1.denumire + " marca: "+ masina1.marca);
        System.out.println("Denumire: "+ masina1.getDenumire() + " marca: "+ masina1.getMarca());
        masina1.setDenumire("Dokker");
        System.out.println("Denumire: "+ masina1.getDenumire() + " marca: "+ masina1.getMarca());
       
    }
}
