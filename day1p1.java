import java.util.*;

public class day1p1 {
    public static boolean IceCream(int budget, int iceCreamPrices[], int n) {
        for(int i = 0; i < n; i++){
            if (iceCreamPrices[i] == budget) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("budget = ");
        int budget = in.nextInt();
        System.out.print("Enter number of ice cream prices: ");
        int n = in.nextInt();
        int[] iceCreamPrices = new int[n];
        System.out.print("iceCreamPrices = ");
        for(int i = 0; i < n; i++) {
            iceCreamPrices[i] = in.nextInt();
        }
        boolean result = IceCream(budget, iceCreamPrices, n);
        System.out.println(result);

        in.close();
    }
    
}
