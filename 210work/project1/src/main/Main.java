package main;

import hw7.StringSet;

public class Main {
    public static void main(String[] args) {
        StringSet mySet = new StringSet(0);
        System.out.println(mySet.toString());
        mySet.add("Chris");
        System.out.println(mySet.toString());
        mySet.add("Chris");
        mySet.add("Kyle");
        System.out.println(mySet.toString());
        mySet.add("Roland");
        mySet.add("Steve");
        mySet.add("Logan");
        mySet.remove("Roland");
        System.out.println(mySet.contains("Stev"));
        System.out.println(mySet.size());
        System.out.println(mySet.toString());


    }
}