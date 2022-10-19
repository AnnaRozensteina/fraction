package fraction;

/**
 * Represents fractions of the form numerator and denominator.
 * The object should be immutable.
 */
public interface Fraction extends Comparable<Fraction> {

    /**
     * Returns a new <code>Fraction</code> that is the <i>sum</i> of <code>this</code> and the parameter:
     * <p>a/b + c/d is (ad + bc)/bd
     *
     * @param f the fraction to add to the current fraction
     * @return the result of the addition
     */
    Fraction add(Fraction f);

    /**
     * Returns a new <code>Fraction</code> that is the <i>difference</i> of <code>this</code> minus the parameter:
     * <p>a/b - c/d is (ad - bc)/bd
     * <p>Uses <code>add()</code> and <code>negate()</code> methods by adding the negated parameter to <code>this</code>
     *
     * @param f the fraction to subtract from the current fraction
     * @return the result of the subtraction
     */
    Fraction subtract(Fraction f);

    /**
     * Returns a new <code>Fraction</code> that is the <i>product</i> of <code>this</code> and the parameter:
     * <p>(a/b) * (c/d) is (a*c)/(b*d)
     *
     * @param f the fraction to multiply with the current fraction
     * @return the result of the multiplication
     */
    Fraction multiply(Fraction f);

    /**
     * Returns a new <code>Fraction</code> that is the <i>quotient</i> of dividing this by the parameter:
     * <p>(a/b) / (c/d) is (a*d)/(b*c)
     * <p>Uses <code>multiply()</code> and <code>inverse()</code> methods by returning the <i>product</i> of
     * <code>this</code> and the inversion of the parameter
     *
     * @param f the fraction to take part in the division
     * @return the result of the division
     */
    Fraction divide(Fraction f);

    /**
     * Returns a new <code>Fraction</code> that is the <i>absolute value</i> of <code>this</code>.
     *
     * @return the absolute value of the fraction as a new fraction
     */
    Fraction abs();

    /**
     * Returns a new <code>Fraction</code> that has the same numeric value as <code>this</code>,
     * but the opposite sign.
     *
     * @return the newly negated fraction
     */
    Fraction negate();

    /**
     * Returns a new <code>Fraction</code> that is the <i>inverse</i> of <code>this</code>.
     * <p>The inverse of a/b is b/a.
     *
     * @return the newly inverted fraction
     */
    Fraction inverse();

    /**
     * Returns <code>true</code> if <code>o</code> is a <code>Fraction</code> equal to <code>this</code>,
     * and <code>false</code> in all other cases.
     *
     * @param o the object to compare this one to
     * @return <code>true</code> if this fraction is the same as the argument; <code>false</code> otherwise.
     */
    @Override
    boolean equals(Object o);

    /**
     * Returns:
     * <ul>
     *     <li>A negative <code>int</code> if this is less than <code>o</code>.</li>
     *     <li>Zero if this is equal to <code>o</code>.</li>
     *     <li>A positive int if this is greater than <code>o</code>.</li>
     * </ul>
     *
     * @param f the fraction to compare this to
     * @return the result of the comparison
     */
    @Override
    int compareTo(Fraction f);

    /**
     * Returns a <code>String</code> of the form n/d, where n is the
     * <i>numerator</i> and d is the <i>denominator</i>.
     * If d is 1, returns n (as a <code>String</code>).
     * If the fraction represents a negative number, a minus sign precedes n.
     * <p>The returned <code>String</code> should not contain any blanks.
     *
     * @return the string representation fo the fraction
     */
    @Override
    String toString();
}