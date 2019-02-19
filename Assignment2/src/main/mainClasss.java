package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static main.validateClass.validate;

public class mainClasss
{
    static int  option;
    static Student[] obj;
    static int count=0;
    static Scanner sc = new Scanner(System.in);

    static void uniquevalidate(int s)throws UniqueRollException, Exception{
        int [] roll=new int[50];
        boolean check=false;
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("Student12.ser"));
            Student[] temp =(Student[])in.readObject();
            in.close();
            for(int i=0; i<temp.length; i++) {
                roll[i]=temp[i].RollNumber;
            }
            Integer S = new Integer(s);
            for (int n : roll) {
                Integer N = new Integer(n);
                if (S.equals(N)) {
                    check= true;
                    break;
                }
            }
            if(check==true)
                throw new UniqueRollException("Roll number should be unique:it exists: Try Again");
        }
        catch(FileNotFoundException e) {
            return;
        }
    }
    public static int [] convert_courses(String courses) {
        String [] arr=courses.split(" ");
        int [] c= {0,0,0,0,0,0};
        for (String i:arr) {
            if(i.equals("A")) {
                c[0]=1;
            }
            else if(i.equals("B")) {
                c[1]=1;

            }
            else if(i.equals("C")) {
                c[2]=1;

            }
            else if(i.equals("D")) {
                c[3]=1;

            }
            else if(i.equals("E")) {
                c[4]=1;

            }
            else if(i.equals("F")) {
                c[5]=1;

            }

        }
        return c;
    }
    public static String convertbackcourses(int[]courses) {
        String a="";
        for(int i=0;i<courses.length;i++) {
            if(courses[i]==1) {
                if(i==0) {
                    a=a+"A ";
                }
                else if(i==1) {
                    a=a+"B ";
                }
                else if(i==2) {
                    a=a+"C ";
                }
                else if(i==3) {
                    a=a+"D ";
                }
                else if(i==4) {
                    a=a+"E ";
                }
                else if(i==5) {
                    a=a+"F ";
                }
            }
        }
        return a;
    }
    public static void main(String args[])throws Exception
    {
        boolean success=false;
        obj=new Student[0];

        File f = new File("Student12.ser");

        if(f.exists()) {
            System.out.println("FILE EXISTS!!!");
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("Student12.ser"));
            Student[] s=(Student[])in.readObject();
            obj = new Student[s.length];
            System.arraycopy(s, 0, obj, 0, s.length);

//            for(int i=0; i<s.length; i++) {
//                System.out.println(s[i].FullName);}
            count=s.length;
            in.close();
        }



        System.out.println("Options: \n1.Add User details.\r\n" +
                "2.Display User details.\r\n" +
                "3 Delete User details\r\n" +
                "4.Save User details.\r\n" +
                "5.Exit\r\n");
         option=Integer.parseInt(sc.nextLine());
        startQuery();
    }

    private static void startQuery() {
        while(option<=5) {
            if(option==1) {
                Student[] temp = new Student[obj.length + 1];
                System.arraycopy(obj, 0, temp, 0, obj.length);
                obj=temp;
                System.out.println("Enter roll number:");
                int roll,age;
                String Roll,Age,name,address,courses;

                Roll=sc.nextLine();
                System.out.println("Enter Age:");
                Age=sc.nextLine();
                System.out.println("Enter name:");
                name=sc.nextLine();
                System.out.println("Enter address:");
                address=sc.nextLine();
                try {
                    validate(Roll);
                    validate(Age);
                    validate(name);
                    validate(address);

                }
                catch(NoValueException e) {
                    System.out.println("Exception"+e);
                    continue;
                }
                try {
                    roll=Integer.parseInt(Roll);
                    age=Integer.parseInt(Age);
                }
                catch (NumberFormatException e)  {
                    System.out.println("Error:Number Format: recheck your age and roll number");
                    continue;
                }
                try {
                    uniquevalidate(roll);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                obj[count]=new Student();
                obj[count].AddStudent(roll,age,name,address);

                count++;
                System.out.println("Save your changes by choosing 4 in your next menu option");
            }
            else if(option==2) {
                ObjectInputStream in= null;
                try {
                    in = new ObjectInputStream(new FileInputStream("Student12.ser"));
                } catch (IOException e) {
                    System.out.println("File not found,first create one by adding");
                }
                Student[] temp = new Student[0];
                try {
                    temp = (Student[])in.readObject();
                } catch (IOException e) {
                    System.out.println("File not found,first create one by adding");
                } catch (ClassNotFoundException e) {
                    System.out.println("File not found,first create one by adding");
                }
                System.out.println("Enter 1:to sort by roll number \n2:to sort by name\n3:to sort by age\n4:to sort by address ");
                int z=Integer.parseInt(sc.nextLine());
                if(z==1) {
                    Arrays.sort(temp, (a, b) -> new Integer(a.RollNumber).compareTo(new Integer(b.RollNumber)));
                }
                else if(z==2) {
                    Arrays.sort(temp, (a, b) -> new String(a.FullName).compareTo(new String(b.FullName)));
                }
                else if(z==3) {
                    Arrays.sort(temp, (a, b) -> new Integer(a.Age).compareTo(new Integer(b.Age)));
                }
                else if(z==4) {
                    Arrays.sort(temp, (a, b) -> new String(a.Address).compareTo(new String(b.Address)));
                }


                System.out.println("-----------------------------------------------------------------------");
                System.out.printf("%12s %12s %12s %12s","Name","RollNumber","Age","Address");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------");
                for(int i=0; i<temp.length; i++) {
                    System.out.printf("%12s %12d %12d %12s",temp[i].FullName,temp[i].RollNumber,temp[i].Age,temp[i].Address);
                    System.out.println();
                }
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(option==3) {
                System.out.println("Enter roll number to be deleted:");
                int k=Integer.parseInt(sc.nextLine());
                ObjectInputStream in= null;
                try {
                    in = new ObjectInputStream(new FileInputStream("Student12.ser"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Student[] temp = new Student[0];
                try {
                    temp = (Student[])in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for(int i=0; i<temp.length; i++) {
                    if(temp[i].RollNumber==k) {
                        ArrayList<Student> arrayList = new ArrayList<Student>(Arrays.asList(temp));
                        arrayList.remove(i);
                        obj=new Student[arrayList.size()];
                        for (int j =0; j < arrayList.size(); j++)
                            obj[j] = arrayList.get(j);
                        break;
                    }
                }
                count--;
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Save your changes by choosing 4 in your next menu option");
            }
            else if(option==4) {
                try{
                    FileOutputStream fos = new FileOutputStream("Student12.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(obj);
                    oos.close();
                    fos.close();
                    System.out.println("Serialzation Done. Data saved.");
                }catch(IOException ioe){
                    System.out.println(ioe);
                }
            }
            else if(option==5) {
                System.out.println("Are you sure? : 1:YES 0:NO");
                int k=Integer.parseInt(sc.nextLine());

                if(k==1) {
                    break;
                }
                else {
                    System.out.println("Options: \n1.Add User details.\r\n" +
                            "2.Display User details.\r\n" +
                            "3 Delete User details\r\n" +
                            "4.Save User details.\r\n" +
                            "5.Exit\r\n");
                    option=Integer.parseInt(sc.nextLine());
                    continue;
                }
            }
            System.out.println("Options: \n1.Add User details.\r\n" +
                    "2.Display User details.\r\n" +
                    "3 Delete User details\r\n" +
                    "4.Save User details.\r\n" +
                    "5.Exit\r\n");
            option=Integer.parseInt(sc.nextLine());


        }
    }
}

