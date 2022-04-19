package com.it.pojo;

public class TextBrand {

    private Integer a;
    public String b;
    protected String c;
    private Integer ordered;
    private String description;
    private Integer status;

    public TextBrand() {
    }

    @Override
    public String toString() {
        return "TextBrand{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getA() {
        return a;
    }
    public void eat() {
        System.out.println("eat......textBrand");
    }
    public void setA() {
        System.out.println("无惨方法");
    }
    public void setA1(Integer setA) {
        System.out.println("有参方法");
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TextBrand(Integer a, String b) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }
}
