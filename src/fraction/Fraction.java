package fraction;

import org.jetbrains.annotations.NotNull;

public class Fraction implements IFraction {

    private final Integer numerator, denominator;

    public Fraction(@NotNull Integer numerator, @NotNull Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private Fraction reduceFraction(int numerator, int denominator) {
        int d;
        d = greatestCommonDivisor(numerator, denominator);

        numerator = numerator / d;
        denominator = denominator / d;
        return new Fraction(numerator, denominator);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        return greatestCommonDivisor(b, a % b);
    }

    @Override
    public @NotNull
    Integer getNumerator() {
        return numerator;
    }

    @Override
    public @NotNull
    Integer getDenominator() {
        return denominator;
    }

    @Override
    public @NotNull
    IFraction add(@NotNull IFraction other) {
        return reduceFraction((numerator * other.getDenominator()) + (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction minus(@NotNull IFraction other) {
        return reduceFraction((numerator * other.getDenominator()) - (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction times(@NotNull IFraction other) {
        return reduceFraction(this.numerator * other.getNumerator(), this.denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction dividedBy(@NotNull IFraction other) {
        return reduceFraction(this.numerator * other.getDenominator(), this.denominator * other.getNumerator());
    }
}
