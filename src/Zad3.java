public class Zad3 {
    private static double cos (double y){
        double e = Math.exp(2);
        double kwadrat = y*y;
        return Math.pow(e,kwadrat);
    }

    public static void main(String[] args) {
        double ap=0, ak=0, h, cal=0;
        int n = 25;
        h=(ak-ap)/(double) n;
        cal = 0;
        for (int i = 0; i < n; i++) {
            cal+=cos(ap+i*h);
        }
        cal+=(cos(ap) + cos(ak))/2;
        cal*=h;

        System.out.println(cal);
    }
}
