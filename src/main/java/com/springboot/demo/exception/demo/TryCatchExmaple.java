package com.springboot.demo.exception.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchExmaple {

    public static void main(String[] args) {
        // catch 中 return 但 finally中修改return的变量 但返回值还是catch中的值
        System.out.println(getResult1());
        // catch和finally都有个return 返回finally的值
        System.out.println(getResult2());
        // try-with-resource 语法:
        getResult3();
    }

    /**
     * catch 中 return 但 finally中修改return的变量 但返回值还是catch中的值
     * @return
     */
    public static int getResult1() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
        }
        return a;
    }


    /**
     * catch和finally都有个return 返回finally的值
     * @return
     */
    public static int getResult2() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
            //如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
            return a;
        }
    }


    public static void getResult3() {
        File file = new File("");
        //在try块中声明的资源（在上面的示例中是ResourceType resource）必须实现java.lang.AutoCloseable或java.io.Closeable接口
        //当try块完成时，无论是正常完成还是由于异常退出，都会自动调用资源的close方法。
        try ( FileInputStream inputStream = new FileInputStream(file);) {
            // 使用资源
        }
        catch (FileNotFoundException e) {
            // 异常处理
        }
        catch (IOException e){
            // 异常处理
        }
        // 资源会自动关闭
    }



}
