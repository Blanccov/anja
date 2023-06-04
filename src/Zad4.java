public class Zad4 {
    public static void main(String[] args) {
        double w1[] = {1, 0, 1, -2, 0, -3};
        double w2[] = {1, 0, 1, -2, 0, -3};
        int stop = 5;
        int n = 11;
        double wynik = 0;
        String txt = "";
        for(int j = 1; j <= stop; j++){
            w2[j] = w2[j-1] * n + w1[j];
            if(j == stop){
                wynik = w2[j];
            }
            if(stop-j == 7){
                txt = w2[j - 1] + "x^[" + (stop - j)+ "]";
            }else{
                txt = w2[j - 1] + "x^[" + (stop - j)+ "] + " + w2;
            }
        }
        System.out.println(txt);
        System.out.println("wartość x=11 " + wynik);
    }
}
