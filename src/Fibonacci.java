import java.math.BigDecimal;
import java.math.BigInteger;

public class Fibonacci {


    static public BigInteger fibonacci(int x) throws IllegalArgumentException{

        long wynik1=fibonacci1(x);
        BigInteger wynik2=fibonacci2(x);
        BigDecimal wynik3=fibonacci3(BigDecimal.valueOf(x));

//all equal
        if(BigInteger.valueOf(wynik1).equals(wynik2) && BigDecimal.valueOf(wynik1).equals(wynik3) && wynik2.equals(wynik3.toBigInteger())) {
            System.out.println(x + " wyraz ciągu Fibonacciego: " + wynik1);
            System.out.println("Głosowanie: 3/3");
            return BigInteger.valueOf(wynik1);
        }

//1 equals 2
        else if(BigInteger.valueOf(wynik1).equals(wynik2)) {
            System.out.println(x + " wyraz ciągu Fibonacciego: " + wynik1);
            System.out.println("Głosowanie: 2/3");
            return BigInteger.valueOf(wynik1);
        }

//1 equals 3
        else if(BigDecimal.valueOf(wynik1).equals(wynik3)) {
            System.out.println(x + " wyraz ciągu Fibonacciego: " + wynik1);
            System.out.println("Głosowanie: 2/3");
            return BigInteger.valueOf(wynik1);
        }

//2 equals 3
        else if(wynik2.equals(wynik3.toBigInteger())) {
            System.out.println(x + " wyraz ciągu Fibonacciego: " + wynik2);
            System.out.println("Głosowanie: 2/3");
            return wynik2;
        }
//all different
        else {
            System.out.println("Błąd: każda funkcja zwraca inną wartość");
            return BigInteger.valueOf(-1);
        }
    }

    static public long fibonacci1(long index) throws IllegalArgumentException {

        if(index<=0) throw new IllegalArgumentException("Liczba nie może być ujemna lub równa zero");
        else if (index == 1 || index == 2)
            return 1;
        return (fibonacci1(index-1)+fibonacci1(index-2));
    }

    public static BigInteger fibonacci2(int index) throws IllegalArgumentException{

        if (index <= 0){
            throw new IllegalArgumentException("Liczba musi być całkowita i różna od zero.");
        } else if (index == 1){
            return BigInteger.valueOf(1);
        } else {
            BigInteger elementFromTwoIterationsAgo = BigInteger.valueOf(0);
            BigInteger elementFromOneIterationAgo = BigInteger.valueOf(1);

            for (int i = 2;i<index+1;i++){
                BigInteger currentElement = elementFromOneIterationAgo.add(elementFromTwoIterationsAgo);
                elementFromTwoIterationsAgo = elementFromOneIterationAgo;
                elementFromOneIterationAgo = currentElement;
            }
            return elementFromOneIterationAgo;
        }

    }

    private static BigDecimal two = BigDecimal.valueOf(2);

    public static BigDecimal fibonacci3(BigDecimal index) throws IllegalArgumentException{

        if (index.compareTo(BigDecimal.ONE)<0)
            throw new IllegalArgumentException("Nie można obliczyć wartości wyrazu mniejszego niż wyraz pierwszy.");
        else if (index.compareTo(BigDecimal.ONE) == 0)
            return BigDecimal.ONE;
        else if (index.compareTo(two)==0) {
            return BigDecimal.ONE;
        }
        else {
            return fibonacci3(index.subtract(BigDecimal.ONE)).add(fibonacci3(index.subtract(two)));
        }
    }
}