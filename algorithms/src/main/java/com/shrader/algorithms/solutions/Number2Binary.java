package com.shrader.algorithms.solutions;

import com.shrader.algorithms.SolutionBase;
import java.util.ArrayList;


public class Number2Binary implements SolutionBase {

    public void run() {
        ArrayList<Integer> result = convert(5);
        print(result);
        print(reverse(result));

        result = convert(8);
        print(result);
        print(reverse(result));

        result = convert(38);
        print(result);
        print(reverse(result));

        result = convert(666);
        print(result);
        print(reverse(result));
    }

    private ArrayList<Integer> convert( int number ) {
        ArrayList<Integer> result = new ArrayList<>();

        while (number > 0) {
            // add remainder (1 or 0)
            result.add( number % 2 );

            // remove remainder
            number /= 2;
        }

        return result;
    }

    private ArrayList<Integer> reverse( ArrayList<Integer> arrayList ) {

        int begin = 0;
        int end = arrayList.size() - 1;

        while (begin <= end) {
            Integer temp = arrayList.get(begin);
            arrayList.set(begin, arrayList.get(end));
            arrayList.set(end, temp);

            begin++;
            end--;
        }

        return arrayList;
    }

    private void print(ArrayList<Integer> arrayList) {
        //arrayList.forEach (e -> System.out.println(e) );
        arrayList.forEach (System.out::print);
        System.out.println();
    }
}


