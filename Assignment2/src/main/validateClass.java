package main;

public class validateClass {

    static void validate(String s)throws NoValueException {
        if(s.length()==0)
            throw new NoValueException("No detail can be left empty: Try Again");
    }

}
