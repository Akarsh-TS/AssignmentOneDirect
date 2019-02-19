package main;

import java.io.Serializable;

public class Student implements Serializable {
    public int RollNumber;
    public int Age;
    public String FullName;
    public String Address;
    public int [] courses=new int [6];
    public void AddStudent(int roll, int age, String name,String address) {
        this.RollNumber = roll;
        this.Age = age;
        this.FullName = name;
        this.Address = address;
    }
}
