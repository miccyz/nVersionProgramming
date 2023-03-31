import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInFibonacci1(){
        Fibonacci.fibonacci1(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInFibonacci2(){
        Fibonacci.fibonacci2(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInFibonacci3(){
        Fibonacci.fibonacci3(BigDecimal.valueOf(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInFibonacci(){
        Fibonacci.fibonacci(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValueInFibonacci1(){ Fibonacci.fibonacci1(0); }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValueInFibonacci2(){
        Fibonacci.fibonacci2(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValueInFibonacci3(){
        Fibonacci.fibonacci3(BigDecimal.valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValueInFibonacci(){
        Fibonacci.fibonacci(0);
    }


    public void testValue(int expectedValue, int index){

//Testy metod liczacych wyrazy ciagu
        assertEquals(expectedValue, Fibonacci.fibonacci1(index));
        assertEquals(BigInteger.valueOf(expectedValue),Fibonacci.fibonacci2(index));
        assertEquals(BigDecimal.valueOf(expectedValue),Fibonacci.fibonacci3(BigDecimal.valueOf(index)));

//Test metody głosującej
        assertEquals(BigInteger.valueOf(expectedValue),Fibonacci.fibonacci(index));
    }

    @Test
    public void testValueOne(){testValue(1,1);}

    @Test
    public void testValueTwo(){ testValue(1,2);}

    @Test
    public void testValueThree(){ testValue(55,10);}

    @Test
    public void testValueFour(){ testValue(4181,19);}
}
