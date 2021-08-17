package com.shrader.algorithms.solutions;

public class Roman2Integer {
    public Roman2Integer() {
        int result = roman2Integer("III");
        System.out.printf( "Roman2Integer Result: %d%n", result );

        result = roman2Integer("VI");
        System.out.printf( "Roman2Integer Result: %d%n", result );

        result = roman2Integer("MDCLI"); // 1000 + 500 + 100 + 50 + 1 = 1651
        System.out.printf( "Roman2Integer Result: %d%n", result );

        result = roman2Integer("IV"); // 4
        System.out.printf( "Roman2Integer Result: %d%n", result );

        result = roman2Integer("LVIII"); // 50 + 5 + 1 + 1 + 1 = 58
        System.out.printf( "Roman2Integer Result: %d%n", result );

        result = roman2Integer("MCMXCIV"); // 1000 + 900 + 90 + 4
        System.out.printf( "Roman2Integer Result: %d%n", result );
    }

    private int roman2Integer(String romanNumerals) {
        int result = 0;

        char[] chars = romanNumerals.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int current = getValue(chars[i]);

            // 0 + 1 = 1 < 2, 1 + 1 = 2 == 2
            if (i + 1 < chars.length) {
                int next = getValue(chars[i + 1]);
                System.out.printf("Result: (%d,%d)%n", current, next);

                if (current >= next) {
                    // next char is less than current so continue (e.g. XI, XV, XX, etc.)
                    result += current;
                } else {
                    // next char is greater than current so get difference and skip ahead counter (e.g. IX)
                    result += (next - current);
                    i++;
                }
            } else {
                // last char
                result += current;
            }
        }

        return result;
    }


    private static int getValue(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }
}
