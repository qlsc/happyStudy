package com.examples.corejava.exception;

/**
 * Description:  FinalTest
 * exception 中 finally之前的return 和 finally一定执行
 * @auther: qlsc
 * @date: 15/8/8
 */
public class FinallyTest {
    private static String finallyTest(){
        try{
            int i = 2/0;
            System.out.println("try");
            return "try result";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("catch");
            return "catch result";
        }finally {
            System.out.println("finally");//finally 一定执行
            //return "finally result";
        }
    }

    public static void main(String[] args) {
        System.out.println(FinallyTest.finallyTest());
    }
}
