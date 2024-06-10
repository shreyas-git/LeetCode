package com.recursion;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressionTest {
    public static void main(String[] args)  {
      test();
    }

    public static void test()  {
        int a = 10;
        int b =0 ;
        try {

            int c = a/b;
        }catch(ArithmeticException e){
            b= 10;

            throw new ArithmeticException("process failed");
        }finally {
            System.out.println(b);
            throw new RuntimeException("unable to process ");
        }
    }
}
