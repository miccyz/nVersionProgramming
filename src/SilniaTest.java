import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SilniaTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInSilnia1(){
        Silnia.silnia1(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInSilnia2(){
        Silnia.silnia2(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInSilnia3(){
        Silnia.silnia3(BigDecimal.valueOf(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownInSilnia(){ Silnia.silnia(-1); }

    public void testValue(int expectedValue, int index){

//Testy metod liczacych wyrazy ciagu
        assertEquals(expectedValue, Silnia.silnia1(index));
        assertEquals(BigInteger.valueOf(expectedValue),Silnia.silnia2(index));
        assertEquals(new BigDecimal(expectedValue),Silnia.silnia3(BigDecimal.valueOf(index)));

//Test metody głosującej
        assertEquals(BigInteger.valueOf(expectedValue),Silnia.silnia(index));
    }

    @Test
    public void testValueOne(){testValue(1,0);}

    @Test
    public void testValueTwo(){testValue(1,1);}

    @Test
    public void testValueThree(){testValue(2,2);}

    @Test
    public void testValueFour(){testValue(120,5);}

    @Test
    public void testValueFive(){
        assertEquals(new BigInteger("51090942171709440000"),Silnia.silnia(21));
    }

    @Test( expected = StackOverflowError.class)
    public void testValueSix(){
        Silnia.silnia3(BigDecimal.valueOf(11988));
    }
}
