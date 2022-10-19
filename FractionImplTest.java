import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fraction.*;

public class FractionImplTest {

    @Test
    public void constructorTest1(){
        assertThrows(ArithmeticException.class,() -> new FractionImpl(1, 0));
    }
    @Test
    public void constructorTest2(){
        assertThrows(ArithmeticException.class,() -> new FractionImpl("1/0"));
    }
    @Test
    public void constructorTest3(){
        assertThrows(NumberFormatException.class,() -> new FractionImpl("/23/23"));
    }
    @Test
    public void constructorTest4(){
        assertThrows(NumberFormatException.class,() -> new FractionImpl("17/17/"));
    }
    @Test
    public void constructorTest5(){
        assertThrows(NumberFormatException.class,() -> new FractionImpl("1 3/4"));
    }
    @Test
    public void constructorTest6(){
        assertThrows(NumberFormatException.class,() -> new FractionImpl("13-4"));
    }
    @Test
    public void constructorTest7(){
        assertThrows(NumberFormatException.class,() -> new FractionImpl("ten"));
    }

    @Test
    public void addTest1(){
        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(1,4);
        FractionImpl test = new FractionImpl(1, 2);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest2(){
        FractionImpl num1 = new FractionImpl(" 1975124 / 1");
        FractionImpl num2 = new FractionImpl(2145508523,1);
        FractionImpl test = new FractionImpl(2147483647, 1); // max int
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest3(){
        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(1,8);
        FractionImpl test = new FractionImpl(3, 8);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest4(){
        FractionImpl num1 = new FractionImpl(" 2 / 10");
        FractionImpl num2 = new FractionImpl(10,2);
        FractionImpl test = new FractionImpl(26, 5);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest5(){
        FractionImpl num1 = new FractionImpl(3, 17);
        FractionImpl num2 = new FractionImpl(2,13);
        FractionImpl test = new FractionImpl(73, 221);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest6(){
        FractionImpl num1 = new FractionImpl("6");
        FractionImpl num2 = new FractionImpl(3,1);
        FractionImpl test = new FractionImpl(9, 1);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest7(){
        FractionImpl num1 = new FractionImpl(" 6");
        FractionImpl num2 = new FractionImpl(-1,1);
        FractionImpl test = new FractionImpl(5, 1);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest8(){
        FractionImpl num1 = new FractionImpl(" 35262 / 235236");
        FractionImpl num2 = new FractionImpl(2361,5742);
        FractionImpl test = new FractionImpl(10525925, 18760071);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest9(){
        FractionImpl num1 = new FractionImpl(" 24135 / 333");
        FractionImpl num2 = new FractionImpl("473482/2643");
        FractionImpl test = new FractionImpl(73819437, 293373);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }
    @Test
    public void addTest10(){
        FractionImpl num1 = new FractionImpl(" 6 / 3");
        FractionImpl num2 = new FractionImpl(14,7);
        FractionImpl test = new FractionImpl(4, 1);
        FractionImpl num3 = (FractionImpl) num1.add(num2);
        assertEquals(num3, test);
    }

    @Test
    public void subtractTest1(){
        FractionImpl num1 = new FractionImpl(" 1 / 2");
        FractionImpl num2 = new FractionImpl(1,2);
        FractionImpl test = new FractionImpl(0, 1);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest2(){
        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(1,2);
        FractionImpl test = new FractionImpl(-1, 4);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest3(){
        FractionImpl num1 = new FractionImpl(" 0 / 2");
        FractionImpl num2 = new FractionImpl(3,8);
        FractionImpl test = new FractionImpl(-3, 8);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest4(){
        FractionImpl num1 = new FractionImpl(" 17 / 12");
        FractionImpl num2 = new FractionImpl(10,24);
        FractionImpl test = new FractionImpl(1, 1);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest5(){
        FractionImpl num1 = new FractionImpl(" 9 / 13");
        FractionImpl num2 = new FractionImpl(4,13);
        FractionImpl test = new FractionImpl(5, 13);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest6(){
        FractionImpl num1 = new FractionImpl(3, 17);
        FractionImpl num2 = new FractionImpl(2,13);
        FractionImpl test = new FractionImpl(5, 221);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest7(){
        FractionImpl num1 = new FractionImpl(13, 124);
        FractionImpl num2 = new FractionImpl(1247,423);
        FractionImpl test = new FractionImpl(-149129, 52452);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest8(){
        FractionImpl num1 = new FractionImpl(3);
        FractionImpl num2 = new FractionImpl(74739876,533);
        FractionImpl test = new FractionImpl(-74738277, 533);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest9(){
        FractionImpl num1 = new FractionImpl(" 9 / 13");
        FractionImpl num2 = new FractionImpl(4,13);
        FractionImpl test = new FractionImpl(5, 13);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest10(){
        FractionImpl num1 = new FractionImpl(" 9862 / 1");
        FractionImpl num2 = new FractionImpl(9862,1);
        FractionImpl test = new FractionImpl(0, 1);
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }
    @Test
    public void subtractTest11(){
        FractionImpl num1 = new FractionImpl(" 2147483647 / 1");
        FractionImpl num2 = new FractionImpl(1_975_124,1);
        FractionImpl test = new FractionImpl(2_145_508_523, 1); // max int
        FractionImpl num3 = (FractionImpl) num1.subtract(num2);
        assertEquals(num3, test);
    }


    @Test
    public void multiplyTest1(){
        FractionImpl num1 = new FractionImpl(2, 7);
        FractionImpl num2 = new FractionImpl(2,7);
        FractionImpl test = new FractionImpl(4, 49);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }
    @Test
    public void multiplyTest2(){
        FractionImpl num1 = new FractionImpl(-3, 5);
        FractionImpl num2 = new FractionImpl(2,7);
        FractionImpl test = new FractionImpl(-6, 35);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }
    @Test
    public void multiplyTest3(){
        FractionImpl num1 = new FractionImpl(3, 8);
        FractionImpl num2 = new FractionImpl(1,7);
        FractionImpl test = new FractionImpl(3, 56);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }
    @Test
    public void multiplyTest4(){
        FractionImpl num1 = new FractionImpl(0, 5);
        FractionImpl num2 = new FractionImpl(-1,7);
        FractionImpl test = new FractionImpl(0, 1);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }
    @Test
    public void multiplyTest5(){
        FractionImpl num1 = new FractionImpl(4, 5);
        FractionImpl num2 = new FractionImpl(9,1);
        FractionImpl test = new FractionImpl(36, 5);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }
    @Test
    public void multiplyTest6(){
        FractionImpl num1 = new FractionImpl(4, 5);
        FractionImpl num2 = new FractionImpl(120568356,124238758);
        FractionImpl test = new FractionImpl(241136712, 310596895);
        FractionImpl num3 = (FractionImpl) num1.multiply(num2);
        assertEquals(num3, test);
    }


    @Test
    public void divideTest1(){
        FractionImpl num1 = new FractionImpl(2, 7);
        FractionImpl num2 = new FractionImpl(2,7);
        FractionImpl test = new FractionImpl(1, 1);
        FractionImpl num3 = (FractionImpl) num1.divide(num2);
        assertEquals(num3, test);
    }
    @Test
    public void divideTest2(){
        FractionImpl num1 = new FractionImpl(3, 7);
        FractionImpl num2 = new FractionImpl(4,7);
        FractionImpl test = new FractionImpl(3, 4);
        FractionImpl num3 = (FractionImpl) num1.divide(num2);
        assertEquals(num3, test);
    }
    @Test
    public void divideTest3(){
        FractionImpl num1 = new FractionImpl(5, 8);
        FractionImpl num2 = new FractionImpl(-3,7);
        FractionImpl test = new FractionImpl(-35, 24);
        FractionImpl num3 = (FractionImpl) num1.divide(num2);
        assertEquals(num3, test);
    }
    @Test
    public void divideTest4(){
        FractionImpl num1 = new FractionImpl(2, 7);
        FractionImpl num2 = new FractionImpl(0,7);
        assertThrows(ArithmeticException.class,() -> num1.divide(num2));
    }
    @Test
    public void divideTest5(){
        FractionImpl num1 = new FractionImpl(0, 7);
        FractionImpl num2 = new FractionImpl(3,5);
        FractionImpl test = new FractionImpl(0, 1);
        FractionImpl num3 = (FractionImpl) num1.divide(num2);
        assertEquals(num3, test);
    }
    @Test
    public void divideTest6(){
        FractionImpl num1 = new FractionImpl(2);
        FractionImpl num2 = new FractionImpl(0);
        assertThrows(ArithmeticException.class,() -> num1.divide(num2));
    }
    @Test
    public void divideTest7(){
        FractionImpl num1 = new FractionImpl("15/17");
        FractionImpl num2 = new FractionImpl("0");
        assertThrows(ArithmeticException.class,() -> num1.divide(num2));
    }


    @Test
    public void absTest1(){
        FractionImpl num1 = new FractionImpl(-3, 7);
        FractionImpl num2 = new FractionImpl(3,7);
        assertEquals(num1.abs(), num2);
    }
    @Test
    public void absTest2(){
        FractionImpl num1 = new FractionImpl(3, 7);
        FractionImpl num2 = new FractionImpl(3,7);
        assertEquals(num1.abs(), num2);
    }
    @Test
    public void absTest3(){
        FractionImpl num1 = new FractionImpl(-5, 1);
        FractionImpl num2 = new FractionImpl(5,1);
        assertEquals(num1.abs(), num2);
    }
    @Test
    public void absTest4(){
        FractionImpl num1 = new FractionImpl(0, -3);
        FractionImpl num2 = new FractionImpl(0,1);
        assertEquals(num1.abs(), num2);
    }
    @Test
    public void absTest5(){
        FractionImpl num1 = new FractionImpl(-10, -13);
        FractionImpl num2 = new FractionImpl(10,13);
        assertEquals(num1.abs(), num2);
    }

    @Test
    public void negateTest1(){
        FractionImpl num1 = new FractionImpl(3, 7);
        FractionImpl num2 = new FractionImpl(-3,7);
        assertEquals(num1.negate(), num2);
    }
    @Test
    public void negateTest2(){
        FractionImpl num1 = new FractionImpl(4, 5);
        FractionImpl num2 = new FractionImpl(-4,5);
        assertEquals(num1.negate(), num2);
    }
    @Test
    public void negateTest3(){
        FractionImpl num1 = new FractionImpl(2, 4);
        FractionImpl num2 = new FractionImpl(-1,2);
        assertEquals(num1.negate(), num2);
    }
    @Test
    public void negateTest4(){
        FractionImpl num1 = new FractionImpl(0, 1);
        FractionImpl num2 = new FractionImpl(0,1);
        assertEquals(num1.negate(), num2);
    }
    @Test
    public void negateTest5(){
        FractionImpl num1 = new FractionImpl(16, 3);
        FractionImpl num2 = new FractionImpl(-16,3);
        assertEquals(num1.negate(), num2);
    }


    @Test
    public void inverseTest1(){
        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(4,1);
        FractionImpl num3 = (FractionImpl) num1.inverse();
        assertEquals(num3, num2);
    }
    @Test
    public void inverseTest2(){
        FractionImpl num1 = new FractionImpl(" 3 / 8");
        FractionImpl num2 = new FractionImpl(8,3);
        FractionImpl num3 = (FractionImpl) num1.inverse();
        assertEquals(num3, num2);
    }
    @Test
    public void inverseTest3(){
        FractionImpl num1 = new FractionImpl(" -5 / 8");
        FractionImpl num2 = new FractionImpl(-8,5);
        FractionImpl num3 = (FractionImpl) num1.inverse();
        assertEquals(num3, num2);
    }
    @Test
    public void inverseTest4(){
        FractionImpl num1 = new FractionImpl(" -13 / 1");
        FractionImpl num2 = new FractionImpl(-1,13);
        FractionImpl num3 = (FractionImpl) num1.inverse();
        assertEquals(num3, num2);
    }
    @Test
    public void inverseTest5(){
        FractionImpl num1 = new FractionImpl(" -2 / 8");
        FractionImpl num2 = new FractionImpl(-4,1);
        FractionImpl num3 = (FractionImpl) num1.inverse();
        assertEquals(num3, num2);
    }
    @Test
    public void inverseTest6(){
        FractionImpl num1 = new FractionImpl("0");
        assertThrows(ArithmeticException.class, num1::inverse);
    }
    @Test
    public void inverseTest7(){
        FractionImpl num1 = new FractionImpl(0, 12463419);
        assertThrows(ArithmeticException.class, num1::inverse);
    }


    @Test
    public void equalsTest1(){
        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(1,4);
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest2(){
        FractionImpl num1 = new FractionImpl("2/8");
        FractionImpl num2 = new FractionImpl(1,4);
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest3(){
        FractionImpl num1 = new FractionImpl(4, 1);
        FractionImpl num2 = new FractionImpl(1,4);
        assertNotEquals(num1, num2);
    }
    @Test
    public void equalsTest4(){
        FractionImpl num1 = new FractionImpl(" 3 / 7");
        FractionImpl num2 = new FractionImpl(" 1 / 7");
        assertNotEquals(num1, num2);
    }
    @Test
    public void equalsTest5(){
        FractionImpl num1 = new FractionImpl("5");
        FractionImpl num2 = new FractionImpl(5);
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest6(){
        FractionImpl num1 = new FractionImpl("-5");
        FractionImpl num2 = new FractionImpl(-5);
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest7(){
        FractionImpl num1 = new FractionImpl(1, -2);
        FractionImpl num2 = new FractionImpl("-1/2");
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest8(){
        FractionImpl num1 = new FractionImpl(-1, -2);
        FractionImpl num2 = new FractionImpl("1/-2");
        assertNotEquals(num1, num2);
    }
    @Test
    public void equalsTest9(){
        FractionImpl num1 = new FractionImpl(-1, -2);
        FractionImpl num2 = new FractionImpl("1/2");
        assertEquals(num1, num2);
    }
    @Test
    public void equalsTest10(){
        FractionImpl num1 = new FractionImpl(-5, -2);
        FractionImpl num2 = new FractionImpl("5/2");
        assertEquals(num1, num2);
    }


    @Test
    public void compareToTest1(){
        FractionImpl num1 = new FractionImpl(-5, -2);
        FractionImpl num2 = new FractionImpl("5/2");
        assertEquals(num1.compareTo(num2),0);
    }
    @Test
    public void compareToTest2(){
        FractionImpl num1 = new FractionImpl(2, 3);
        FractionImpl num2 = new FractionImpl("1/3");
        assertEquals(num1.compareTo(num2),1);
    }
    @Test
    public void compareToTest3(){
        FractionImpl num1 = new FractionImpl(3, 8);
        FractionImpl num2 = new FractionImpl("5/8");
        assertEquals(num1.compareTo(num2),-1);
    }
    @Test
    public void compareToTest4(){
        FractionImpl num1 = new FractionImpl(4, 1);
        FractionImpl num2 = new FractionImpl(4);
        assertEquals(num1.compareTo(num2),0);
    }
    @Test
    public void compareToTest5(){
        FractionImpl num1 = new FractionImpl(17, 19);
        FractionImpl num2 = new FractionImpl("1/3");
        assertEquals(num1.compareTo(num2),1);
    }
    @Test
    public void compareToTest6(){
        FractionImpl num1 = new FractionImpl(11);
        FractionImpl num2 = new FractionImpl(12);
        assertEquals(num1.compareTo(num2),-1);
    }

    @Test
    public void toStringTest1(){
        FractionImpl num1 = new FractionImpl(-5, 2);
        assertEquals(num1.toString(), "-5/2");
    }
    @Test
    public void toStringTest2(){
        FractionImpl num1 = new FractionImpl(6);
        assertEquals(num1.toString(), "6");
    }
    @Test
    public void toStringTest3(){
        FractionImpl num1 = new FractionImpl("9          /   13");
        assertEquals(num1.toString(),"9/13");
    }
    @Test
    public void toStringTest4(){
        FractionImpl num1 = new FractionImpl("    -3/8     ");
        assertEquals(num1.toString(), "-3/8");
    }
    @Test
    public void toStringTest5(){
        FractionImpl num1 = new FractionImpl("40/45");
        assertEquals(num1.toString(), "8/9");
    }
    @Test
    public void toStringTest6(){
        FractionImpl num1 = new FractionImpl("-40/-45");
        assertEquals(num1.toString(), "8/9");
    }
    @Test
    public void toStringTest7(){
        FractionImpl num1 = new FractionImpl(-15);
        assertEquals(num1.toString(), "-15");
    }
    @Test
    public void toStringTest8(){
        FractionImpl num1 = new FractionImpl("40/-45");
        assertEquals(num1.toString(), "-8/9");
    }
    @Test
    public void toStringTest9(){
        FractionImpl num1 = new FractionImpl("40/5");
        assertEquals(num1.toString(), "8");
    }
}
