package fraction;
import java.util.*;

/**
 * Class <code>FractionImpl</code> represents fractions of the form numerator and denominator.
 * A number of class methods can be called on <code>FractionImpl</code> objects to perform
 * arithmetic operations and compare <code>FractionImpl</code> objects.
 * The object are immutable.
 * Passing a null argument to a constructor or method in this class will cause a
 * {@link NullPointerException} to be thrown.
 *
 */

public class FractionImpl implements Fraction {

    private final int numerator;
    private final int denominator;

    /**
     * Takes 2 integers as parameters and constructs a new <code>FractionImpl</code> object.
     *
     * <p>Fractions are normalised as they are created. For instance, if the parameters are (8, -12),
     * <code>Fraction</code> with numerator -2 and denominator 3 is created. Denominator cannot be 0.
     * {@link ArithmeticException} will be thrown if denominator is equal to 0.
     *
     * @throws ArithmeticException if the denominator is zero
     * @throws NullPointerException if passed null
     * @param numerator top (left) part of the fraction
     * @param denominator bottom (right) part of the fraction
     */
    public FractionImpl(int numerator, int denominator) {

        int sign = 1;

        if(denominator == 0){
            throw new ArithmeticException("Denominator cannot be equal to 0.");
        }
        else {
            if( numerator == 0){
                this.numerator = 0;
                this.denominator = 1;
            }
            else if ( numerator == denominator) {
                this.numerator = 1;
                this.denominator = 1;
            }
            else {
                if(numerator < 0 ^ denominator < 0){
                    sign = -1;
                }
                numerator = Math.abs(numerator);
                denominator = Math.abs(denominator);

                int gcd = findGCD(numerator, denominator);
                this.numerator = numerator / gcd * sign;
                this.denominator = denominator / gcd;
            }
        }
    }

    /**
     * Takes 1 integers a parameter and constructs a new <code>FractionImpl</code> object.
     *
     * <p>The parameter is the numerator and 1 is the implicit denominator.
     * @throws NullPointerException if passed null
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * Constructs a new <code>FractionImpl</code> object.
     * The parameter is a <code>String</code> containing either a whole number, such as "5" or "-3",
     * or a fraction, such as "8/-12".
     * Blanks are allowed around (but not within) integers.
     *
     * @throws ArithmeticException if passed fraction with denominator equal to zero
     * @throws NullPointerException if passed null
     * @throws NumberFormatException if passed string that's not in acceptable format
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // String constructor uses a helper method stringToInt and then the int constructor.
        // Division by zero (denominator == 0) is handled within int constructor.
        this(stringToInt(fraction)[0],stringToInt(fraction)[1]);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl fr = (FractionImpl) f;
        int num, denom;
        //checking if denominators match can save on normalising later
        if( this.denominator == fr.denominator){
            denom = this.denominator;
            num = this.numerator + fr.numerator;
        }
        else{
            num = this.numerator * fr.denominator + fr.numerator * this.denominator;
            denom = this.denominator * fr.denominator;
        }
        return new FractionImpl(num, denom);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl fNegate = (FractionImpl) f.negate();
        return this.add(fNegate);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl frac = (FractionImpl) f;
        int num, denom;

        num = this.numerator * frac.numerator;
        denom = this.denominator * frac.denominator;
        return new FractionImpl(num, denom);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl fInverse = (FractionImpl) f.inverse();
        return this.multiply(fInverse);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.numerator),this.denominator);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(this.numerator*-1,this.denominator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if ( obj == this){
            return true;
        }
        if(!(obj instanceof FractionImpl )){
            return false;
        }
        FractionImpl f = (FractionImpl) obj;
        return Objects.equals(f.denominator,this.denominator) && Objects.equals(f.numerator, this.numerator);
    }

    /**
     * {@inheritDoc}
     * <p>Integer overflow or underflow is not handled by this method.
     * @throws ArithmeticException if used on fraction with numerator equal to 0
     */
    @Override
    public Fraction inverse() {

        if(this.numerator != 0) {
            return new FractionImpl(this.denominator, this.numerator);
        }
        else{
            throw new ArithmeticException("Reciprocal of 0 is undefined.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Fraction o) {
        FractionImpl fr1 = new FractionImpl(this.numerator, this.denominator);
        FractionImpl fr2 = (FractionImpl) o;
        FractionImpl res  = (FractionImpl) fr1.subtract(fr2);

        if( res.numerator > 0){
            return 1;
        }
        else if ( res.numerator < 0 ){
            return -1;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if( this.denominator == 1){
            return(this.numerator+"");
        }
        return (this.numerator + "/" + this.denominator);
    }

    /**
     * Helper function to find the greatest common divisor for 2 passed in integers. Used for normalisation
     * of fractions.
     * @param num1 integer
     * @param num2 integer
     * @return int greatest common divisor.
     */
    private static int findGCD(int num1, int num2){
        int small = Math.min(num1, num2);
        int big = Math.max(num1, num2);
        int gcd;

        while (true){
            int remain = big%small;
            if ( remain == 0){
                gcd = small;
                break;
            }
            else{
                big = small;
                small = remain;
            }
        }
        return gcd;
    }

    /**
     * Helper method for <code>FractionImpl</code> <code>String</code> constructor.
     * The parameter is a <pre>String</pre> containing either a whole number, such as "5" or "-3", or a fraction,
     * such as "8/-12".
     * Allows blanks around (but not within) integers.
     * Returns an array of 2 integers parsed from parameter <code>String</code>. If whole number is passed then the
     * implicit denominator is 1.
     *
     * @throws NumberFormatException if incorrect format of <code>String</code> is passed, such as,
     * containing symbols other than numbers or one or none '/', more than two integers, spaces within integers,
     * number representation that can't be parsed to int.
     * @param s the string representation of the fraction
     * @return Array with numerator and denominator
     */
    private static int[] stringToInt(String s){

        try{
            int[] res = new int[2];
            String[] nums = s.split("/", 2);

            if ( nums.length == 2) {
                res[0] = Integer.parseInt(nums[0].trim());
                res[1] = Integer.parseInt(nums[1].trim());
            }
            else if ( nums.length == 1) {
                res[0] = Integer.parseInt(nums[0].trim());
                res[1] = 1;
            }
            return res;
        }
        catch( NumberFormatException ex ){
            throw new NumberFormatException("Incorrect use of fraction string constructor.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}