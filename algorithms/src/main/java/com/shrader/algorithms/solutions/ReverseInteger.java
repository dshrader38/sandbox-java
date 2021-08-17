package com.shrader.algorithms.solutions;


/*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
    the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
*/
public class ReverseInteger {
    public ReverseInteger() {
        int result = reverseInteger(123);
        System.out.printf( "Result: %d%n", result );
        assert(result == 321);

        result = reverseInteger(120);
        System.out.printf( "Result: %d%n", result );
        assert(result == 21);

        result = reverseInteger(153423);
        System.out.printf( "Result: %d%n", result );

        result = reverseInteger(1534236469);
        System.out.printf( "Result: %d%n", result );
    }


    private int reverseInteger(int num) {
        int result = 0;

        // get last digit it and add to new number
        while (num != 0) {
            // get last digit from number (gets remainder)
            int lastDigit = num % 10;

            // INT_MAX = 2147483647
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && lastDigit > 7)) return 0;

            // INT_MAX = -2147483648
            if (result < (Integer.MIN_VALUE / 10) || (result == (Integer.MIN_VALUE / 10) && lastDigit < -8)) return 0;

            // 3, 32, 321
            result = (result * 10) + lastDigit;

            // remove last digit from number
            num /= 10;
        }

        return result;
    }
}
