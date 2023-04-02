package com.example.oop4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TRational extends CompositeNumber{

    private final Integer a;
    private final Integer b;

    private static final Pattern pattern = Pattern.compile("^[-]?[0-9]*[/][-]?[0-9]*$");

    public TRational(Integer a, Integer b){
        int gcd = gcd(a, b);
        this.a = a/gcd;
        this.b = b/gcd;
    }

    public TRational(String value) throws Exception {
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new Exception("Неверный формат строки");
        }
        String[] values = value.split("/");
        Integer a = Integer.valueOf(values[0]);
        Integer b = Integer.parseInt(values[1]);
        if (b <= 0) {
            throw new Exception("Неверные значения");
        }
        int gcd = gcd(a, b);
        this.a = a/gcd;
        this.b = b/gcd;
    }

    private int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    @Override
    int intFirstValue() {
        return a;
    }

    @Override
    int intSecondValue() {
        return b;
    }

    @Override
    long longFirstValue() {
        return a.longValue();
    }

    @Override
    long longSecondValue() {
        return b.longValue();
    }

    @Override
    float floatFirstValue() {
        return a.floatValue();
    }

    @Override
    float floatSecondValue() {
        return b.floatValue();
    }

    @Override
    double doubleFirstValue() {
        return a.doubleValue();
    }

    @Override
    double doubleSecondValue() {
        return b.doubleValue();
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }
}
