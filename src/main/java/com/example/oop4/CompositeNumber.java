package com.example.oop4;

public abstract class CompositeNumber {

    public static CompositeNumber getDefaultValue(CompositeNumber value) {
        if (value instanceof TRational) return new TRational(0, 1);
        if (value instanceof TComplex) return new TComplex(0, 0);
        if (value instanceof RealNumber) return new RealNumber(0.0);
        return null;
    }
    abstract int intFirstValue();

    abstract int intSecondValue();

    abstract long longFirstValue();

    abstract long longSecondValue();

    abstract float floatFirstValue();

    abstract float floatSecondValue();

    abstract double doubleFirstValue();

    abstract double doubleSecondValue();
}
