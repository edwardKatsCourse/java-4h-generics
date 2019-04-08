package com.company.variance;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Covariance
        String [] names = new String[] {
                "peter",
                "sally",
                "james"
        };

        //Object [] <- String []
        Object [] objectNames = names;

        Integer digit = (Integer) objectNames[0];


        //Invariance
        //String [] <- String []


        User<String> stringUser_1 = new User<>();
        User<String> stringUser_2 = new User<>();
        stringUser_1 = stringUser_2;


        User<Object> objectUser = new User<>();

        //invariance - no variants (string:string, integer:integer, object:object)
        //string <- object
//        stringUser_1 = objectUser;

        //object <- string
//        objectUser = stringUser_2;


        List<String> stringList_1 = new ArrayList<>();
        List<String> stringList_2 = new ArrayList<>();
        stringList_1 = stringList_2;


        List<Integer> integerList = new ArrayList<>();
//        integerList = stringList_1;

        List<Object> objectList = new ArrayList<>();
        //integerList = objectList; //invariant

        //Covariance
//        List<? extends Number> numberList = new ArrayList<>();//double, int, long, short

//        List<Integer> integers = new ArrayList<>();
//        List<Long> longs = new ArrayList<>();

//        numberList = integers;
//        numberList = longs;
//        integers = numberList;


        //Contravariant
        List<Number> numbers = new ArrayList<>();
        List<? super Integer> integers = new ArrayList<>();
        List<Integer> longs = new ArrayList<>();

        integers = numbers;

    }
}

class User<T> {
    T param;
}
