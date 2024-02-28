import java.util.Scanner;

public class ex2 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de elemente a vectorului");
        int dimensiune = scanner.nextInt();
        int[] numere=new int[dimensiune];
        System.out.println("Introduceti elementele vectorului!");
        for(int i=0;i<dimensiune;i++){
            System.out.println("elementul "+ (i+1)+ "- ");
            numere[i]=scanner.nextInt();
        }
        double medie = calculMedie(numere);
        System.out.println("Media vectorului: "+ medie);
        scanner.close();
    }
    public static double calculMedie(int[] numere){
        int total=0;
        for(int num:numere){
            total+=num;
        }
        return (double)total/numere.length;
    }
}
