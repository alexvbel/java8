package com.abel.tricks.recursion;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Factorial {

    private UnaryOperator<BigInteger> factorial = x -> BigInteger.ZERO.equals(x) ? BigInteger.ONE : this.factorial.apply(x.subtract(BigInteger.ONE)).multiply(x);

    public static void main(String[] args) {
        BigInteger input = new Scanner(System.in).nextBigInteger();
        System.out.println(new Factorial().factorial.apply(input));
    }
}
