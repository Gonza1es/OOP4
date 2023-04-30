package com.example.oop4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TComplex extends CompositeNumber {

    private final Number real;
    private final Number imaginary;

    private static final Pattern pattern = Pattern.compile("^[-]?[0-9]*[.,]?[0-9]*[+]{1}[-]?[0-9]*[.,]?[0-9]*[i]$");

    public TComplex(Number real, Number imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public TComplex(String complexString) throws Exception {
        Matcher matcher = pattern.matcher(complexString);
        if (!matcher.matches()) {
            throw new Exception("Неверный формат строки");
        }
        String[] values = complexString.split("\\+");
        values[1] = values[1].replaceAll("i","");
        this.real = Double.valueOf(values[0]);
        this.imaginary = Double.valueOf(values[1]);
    }

    @Override
    int intFirstValue() {
        return real.intValue();
    }

    @Override
    int intSecondValue() {
        return imaginary.intValue();
    }

    @Override
    long longFirstValue() {
        return real.longValue();
    }

    @Override
    long longSecondValue() {
        return imaginary.longValue();
    }

    @Override
    float floatFirstValue() {
        return real.floatValue();
    }

    @Override
    float floatSecondValue() {
        return imaginary.floatValue();
    }

    @Override
    double doubleFirstValue() {
        return real.doubleValue();
    }

    @Override
    double doubleSecondValue() {
        return imaginary.doubleValue();
    }

    @Override
    public String toString() {
        return real.doubleValue()+ "+" + imaginary.doubleValue() + "i";
    }
}
