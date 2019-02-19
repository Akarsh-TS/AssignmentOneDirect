package Test;

import org.junit.Assert;
import org.junit.Before;
import TaxCalculator.claculateTax;
import org.junit.Test;

public class testClass {
    claculateTax calculateTax;
    @Before
    public void setup(){
        calculateTax = new claculateTax();
    }

    @Test
    public void testRawTax(){
        calculateTax.setPrice(100.00);
        double salestax =calculateTax.getRawTax();
        Assert.assertEquals(salestax,(double) 12.5,2);
    }

    @Test
    public void testManufacturedTax(){
        calculateTax.setPrice(120.00);
        double salestax =calculateTax.getManufacturedTax();
        Assert.assertEquals(salestax,15.3,2);
    }

    @Test
    public void testImportedTax(){
        calculateTax.setPrice(180.00);
        double salestax =calculateTax.getImportedTax();
        Assert.assertEquals(salestax,11.8,2);
    }
}
