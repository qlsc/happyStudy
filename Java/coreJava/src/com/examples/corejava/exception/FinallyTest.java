package com.examples.corejava.exception;

/**
 * Description:  FinalTest
 * 异常中，如果有 finally ，并且有返回值， return 之后，finally也一定执行
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
