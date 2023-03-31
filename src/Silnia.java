import java.math.BigDecimal;
import java.math.BigInteger;

public class Silnia {


    static public BigInteger silnia(int x) throws IllegalArgumentException {

        long wynik1 = silnia1(x);
        BigInteger wynik2 = silnia2(x);
        BigDecimal wynik3 = silnia3(BigDecimal.valueOf(x));

//all equal
        if (BigInteger.valueOf(wynik1).equals(wynik2) && BigDecimal.valueOf(wynik1).equals(wynik3) && wynik2.equals(wynik3.toBigInteger())) {
            System.out.println(x + "! jest równe " + wynik1);
            System.out.println("Głosowanie: 3/3");
            return BigInteger.valueOf(wynik1);
        }

//1 equals 2
        else if (BigInteger.valueOf(wynik1).equals(wynik2)) {
            System.out.println(x + "! jest równe " + wynik1);
            System.out.println("Głosowanie: 2/3");
            return BigInteger.valueOf(wynik1);
        }

//1 equals 3
        else if (BigDecimal.valueOf(wynik1).equals(wynik3)) {
            System.out.println(x + "! jest równe " + wynik1);
            System.out.println("Głosowanie: 2/3");
            return BigInteger.valueOf(wynik1);
        }

//2 equals 3
        else if (wynik2.equals(wynik3.toBigInteger())) {
            System.out.println(x + "! jest równe " + wynik2);
            System.out.println("Głosowanie: 2/3");
            return wynik2;
        }

//all different
        else {
            System.out.println("Błąd: każda funkcja zwraca inną wartość");
            return BigInteger.valueOf(-1);
        }
    }

    public static long silnia1(long a) throws IllegalArgumentException {

        if (a < 0) throw new IllegalArgumentException("Liczba nie może być ujemna");
        if (a < 2) return 1;
        return a * silnia1(a - 1);
    }

    public static BigInteger silnia2(int number) throws IllegalArgumentException {

        if (number < 0) {
            throw new IllegalArgumentException("Liczba musi być całkowita.");
        } else if (number == 0)
            return BigInteger.valueOf(1);
        else {
            BigInteger factorial = BigInteger.valueOf(1);

            for (int i = 1; i < number + 1; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        }
    }

    public static BigDecimal silnia3(BigDecimal index) throws IllegalArgumentException {

        if (index.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Nie można obliczyć silnii liczby ujemnej.");
        } else if (index.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else if (index.compareTo(BigDecimal.ONE) == 0) {
            return BigDecimal.ONE;
        } else {
            return index.multiply(silnia3(index.subtract(BigDecimal.ONE)));
        }
    }
}
