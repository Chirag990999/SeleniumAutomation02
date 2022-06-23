package org.example;

public class NumberDivision3_5 {
    public static void Division3_5(int i){
        if(i%3==0 && i%5==0){
            System.out.println("Foo Bar");
        }
        else if (i%3==0){
            System.out.println("Foo");
        }
        else if (i%5==0){
            System.out.println("Bar");
        }
        else{
            System.out.println("Invalid Number");
        }

    }

    public static void main(String[] args) {
        Division3_5( 50 );
    }
}
