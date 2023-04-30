package com.example.oop4;

public class RealNumber extends CompositeNumber{

    private Double value;

    public RealNumber(Double value) {
        this.value = value;
    }

    public RealNumber(String value) {
        try {
            this.value = Double.valueOf(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    int intFirstValue() {
        return value.intValue();
    }

    @Override
    int intSecondValue() {
        return 0;
    }

    @Override
    long longFirstValue() {
        return value.longValue();
    }

    @Override
    long longSecondValue() {
        return 0;
    }

    @Override
    float floatFirstValue() {
        return value.floatValue();
    }

    @Override
    float floatSecondValue() {
        return 0;
    }

    @Override
    double doubleFirstValue() {
        return value;
    }

    @Override
    double doubleSecondValue() {
        return 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
