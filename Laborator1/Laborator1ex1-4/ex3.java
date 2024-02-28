public class ex3 {
    public static void main(String[] args){
        for (int i=2;i<100;i++){
            if(prim(i) && prim(i+2)){
                System.out.printf("(%d,%d)",i,i+2);
            }
        }
    }
    public static boolean prim(int n){
        if ( n<2 ) return false;
        for (int i=2;i<=n/2;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
