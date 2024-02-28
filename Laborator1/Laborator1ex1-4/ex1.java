import java.util.Scanner;

public class ex1{
    public static void main(String[]args){
        System.out.println("Introduceti un numar!");
        Scanner scanner = new Scanner(System.in);
        int numar = scanner.nextInt();
        if(numar<0) System.out.println("Numarul este negativ!");
        else System.out.println("Numarul este pozitiv!");
        scanner.close();
    }

}