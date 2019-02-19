package TaxCalculator;

public class claculateTax {
    private String name;
    private double price;
    private int quantity;
    private int type;
    private double salestax;

    public void tax() {
        if (this.type==1) {
            this.salestax=getRawTax();
        }


        else if (this.type==2) {

            this.salestax=getManufacturedTax();
        }
        else if (this.type==3) {
            this.salestax=getImportedTax();

        }

    }

    public double getImportedTax() {
        this.salestax=0.01*this.price;
        if(this.price+this.salestax<=100)
        {
            this.salestax+=5;
        }
        else if(this.price+this.salestax>100&&this.price+this.salestax<200) {
            this.salestax+=10;
        }
        else {
            this.salestax+=0.05*(this.salestax+this.price);
        }
        return salestax;

    }

    public double getManufacturedTax() {
        return(0.125*this.price+0.0025*this.price);
    }

    public double getRawTax() {
        return (0.125*this.price);
    }

    public void get() {
        System.out.println("The information entered along with calculated sales tax is as follows:");
        String type="";
        if(this.type==1) {
            type="Raw";
        }
        else if(this.type==2) {
            type="Manufactured";
        }
        else {
            type="Imported";
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%12s | %12s | %12s | %12s | %12s | %12s ","NAME","PRICE","QUANTITY","TYPE","SALESTAX","TOTALPRICE");
        System.out.println();
        System.out.printf("%12s | %12f | %12d | %12s | %12f | %12f ",this.name,this.price,this.quantity,type,this.salestax
                ,(this.salestax+this.price));
        System.out.println();


    }
    public void set(String name, Double price, int quantity, String type) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setType(type);
        System.out.println("New item added.");
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setType(String type) {
        if(type.equals("raw")||type.equals("Raw")||type.equals("RAW")) this.type=1;
        else if(type.equals("manufactured")||type.equals("Manufactured")||type.equals("MANUFACTURED")) this.type=2;
        else if(type.equals("imported")||type.equals("Imported")||type.equals("IMPORTED")) this.type=3;
    }

    public void setPrice(Double price) {
        this.price=price;

    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPrice() {
        return this.price;
    }
}
