public class MyOwnAutoShop {
    public static void main(String[] args){
        Sedan audiSedan=new Sedan(250,80000,"albastru",22);
        Ford fordFocus=new Ford(180,30000,"galben",2019,2000);
        Ford fordPuma=new Ford(200,42000,"verde",2022,3400);
        Car masina=new Car(240,50000,"portocaliu");
        System.out.println("audiSedan Sale Price: " + audiSedan.getSalePrice());
        System.out.println("fordFocus Sale Price:   " + fordFocus.getSalePrice());
        System.out.println("fordPuma Sale Price: " + fordPuma.getSalePrice());
        System.out.println("masina Sale Price: " + masina.getSalePrice());
    }
}
