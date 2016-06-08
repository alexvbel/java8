package com.abel.tricks.recursion;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibonacciRecursive {

    private static BigInteger calculateFibonacci(int number) {
        return fibonacci(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(number)).invoke();
    }

    private static TailCall<BigInteger> fibonacci(BigInteger val1, BigInteger val2, BigInteger x) {
        if (x.equals(BigInteger.ZERO)) {
            return TailCall.done(BigInteger.ONE);
        } else if (x.equals(BigInteger.ONE)) {
            return TailCall.done(val1.add(val2));
        } else {
            return TailCall.next(() -> fibonacci(val2, val1.add(val2), x.subtract(BigInteger.ONE)));
        }
    }

    private static String fibonacciRange(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                .map(i -> calculateFibonacci(i))
                .map(BigInteger::toString)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {

        int in = new Scanner(System.in).nextInt();
        System.out.println(fibonacciRange(in));

    }


}
