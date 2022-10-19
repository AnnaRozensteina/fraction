import fraction.*;

public class Main {

    public static void main(String[] args) {

        // below are examples of how FractionImpl can be used

        FractionImpl num1 = new FractionImpl(" 1 / 4");
        FractionImpl num2 = new FractionImpl(" 3 / 8");
        System.out.println("Addition example: ");
        System.out.println(num1 + " + " + num2 + " = " + num1.add(num2) + "\n");

        FractionImpl num3 = new FractionImpl(3, 8);
        FractionImpl num4 = new FractionImpl(1, 24);
        System.out.println("Subtraction example: ");
        System.out.println(num3 + " - " + num4 + " = " + num3.subtract(num4) + "\n");

        FractionImpl num5 = new FractionImpl(5, 13);
        FractionImpl num6 = new FractionImpl(12, 5);
        System.out.println("Multiplication example: ");
        System.out.println(num5 + " * " + num6 + " = " + num5.multiply(num6) + "\n");

        FractionImpl num7 = new FractionImpl(43, 9);
        FractionImpl num8 = new FractionImpl(89, 17);
        System.out.println("Division example: ");
        System.out.println(num7 + " : " + num8 + " = " + num7.divide(num8) + "\n");

        FractionImpl num9 = new FractionImpl(-1, 9);
        System.out.println("The absolute value of " + num9 + " is " + num9.abs() + "\n");

        System.out.println("The reciprocal of " + num8 + " is " + num8.inverse() + "\n");

        FractionImpl num10 = new FractionImpl("16/80");
        System.out.println("All fractions are normalised.\nFor example, 16/80 is normalised to " + (num10) + "\n");

        FractionImpl num11 = new FractionImpl(1, 3);
        System.out.println("Methods can be nested to work with more than two fractions at a time:");
        System.out.println("(1/3 + 1/3) * 1/3 = " + num11.multiply(num11.add(num11)) + "\n");

        FractionImpl num12 = new FractionImpl(5, 13);
        System.out.println(num5.equals(num6) + " is returned when comparing 2 fractions that are not equal.");
        System.out.println(num5.equals(num12) + " is returned when comparing 2 fractions that are are equal.");

    }
}