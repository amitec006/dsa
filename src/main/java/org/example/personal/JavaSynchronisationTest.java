package org.example.personal;

public class JavaSynchronisationTest {
    static int i = 0;
    public static synchronized void test(int i) {
        System.out.println("Hello World static"+ i);
    }

    public synchronized void test1(int i) {
        System.out.println("Hello World non-static" + i);
    }

    public static void main(String[] args) {
        for (int j = 0; j < 20; j++) {
            JavaSynchronisationTest.test(i);
            JavaSynchronisationTest obj = new JavaSynchronisationTest();
            obj.test1(i);
            i++;
        }
    }
}
