package com.it.pojo;

public class Student {

    public String a="name";
    public String toString() {
        System.out.println(a);
        return "Student{" +
                "a='" + a + '\'' +
                '}';
    }
    public void sleep() {
        System.out.println("sleep......");
    }

}
