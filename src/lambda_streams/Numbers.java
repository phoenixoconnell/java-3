package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

class Numbers {

    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wherever possible.
        System.out.println(nums);
        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.
        added(() -> {});
        OR
        lambdaAdd = () -> {};
        added(lambdaAdd);
        isOdd(() -> {});
        OR
        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...
        */
        System.out.println(isOdd(() -> nums.get(1) % 2 != 0));
        System.out.println(isEven(() -> nums.get(1) % 2 == 0));
        System.out.println(isPrime(() -> {
            int n = nums.get(1);
            if(n == 2) return true;
            for(int j = n / 2; j > 2; j--) {
                if(n % j == 0) {
                    return false;
                }
            }
            return true;
        }));
        System.out.println(added((a, i) -> a + i));
        System.out.println(subtracted((a, i) -> a - i));
        System.out.println(multiplied((a, i) -> (long) (a * i)));
        System.out.println(divided(n -> n / 2));
        System.out.println(findMax(() -> nums.stream().max(Integer::compare).get()));
        System.out.println(findMin(() -> nums.stream().min(Integer::compare).get()));
        System.out.println(compare((a, b) -> a < b ? a == b ? 0 : 1 : -1, 0, 1));
        System.out.println(append(n -> n, 234));
    }

    static boolean isOdd(BooleanSupplier fn) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        return fn.getAsBoolean();
    }

    static boolean isEven(BooleanSupplier fn) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        return fn.getAsBoolean();
    }

    static boolean isPrime(BooleanSupplier fn) {
        //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        return fn.getAsBoolean();
    }

    static int added(BinaryOperator<Integer> fn) {
        //add all the elements in the list.  return the sum.
        return nums.stream().reduce(0, (a, i) -> fn.apply(a, i));
    }

    static int subtracted(BinaryOperator<Integer> fn) {
        //subtract all the elements in the list. return the remainder.
        return nums.stream().reduce(0, (a, i) -> fn.apply(a, i));
    }

    static long multiplied(ToLongBiFunction<Integer, Integer> fn) {
        //multiply all the elements in the list. and return the product.
        return (long) nums.stream().reduce(1, (a, i) -> Math.toIntExact(fn.applyAsLong(a, i)));
    }

    static List<Integer> divided(IntUnaryOperator fn) {
        //multiply all the elements in the list. and return the product.
        List<Integer> divs = nums.stream().map(n -> fn.applyAsInt(n)).collect(Collectors.toList());
        return divs;
    }

    static int findMax(IntSupplier fn) {
        //return the maximum value in the list.
        return fn.getAsInt();
    }

    static int findMin(IntSupplier fn) {
        //return the minimum value in the list.
        return fn.getAsInt();
    }

    static int compare(IntBinaryOperator fn, Integer i, Integer j) {
        //compare the values stored in the array at index position i and j.
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        int x = nums.get(i);
        int y = nums.get(j);
        int comp = fn.applyAsInt(x, y);
        return comp;
    }

    static int append(IntUnaryOperator fn, Integer i) {
        //add a new value to the values list. return that value after adding it to the list.
        //for some reason calling .add() crashes the app.  I don't understand why
        ArrayList<Integer> temp = new ArrayList<>(nums);
        temp.add(i);
        nums = (List<Integer>) temp;
//        System.out.println(nums);
        return fn.applyAsInt(i);
    }
}