public class FibonacciCalculator{
    public static int FibonacciCalculator(int n){
        if(n == 0 || n == 1){
            return n;
        }
        else{
            return FibonacciCalculator(n-1) + FibonacciCalculator(n-2);
        }
    }
}