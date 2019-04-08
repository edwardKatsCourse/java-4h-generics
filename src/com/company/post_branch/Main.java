package com.company.post_branch;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         *                  Package
         *
         *  Small Package   Middle Package   Large Package
         */

        LargePackage largeCargoSent = new LargePackage("John Smith", "Peter Dale", 19);


        Package receivedWithParent = processPackageWithParent(largeCargoSent);

        //processPackageWithGeneric<LargePackage>
        LargePackage receivedWithGeneric = processPackageWithGeneric(largeCargoSent);

        MiddlePackage middlePackageWithGenericSend = new MiddlePackage("JS", "PD", 9);

        MiddlePackage middlePackage = processPackageWithGeneric(middlePackageWithGenericSend);


        SmallPackage smallPackageWithGeneric = new SmallPackage("from", "to", 1);

        SmallPackage receivedPackageWithParent = processPackageWithGeneric(smallPackageWithGeneric);

//        processPackageWithGeneric(new StringBuilder())

        List list = getList();
        //  Child              Parent
//        ArrayList arrayList = getList();

        //Parent = Child
        //Parent = Parent



    }

    private static List getList() {
        return new ArrayList();
    }

    private static Package resolvePackageByWeight(String from, String to, Integer weight) {
        if (weight == null || weight == 0) {
            return null;
        }

        if (weight <= SmallPackage.getMaxWeight()) {

            return new SmallPackage(from, to, weight);

        } else if (weight <= MiddlePackage.getMaxWeight()) {

            return new MiddlePackage(from, to, weight);
        } else if (weight <= LargePackage.getMaxWeight()){

            return new LargePackage(from, to, weight);
        } else {

            System.out.println("Hire yourself a plane!");
        }
        return null;
    }

    //processPackage - Small package
    //processPackage - Middle package
    //processPackage - Large package
    private static <T extends Package> T processPackageWithGeneric(T pack) {
        System.out.println(pack.toString());
        return pack;
    }

//    private static <T extends List<T>> T processList(T pack) {}

    private static Package processPackageWithParent(Package pack) {
        System.out.println(pack.toString());
        return pack;
    }


}

class Package {
    private String from;
    private String to;
    private Integer weight;

    public Package(String from, String to, Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public static Integer getMaxWeight() {
        return 0;
    }
}

class SmallPackage extends Package {
    public SmallPackage(String from, String to, Integer weight) {
        super(from, to, weight);
    }

    public static Integer getMaxWeight() {
        return 2; //kg
    }
}

class MiddlePackage extends Package {
    public MiddlePackage(String from, String to, Integer weight) {
        super(from, to, weight);
    }

    public static Integer getMaxWeight() {
        return 10; //kg
    }
}

class LargePackage extends Package {
    public LargePackage(String from, String to, Integer weight) {
        super(from, to, weight);
    }

    public static Integer getMaxWeight() {
        return 20; //kg
    }
}