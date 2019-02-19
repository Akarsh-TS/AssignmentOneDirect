package TaxCalculator;

import java.util.Scanner;
public class mainClass {
    private static Scanner sc;


    public static void main(String args[]){
        setup(args);
    }

    private static void setup(String args[]) {
         sc = new Scanner(System.in);

        if(args.length==0){
            System.out.println("No command line arguments found");

            claculateTax a = new claculateTax();
            queryForMore(args,a);
        }
        else {
            for(String i:args) {System.out.println(i);}
            claculateTax a = new claculateTax();
            String[] arr=new String[4];
            a.set(arr[0], Double.parseDouble(arr[1]), Integer.parseInt(arr[2]), arr[3]);
            a.tax();
            a.get();
            queryForMore(args,a);
        }

    }

    private static void queryForMore(String arr[],claculateTax a) {
        System.out.println("Do you want to add more items(y,n): ");
        String option;
        option = sc.next();
        arr=new String[4];
        while(option.equals("y")|| option.equals("Y"))
        {
            System.out.println("Enter name");
            arr[0]=sc.next();
            System.out.println("Enter price");
            arr[1]=sc.next();
            System.out.println("quantity");
            arr[2]=sc.next();
            System.out.println("type");
            arr[3]=sc.next();
            System.out.println(arr[0]+" "+arr[1]+"  "+arr[2]+" "+arr[3]);
            a= new claculateTax();
            a.set(arr[0],Double.parseDouble(arr[1]),Integer.parseInt(arr[2]),arr[3]);
            a.tax();
            a.get();
            System.out.println("Do you want to add more items: ");
            option = sc.next();

        }
    }


}
