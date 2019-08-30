package com.example.demo;

import java.util.Arrays;

public class test1 {
	public static void main(String[] args) {
        Person1[] ps = new Person1[3]; // 声明一个对象数组，里面有三个对象
        System.out.println("---------------数组声明后-------------------");
        for (int x = 0; x < ps.length; x++) {
            System.out.print(ps[x] + " "); // 循环输出
        }
        // 创建3个人，并实例化
        Person1 p1 = new Person1("jerry", 18);
        Person1 p2 = new Person1("tom", 20);
        Person1 p3 = new Person1("rose", 25); 
        ps[0] = p1; // 实例化第一个元素
        ps[1] = p2; // 实例化第二个元素
        ps[2] =p3; // 实例化第三个元素
        System.out.println("\n---------------对象实例化-------------------");
        for (int x = 0; x < ps.length; x++) {
            System.out.print(ps[x] + " ");
        }
        
        Person1 ps1[] = { new Person1("jerry", 18), new Person1("tom", 20), 
                new Person1("rose", 25)}; 
            System.out.println("---------------数组输出-------------------");
            for (int x = 0; x < ps1.length; x++) {
                System.out.println(ps1[x] + " "); // 循环输出
            }
            
            
            
            
            Person1[] person=new Person1[2];
            Person1 pps1=new Person1("name",15);
            Person1 pps2=new Person1("name1",25);
            Person1 pps3=new Person1("name2",35);
            person[0]=pps1;
            person[1]=pps2;
            //person[2]=pps3;
            
            Person1 person1[]= {new Person1("sfaf",24),new Person1("asdf",24),new Person1("fdsaaw",24)};
            System.out.println(Arrays.toString(person1));
    }
}
class Person1 {
    private String name; // 姓名属性
    private int age; // 年龄属性
    public Person1(String name, int age) { // 通过构造方法设置内容
        this.name = name; // 为姓名赋值
        this.age = age; // 为年龄赋值
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
