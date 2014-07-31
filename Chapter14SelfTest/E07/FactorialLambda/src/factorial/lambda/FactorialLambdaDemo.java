package factorial.lambda;

/**
 * Demo of a block lamda tha computes a factorial.
 */
public class FactorialLambdaDemo {
    public static void main(String args[]){
        
        // This block lambda returns the factorial of a value.
        NumericFunc factorial = (n) -> {
            int result = 1;
            for(int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;        
        };
        
        System.out.println("5! = " + factorial.func(5));
        System.out.println("2! = " + factorial.func(2));
        System.out.println("8! = " + factorial.func(8));
    }
}
